package modeles;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Vector;

public class Acteur implements Comparable {
    
    private int id;

    private String firstName;

    private String lastName;

    private ArrayList<Film> films;

    private Vector<Personnage> personnages;

    public Acteur()
    {
        firstName = null;
        lastName = null;
        films = new ArrayList<Film>();
        personnages = new Vector<Personnage>(2);
    }

    public Acteur(String firstName, String lastName, ArrayList<Film> films, Vector<Personnage> personnages) 
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.films = films;
        if (personnages.capacity() > 2)
            throw new InvalidParameterException("Capacity of personnages parameter cannot be longer than 2");
        this.personnages = personnages;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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

    public ArrayList<Film> getFilms() {
        return this.films;
    }

    public void setFilms(ArrayList<Film> films) {
        this.films = films;
    }

    public Vector<Personnage> getPersonnages() {
        return this.personnages;
    }

    public void setPersonnages(Vector<Personnage> personnages) {
        if (personnages.capacity() > 2)
            throw new InvalidParameterException("Capacity of personnages parameter cannot be longer than 2");
        this.personnages = personnages;
    }

    @Override
    public String toString() {
        return "{" +
            " firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            "}";
    }

    public int nbPersonnages() {
        
        if (personnages == null)
            return 0;

        return personnages.size();
    }

    public int compareTo(Acteur a) {
        return firstName.compareTo(a.firstName);
    }

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
