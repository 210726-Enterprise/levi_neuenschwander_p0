package com.projectZero.repo;

/*
imports
 */
import com.projectZero.User;
import com.projectZero.util.ConnectionFactory;
import com.revature.collection.RevArrayList;
import java.sql.*;

/*
Class for database functionality for users
 */
public class UserDaoImpl {

    /**
     * Method to create a new user in the database
     * @param fName first name of user
     * @param lName last name of user
     * @param username username of user
     * @param pass password of user
     */
    public void createUser(String fName, String lName, String username, String pass) {
        Connection connection = ConnectionFactory.getConnection();
        String sql = "INSERT INTO users (fname, lname, username, password) VALUES (?,?,?,?)";
        PreparedStatement ps;
        try{
            ps = connection.prepareStatement(sql);
            ps.setString(1, fName);
            ps.setString(2, lName);
            ps.setString(3, username);
            ps.setString(4, pass);
            ps.execute();
            connection.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Method to retrieve all users currently in the database
     * @return list of users from the database
     */
    public RevArrayList<User> getAllUsers() {
        Connection connection = ConnectionFactory.getConnection();
        RevArrayList<User> userList = new RevArrayList<>();

        String sql = "SELECT * FROM users";
        Statement s;
        try {
            s = connection.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while(rs.next()){
                userList.add(new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
            }
            //implement with class made lists
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
}
