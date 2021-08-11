package com.projectZero.service;

import com.projectZero.Account;
import com.projectZero.repo.AccountDaoImpl;
import com.revature.collection.RevArrayList;
import com.revature.collection.RevaList;

import java.util.List;

public class AccountServiceImpl {

    private AccountDaoImpl aDao;

    public AccountServiceImpl(AccountDaoImpl aDao2){this.aDao = aDao2;}

    public RevArrayList<Account> getAccounts(){
        RevArrayList<Account> accountList = aDao.getAccounts();
        return accountList;
    }

    public void createAccount(double b, int userid){
        aDao.createAccount(b, userid);
    }

    public void setBalance(double amount, Account a){
        System.out.println(amount);
        aDao.setBalance(amount, a);
    }
}
