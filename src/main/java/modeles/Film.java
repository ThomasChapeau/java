package modeles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Film {

	//déclaration des variables
	
    private int id;
    
    private String title;

    private int releaseYear;

    private int numEpisode;

    private long cost;

    private long receipt;

    private ArrayList<Acteur> acteurs;

    /**
     * constructeur
     */
    public Film()
    {
        title = null;
        releaseYear = 0;
        numEpisode = 0;
        cost = 0;
        receipt = 0;
    }

    /**
     * Constructeur de Film
     * 
     * @param title       initialiser le titre
     * @param releaseYear initialiser l'année de sortie
     * @param numEpisode  initialiser le numéro du film
     * @param cost        initialiser le prix du film
     * @param receipt     initialiser les recettes
     * @param acteurs     initialiser les acteurs
     */
    public Film(String title, int releaseYear, int numEpisode, long cost, long receipt, ArrayList<Acteur> acteurs)
    {
        this.title = title;
        this.releaseYear = releaseYear;
        this.numEpisode = numEpisode;
        this.cost = cost;
        this.receipt = receipt;
        this.acteurs = acteurs;
    }

    /**
     * ajout ID
     * 
     * @return id
     */
    public int getId() {
        return this.id;
    }
    
    /**
     * modification ID
     * 
     * @return id
     */

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Ajout du titre
     * 
     * @return title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * modification du titre
     * 
     * @param title New title value
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Ajout de l'année
     * 
     * @return releaseYear
     */
    public int getReleaseYear() {
        return this.releaseYear;
    }

    /**
     * modification de l'année
     * 
     * @param releaseYear New releaseYear value
     */
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    /**
     * Ajout numéro du film
     * 
     * @return numEpisode
     */
    public int getNumEpisode() {
        return this.numEpisode;
    }

    /**
     * modification du numéro
     * 
     * @param numEpisode New numEpisode value
     */
    public void setNumEpisode(int numEpisode) {
        this.numEpisode = numEpisode;
    }

    /**
     * Ajout du prix
     * 
     * @return cost
     */
    public long getCost() {
        return this.cost;
    }

    /**
     * modification du prix
     * 
     * @param cost New cost value
     */
    public void setCost(long cost) {
        this.cost = cost;
    }

    /**
     * Ajout des recettes
     * 
     * @return receipt
     */
    public long getReceipt() {
        return this.receipt;
    }

    /**
     * modification des recettes
     * 
     * @param receipt New receipt value
     */
    public void setReceipt(long receipt) {
        this.receipt = receipt;
    }

    /**
     * Ajout des acteurs
     * 
     * @return acteurs
     */
    public ArrayList<Acteur> getActeurs() {
        return this.acteurs;
    }

    /**
     * modification des acteurs
     * 
     * @param acteurs New acteurs value
     */
    public void setActeurs(ArrayList<Acteur> acteurs) {
        this.acteurs = acteurs;
    }

    @Override
    public String toString() {
        return "{" +
            " title='" + getTitle() + "'" +
            ", releaseYear='" + getReleaseYear() + "'" +
            ", numEpisode='" + getNumEpisode() + "'" +
            ", cost='" + getCost() + "'" +
            ", receipt='" + getReceipt() + "'" +
            "}";
    }

    public int nbActeurs() {
        
        if (acteurs == null)
            return 0;

        return acteurs.size();
    }

    public int nbPersonnages() {

        if (acteurs == null)
            return 0;

        int total = 0;

        for (Acteur acteur : acteurs) {
            
            if (acteur != null)
                total += acteur.nbPersonnages();
        }

        return total;
    }

    public long calculBenefice() {
        return receipt - cost;
    }

    public boolean isBefore(int annee) {
        return annee < this.releaseYear;
    }

    public void tri() {
        Collections.sort(this.acteurs);
    }
}
