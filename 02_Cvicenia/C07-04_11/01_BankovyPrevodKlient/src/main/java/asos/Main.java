
package asos;

import ws.Currency;
import ws.Exception_Exception;

public class Main {
    public static void main(String[] args) {
        
        try { 
            ws.BankWS_Service service = new ws.BankWS_Service();
            ws.BankWS port = service.getBankWSPort();

//            int jmId = port.addClient("Jozko Mrkvicka", "HornaDolna");
//            int fmId = port.addClient("Ferko Mrkvicka", "HornaDolna");
                
            int jmId = 5509;
            int fmId = 9277;
//            System.out.println("jmId = " + jmId + " fmId = " + fmId);
            
//            System.out.println("JM: " + port.addAccount(jmId, "000000", Currency.EUR));
//            System.out.println("FM: " +port.addAccount(fmId, "111111", Currency.EUR));
//            
//            System.out.println("JM: " + port.putMoney("000000", 1000, Currency.EUR));
//            System.out.println("FM: " + port.putMoney("111111", 1000, Currency.EUR));
//            
//            System.out.println("JM: " + port.withdrawMoney("000000", 100, Currency.EUR));
//            System.out.println("FM: " +port.withdrawMoney("111111", 10, Currency.EUR));

            System.out.println(port.transferMoney("111111", "000000", 10, Currency.EUR));
         
            System.out.println(port.transferMoney("000000", "111111", 20, Currency.EUR));
            
        } catch (Exception_Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
