package sk.stuba.fei.uim.asos.cvicenie1.beanscopes;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.web.context.WebApplicationContext.SCOPE_SESSION;

@Component
@Scope(SCOPE_SESSION)
public class SessionBean extends AbstractBean {
}
