package sk.stuba.fei.uim.asos.cvicenie1.beanscopes;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Component
@Scope(SCOPE_PROTOTYPE)
public class PrototypeBean extends AbstractBean {
}
