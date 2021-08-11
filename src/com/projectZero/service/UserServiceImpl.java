package com.projectZero.service;

import com.projectZero.User;
import com.projectZero.repo.UserDaoImpl;
import com.revature.collection.RevArrayList;

import java.util.List;

public class UserServiceImpl {
    private UserDaoImpl uDao;

    public UserServiceImpl(UserDaoImpl uDao2){
        this.uDao = uDao2;
    }

    public void createUser(String fName, String lName, String username, String pass){
        uDao.createUser(fName,lName,username,pass);
    }

    public RevArrayList<User> getAllUsers(){
        RevArrayList<User> usersList = uDao.getAllUsers();
        return usersList;
    }


}
