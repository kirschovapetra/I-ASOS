/*
Poistenie domu a bytu
- typ nehnuteľnosti (číselníková hodnota, povolené hodnoty sú: "Byt", "Rodinný dom - murovaný", "Rodinný dom - drevený")
- adresa nehnuteľnosti
- hodnota nehnuteľnosti v eurách

- pripoistenie garáže (áno / nie)
 */
package sk.stuba.fei.uim.asos.assignment1.domain.contract;

import sk.stuba.fei.uim.asos.assignment1.PropertyType;
import sk.stuba.fei.uim.asos.assignment1.domain.user.Address;


public class HouseApartmentInsurance extends NonLifeInsurance{
    private boolean garageInsurance;

    public HouseApartmentInsurance() {
    }

    public HouseApartmentInsurance(boolean garageInsurance, Long id, PropertyType propertyType, Address propertyAddress, Double propertyValue) {
        super(id, propertyType, propertyAddress, propertyValue);
        this.garageInsurance = garageInsurance;
    }

    public boolean isGarageInsurance() {
        return garageInsurance;
    }

    public void setGarageInsurance(boolean garageInsurance) {
        this.garageInsurance = garageInsurance;
    }


    @Override
    public String toString() {
        return "NonLifeInsurance{" + "propertyType=" + propertyType + 
                ", propertyAddress=" + propertyAddress + ", propertyValue=" + 
                propertyValue + "garageInsurance=" + garageInsurance +'}';
    }
}
