package com.frostick.accountapp.data.impl;

import com.frostick.accountapp.data.Account;

import javax.persistence.*;
import java.util.Objects;

/**
 * The Implementation for the Account object.
 */
@Entity
@Table(name = "account", schema = "account")
@NamedQuery(name = "Account.byName", query = "SELECT a from AccountImpl a where a.name = ?1")
public class AccountImpl implements Account {

    /** Account number. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_number")
    private int accountNumber;
    /** Name. */
    @Basic
    @Column(name = "name")
    private String name;
    /** Account Balance. */
    @Basic
    @Column(name = "balance")
    private double balance;

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setAccountNumber(final int accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getBalance() {
        return balance;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setBalance(final double balance) {
        this.balance = balance;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountImpl account = (AccountImpl) o;
        return accountNumber == account.accountNumber && Double.compare(account.balance, balance) == 0 && Objects.equals(name, account.name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, name, balance);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "AccountImpl{" +
                "accountNumber=" + accountNumber +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
