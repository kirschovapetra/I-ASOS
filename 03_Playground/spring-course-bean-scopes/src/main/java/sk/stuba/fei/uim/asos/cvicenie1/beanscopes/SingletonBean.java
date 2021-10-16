package sk.stuba.fei.uim.asos.cvicenie1.beanscopes;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_SINGLETON;

@Component
@Scope(SCOPE_SINGLETON)
public class SingletonBean extends AbstractBean {
}