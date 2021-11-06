package asos;

public class ServiceB {

    private String secret = "B";
    private ServiceA serviceA;

    public ServiceB() {}
    
    public ServiceB(ServiceA serviceA) {
        this.serviceA = serviceA;
    }

    
    public String getSecret() {
        return secret;
    }

    public String getCombinedSecrets() {
        return secret + serviceA.getSecret();
    }

    public ServiceA getServiceA() {
        return serviceA;
    }

    public void setServiceA(ServiceA serviceA) {
        this.serviceA = serviceA;
    }
    
    
}
