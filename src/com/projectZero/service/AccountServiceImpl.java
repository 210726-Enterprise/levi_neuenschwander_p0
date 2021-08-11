package com.projectZero.service;
/*
imports
 */
import com.projectZero.Account;
import com.projectZero.repo.AccountDaoImpl;
import com.revature.collection.RevArrayList;

/*
Class in between account functionality and database functionality
 */
public class AccountServiceImpl {
    /*
    instance variables
     */
    private AccountDaoImpl aDao;

    /**
     * Constructor for Account Service class
     * @param aDao2 Account database functionality class
     */
    public AccountServiceImpl(AccountDaoImpl aDao2){this.aDao = aDao2;}

    /**
     * Method to call the database functionality class to retrieve all accounts
     * @return list of the current accounts in the database
     */
    public RevArrayList<Account> getAccounts(){
        RevArrayList<Account> accountList = aDao.getAccounts();
        return accountList;
    }

    /**
     * Method to call the database functionality class to create a new account in the database
     * @param b balance of the new account
     * @param userid database id for user who owns account
     */
    public void createAccount(double b, int userid){
        aDao.createAccount(b, userid);
    }

    /**
     * Method to call database functionality class to update the current balance of the account
     * @param amount new balance for the account
     * @param a account to update
     */
    public void setBalance(double amount, Account a){
        System.out.println(amount);
        aDao.setBalance(amount, a);
    }
}
