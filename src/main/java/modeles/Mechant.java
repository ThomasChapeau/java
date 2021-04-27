package modeles;

public class Mechant extends Personnage {
    
    private boolean coteObscur;

    public Mechant() 
    {
        super();
        this.coteObscur = false;
    }

    public Mechant(String firstName, String lastName, Acteur acteur, boolean coteObscur)
    {
        super(firstName, lastName, acteur);
        this.coteObscur = coteObscur;
    }

    public boolean getCoteObscur() {
        return this.coteObscur;
    }

    public void setCoteObscur(boolean coteObscur) {
        this.coteObscur = coteObscur;
    }
    
    @Override
    public String toString() {
        return "{" +
            " firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", coteObscur='" + getCoteObscur() + "'" +
            "}";
    }
}
