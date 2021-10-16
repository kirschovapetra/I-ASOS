package sk.stuba.fei.uim.asos.cvicenie1.beanscopes;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST;

@Component
@Scope(SCOPE_REQUEST)
public class RequestBean extends AbstractBean {
}
