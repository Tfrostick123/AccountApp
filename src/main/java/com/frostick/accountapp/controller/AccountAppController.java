package com.frostick.accountapp.controller;

import com.frostick.accountapp.data.impl.AccountImpl;
import com.frostick.accountapp.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * The Rest Controller for the Account App.
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/accounts")
public class AccountAppController {
    /**
     * The Account Service.
     */
    @Resource(name = "accountService")
    private AccountService accountService;

//    private static Map<String, String> CORS_MAP;
//
//    static {
//        CORS_MAP = new HashMap<String, String>();
//        CORS_MAP.put("Access-Control-Allow-Origin", "*");
//        CORS_MAP.put("Access-Control-Allow-Methods", "GET, POST, PATCH, PUT, DELETE, OPTIONS");
//        CORS_MAP.put("Access-Control-Allow-Headers", "Origin, Content-Type, X-Auth-Token");
//    }

    /**
     * Get all the accounts.
     * @return ResponseEntity wrapping the list of accounts
     */
    @GetMapping
    public ResponseEntity<Object> getAccounts() {
        return new ResponseEntity<>(accountService.getAll(), HttpStatus.OK);
    }

    /**
     * Save an account.
     * @param account the account
     * @return ResponseEntity wrapping the saved account
     */
    @PostMapping(value = "/account")
    public ResponseEntity<Object> saveAccount(@RequestBody AccountImpl account) {
        return new ResponseEntity<>(accountService.saveAccount(account), HttpStatus.OK);
    }

    /**
     * Save an account.
     * @param account the account
     * @return ResponseEntity wrapping the saved account
     */
    @PutMapping(value = "/account/{accountNumber}")
    public ResponseEntity<Object> updateAccount(@PathVariable int accountNumber, @RequestBody AccountImpl account) {
        return new ResponseEntity<>(accountService.updateAccount(accountNumber, account), HttpStatus.OK);
    }

    /**
     * Delete the account with the passed account number.
     * @param accountNumber the account number
     * @return true if successful
     */
    @DeleteMapping("/account/{accountNumber}")
    public ResponseEntity<Object> deleteAccount(@PathVariable int accountNumber) {
        return new ResponseEntity<>(accountService.deleteAccount(accountNumber), HttpStatus.OK);
    }

//    @GetMapping("/account/{name}")
//    public ResponseEntity<Object> getAccount(@RequestParam(value = "name") @PathVariable String name) {
//        return null;
//    }

    /**
     * Get the account for the passed account number.
     * @param accountNumber the account number
     * @return Response Entity wrapping the account
     */
    @GetMapping("/account/{accountNumber}")
    public ResponseEntity<Object> getAccount(@PathVariable int accountNumber) {
        return new ResponseEntity<>(accountService.getById(accountNumber), HttpStatus.OK);
    }

}
