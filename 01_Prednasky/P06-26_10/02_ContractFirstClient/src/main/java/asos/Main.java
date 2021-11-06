package asos;

public class Main {

    public static void main(String[] args) {

        ws.PoistenieFromWSDL_Service service = new ws.PoistenieFromWSDL_Service();
        ws.PoistenieFromWSDL port = service.getPoistenieFromWSDLPort();

        ws.Zmluva result = port.hladaj("abc123");
        System.out.println("\n" + result.getCislo()
                         + " " + result.getDruh()
                         + " " + result.getPoistnaSuma()
                         + "\n");

        // majitel je referencia, preto Object
        Object majitel = result.getMajitel();
        ws.Osoba poistenec = result.getPoistenci().get(0);

        
        System.out.print("majitel == poistenec? ");
        System.out.print(majitel == poistenec); // vrati true

    }
}
