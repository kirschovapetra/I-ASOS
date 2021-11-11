/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import ws.Exception_Exception;

/**
 *
 * @author petra
 */
public class Main {

    static void pridajSpoje(ws.AutobusWS_Service service, ws.AutobusWS port) {

        try {

            List<String> volneMiesta = new ArrayList<>();
            volneMiesta.add("A1");
            volneMiesta.add("A2");
            volneMiesta.add("A3");
            volneMiesta.add("B1");
            volneMiesta.add("B2");
            volneMiesta.add("B3");
            volneMiesta.add("C1");
            volneMiesta.add("C2");
            volneMiesta.add("C3");

            port.pridajSpoj("BA-KE", "Kosice", volneMiesta);
            port.pridajSpoj("KE-BA", "Bratislava", volneMiesta);
            port.pridajSpoj("BA-TT", "Trnava", volneMiesta);
            port.pridajSpoj("TT-BA", "Bratislava", volneMiesta);

        } catch (Exception_Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    static void cestPoriadok(ws.AutobusWS_Service service, ws.AutobusWS port) {
        List<ws.Spoj> spoje = port.cestovnyPoriadok();
        for (ws.Spoj sp : spoje) {
            System.out.println(sp.getNazov() + " " + sp.getCiel() + " " + sp.getVolneMiesta());
        }
    }

    static void rezervuj(ws.AutobusWS_Service service, ws.AutobusWS port, String miesto) {

        try {

            javax.xml.ws.AsyncHandler<ws.RezervujMiestoResponse> asyncHandler
                    = (javax.xml.ws.Response<ws.RezervujMiestoResponse> response) -> {
                        try {
                            System.out.println("Result = " + response.get().getReturn());
                        } catch (InterruptedException | ExecutionException ex) {
                        }
                    };
            java.util.concurrent.Future<? extends java.lang.Object> result = 
                    port.rezervujMiestoAsync("BA-KE", miesto, asyncHandler);
            int i = 0;
            while (!result.isDone()) {
                System.out.println("..." + i++);
                Thread.sleep(100);
            }
        } catch (InterruptedException ex) {}

    }

    public static void main(String[] args) {
        ws.AutobusWS_Service service = new ws.AutobusWS_Service();
        ws.AutobusWS port = service.getAutobusWSPort();

//        pridajSpoje(service, port);
//        cestPoriadok(service, port);
        rezervuj(service, port, "B1");
//        rezervuj(service, port, "B2");
        rezervuj(service, port, "C3");
        cestPoriadok(service, port);
    }
}
