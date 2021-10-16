package sk.stuba.fei.uim.asos.assignment1.domain.user;

/* 
   Abstraktná trieda používateľa
   @param <T> Trieda identifikátora používateľa
 */
public abstract class AbstractUser<T> {

    protected T id;

    public AbstractUser() {
    }

    public AbstractUser(T id) {
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
