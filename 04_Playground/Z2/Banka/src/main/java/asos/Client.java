/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author petra
 */
public class Client {
    int id;
    String name;
    String address;
    List<String> bankAccounts = new ArrayList<>();

    public Client(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
    
    public Client(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<String> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }
    
    
}
