package com.projectZero.service;

/**
 * Imports
 */
import com.projectZero.User;
import com.projectZero.repo.UserDaoImpl;
import com.revature.collection.RevArrayList;

/**
 * Class in between user functionality and database functionality
 */
public class UserServiceImpl {
    /*
    instance variables
     */
    private UserDaoImpl uDao;

    /**
     * Constructor for UserService class
     * @param uDao2 Database user functionality class
     */
    public UserServiceImpl(UserDaoImpl uDao2){
        this.uDao = uDao2;
    }

    /**
     * Method calling for the database functionality class to create a new user
     * @param fName first name of user
     * @param lName last name of user
     * @param username username of user
     * @param pass password of user
     */
    public void createUser(String fName, String lName, String username, String pass){
        uDao.createUser(fName,lName,username,pass);
    }

    /**
     * Method calling for the database functionality class to retrieve all users
     * @return a list of all the users in the database
     */
    public RevArrayList<User> getAllUsers(){
        RevArrayList<User> usersList = uDao.getAllUsers();
        return usersList;
    }


}
