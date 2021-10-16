package sk.stuba.fei.uim.asos.cvicenie1.dependencyinjection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DependencyInjectionApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DependencyInjectionApplication.class, args);
    }

    private final static Logger log = LoggerFactory.getLogger(DependencyInjectionApplication.class);

    private final List<TranslationService> services;

    @Autowired
    public DependencyInjectionApplication(List<TranslationService> services) {
        this.services = services;
    }

    @Override
    public void run(String... args) throws Exception {
        for (TranslationService service : services) {
            log.info(service.translate("nieco"));
        }

        /*
        Java SE 8 Streams:
        services.forEach(service -> log.info(service.translate("nieco")));
        */
    }
}
