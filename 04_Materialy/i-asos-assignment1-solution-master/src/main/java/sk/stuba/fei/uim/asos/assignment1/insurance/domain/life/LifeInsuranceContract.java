package sk.stuba.fei.uim.asos.assignment1.insurance.domain.life;

import sk.stuba.fei.uim.asos.assignment1.insurance.domain.InsuranceContract;
import sk.stuba.fei.uim.asos.assignment1.user.domain.User;

import java.time.LocalDate;

public abstract class LifeInsuranceContract extends InsuranceContract {

    protected User insured;

    public LifeInsuranceContract() {
        super();
    }

    public LifeInsuranceContract(User insured) {
        this();
        this.insured = insured;
    }

    public LifeInsuranceContract(LocalDate creationDate, LocalDate startDate, LocalDate endDate, Double total, Double monthlyPayment, User insurer, User insured) {
        super(creationDate, startDate, endDate, total, monthlyPayment, insurer);
        this.insured = insured;
    }

    public User getInsured() {
        return insured;
    }

    public void setInsured(User insured) {
        this.insured = insured;
    }
}
