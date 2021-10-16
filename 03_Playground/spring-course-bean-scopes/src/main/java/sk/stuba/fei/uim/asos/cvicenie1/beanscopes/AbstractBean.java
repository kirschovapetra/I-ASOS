package sk.stuba.fei.uim.asos.cvicenie1.beanscopes;

public abstract class AbstractBean {

    private final String name;

    public AbstractBean() {
        this.name = this.getClass().getSimpleName() + ":\t" + System.currentTimeMillis();
    }

    public String getName() {
        return name;
    }
}
