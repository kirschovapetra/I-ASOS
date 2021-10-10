package sk.stuba.fei.uim.asos.assignment1.insurance.domain;

/**
 * Abstraktná trieda poistnej zmluvy.
 *
 * @param <T> Trieda identifikátora zmluvy
 */
public abstract class AbstractInsuranceContract<T> {

    protected T id;

    public AbstractInsuranceContract() {
    }

    public AbstractInsuranceContract(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public abstract String toString();
}
