package ws;

import asos.BankAccount;
import asos.Client;
import asos.Currency;
import asos.Transfer;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "BankWS")
@Stateless
public class BankWS {

    private Map<String, BankAccount> accounts = new HashMap<>();
    private Map<Integer, Client> clients = new HashMap<>();
    private Map<Integer, Transfer> transfers = new HashMap<>();

    @WebMethod
    public Collection<BankAccount> getAccounts() {
        return accounts.values();
    }
    
    @WebMethod
    public Collection<Client> getClients() {
        return clients.values();
    }
    
    @WebMethod
    public Collection<Transfer> getTransfers() {
        return transfers.values();
    }

    
    @WebMethod
    public int addClient(
            @WebParam(name = "name") String name,
            @WebParam(name = "address") String address) throws Exception {

        if (name == null || address == null) {
            throw new Exception("Incorrect data");
        }
        
        int clientId = new Random().nextInt(10000);
        
        while (clients.containsKey(clientId)) 
            clientId = new Random().nextInt(10000);

        Client cl = new Client(clientId, name, address);
        clients.put(clientId, cl);
        return clientId;
    }

    @WebMethod
    public String addAccount(
            @WebParam(name = "clientId") int clientId,
            @WebParam(name = "iban") String iban,
            @WebParam(name = "currency") Currency currency) {

        if (currency == null || iban == null) {
            return "Incorrect data";
        }
        
        if (!clients.containsKey(clientId)) {
            return "Unknown client";
        }

        if (accounts.containsKey(iban)) {
            return "Bank account already exists";
        }
        
        Client owner = clients.get(clientId);
        BankAccount acc = new BankAccount(iban, currency, 0, owner);
        owner.addAccount(acc);
        accounts.put(iban, acc);
        
        return "Success";
    }

    @WebMethod
    public int transferMoney(
            @WebParam(name = "srcIban") String srcIban, 
            @WebParam(name = "targIban") String targIban, 
            @WebParam(name = "amount") double amount, 
            @WebParam(name = "cur") Currency cur) throws Exception {
        
        if (srcIban == null || targIban == null || cur == null || 
                !accounts.containsKey(srcIban) || !accounts.containsKey(targIban)) {
            throw new Exception("Incorrect data");
        }

        
        BankAccount src = accounts.get(srcIban);
        BankAccount targ = accounts.get(targIban);
        
        if (src.getCurrency() != targ.getCurrency())
            throw new Exception("src currency != target currency");
        
        int transfId = new Random().nextInt(10000);

        while (transfers.containsKey(transfId))
            transfId = new Random().nextInt(10000);
        
        Transfer transf = new Transfer(transfId, new Date(), src, targ, amount, cur);
        
        withdrawMoney(src.getIban(), amount, src.getCurrency());
        putMoney(targ.getIban(), amount, targ.getCurrency());
        
        transfers.put(transfId, transf);
        
        return transf.getId();
    }
    
    @WebMethod
    public double putMoney(String iban, double amount, Currency currency) throws Exception {
        if (currency == null || iban == null || !accounts.containsKey(iban)) 
        {
            throw new Exception("Incorrect data");
        }
   
        
        BankAccount target = accounts.get(iban);
        
        if (target.getCurrency() != currency)
            throw new Exception("Incorrect currency");
        
        target.setBalance(target.getBalance()+amount);
        
        return target.getBalance();
    }
    
    @WebMethod
    public double withdrawMoney(String iban, double amount, Currency currency) throws Exception {
        if (currency == null || iban == null || !accounts.containsKey(iban)) {
            throw new Exception("Incorrect data");
        }

        BankAccount source = accounts.get(iban);

        if (source.getCurrency() != currency) {
            throw new Exception("Incorrect currency");
        }

        source.setBalance(source.getBalance() - amount);

        return source.getBalance();
    }
    
}
