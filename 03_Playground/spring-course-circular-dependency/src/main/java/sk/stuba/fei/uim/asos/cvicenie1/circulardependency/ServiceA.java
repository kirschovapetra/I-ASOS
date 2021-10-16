package sk.stuba.fei.uim.asos.cvicenie1.circulardependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class ServiceA {

    private final String secret = "A";
    private final ServiceB serviceB;

    @Autowired
    public ServiceA(@Lazy ServiceB serviceB) {
        this.serviceB = serviceB;
    }

    // Setter-based DI
//    public void setServiceB(ServiceB serviceB){
//        this.serviceB = serviceB;
//    }

    public String getSecret() {
        return secret;
    }

    public String getCombinedSecrets() {
        return secret + serviceB.getSecret();
    }
}
