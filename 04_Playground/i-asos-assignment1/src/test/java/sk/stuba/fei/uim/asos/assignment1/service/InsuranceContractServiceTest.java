package sk.stuba.fei.uim.asos.assignment1.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import sk.stuba.fei.uim.asos.assignment1.domain.contract.AbstractInsuranceContract;
import sk.stuba.fei.uim.asos.assignment1.domain.user.AbstractUser;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.reflect.Type;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:config.xml"})
public class InsuranceContractServiceTest {

    private final static Logger log = Logger.getLogger(InsuranceContractServiceTest.class.getSimpleName());

    @Autowired
    private IInsuranceContractService<? extends AbstractInsuranceContract, ?> contractService;

    @Autowired
    private IUserService<? extends AbstractUser, ?> userService;

    private Class<? extends AbstractInsuranceContract> contractClass;

    @BeforeEach
    public void getClasses() {
        Type[] actualTypes = ((ParameterizedTypeImpl) contractService.getClass().getGenericInterfaces()[0]).getActualTypeArguments();
        contractClass = (Class) actualTypes[0];
        assert contractClass.getSuperclass().getSimpleName().equals("AbstractInsuranceContract");
    }

    @Test
    public void shouldCreateContract() throws IllegalAccessException, InstantiationException {
        AbstractInsuranceContract contract = contractClass.newInstance();
        assertNull(contract.getId());
        contract = ((IInsuranceContractService<AbstractInsuranceContract, ?>) contractService).create(contract);
        log.info("Create contract: [id:" + contract.getId() + "] " + contract);
        assertNotNull(contract.getId());
    }

    @Test
    public void shouldUpdateContract() throws IllegalAccessException, InstantiationException {
        AbstractInsuranceContract contract = contractService.getAll().stream().findAny().orElseThrow(() -> new IllegalStateException("Cannot find any contract!"));
        AbstractInsuranceContract contract1 = contractClass.newInstance();
        contract1.setId(contract.getId());
        contract = ((IInsuranceContractService<AbstractInsuranceContract, ?>) contractService).update(contract1);
        log.info("Update contract [id:" + contract.getId() + "] " + contract);
        assertNotNull(contract);
        assertEquals(contract.getId(), contract1.getId());
    }

    @Test
    public void shouldGetAllContracts() {
        List contracts = contractService.getAll();
        log.info("Number of contracts: " + contracts.size());
        assertFalse(contracts.isEmpty());
        assertTrue(contracts.stream().allMatch(u -> u instanceof AbstractInsuranceContract));
    }

    @Test
    public void shouldGetContractsByUserId() {
        List<AbstractUser> users = (List<AbstractUser>) userService.getAll();
        if (users.isEmpty())
            throw new IllegalStateException("Cannot find any users!");
        assertTrue(users.stream().anyMatch(u -> {
            List contracts = ((IInsuranceContractService<? extends AbstractInsuranceContract, Object>) contractService).getByUserId((Object) u.getId());
            log.info("Number of contracts: " + contracts.size() + " of user [id:" + u.getId() + "] " + u);
            assertNotNull(contracts);
            return !contracts.isEmpty();
        }));
    }

}
