package sk.stuba.fei.uim.asos.assignment1.insurance.domain.life;

import sk.stuba.fei.uim.asos.assignment1.insurance.domain.life.enums.TravelReason;
import sk.stuba.fei.uim.asos.assignment1.user.domain.User;

import java.time.LocalDate;

public class TravelInsuranceContract extends LifeInsuranceContract {

    private Boolean inEU;
    private TravelReason travelReason;

    public TravelInsuranceContract() {
        super();
    }

    public TravelInsuranceContract(Boolean inEU, TravelReason travelReason) {
        this();
        this.inEU = inEU;
        this.travelReason = travelReason;
    }

    public TravelInsuranceContract(LocalDate creationDate, LocalDate startDate, LocalDate endDate, Double total, Double monthlyPayment, User insurer, User insured, Boolean inEU, TravelReason travelReason) {
        super(creationDate, startDate, endDate, total, monthlyPayment, insurer, insured);
        this.inEU = inEU;
        this.travelReason = travelReason;
    }

    public Boolean getInEU() {
        return inEU;
    }

    public void setInEU(Boolean inEU) {
        this.inEU = inEU;
    }

    public TravelReason getTravelReason() {
        return travelReason;
    }

    public void setTravelReason(TravelReason travelReason) {
        this.travelReason = travelReason;
    }

    @Override
    public String toString() {
        return "TravelInsuranceContract{" +
                "travelReason=" + travelReason +
                ", insured=" + insured +
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
