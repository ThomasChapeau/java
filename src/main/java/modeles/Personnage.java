package modeles;

public class Personnage {
    
    private String firstName;

    private String lastName;

    private Acteur acteur;

    public Personnage()
    {
        firstName = null;
        lastName = null;
    }

    public Personnage(String firstName, String lastName, Acteur acteur)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.acteur = acteur;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Acteur getActeur() {
        return this.acteur;
    }

    public void setActeur(Acteur acteur) {
        this.acteur = acteur;
    }

    @Override
    public String toString() {
        return "{" +
            " firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            "}";
    }
}
