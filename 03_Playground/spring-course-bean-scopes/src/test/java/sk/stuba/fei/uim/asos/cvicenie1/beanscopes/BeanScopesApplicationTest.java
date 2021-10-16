package sk.stuba.fei.uim.asos.cvicenie1.beanscopes;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;

@SpringBootTest
@Profile("test")
public class BeanScopesApplicationTest {

    private static final Logger LOG = LoggerFactory.getLogger(BeanScopesApplicationTest.class);

    @Autowired
    private ApplicationContext appContext;

    @Test
    public void prototypeBeanTest(){
        PrototypeBean bean = appContext.getBean(PrototypeBean.class);
        assert bean != null;
        LOG.info("Bean string: "+bean.getName());
        assert bean.getName().contains(bean.getClass().getSimpleName());
    }

    @Test
    public void requestBeanTest(){
        RequestBean bean = appContext.getBean(RequestBean.class);
        assert bean != null;
        LOG.info("Bean string: "+bean.getName());
        assert bean.getName().contains(bean.getClass().getSimpleName());
    }

    @Test
    public void sessionBeanTest(){
        SessionBean bean = appContext.getBean(SessionBean.class);
        assert bean != null;
        LOG.info("Bean string: "+bean.getName());
        assert bean.getName().contains(bean.getClass().getSimpleName());
    }

    @Test
    public void singletonBeanTest(){
        SingletonBean bean = appContext.getBean(SingletonBean.class);
        assert bean != null;
        LOG.info("Bean string: "+bean.getName());
        assert bean.getName().contains(bean.getClass().getSimpleName());
    }


}
