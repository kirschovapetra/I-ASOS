package ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


// glassfish konzola http://localhost:4848/

@WebService(serviceName = "FirstService")
public class FirstService {

    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
}
