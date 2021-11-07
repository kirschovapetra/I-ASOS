package ws;

import asos.*;
import java.util.*;
import javax.jws.*;


@WebService(serviceName = "JedalenServis")
public class JedalenServis {

    Map<DenEnum, Menu> menuNaTyzden = new HashMap<>();
    @WebMethod
    public void hello(){}
    
    public JedalenServis(){
        for (DenEnum d : DenEnum.values()) {
            menuNaTyzden.put(d, new Menu(d));
        }
    }
    
    @WebMethod
    public Menu getMenu(@WebParam(name = "den") DenEnum den) throws Exception {
        if (den == null)
            throw new Exception("Den nemoze byt null");
        
        if (!menuNaTyzden.containsKey(den)) 
            throw new Exception("ked sa vyhodila tato vynimka, tak som nieco seriozne posrala");
        
        return menuNaTyzden.get(den);
    }
    
    @WebMethod
    public String addJedlo(
            @WebParam(name="jedlo") Jedlo j, 
            @WebParam(name = "den") DenEnum den) throws Exception {
        
        if (j == null || den == null) {
            throw new Exception("Den ani jedlo nemoze byt null");
        }

        
        Menu m = getMenu(den);
        List<Jedlo> ponuka = m.getPonuka();
        
        for (Jedlo jj : ponuka){
            if (jj.getNazov().equals(j.getNazov()))
                throw new Exception("Jedlo sa uz v menu nachadza");
        }
        
        ponuka.add(j);
        return "Success";
    }
}
