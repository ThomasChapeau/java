package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import modeles.Acteur;
import modeles.Film;

public class DAOFilm extends DAOStarwars {

    //CONSTANTES
    private final String SQL_ADD = "INSERT INTO FILM (title, release_year, num_episode, cost, receipt) VALUES(?, ?, ?, ?, ?)";
    private final String SQL_ADD_RELATION = "INSERT INTO FILM_ACTEUR (film_id, acteur_id) VALUES(?, ?)";
    private final String SQL_DELETE = "DELETE FROM FILM WHERE id=?";

    //Ajout
    private Statement defaultStatement;
    private PreparedStatement addStatement;
    private PreparedStatement addRelationStatement;
    private PreparedStatement deleteStatement;

    public DAOFilm(String login, String password, String url, String port, String dbName) {

        super(login, password, url, port, dbName);
        try {
            defaultStatement = conn.createStatement();
            addStatement = conn.prepareStatement(SQL_ADD);
            addRelationStatement = conn.prepareStatement(SQL_ADD_RELATION);
            deleteStatement = conn.prepareStatement(SQL_DELETE);
        } catch (SQLException e) {
            e.printStackTrace();
        }       
    }

    public void close() {
        try {
            defaultStatement.close();
            addStatement.close();
            addRelationStatement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void lister() {
        
        List<Film> films = listerFilms();

        for (Film film : films) {
            System.out.println(film);
        }
    }

    public List<Film> listerFilms() {

        ArrayList<Film> films = new ArrayList<>();

        try {
            ResultSet rsUsers = defaultStatement.executeQuery("SELECT * FROM Film");

            while (rsUsers.next()) {
                Film film = new Film();

                film.setTitle(rsUsers.getString(2));
                film.setReleaseYear(rsUsers.getInt(3));
                film.setNumEpisode(rsUsers.getInt(4));
                film.setCost(rsUsers.getInt(5));
                film.setReceipt(rsUsers.getInt(6));

                films.add(film);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return films;
    }

    public Film findOneByTitle(String title) {

        Film film = null;

        try {
            ResultSet rsUsers = defaultStatement.executeQuery("SELECT * FROM Film WHERE title='" + title + "' LIMIT 1;");

            film = new Film();

            film.setTitle(rsUsers.getString(2));
            film.setReleaseYear(rsUsers.getInt(3));
            film.setNumEpisode(rsUsers.getInt(4));
            film.setCost(rsUsers.getInt(5));
            film.setReceipt(rsUsers.getInt(6));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return film;
    }

    public void ajouter(String title, int releaseYear, int numEpisode, long cost, long receipt, ArrayList<Acteur> acteurs) {
        
        try {
            
            addStatement.setString(1, title);
            addStatement.setInt(2, releaseYear);
            addStatement.setInt(3, numEpisode);
            addStatement.setLong(4, cost);
            addStatement.setLong(5, receipt);

            addStatement.executeUpdate();

            Film film = findOneByTitle(title);

            for (Acteur acteur : acteurs) {
                addRelationStatement.setInt(1, film.getId());
                addRelationStatement.setInt(2, acteur.getId());

                addRelationStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ajouter(Film film) {
        ajouter(film.getTitle(), film.getReleaseYear(), film.getNumEpisode(), film.getCost(), film.getReceipt(), film.getActeurs());
    }

    public void supprimer(int id) {
        try {
            
            deleteStatement.setInt(1, id);

            boolean status = deleteStatement.execute();

            if (status) {
                System.out.println("La ligne a bien été supprimé");
            } else {
                System.out.println("La ligne n'a pas pu être supprimé");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void supprimer(Film film) {
        supprimer(film.getId());
    }
}
