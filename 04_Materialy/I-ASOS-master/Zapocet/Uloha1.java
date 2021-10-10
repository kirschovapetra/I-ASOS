/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uloha1;

import java.util.List;

/**
 *
 * @author vsa
 */
public class Uloha1 {

    /**
     * @param args the command line arguments
     */
    private static String AIS_ID = "xxxxx";
    private static String Stanica = "Zvolen";
    public static void main(String[] args) {

        List<ws.Spoj> poriadok = cestovnyPoriadok(AIS_ID);
        
        String rez_m = "";
        String rez_s = "";
        
        for(ws.Spoj spoj : poriadok) {
            if(spoj.getStanica().equalsIgnoreCase(Stanica)) {
                for(String miesto : spoj.getVolneMiesta()) {
                    rez_m = miesto;
                    rez_s = spoj.getNazovSpoja();
                    break;
                }
            }
        }
        // Uloha A
        /*
            String ret = rezervujMiesto(AIS_ID, rez_s, rez_m);
            System.out.println("Miesto: "+ rez_m + " Spoj: " + rez_s+ " Odpoved: "+ ret);
        */
        
        // Uloha B
        rezervujMiestoAsync(AIS_ID, rez_s, rez_m);

    }

    private static java.util.List<ws.Spoj> cestovnyPoriadok(java.lang.String cestujuci) {
        ws.AutobusWS_Service service = new ws.AutobusWS_Service();
        ws.AutobusWS port = service.getAutobusWSPort();
        return port.cestovnyPoriadok(cestujuci);
    }

    private static String rezervujMiesto(java.lang.String cestujuci, java.lang.String nazovSpoja, java.lang.String miesto) {
        ws.AutobusWS_Service service = new ws.AutobusWS_Service();
        ws.AutobusWS port = service.getAutobusWSPort();
        return port.rezervujMiesto(cestujuci, nazovSpoja, miesto);
    }
    
    private static void rezervujMiestoAsync(String cestujuci, String nazovSpoja, String miesto) {
        try { // Call Web Service Operation(async. callback)
            ws.AutobusWS_Service service = new ws.AutobusWS_Service();
            ws.AutobusWS port = service.getAutobusWSPort();
            // TODO initialize WS operation arguments here
            javax.xml.ws.AsyncHandler<ws.RezervujMiestoResponse> asyncHandler = new javax.xml.ws.AsyncHandler<ws.RezervujMiestoResponse>() {
                public void handleResponse(javax.xml.ws.Response<ws.RezervujMiestoResponse> response) {
                    try {
                        // TODO process asynchronous response here
                        System.out.println("Miesto: "+ miesto + " Spoj: " + nazovSpoja+ " Odpoved: "+ response.get().getReturn());
                    } catch(Exception ex) {
                        // TODO handle exception
                    }
                }
            };
            java.util.concurrent.Future<? extends java.lang.Object> result = port.rezervujMiestoAsync(cestujuci, nazovSpoja, miesto, asyncHandler);
            while(!result.isDone()) {
                // do something
                Thread.sleep(100);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
    }
}
