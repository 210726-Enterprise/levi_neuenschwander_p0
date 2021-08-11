package com.projectZero;
//imports
import com.projectZero.repo.AccountDaoImpl;
import com.projectZero.repo.UserDaoImpl;
import com.projectZero.service.AccountServiceImpl;
import com.projectZero.service.UserServiceImpl;
import com.revature.collection.RevArrayList;
import java.text.DecimalFormat;
import java.util.Scanner;


/**
 * Class UserMenus to create all user interaction.
 */
public class UserMenus {

    /**
     * Instance variables
     */
    static Scanner sc = new Scanner(System.in);
    static UserServiceImpl usi = new UserServiceImpl(new UserDaoImpl());
    static AccountServiceImpl asi = new AccountServiceImpl(new AccountDaoImpl());
    private static boolean validated = false;
    static UserFunction uf;
    static DecimalFormat df = new DecimalFormat("#.00");


    /**
     * Initial menu for user input
     */
    public static void StartMenu(){

        System.out.println("1) Login");
        System.out.println("2) Create a New Account");
        System.out.println("3) Exit");
        String choice = sc.nextLine();
        switch(choice){
            case "1":
                System.out.println("Enter your login information");
                loginMenu();
            case "2":
                System.out.println("Create your profile");
                createMenu();
            case"3":
                System.exit(0);
            default:
                System.out.println("Please enter one of the options.");
        }
    }


    /**
     * Menu to allow an existing user to login
     */
    public static void loginMenu(){
        System.out.println("Username: ");
        String username = sc.nextLine();
        System.out.println("Password: ");
        String pass = sc.nextLine();
        validate(username, pass);
        if(validated){
            systemMenu();
        }
        else{
            System.out.println("Your username and password didn't match up, try again.");
            loginMenu();
        }
    }


    /**
     * Menu to allow a user to create their profile in the database.
     */
    public static void createMenu(){
        System.out.println("First Name: ");
        String fName = sc.nextLine();
        System.out.println("Last Name: ");
        String lName = sc.nextLine();
        System.out.println("Username: ");
        String username = sc.nextLine();
        System.out.println("Password: ");
        String pass = sc.nextLine();
        usi.createUser(fName, lName, username, pass);
        StartMenu();
    }

    /**
     * Menu for existing users after logging in
     */
    public static void systemMenu(){
        System.out.println("Welcome, " + uf.getUser().getFName() + ", what would you like to do?");
        System.out.println("1) Deposit Funds");
        System.out.println("2) Withdraw Funds");
        System.out.println("3) View Account Balance");
        System.out.println("4) Logout");
        String choice = sc.nextLine();
        switch(choice){
            case "1":
                deposit();
            case "2":
                withdraw();
            case "3":
                viewBalance();
            case "4":
                logout();
            default:
                System.out.println("Please enter one of the options.");
                systemMenu();
        }
    }

    /**
     * Method to validate the credentials given in loginmenu against database values
     * @param u user inputted username
     * @param p user inputted password
     * @return true if login is successful
     */
    public static boolean validate(String u, String p){
        RevArrayList<User> userList = usi.getAllUsers();
        User user = null;
        boolean status = false;
        int count = 0;
        while(!status){
            user = userList.get(count);
            if(user.getUsername().equals(u)){
                status = true;
            }
            count++;
            if(count == userList.size()){
                status = true;
            }
        }
        if(user.getPassword().equals(p)){
            uf = new UserFunction(user);
            userAccount();
            validated = true;
            return true;
        }
        else{
            System.out.println("Your credentials did not match, try again.");
            loginMenu();
        }
        return false;
    }

    /**
     * Method to check user given deposit amount for proper format
     */
    public static void deposit(){
        System.out.println("Deposit:");
        System.out.println("How much do you want to deposit?");
        String amount = sc.nextLine();
        try{
            uf.deposit(Double.parseDouble(amount));
        }catch(NumberFormatException e){
            System.out.println("Please enter a double");
            deposit();
        }
        systemMenu();
    }

    /**
     * Method to check user given input for proper format
     */
    public static void withdraw(){
        System.out.println("Withdraw:");
        System.out.println("How much do you want to withdraw?");
        String amount = sc.nextLine();
        try{
            uf.withdraw(Double.parseDouble(amount));
        }catch(NumberFormatException e){
            System.out.println("Please enter a double");
            withdraw();
        }
        systemMenu();
    }

    /**
     * Method to print the current balance of a users account
     */
    public static void viewBalance(){
        System.out.println("Here is your balance: ");
        System.out.println("$" + df.format(uf.viewBalance()));
        systemMenu();
    }

    /**
     * Method to set currently logged in user and check if they have an account
     */
    public static void userAccount(){
        {
            boolean status = false;
            RevArrayList<Account> accountList = asi.getAccounts();
            for(int i = 0; i < accountList.size(); i++){
                if(accountList.get(i).getOwner() == uf.getUser().getId()){
                    uf.setAccount((accountList.get(i)));
                    status = true;
                }
            }
            if(!status) {
                System.out.println("You don't have an account yet, let's create one.");
                System.out.println("How much would you like to deposit?");
                double initial = sc.nextDouble();
                asi.createAccount(initial,uf.getUser().getId());
                userAccount();
            }
        }
    }

    /**
     * Method for user to exit back to initial menu
     */
    public static void logout(){
        System.out.println("Goodbye");
        uf.setUser(null);
        uf.setAccount(null);
        StartMenu();
    }
}
