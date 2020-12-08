import com.google.gson.*;

import java.io.*;
import java.util.*;

/**
 * Main class holds the methods for each menu selection.
 * This includes printing heroes list, adding and removing heroes,
 * updating civilian count, listing top three heroes and debugDump
 * It also supports reading and writing superhero-list.json file.
 */
public class Main {
    private static final List<Superhero> superheroes = new ArrayList<>();
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
	    fileReader();
	    boolean isDone = false;
	    while (!isDone) {
            TextMenu.printMenu();
            int choice = in.nextInt();
            switch (choice) {
                case 1 -> printHeroes();
                case 2 -> addHero();
                case 3 -> removeHero();
                case 4 -> civilUpdate();
                case 5 -> topThree();
                case 6 -> debugDump();
                case 7 -> isDone = true;
                default -> System.out.println("Invalid number, please retry.");
            }
        }
	    fileWriter();
    }

    private static void fileReader() {
        File input = new File("superhero-list.json");
        try {
            JsonElement fileElement = JsonParser.parseReader(new FileReader(input));
            JsonObject fileObject = fileElement.getAsJsonObject();

            // Processing Heroes
            JsonArray jsonArrayOfHeroes = fileObject.get("superhero").getAsJsonArray();
            for (JsonElement heroElement : jsonArrayOfHeroes) {
                // Get Json Object
                JsonObject heroJsonObject = heroElement.getAsJsonObject();

                // Extract data
                String name = heroJsonObject.get("name").getAsString();
                String superpower = heroJsonObject.get("superpower").getAsString();
                double height = heroJsonObject.get("height").getAsDouble();
                int civiliansSaved = heroJsonObject.get("civiliansSaved").getAsInt();

                // Create Class
                Superhero superhero = new Superhero(name, superpower, height, civiliansSaved);
                superheroes.add(superhero);
            }
        } catch (FileNotFoundException ignored) {
        } catch (Exception e) {
            System.err.println("Error processing input file");
        }
    }

    // Refer to StackOverFlow post
    // https://stackoverflow.com/questions/29319434/how-to-save-data-with-gson-in-a-json-file
    private static void fileWriter() {
        try (Writer writer = new FileWriter("superhero-list.json")){
            // Create Gson
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            // Write File
            writer.write("{\"superhero\":");
            gson.toJson(superheroes, writer);
            writer.write("}");

        } catch (Exception e) {
            System.err.println("Error processing output file");
        }
    }

    private static void printHeroes() {
        if (superheroes.size() == 0) {
            System.out.println("No heroes present in the list. Add more..\n");
            return;
        }

        int count = 0;
        for (Superhero hero:superheroes) {
            count++;
            System.out.print(count);
            System.out.println(". Hero name: " + hero.getName() +
                    ", height: " + hero.getHeight() +
                    "cm, superpower: " + hero.getSuperpower() +
                    ", saved " + hero.getCiviliansSaved() + " civilians.");
        }
        System.out.println();
    }

    private static void addHero () {
        System.out.print("Enter Hero's name: ");
        in.nextLine();
        String name = in.nextLine();

        // Input + validate height
        double height = 0;
        while (height <= 0) {
            System.out.print("Enter Hero's height in cm: ");
            height = in.nextDouble();
            if (height <= 0) {
                System.out.println("Invalid Number, positive numbers only");
            }
        }

        System.out.print("Enter Hero's Superpower: ");
        in.nextLine();
        String superpower = in.nextLine();

        superheroes.add(new Superhero(name, superpower, height, 0));
        System.out.println(name + " has been added to the list of superheroes.\n");
    }

    private static void removeHero () {
        printHeroes();

        int sizeOfList = superheroes.size();
        if (sizeOfList == 0) {
            return;
        }

        int chooseNum = chooseList(sizeOfList, 3);
        if (chooseNum != 0) {
            System.out.println(superheroes.get(chooseNum-1).getName() +
                    " has been removed from the list of superheroes.");
            superheroes.remove(chooseNum-1);
        }
        System.out.println();
    }

    private static int chooseList (int sizeOfList, int menuNumber) {
        int input = -1;

        // Array based on Menu selection
        String[] message = {" ", " ", "be removed",
                            "update civilian count"};

        // Validate Menu input
        while (input < 0 || input > sizeOfList) {
            System.out.println("Enter Hero number to " + message[menuNumber-1] + " or Enter 0 to cancel");
            System.out.print("Enter>> ");
            input = in.nextInt();

            if (input < 0 || input > sizeOfList) {
                System.out.println("Invalid Number, please choose numbers in range");
            }
        }
        return input;
    }

    private static void civilUpdate () {
        int sizeOfList = superheroes.size();
        printHeroes();

        if (sizeOfList == 0) {
            return;
        }

        int chooseNum = chooseList(sizeOfList, 4);
        if (chooseNum != 0) {
            int civiliansSaved = -1;

            // Input and validate civilians saved count
            while (civiliansSaved < 0) {
                System.out.print("Enter new civilian save count: ");
                civiliansSaved = in.nextInt();
                if (civiliansSaved <= 0) {
                    System.out.println("Invalid Number, positive numbers only");
                }
            }
            
            int previousCiviliansSaved = superheroes.get(chooseNum-1).getCiviliansSaved();
            superheroes.get(chooseNum-1).setCiviliansSaved(civiliansSaved);

            String name = superheroes.get(chooseNum-1).getName();
            System.out.println("Number of civilians saved by " + name +
                    " has been updated from " + previousCiviliansSaved +
                    " to " + civiliansSaved + "\n");
        }
    }

    private static void topThree () {
        if (superheroes.size() < 3 ) {
            System.out.println("There is not enough superheroes in the list. Please add more.");
            return;
        }

        // Loop used to count number of superheroes with at least 1 civilian saved
        int count = 0;
        for (Superhero hero:superheroes) {
            if (hero.getCiviliansSaved() != 0) {
                count++;
            }
        }
        if (count < 3 ) {
            System.out.println("The superheroes have not saved enough civilians.\n");
            return;
        }

        // Copy superheroes list to topThreeCivilianSaved to sort
        List<Superhero> topThreeCiviliansSaved = new ArrayList<>(superheroes);

        topThreeCiviliansSaved.sort((hero1, hero2) -> hero2.getCiviliansSaved() - hero1.getCiviliansSaved());

        for (int i = 0; i < 3; i++) {
            System.out.println(i+1 + ". " +
                    topThreeCiviliansSaved.get(i).getName() + " has saved " +
                    topThreeCiviliansSaved.get(i).getCiviliansSaved() + " civilians");
        }
        System.out.println();
    }

    private static void debugDump () {
        int count = 1;
        for (Superhero hero:superheroes) {
            System.out.print(count);
            System.out.println(". " + hero);
            count++;
        }
        System.out.println();
    }
}
