package com.projectZero;

/**
 * imports
 */
import com.projectZero.repo.AccountDaoImpl;
import com.projectZero.service.AccountServiceImpl;
import java.text.DecimalFormat;

/**
 * Class for user functionalities and logic
 */
public class UserFunction {
    /**
     * Instance variables
     */
    private User user;
    private Account account;
    AccountServiceImpl asi = new AccountServiceImpl(new AccountDaoImpl());
    DecimalFormat df = new DecimalFormat("#.00");

    /**
     * Constructor for the UserFunction class
     * @param u currently logged-in user
     */
    public UserFunction(User u){
        user = u;
    }

    /**
     * Setter method for the account of the currently logged-in user
     * @param a account belonging to current user
     */
    public void setAccount(Account a){
        account = a;
    }

    /**
     * Method for checking value to be deposited and logic for deposit
     * @param amount amount to be deposited
     */
    public void deposit(double amount){
        if(amount <= 0) {
            System.out.println("You cannot deposit a non-positive number.");
        }
        else{
            System.out.println(amount);
            asi.setBalance(account.getTotal() + amount, account);
        }
    }

    /**
     * Method for checking value of amount to be withdrawn and logic
     * @param amount amount to be withdrawn
     */
    public void withdraw(double amount){
        if(amount <= account.getTotal()) {
            asi.setBalance(account.getTotal() - amount, account);
        }
        else{
            System.out.println("You cannot withdraw more than your current balance: ");
            System.out.println("Your balance is: " + "$" + df.format(account.getTotal()));
        }
    }

    /**
     * Method to check account is up to date and get the balance of the users account
     * @return balance of current users account
     */
    public double viewBalance(){
        UserMenus.userAccount();
        return account.total;
    }

    /**
     * Getter method for the current user
     * @return current user
     */
    public User getUser(){
        return user;
    }

    /**
     * Setter method for current user
     * @param u user to be set
     */
    public void setUser(User u) {
        this.user = u;
    }
}
