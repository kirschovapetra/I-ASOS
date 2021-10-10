package sk.stuba.fei.uim.asos.assignment1.insurance.domain.nonlife;

import sk.stuba.fei.uim.asos.assignment1.insurance.domain.nonlife.enums.PropertyType;
import sk.stuba.fei.uim.asos.assignment1.user.domain.Address;
import sk.stuba.fei.uim.asos.assignment1.user.domain.User;

import java.time.LocalDate;

public class PropertyInsuranceContract extends NonLifeInsuranceContract{

    private Boolean garage;

    public PropertyInsuranceContract() {
        super();
    }

    public PropertyInsuranceContract(Boolean garage) {
        this();
        this.garage = garage;
    }

    public PropertyInsuranceContract(LocalDate creationDate, LocalDate startDate, LocalDate endDate, Double total, Double monthlyPayment, User insurer, PropertyType propertyType, Address propertyAddress, Double propertyValue, Boolean garage) {
        super(creationDate, startDate, endDate, total, monthlyPayment, insurer, propertyType, propertyAddress, propertyValue);
        this.garage = garage;
    }

    public Boolean getGarage() {
        return garage;
    }

    public void setGarage(Boolean garage) {
        this.garage = garage;
    }

    @Override
    public String toString() {
        return "PropertyInsuranceContract{" +
                "garage=" + garage +
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
