package com.igorpardinho.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private String ag;
    private int lastAccount = 1;

    private List<Account> accounts;
    public Bank(String ag){
        this.ag = ag;
        this.accounts = new ArrayList<>();
    }

    public void bankTotal(){
        double totalAccount = 0;
        for (Account account: accounts){
            totalAccount += account.getCash();
        }
        System.out.println("Total depositado no banco R$" + totalAccount);
    }
    public List<Account> getAccounts(){
        return accounts;
    }
    public void insertAccount(Account account){
        accounts.add(account);
    }
    public Account generateAccount(String name){
        Account account = new Account(ag,""+ lastAccount,name);
        lastAccount++;
        return account;
    }
}
