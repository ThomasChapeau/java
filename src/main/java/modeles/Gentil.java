package modeles;

public class Gentil extends Personnage {
    
    private boolean force;

    public Gentil()
    {
        super();
        this.force = false;
    }

    public Gentil(String firstName, String lastName, Acteur acteur, boolean force) 
    {
        super(firstName, lastName, acteur);
        this.force = force;
    }

    public boolean getForce() {
        return this.force;
    }

    public void setForce(boolean force) {
        this.force = force;
    }

    @Override
    public String toString() {
        return "{" +
            " firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", force='" + getForce() + "'" +
            "}";
    }
}
