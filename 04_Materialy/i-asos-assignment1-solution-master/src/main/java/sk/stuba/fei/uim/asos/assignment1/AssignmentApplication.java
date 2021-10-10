package sk.stuba.fei.uim.asos.assignment1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sk.stuba.fei.uim.asos.assignment1.insurance.domain.AbstractInsuranceContract;
import sk.stuba.fei.uim.asos.assignment1.insurance.domain.InsuranceContract;
import sk.stuba.fei.uim.asos.assignment1.insurance.domain.life.TravelInsuranceContract;
import sk.stuba.fei.uim.asos.assignment1.insurance.domain.life.enums.TravelReason;
import sk.stuba.fei.uim.asos.assignment1.insurance.service.IInsuranceContractService;
import sk.stuba.fei.uim.asos.assignment1.insurance.service.InsuranceContractService;
import sk.stuba.fei.uim.asos.assignment1.user.domain.AbstractUser;
import sk.stuba.fei.uim.asos.assignment1.user.domain.Address;
import sk.stuba.fei.uim.asos.assignment1.user.domain.User;
import sk.stuba.fei.uim.asos.assignment1.user.service.IUserService;
import sk.stuba.fei.uim.asos.assignment1.user.service.UserService;

import java.time.LocalDate;
import java.util.logging.Logger;

public class AssignmentApplication {

    private static final Logger log = Logger.getLogger(AssignmentApplication.class.getSimpleName());

    public static final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");

    public static void main(String[] args) {
        UserService userService = (UserService) applicationContext.getBean("userService");
        InsuranceContractService contractService = (InsuranceContractService) applicationContext.getBean("contractService");

        User user = (User) addUser(userService);
        addContract(contractService, user);
    }

    public static AbstractUser addUser(IUserService service) {
        User user = new User(
                "Meno",
                "Priezvisko",
                "140798/6511",
                "meno@example.com",
                new Address(
                        "Ulica",
                        "23A",
                        "Bratislava",
                        "84105"
                ),
                null
        );
        return service.add(user);
    }

    public static AbstractInsuranceContract addContract(IInsuranceContractService service, AbstractUser user) {
        TravelInsuranceContract contract = new TravelInsuranceContract(
                LocalDate.now(),
                LocalDate.now(),
                LocalDate.now().plusDays(3),
                1000.0,
                20.0,
                (User) user,
                (User) user,
                true,
                TravelReason.VACATION
        );
        return (TravelInsuranceContract) service.create(contract);
    }

}
