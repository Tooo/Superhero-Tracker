/**
 * Superhero class models information about a superhero.
 * Data includes name, superpower, height, and number of civilians saved.
 */
public class Superhero {
    private String name;
    private String superpower;
    private double height;
    private int civiliansSaved;

    public Superhero (String name, String superpower, double height, int civiliansSaved) {
        this.name = name;
        this.superpower = superpower;
        this.height = height;
        this.civiliansSaved = civiliansSaved;
    }

    public String getName() {
        return name;
    }

    public String getSuperpower() {
        return superpower;
    }

    public double getHeight() {
        return height;
    }

    public int getCiviliansSaved() {
        return civiliansSaved;
    }

    public void setCiviliansSaved(int civiliansSaved) {
        this.civiliansSaved = civiliansSaved;
    }

    @Override
    public String toString() {
        return "Superhero{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", civiliansSaved=" + civiliansSaved +
                ", superpower='" + superpower + '\'' +
                '}';
    }
}
