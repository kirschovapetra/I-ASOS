package asos;


public class ServiceA {

    private String secret = "A";
    private ServiceB serviceB;

    public ServiceA() {
    }
    
    public ServiceA(ServiceB serviceB) {
        this.serviceB = serviceB;
    }

    public String getSecret() {
        return secret;
    }

    public String getCombinedSecrets() {
        return secret + serviceB.getSecret();
    }

    public ServiceB getServiceB() {
        return serviceB;
    }

    public void setServiceB(ServiceB serviceB) {
        this.serviceB = serviceB;
    }
    
    
}
