package sk.stuba.fei.uim.asos.cvicenie1.circulardependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceB {

    private final String secret = "B";
    private final ServiceA serviceA;

    @Autowired
    public ServiceB(ServiceA serviceA) {
        this.serviceA = serviceA;
    }

    public String getSecret() {
        return secret;
    }

    public String getCombinedSecrets() {
        return secret + serviceA.getSecret();
    }
}
