/*
Adresa sa skladá z:

PSČ,
názvu obce,
názvu ulice,
orientačného čísla domu

 */
package sk.stuba.fei.uim.asos.assignment1.domain.user;


public class Address {
    private String postalCode;
    private String city;
    private String street;
    private String streetNumber;

    public Address() {
    }

    public Address(String postalCode, String city, String street, String streetNumber) {
        this.postalCode = postalCode;
        this.city = city;
        this.street = street;
        this.streetNumber = streetNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }
    
    

}
