package com.frostick.accountapp.data;

public interface Account {

    /**
     * @return name
     */
    String getName();

    /**
     * @param name
     */
    void setName(String name);

    /**
     * @return
     */
    int getAccountNumber();

    /**
     * @param accountNumber
     */
    void setAccountNumber(int accountNumber);

    /**
     * @return
     */
    double getBalance();

    /**
     * @param balance
     */
    void setBalance(double balance);
}
