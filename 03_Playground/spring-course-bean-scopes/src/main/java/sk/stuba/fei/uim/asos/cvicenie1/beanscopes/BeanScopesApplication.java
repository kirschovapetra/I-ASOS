package sk.stuba.fei.uim.asos.cvicenie1.beanscopes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class BeanScopesApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeanScopesApplication.class, args);
    }


    private final ApplicationContext appContext;

    public BeanScopesApplication(ApplicationContext appContext) {
        this.appContext = appContext;
    }

    @GetMapping("/")
    public String getNames() throws InterruptedException {
        SingletonBean singletonBean = appContext.getBean(SingletonBean.class);
        PrototypeBean prototypeBean = appContext.getBean(PrototypeBean.class);
        RequestBean requestBean = appContext.getBean(RequestBean.class);
        SessionBean sessionBean = appContext.getBean(SessionBean.class);

        StringBuilder builder = new StringBuilder();
        builder.append(singletonBean.getName()).append("\n");
        builder.append(prototypeBean.getName()).append("\n");
        builder.append(requestBean.getName()).append("\n");
        builder.append(sessionBean.getName()).append("\n");

        Thread.sleep(500);
        builder.append("\n----- After 500ms -----\n\n");

        singletonBean = appContext.getBean(SingletonBean.class);
        prototypeBean = appContext.getBean(PrototypeBean.class);
        requestBean = appContext.getBean(RequestBean.class);

        builder.append(singletonBean.getName()).append("\n");
        builder.append(prototypeBean.getName()).append("\n");
        builder.append(requestBean.getName()).append("\n");
        builder.append(sessionBean.getName()).append("\n");

        return builder.toString();
    }
}