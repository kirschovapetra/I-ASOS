package sk.stuba.fei.uim.asos.assignment1.insurance.domain.life;

import sk.stuba.fei.uim.asos.assignment1.insurance.domain.life.enums.Territory;
import sk.stuba.fei.uim.asos.assignment1.user.domain.User;

import java.time.LocalDate;

public class AccidentInsuranceContract extends LifeInsuranceContract{

    private Double permanentDisability;
    private Double death;
    private Double hospitalization;
    private Territory territory;

    public AccidentInsuranceContract() {
        super();
    }

    public AccidentInsuranceContract(Double permanentDisability, Double death, Double hospitalization, Territory territory) {
        this();
        this.permanentDisability = permanentDisability;
        this.death = death;
        this.hospitalization = hospitalization;
        this.territory = territory;
    }

    public AccidentInsuranceContract(LocalDate creationDate, LocalDate startDate, LocalDate endDate, Double total, Double monthlyPayment, User insurer, User insured, Double permanentDisability, Double death, Double hospitalization, Territory territory) {
        super(creationDate, startDate, endDate, total, monthlyPayment, insurer, insured);
        this.permanentDisability = permanentDisability;
        this.death = death;
        this.hospitalization = hospitalization;
        this.territory = territory;
    }

    public Double getPermanentDisability() {
        return permanentDisability;
    }

    public void setPermanentDisability(Double permanentDisability) {
        this.permanentDisability = permanentDisability;
    }

    public Double getDeath() {
        return death;
    }

    public void setDeath(Double death) {
        this.death = death;
    }

    public Double getHospitalization() {
        return hospitalization;
    }

    public void setHospitalization(Double hospitalization) {
        this.hospitalization = hospitalization;
    }

    public Territory getTerritory() {
        return territory;
    }

    public void setTerritory(Territory territory) {
        this.territory = territory;
    }

    @Override
    public String toString() {
        return "AccidentInsuranceContract{" +
                "permanentDisability=" + permanentDisability +
                ", death=" + death +
                ", hospitalization=" + hospitalization +
                ", territory=" + territory +
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
