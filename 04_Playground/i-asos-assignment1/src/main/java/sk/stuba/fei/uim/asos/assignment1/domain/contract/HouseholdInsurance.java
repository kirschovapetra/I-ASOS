/*
Poistenie domácnosti
- typ nehnuteľnosti (číselníková hodnota, povolené hodnoty sú: "Byt", "Rodinný dom - murovaný", "Rodinný dom - drevený")
- adresa nehnuteľnosti
- hodnota nehnuteľnosti v eurách

- hodnota zariadenia domácnosti v eurách
 */
package sk.stuba.fei.uim.asos.assignment1.domain.contract;

import sk.stuba.fei.uim.asos.assignment1.PropertyType;
import sk.stuba.fei.uim.asos.assignment1.domain.user.Address;


public class HouseholdInsurance extends NonLifeInsurance {
    private Double furnitureValue;

    public HouseholdInsurance() {
    }

    public HouseholdInsurance(Long id, Double furnitureValue, PropertyType propertyType, Address propertyAddress, Double propertyValue) {
        super(id, propertyType, propertyAddress, propertyValue);
        this.furnitureValue = furnitureValue;
    }

    @Override
    public String toString() {
        return "HouseholdInsurance{" + "propertyType=" + propertyType + 
                ", propertyAddress=" + propertyAddress + ", propertyValue=" + 
                propertyValue + "furnitureValue=" + furnitureValue + '}';
    } 
}
