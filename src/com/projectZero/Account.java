package com.projectZero;

public class Account {
    private int owner;
    private int accountId;
    public double total;

    public Account(int owner, double balance, int accountId) {
        this.owner = owner;
        this.accountId = accountId;
        this.total = balance;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
