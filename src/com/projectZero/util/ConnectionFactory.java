package com.projectZero.util;

/**
 * Imports
 */
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Class to create connection to database
 */
public class ConnectionFactory {
    /**
     * Instance variables
     */
    static Properties prop = new Properties();
    private static String url = "";
    private static String username = "";
    private static String password = "";
    private static Connection connection;

    /**
     * Method to create the connection
     * @return created connection
     */
    public static Connection getConnection(){
        try{
            prop.load(new FileReader("src/resources/application.properties")); //Finding path of file holding database credentials
            url = prop.getProperty("ENDPOINT"); //Database url
            username = prop.getProperty("USERNAME"); //database username
            password = prop.getProperty("PASSWORD"); //database password
            connection = DriverManager.getConnection(url, username, password); //creating connection with credentials
        }
        catch(SQLException e){
            System.out.println("There's a problem with the database connection.");//problem with database connection
        }
        catch(IOException e){
            System.out.println("There's a problem with the properties file.");//problem reading the file
        }

        return connection;
    }
}
