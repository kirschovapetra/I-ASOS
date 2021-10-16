/*
- referenciu na poistenca

- trvalé následky úrazu (poistná suma v eurách)
- Smrť v dôsledku úrazu (poistná suma v eurách)
- Denné odškodné za hospitalizáciu (poistná suma v eurách)
- Územná platnosť (číselníková hodnota, povolené hodnoty sú: “Slovensko”, “Svet”, “Svet + Slovensko”)
 */
package sk.stuba.fei.uim.asos.assignment1.domain.contract;

import sk.stuba.fei.uim.asos.assignment1.Region;
import sk.stuba.fei.uim.asos.assignment1.domain.user.User;

/**
 *
 * @author petra
 */
public class InjuryInsurance extends LifeInsurance{
    private Double longTermAmount;
    private Double deathAmount;
    private Double dailyAmount;
    private Region region;

    
    public InjuryInsurance(){}
    
    
    public InjuryInsurance(Double longTermAmount, Double deathAmount, Double dailyAmount, Region region, Long id, User insuree) {
        super(id, insuree);
        this.longTermAmount = longTermAmount;
        this.deathAmount = deathAmount;
        this.dailyAmount = dailyAmount;
        this.region = region;
    }

    public Double getLongTermAmount() {
        return longTermAmount;
    }

    public void setLongTermAmount(Double longTermAmount) {
        this.longTermAmount = longTermAmount;
    }

    public Double getDeathAmount() {
        return deathAmount;
    }

    public void setDeathAmount(Double deathAmount) {
        this.deathAmount = deathAmount;
    }

    public Double getDailyAmount() {
        return dailyAmount;
    }

    public void setDailyAmount(Double dailyAmount) {
        this.dailyAmount = dailyAmount;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "InjuryInsurance{" + "insuree=" + insuree + "longTermAmount=" + 
                longTermAmount + ", deathAmount=" + deathAmount + 
                ", dailyAmount=" + dailyAmount + ", region=" + region + '}';
    }
    
    
}
