package sk.stuba.fei.uim.asos.assignment1.insurance.domain.nonlife;

import sk.stuba.fei.uim.asos.assignment1.insurance.domain.InsuranceContract;
import sk.stuba.fei.uim.asos.assignment1.insurance.domain.nonlife.enums.PropertyType;
import sk.stuba.fei.uim.asos.assignment1.user.domain.Address;
import sk.stuba.fei.uim.asos.assignment1.user.domain.User;

import java.time.LocalDate;

public abstract class NonLifeInsuranceContract extends InsuranceContract {

    protected PropertyType propertyType;
    protected Address propertyAddress;
    protected Double propertyValue;

    public NonLifeInsuranceContract() {
        super();
    }

    public NonLifeInsuranceContract(PropertyType propertyType, Address propertyAddress, Double propertyValue) {
        this();
        this.propertyType = propertyType;
        this.propertyAddress = propertyAddress;
        this.propertyValue = propertyValue;
    }

    public NonLifeInsuranceContract(LocalDate creationDate, LocalDate startDate, LocalDate endDate, Double total, Double monthlyPayment, User insurer, PropertyType propertyType, Address propertyAddress, Double propertyValue) {
        super(creationDate, startDate, endDate, total, monthlyPayment, insurer);
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
}
