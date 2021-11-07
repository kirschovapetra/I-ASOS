/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import asos.DenEnum;
import asos.Jedlo;
import asos.MenuMap;
import java.util.HashMap;
import java.util.Map;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "JedalenServisMap")
public class JedalenServisMap {

    Map<DenEnum, MenuMap> menuNaTyzden = new HashMap<>();

    public JedalenServisMap() {
        for (DenEnum d : DenEnum.values()) {
            menuNaTyzden.put(d, new MenuMap(d));
        }
    }

    @WebMethod
    public MenuMap getMenu(@WebParam(name = "den") DenEnum den) throws Exception {
        if (den == null) {
            throw new Exception("Den nemoze byt null");
        }

        if (!menuNaTyzden.containsKey(den)) {
            throw new Exception("ked sa vyhodila tato vynimka, tak som nieco seriozne posrala");
        }

        return menuNaTyzden.get(den);
    }

    public String addJedlo(
            @WebParam(name = "jedlo") Jedlo j,
            @WebParam(name = "den") DenEnum den) throws Exception {

        if (j == null || den == null) {
            throw new Exception("Den ani jedlo nemoze byt null");
        }

        MenuMap m = getMenu(den);
        Map<String, Jedlo> ponuka = m.getPonuka();

        if (ponuka.containsKey(j.getNazov())) {
            throw new Exception("Jedlo sa uz v menu nachadza");
        }

        ponuka.put(j.getNazov(), j);
        return "Success";
    }
}
