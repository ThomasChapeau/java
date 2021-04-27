package database;

import java.util.ArrayList;

import modeles.Acteur;
import modeles.Film;

public class App {
    
    public static void main(String[] args) {
        
        DAOFilm daoFilm = new DAOFilm("root", "1234", "127.0.0.1", "3306", "starwars");

        Film f1 = new Film("Star Wars, épisode IV : Un nouvel espoir", 1977, 1, (long)1000000, (long)10000000, 
                new ArrayList<Acteur>());

        daoFilm.ajouter(f1);
    }
}
