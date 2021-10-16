/*
Cestovné poistenie

- referenciu na poistenca

- v rámci EU / mimo EU
- účel cesty (číselníková hodnota, povolené sú: pracovne, rekreačne, šport, a pod.)
 */
package sk.stuba.fei.uim.asos.assignment1.domain.contract;

import sk.stuba.fei.uim.asos.assignment1.Purpose;
import sk.stuba.fei.uim.asos.assignment1.domain.user.User;

/**
 *
 * @author petra
 */
public class TravelInsurance extends LifeInsurance {
    private Boolean insideEU;
    private Purpose purpose;

    public TravelInsurance(Boolean insideEU, Purpose purpose, Long id, User insuree) {
        super(id, insuree);
        this.insideEU = insideEU;
        this.purpose = purpose;
    }
    
    public TravelInsurance(){}

    public Boolean getInsideEU() {
        return insideEU;
    }

    public void setInsideEU(Boolean insideEU) {
        this.insideEU = insideEU;
    }

    public Purpose getPurpose() {
        return purpose;
    }

    public void setPurpose(Purpose purpose) {
        this.purpose = purpose;
    }

    @Override
    public String toString() {
        return "TravelInsurance{" + "insuree=" + insuree + "insideEU=" + 
                insideEU + ", purpose=" + purpose + '}';
    }
    
    
    
}
