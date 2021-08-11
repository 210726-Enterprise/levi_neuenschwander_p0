package com.projectZero.repo;

/*
imports
 */
import com.projectZero.Account;
import com.projectZero.util.ConnectionFactory;
import com.revature.collection.RevArrayList;
import java.sql.*;

/*
Class for database functionality of accounts
 */
public class AccountDaoImpl {
    /**
     * Method to retrieve all accounts from the database
     * @return list of accounts from the database
     */
    public RevArrayList<Account> getAccounts() {
        Connection connection = ConnectionFactory.getConnection();

        RevArrayList<Account> accountList = new RevArrayList<>();

        String sql = "SELECT * FROM accounts";
        Statement s;
        try {
            s = connection.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                accountList.add(new Account(rs.getInt(3),rs.getInt(2),rs.getInt(1)));
            }
            //implement with class made lists
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accountList;
    }

    /**
     * Method to create a new account in the database
     * @param b balance of new account
     * @param userid database id of owner of new account
     */
    public void createAccount(double b, int userid){
        Connection connection = ConnectionFactory.getConnection();
        String sql = "INSERT INTO accounts (Balance, UserId) VALUES (?,?);";
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql);
            ps.setDouble(1, b);
            ps.setInt(2, userid);
            ps.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to update the balance of an existing account in the database
     * @param newBalance new balance of account
     * @param a account to be updated
     */
    public void setBalance(double newBalance, Account a){
        Connection connection = ConnectionFactory.getConnection();
        String sql = "UPDATE accounts SET balance = ? where accountid = ?;";
        PreparedStatement ps;

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(2,a.getAccountId());
            ps.setDouble(1, newBalance);
            System.out.println(newBalance);
            ps.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
