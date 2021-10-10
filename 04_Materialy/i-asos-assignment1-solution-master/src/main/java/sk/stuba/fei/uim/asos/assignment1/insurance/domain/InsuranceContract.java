package sk.stuba.fei.uim.asos.assignment1.insurance.domain;

import sk.stuba.fei.uim.asos.assignment1.user.domain.User;

import java.time.LocalDate;

public abstract class InsuranceContract extends AbstractInsuranceContract<Long> {

    protected LocalDate creationDate;
    protected LocalDate startDate;
    protected LocalDate endDate;
    protected Double total;
    protected Double monthlyPayment;
    protected User insurer;

    public InsuranceContract() {
        super();
    }

    public InsuranceContract(LocalDate creationDate, LocalDate startDate, LocalDate endDate, Double total, Double monthlyPayment, User insurer) {
        this();
        this.creationDate = creationDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.total = total;
        this.monthlyPayment = monthlyPayment;
        this.insurer = insurer;
    }

    public InsuranceContract(Long id, LocalDate creationDate, LocalDate startDate, LocalDate endDate, Double total, Double monthlyPayment, User insurer) {
        super(id);
        this.creationDate = creationDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.total = total;
        this.monthlyPayment = monthlyPayment;
        this.insurer = insurer;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(Double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public User getInsurer() {
        return insurer;
    }

    public void setInsurer(User insurer) {
        this.insurer = insurer;
    }

    @Override
    public String toString() {
        return "InsuranceContract{" +
                "creationDate=" + creationDate +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", total=" + total +
                ", monthlyPayment=" + monthlyPayment +
                ", insurer=" + insurer +
                ", id=" + id +
                '}';
    }
}
