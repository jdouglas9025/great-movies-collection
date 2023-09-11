package jdouglas9025.github.io.greatmoviescollection.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtility {
    //App developed/tested using a local MySQL server (some arguments removed for security reasons)

    //URL of the database along with vendor's driver
    private static final String url = "jdbc:mysql://";
    //Name of the database on the server
    private static final String name = "great-movies-collection";
    //Optional params for DB connection
    private static final String params = "?useSSL=false";
    //Username of admin account
    private static final String username = "";
    //Password of admin account
    private static final String password = "";
    //Represents connection to database
    private static Connection connection = null;

    //Create a connection to database (or return existing one if one already exists)
    public static Connection getConnection() {
        //If connection already exists, return the current one
        if (connection != null) {
            return connection;
        }

        String connectionUrl = url + name + params;

        try {
            connection = DriverManager.getConnection(connectionUrl, username, password);
        } catch (SQLException e) {
            System.err.println("Issue with getting connection: " + e.getMessage());
        }

        return connection;
    }
}
