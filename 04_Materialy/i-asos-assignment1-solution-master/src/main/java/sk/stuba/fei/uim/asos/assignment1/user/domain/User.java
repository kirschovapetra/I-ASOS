package sk.stuba.fei.uim.asos.assignment1.user.domain;

import sk.stuba.fei.uim.asos.assignment1.insurance.domain.AbstractInsuranceContract;

import java.util.HashSet;
import java.util.Set;

public class User extends AbstractUser<Long> {

    private String surname;
    private String lastname;
    private String identificationNumber;
    private String email;
    private Address permanentAddress;
    private Address correspondenceAddress;
    private Set<AbstractInsuranceContract> contracts;

    public User() {
        super();
        contracts = new HashSet<>();
    }

    public User(String surname, String lastname, String identificationNumber, String email, Address permanentAddress, Address correspondenceAddress) {
        this();
        this.surname = surname;
        this.lastname = lastname;
        this.identificationNumber = identificationNumber;
        this.email = email;
        this.permanentAddress = permanentAddress;
        this.correspondenceAddress = correspondenceAddress;

        if (this.correspondenceAddress == null)
            this.correspondenceAddress = this.permanentAddress;
    }

    public void addContract(AbstractInsuranceContract contract) {
        this.contracts.add(contract);
    }

    @Override
    public String toString() {
        return "User{" +
                "surname='" + surname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", identificationNumber='" + identificationNumber + '\'' +
                ", email='" + email + '\'' +
                ", permanentAddress=" + permanentAddress +
                ", correspondenceAddress=" + correspondenceAddress +
                ", contracts=" + contracts +
                ", id=" + id +
                '}';
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(Address permanentAddress) {
        if (correspondenceAddress == null || correspondenceAddress == this.permanentAddress) {
            this.correspondenceAddress = permanentAddress;
        }
        this.permanentAddress = permanentAddress;
    }

    public Address getCorrespondenceAddress() {
        return correspondenceAddress;
    }

    public void setCorrespondenceAddress(Address correspondenceAddress) {
        this.correspondenceAddress = correspondenceAddress;
    }

    public Set<AbstractInsuranceContract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<AbstractInsuranceContract> contracts) {
        this.contracts = contracts;
    }
}
