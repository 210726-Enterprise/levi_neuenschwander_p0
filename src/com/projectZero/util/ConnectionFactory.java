package com.projectZero.util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    static Properties prop = new Properties();
    private static String url = "";
    private static String username = "";
    private static String password = "";

    private static Connection connection;

    public static Connection getConnection(){
        try{
            prop.load(new FileReader("src/resources/application.properties"));
            url = prop.getProperty("ENDPOINT");
            username = prop.getProperty("USERNAME");
            password = prop.getProperty("PASSWORD");
            connection = DriverManager.getConnection(url, username, password);
        }
        catch(SQLException e){
            System.out.println("There's a problem with the database connection.");;
        }
        catch(IOException e){
            System.out.println("There's a problem with the properties file.");
        }

        return connection;
    }
}
