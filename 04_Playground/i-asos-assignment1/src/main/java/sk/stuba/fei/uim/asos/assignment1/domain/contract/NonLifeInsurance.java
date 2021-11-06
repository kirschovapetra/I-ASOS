/*
Medzi zmluvy neživotného poistenia patria:

Poistenie domácnosti
- typ nehnuteľnosti (číselníková hodnota, povolené hodnoty sú: "Byt", "Rodinný dom - murovaný", "Rodinný dom - drevený")
- adresa nehnuteľnosti
- hodnota nehnuteľnosti v eurách

- hodnota zariadenia domácnosti v eurách

Poistenie domu a bytu
- typ nehnuteľnosti (číselníková hodnota, povolené hodnoty sú: "Byt", "Rodinný dom - murovaný", "Rodinný dom - drevený")
- adresa nehnuteľnosti
- hodnota nehnuteľnosti v eurách

- pripoistenie garáže (áno / nie)

Trieda zmluvy musí dediť od AbstractInsuranceContract.

 */
package sk.stuba.fei.uim.asos.assignment1.domain.contract;

import sk.stuba.fei.uim.asos.assignment1.PropertyType;
import sk.stuba.fei.uim.asos.assignment1.domain.user.Address;


class NonLifeInsurance extends AbstractInsuranceContract<Long>{

    protected PropertyType propertyType;
    protected Address propertyAddress;
    protected Double propertyValue;

    public NonLifeInsurance() {
    }

    public NonLifeInsurance(Long id, PropertyType propertyType, Address propertyAddress, Double propertyValue) {
        super(id);
        this.propertyType = propertyType;
        this.propertyAddress = propertyAddress;
        this.propertyValue = propertyValue;
    }
   
    
    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    public Address getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(Address propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    public Double getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(Double propertyValue) {
        this.propertyValue = propertyValue;
    }

    @Override
    public String toString() {
        return "NonLifeInsurance{" + "propertyType=" + propertyType + 
                ", propertyAddress=" + propertyAddress + ", propertyValue=" + 
                propertyValue + '}';
    }

    
    
    
}
