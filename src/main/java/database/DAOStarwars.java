package database;

import java.sql.*;

public abstract class DAOStarwars {
    
    protected Connection conn;

    protected DAOStarwars(String login, String password, String url, String port, String dbName) {
        
        String strClassName = "com.mysql.jdbc.Driver";
        String databaseUrl = "jdbc:mysql://localhost:3306/?autoReconnect=true&useSSL=false" + dbName;

        try {
            Class.forName(strClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(databaseUrl, login, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    abstract public void close();
}
