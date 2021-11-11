/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import asos.BankAccount;
import asos.BankTransfer;
import asos.Client;
import asos.Currency;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author petra
 */
@WebService(serviceName = "BankaWS")
public class BankaWS {

    Map<Integer, Client> clients = new HashMap<>();
    Map<String, BankAccount> accounts = new HashMap<>();
    Map<Integer, BankTransfer> transactions = new HashMap<>();
    
    @WebMethod
    public int addClient(@WebParam(name = "name") String name, 
            @WebParam(name = "address") String address) throws Exception {
    
        if (name ==  null || address == null) 
            throw new Exception("Zly input");
        
        
        int id = (int) System.currentTimeMillis();
        Client client = new Client(id, name, address);
        clients.put(id, client);
        
        return id;

    }
    
    @WebMethod
    public String addAccount(
            @WebParam(name = "iban") String iban,
            @WebParam(name = "ownerId") int ownerId,
            @WebParam(name = "balance") double balance,
            @WebParam(name = "currency") Currency currency) throws Exception {
        if (iban == null) 
            throw new Exception("Zly input");
        
        if (!clients.containsKey(ownerId))
            throw new Exception("Taky klient neexistuje");
        
        if (accounts.containsKey(iban))
            throw new Exception("Taky iban uz existuje");

        
        Client owner = clients.get(ownerId);
        BankAccount acc = new BankAccount(iban, owner, balance, currency);
        owner.getBankAccounts().add(iban);
        accounts.put(iban, acc);
        
        return iban;
    }
    
    @WebMethod
    public int createTransfer(@WebParam(name = "src") String srcIban, 
                               @WebParam(name = "trg") String trgIban,
                               @WebParam(name = "amount") double amount) throws Exception{
        
        if (srcIban == null | trgIban == null) {
            throw new Exception("Zly input");
        }
        
        if (!accounts.containsKey(srcIban) || !accounts.containsKey(trgIban))
            throw new Exception("Ucet neexistuje");
        
        
        BankAccount src = accounts.get(srcIban);
        BankAccount trg = accounts.get(trgIban);
        
        int transferId = (int) System.currentTimeMillis();
        BankTransfer tr = new BankTransfer(transferId, src, trg, new Date(), amount);
        tr.transferMoney();
        
        transactions.put(transferId, tr);
        return transferId;
    
    }
    
    
    @WebMethod
    public int cancelTransfer(@WebParam(name = "transferId") int transferId) throws Exception{
        if (!transactions.containsKey(transferId)){
            throw new Exception("Transfer s "+ transferId + " neexistuje");
        }
        
        BankTransfer tr = transactions.get(transferId);
        tr.cancelTransaction();
        
        return transferId;
    }

    
    @WebMethod
    public void withdraw(BankAccount acc, double amount) throws Exception {
        double balance = acc.getBalance();
        
        if (amount > balance)
            throw new Exception("nemas dost money na ucte");
        
        acc.setBalance(balance - amount);
    }
    
    @WebMethod
    public void deposit(BankAccount acc, double amount) {
        double balance = acc.getBalance();
        acc.setBalance(balance + amount);
    }
    
    
    @WebMethod
    public Collection<BankAccount> getAccounts(){
        return accounts.values();
    }
    
    @WebMethod
    public Collection<Client> getClients() {
        return clients.values();
    }

    @WebMethod
    public List<BankTransfer> getCancelledTransactions() {
        List<BankTransfer> canc = new ArrayList<>();
        
        for (BankTransfer tr: transactions.values()){
            if (tr.getCancelledAt() != null)
                canc.add(tr);
        }
        
        return canc;
    }
    
    @WebMethod
    public List<BankTransfer> getNotCancelledTransactions() {
        List<BankTransfer> notCanc = new ArrayList<>();

        for (BankTransfer tr : transactions.values()) {
            if (tr.getCancelledAt() == null) {
                notCanc.add(tr);
            }
        }

        return notCanc;
    }
}
