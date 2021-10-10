package sk.stuba.fei.uim.asos.assignment1.insurance.domain.nonlife;

import sk.stuba.fei.uim.asos.assignment1.insurance.domain.nonlife.enums.PropertyType;
import sk.stuba.fei.uim.asos.assignment1.user.domain.Address;
import sk.stuba.fei.uim.asos.assignment1.user.domain.User;

import java.time.LocalDate;

public class HouseholdInsuranceContract extends NonLifeInsuranceContract{

    private Double householdValue;

    public HouseholdInsuranceContract() {
        super();
    }

    public HouseholdInsuranceContract(Double householdValue) {
        this();
        this.householdValue = householdValue;
    }

    public HouseholdInsuranceContract(LocalDate creationDate, LocalDate startDate, LocalDate endDate, Double total, Double monthlyPayment, User insurer, PropertyType propertyType, Address propertyAddress, Double propertyValue, Double householdValue) {
        super(creationDate, startDate, endDate, total, monthlyPayment, insurer, propertyType, propertyAddress, propertyValue);
        this.householdValue = householdValue;
    }

    public Double getHouseholdValue() {
        return householdValue;
    }

    public void setHouseholdValue(Double householdValue) {
        this.householdValue = householdValue;
    }

    @Override
    public String toString() {
        return "HouseholdInsuranceContract{" +
                "householdValue=" + householdValue +
                ", propertyType=" + propertyType +
                ", propertyAddress=" + propertyAddress +
                ", propertyValue=" + propertyValue +
                ", creationDate=" + creationDate +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", total=" + total +
                ", monthlyPayment=" + monthlyPayment +
                ", insurer=" + insurer +
                ", id=" + id +
                '}';
    }
}
