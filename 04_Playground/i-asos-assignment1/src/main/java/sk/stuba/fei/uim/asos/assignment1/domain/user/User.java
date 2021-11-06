/*
O každej osobe systém eviduje nasledovné dáta:

    unikátny identifikátor (ID),
    meno,
    priezvisko,
    rodné číslo,
    e-mail,
    adresa trvalého pobytu,
    korešpondenčná adresa,
    zoznam zmlúv (zmluvy uzatvorené osobou)

Pokiaľ korešpondenčná adresa osoby nie je definovaná, použije sa jeho adresa trvalého pobytu. 

Trieda osoby musí dediť od AbstractUser.

*/

package sk.stuba.fei.uim.asos.assignment1.domain.user;

import sk.stuba.fei.uim.asos.assignment1.domain.contract.AbstractInsuranceContract;
import java.util.ArrayList;
import java.util.List;
import sk.stuba.fei.uim.asos.assignment1.domain.contract.AbstractInsuranceContract;


public class User extends AbstractUser<Long> {

    public String firstName;
    public String lastName;
    public String birth_number;
    public String email;
    public Address homeAddress;
    public Address postAddress;
    public List<AbstractInsuranceContract> contractList = new ArrayList<>();

    public User() {}

    public User(Long id) {
        super(id);
    }

    public User(Long id, String firstName, String lastName, String birth_number, 
            String email, Address homeAddress, Address postAddress) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.birth_number = birth_number;
        this.email = email;
        this.homeAddress = homeAddress;
        this.postAddress = postAddress;
    }
    
    public User(Long id, String firstName, String lastName, String birth_number,
            String email, Address homeAddress) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.birth_number = birth_number;
        this.email = email;
        this.homeAddress = homeAddress;
        this.postAddress = homeAddress;
    }


    @Override
    public String toString() {
        return "User{" + "firstName=" + firstName + ", lastName=" + lastName + ", birth_number=" + birth_number + ", email=" + email + ", homeAddress=" + homeAddress + ", postAddress=" + postAddress + ", contractList=" + contractList + '}';
    }
    
    
}
