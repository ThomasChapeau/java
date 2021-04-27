package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

import modeles.Acteur;
import modeles.Film;
import modeles.Gentil;
import modeles.Personnage;

public class App 
{
    public static void main( String[] args )
    {
        Film f1 = new Film("Star Wars, Episode IV : Un nouvel espoir", 1977, 1, (long)1000000, (long)10000000, 
                new ArrayList<Acteur>());

        Film f2 = new Film("Star Wars, Episode V : L'Empire contre-attaque", 1977, 1, (long) 1000000, (long) 10000000,
                new ArrayList<Acteur>());

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter a film title");
        String title = scanner.nextLine();

        System.out.println("Enter a release year");
        int releaseYear = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter a number of episode");
        int episodeNumber = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter a number of cost");
        long cost = Long.parseLong(scanner.nextLine());

        System.out.println("Enter a number of receipt");
        long receipt = Long.parseLong(scanner.nextLine());

        Film f3 = new Film(title, releaseYear, episodeNumber, cost, receipt, new ArrayList<Acteur>());

        scanner.close();

        Personnage vador = new Personnage("Dark", "Vador", null);
        Gentil luc = new Gentil("Luc", "Skywalker", null, true);

        ArrayList<Film> films = new ArrayList<Film>();
        films.add(f1);
        films.add(f2);
        films.add(f3);

        PrintFilmArray(films);

        Gentil C3PO = new Gentil("C3", "PO", null, false);
        Gentil hanSolo = new Gentil("Han", "Solo", null, false);

        Vector<Personnage> personnages = new Vector<Personnage>(2);
        personnages.add(C3PO);
        personnages.add(hanSolo);

        Acteur harrisonFord = new Acteur("Harrison", "Ford", films, personnages);

        for (Film film : films) {
            film.getActeurs().add(harrisonFord);
            film.tri();
        }

        Map<String, Film> dictionary = new HashMap<String, Film>();

        for (Film film : films) {
            dictionary.put(String.valueOf(film.getReleaseYear()), film);
        }

        makeBackUp(dictionary);
    }

    public static void PrintFilmArray(ArrayList<Film> films)
    {
        for (Film film : films) {
            System.out.println(film);
        }
    }

    public static void makeBackUp(Map<String, Film> dictionary) {

        for (Map.Entry<String, Film> entry : dictionary.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getTitle() + " - " + entry.getValue().calculBenefice());
        }
    }
}
