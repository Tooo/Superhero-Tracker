/**
 * TextMenu class holds the methods and strings for the menu.
 * Data includes strings for Menu Title and Menu Options.
 * It supports printing the menu and printing stars for the title.
 */
public class TextMenu {
    private static String menuTitle = " Super Hero Tracker ";
    private static String[] menuOptions = {"List all superheros", "Add a new superhero",
            "Remove a superhero", "Update number of civilians saved by a superhero",
            "List Top 3 superheroes", "Debug Dump (toString)", "Exit"};

    public static void printMenu() {
        //Print Title
        int starLength = menuTitle.length();
        printStars(starLength);
        System.out.println(menuTitle);
        printStars(starLength);

        //Print List
        int count = 1;
        for (String menu:menuOptions) {
            System.out.print(count + ": ");
            System.out.println(menu);
            count++;
        }

        System.out.print("Enter >> ");
    }

    private static void printStars(int amount) {
        for (int i = 0; i < amount; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
