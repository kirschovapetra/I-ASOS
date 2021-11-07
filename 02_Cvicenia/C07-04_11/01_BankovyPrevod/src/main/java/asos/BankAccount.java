/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos;

import java.util.Objects;

/**
 *
 * @author petra
 */
public class BankAccount {
    private Currency currency;
    private double balance;
    private Client owner;
    private String iban;

    public BankAccount(String iban, Currency currency, double balance, Client owner) {
        this.currency = currency;
        this.balance = balance;
        this.owner = owner;
        this.iban = iban;
    }

    public BankAccount(){}
    
    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.iban);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BankAccount other = (BankAccount) obj;
        if (!Objects.equals(this.iban, other.iban)) {
            return false;
        }
        return true;
    }
    
    
}
