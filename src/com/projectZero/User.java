package com.projectZero;

/**
 * User class
 */
public class User {
    /**
     * Instance variables
     */
    private int id;
    private String fName, lName, username, password;

    /**
     * Constructor for a user
     * @param id database id of the user
     * @param fName first name of the user
     * @param lName last name of the user
     * @param username username of the user
     * @param password password of the user
     */
    public User(int id, String fName, String lName, String username, String password) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.username = username;
        this.password = password;
    }

    /**
     * Getter method for the database id of the user
     * @return database id of the user
     */
    public int getId(){
        return this.id;
    }

    /**
     * Getter method for first name of the user
     * @return first name of the user
     */
    public String getFName() {
        return fName;
    }

    /**
     * Setter method for first name of the user
     * @param fName first name of the user
     */
    public void setFName(String fName) {
        this.fName = fName;
    }

    /**
     * Getter method for the last name of the user
     * @return last name of the user
     */
    public String getLName() {
        return lName;
    }

    /**
     * Setter method for the last name of the user
     * @param lName last name of the user
     */
    public void setLName(String lName) {this.lName = lName;}

    /**
     * Getter method for username
     * @return username of the user
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter method for the username
     * @param username username of the user
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter method for the password
     * @return password of the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method for the password
     * @param password password for the user
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
