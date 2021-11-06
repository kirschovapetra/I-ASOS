package asos;

public class Main {
    
    public static ws.Zmluva hladaj(){
        ws.PoistenieFromWSDL_Service service = new ws.PoistenieFromWSDL_Service();
        ws.PoistenieFromWSDL port = service.getPoistenieFromWSDLPort();
        ws.Zmluva result = port.hladaj("cislo111");
        System.out.println("\n" + result.getCislo()
                + " " + result.getDruh()
                + " " + result.getPoistnaSuma()
                + "\n");
        
        return result;
    }
    
    public static void vytvor(ws.Zmluva zmluva) {
        ws.PoistenieFromWSDL_Service service = new ws.PoistenieFromWSDL_Service();
        ws.PoistenieFromWSDL port = service.getPoistenieFromWSDLPort();
        String result = port.vytvor(zmluva);
        System.out.println("\n" + result + "\n");
    }
    
    public static void main(String[] args) {
        
        ws.Zmluva zmluva = hladaj();
        vytvor(zmluva);

    }
}
