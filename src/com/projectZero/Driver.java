package com.projectZero;

import com.projectZero.repo.UserDaoImpl;
import com.projectZero.util.ConnectionFactory;

public class Driver {

    public static void main(String[] args) {
//        UserDaoImpl udi = new UserDaoImpl();
//        udi.getAllUsers();
        UserMenus.StartMenu();
    }
}
