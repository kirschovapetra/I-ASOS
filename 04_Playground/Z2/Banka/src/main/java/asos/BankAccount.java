/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos;

/**
 *
 * @author petra
 */
public class BankAccount {
    String iban;
    Client owner;
    double balance;
    Currency currency;

    public BankAccount(String iban, Client owner, double balance, Currency currency) {
        this.iban = iban;
        this.owner = owner;
        this.balance = balance;
        this.currency = currency;
    }

    public BankAccount(){}
    


    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
    
    
}
