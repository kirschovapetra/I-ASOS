/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos;

import ws.Exception_Exception;

/**
 *
 * @author petra
 */
public class Main {

    static void printClients(ws.BankaWS port) {
        port.getClients().forEach(cl -> {
            System.out.println(cl.getId() + " " + cl.getName() + " " + cl.getAddress());
        });
    }

    static void printAccounts(ws.BankaWS port) {
        port.getAccounts().forEach(cl -> {
            System.out.println(cl.getIban()
                    + " owner:" + cl.getOwner().getId()
                    + " balance: " + cl.getBalance());
        });
    }

    static void printCancelledTransactions(ws.BankaWS port) {
        port.getCancelledTransactions().forEach(cl -> {
            System.out.println(cl.getId()
                    + " src:" + cl.getSrc().getIban()
                    + " trg:" + cl.getTrg().getIban()
                    + " created:" + cl.getCreatedAt()
                    + " cancelled:" + cl.getCancelledAt());
        });
    }

    static void printNotCancelledTransactions(ws.BankaWS port) {
        port.getNotCancelledTransactions().forEach(cl -> {
            System.out.println(cl.getId()
                    + " src:" + cl.getSrc().getIban()
                    + " trg:" + cl.getTrg().getIban()
                    + " created:" + cl.getCreatedAt()
                    + " cancelled:" + cl.getCancelledAt());
        });
    }

    public static void main(String[] args) {

        try {

            ws.BankaWS_Service service = new ws.BankaWS_Service();
            ws.BankaWS port = service.getBankaWSPort();

            int id1 = port.addClient("aa", "123");
            int id2 = port.addClient("bb", "456");
            int id3 = port.addClient("cc", "789");
            System.out.println("\nClients");
            printClients(port);

            String iban1_1 = port.addAccount("123456", id1, 1000.0, ws.Currency.EUR);
            String iban1_2 = port.addAccount("aaabbb", id1, 2000.0, ws.Currency.EUR);
            String iban2 = port.addAccount("987654", id2, 3000.0, ws.Currency.EUR);

            System.out.println("\nAccounts before transactions");
            printAccounts(port);

            int trId1 = port.createTransfer(iban1_1, iban2, 10.0);
            int trId2 = port.createTransfer(iban1_1, iban2, 10.0);
            int trId3 = port.createTransfer(iban1_2, iban2, 10.0);

            System.out.println("\nAccounts after transactions");

            printAccounts(port);

            int cancId = port.cancelTransfer(trId1);
            System.out.println("\nAccounts canceled transactions");
            printAccounts(port);
            
            System.out.println("\nNot canceled transactions");
            printNotCancelledTransactions(port);
            
            System.out.println("\nCanceled transactions");
            printCancelledTransactions(port);

        } catch (Exception_Exception ex) {
            System.out.println(ex.getMessage());

        }

    }
}
