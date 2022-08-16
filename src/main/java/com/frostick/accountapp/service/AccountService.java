package com.frostick.accountapp.service;

import com.frostick.accountapp.data.impl.AccountImpl;
import com.frostick.accountapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The service for the Account Repository.
 */
@Service("accountService")
public class AccountService {
    /**
     * The account repository.
     */
    @Autowired
    private AccountRepository accountRepository;

    /**
     * Get all the Accounts.
     * @return List of accounts
     */
    public List<AccountImpl> getAll() {
        return accountRepository.findAll();
    }

    /**
     * Get a specific account by the id (Account Number)
     * @param id the id
     * @return the Account
     */
    public Optional<AccountImpl> getById(int id) {
        return accountRepository.findById(id);
    }

    /**
     * Save the account passed in.
     * @param account the account
     * @return the account saved
     */
    public AccountImpl saveAccount(AccountImpl account) {
        return accountRepository.save(account);
    }

    /**
     * Save the account passed in.
     * @param id account number
     * @param account the account
     * @return the account saved
     */
    public AccountImpl updateAccount(int id, AccountImpl account) {
        AccountImpl ret;
        Optional<AccountImpl> optional = getById(id);
        if (optional.isPresent()) {
            ret = optional.get();
            if (account.getName() != null) ret.setName(account.getName());
            if (account.getBalance() != double.NaN) ret.setBalance(account.getName());
            return accountRepository.save(ret);
        } else {
            ret = null;
        }
        return ret;
    }

    /**
     * Delete the account with the passed id.
     * @param id id (account number)
     * @return true if successful
     */
    public boolean deleteAccount(int id) {
        accountRepository.deleteById(id);
        return true;
    }
}
