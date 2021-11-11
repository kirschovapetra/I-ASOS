/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos;

import java.util.Date;

/**
 *
 * @author petra
 */
public class BankTransfer {
    int id;
    BankAccount src;
    BankAccount trg;
    Date createdAt;
    Date cancelledAt;
    double amount;

    public BankTransfer(int id, BankAccount src, BankAccount trg, Date createdAt, double amount) {
        this.id = id;
        this.src = src;
        this.trg = trg;
        this.createdAt = createdAt;
        this.amount = amount;
      
    }
    
    public void transferMoney() throws Exception {
        
        if (cancelledAt != null)
            throw new Exception("Transakcia je stornovana");
        
        double srcBalance = src.getBalance();
        double trgBalance = trg.getBalance();

        if (amount > srcBalance) {
            throw new Exception("nemas dost money na ucte");
        }

        src.setBalance(srcBalance - amount);
        trg.setBalance(trgBalance + amount);
        
    }
    
    public void cancelTransaction() throws Exception {

        if (cancelledAt != null) {
            throw new Exception("Transakcia je uz stornovana");
        }

        double srcBalance = src.getBalance();
        double trgBalance = trg.getBalance();

        if (amount > trgBalance) {
            throw new Exception("nemas dost money na ucte");
        }

        trg.setBalance(trgBalance - amount);
        src.setBalance(srcBalance + amount);
        
        cancelledAt = new Date();
        
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    
    
    public BankTransfer(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    public BankAccount getSrc() {
        return src;
    }

    public void setSrc(BankAccount src) {
        this.src = src;
    }

    public BankAccount getTrg() {
        return trg;
    }

    public void setTrg(BankAccount trg) {
        this.trg = trg;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getCancelledAt() {
        return cancelledAt;
    }

    public void setCancelledAt(Date cancelledAt) {
        this.cancelledAt = cancelledAt;
    }
    
    
}
