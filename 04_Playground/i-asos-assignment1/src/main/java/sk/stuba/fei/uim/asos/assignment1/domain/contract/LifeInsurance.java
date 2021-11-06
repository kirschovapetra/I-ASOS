/*
Medzi zmluvy životného poistenia patria:

Cestovné poistenie

- referenciu na poistenca

- v rámci EU / mimo EU
- účel cesty (číselníková hodnota, povolené sú: pracovne, rekreačne, šport, a pod.)

Úrazové poistenie

- referenciu na poistenca

- trvalé následky úrazu (poistná suma v eurách)
- Smrť v dôsledku úrazu (poistná suma v eurách)
- Denné odškodné za hospitalizáciu (poistná suma v eurách)
- Územná platnosť (číselníková hodnota, povolené hodnoty sú: “Slovensko”, “Svet”, “Svet + Slovensko”)

Trieda zmluvy musí dediť od AbstractInsuranceContract.
 */

package sk.stuba.fei.uim.asos.assignment1.domain.contract;

import sk.stuba.fei.uim.asos.assignment1.domain.user.User;


class LifeInsurance extends AbstractInsuranceContract{
    
    protected User insuree;

    public LifeInsurance(Long id, User insuree) {
        super(id);
        this.insuree = insuree;
    }
    
    public LifeInsurance(){}

    @Override
    public String toString() {
        return "LifeInsurance{" + "insuree=" + insuree + '}';
    }
    
    
    
    
}
