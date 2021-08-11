package com.projectZero;

/**
 * Account class
 */
public class Account {
    /**
     * Instance variables
     */
    private int owner;
    private int accountId;
    public double total;

    /**
     * Constructor for an account
     * @param owner user who owns the account
     * @param balance current balance of the account
     * @param accountId database id of the account
     */
    public Account(int owner, double balance, int accountId) {
        this.owner = owner;
        this.accountId = accountId;
        this.total = balance;
    }

    /**
     * Getter method for owner of the account
     * @return database id of account owner
     */
    public int getOwner() {
        return owner;
    }

    /**
     * Setter method for owner of the account
     * @param owner database id of account owner
     */
    public void setOwner(int owner) {
        this.owner = owner;
    }

    /**
     * Getter for database id of the account
     * @return database id of account
     */
    public int getAccountId() {
        return accountId;
    }

    /**
     * Setter for database id of account
     * @param accountId database id of account
     */
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    /**
     * Getter for balance of account
     * @return current balance of account
     */
    public double getTotal() {
        return total;
    }

    /**
     * Setter for balance of account
     * @param total new balance of account
     */
    public void setTotal(float total) {
        this.total = total;
    }
}
