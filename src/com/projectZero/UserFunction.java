package com.projectZero;

import com.projectZero.repo.AccountDaoImpl;
import com.projectZero.service.AccountServiceImpl;

import java.text.DecimalFormat;

public class UserFunction {
    private User user;
    private Account account;
    AccountServiceImpl asi = new AccountServiceImpl(new AccountDaoImpl());
    DecimalFormat df = new DecimalFormat("#.00");

    public UserFunction(User u){
        user = u;
    }

    public void setAccount(Account a){
        account = a;
    }

    public void deposit(double amount){
        if(amount <= 0) {
            System.out.println("You cannot deposit a non-positive number.");
        }
        else{
            System.out.println(amount);
            asi.setBalance(account.getTotal() + amount, account);
        }
    }

    public void withdraw(double amount){
        if(amount <= account.getTotal()) {
            asi.setBalance(account.getTotal() - amount, account);
        }
        else{
            System.out.println("You cannot withdraw more than your current balance: ");
            System.out.println("Your balance is: " + "$" + df.format(account.getTotal()));
        }
    }

    public double viewBalance(){
        UserMenus.userAccount();
        return account.total;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User u) {
        this.user = u;
    }
}
