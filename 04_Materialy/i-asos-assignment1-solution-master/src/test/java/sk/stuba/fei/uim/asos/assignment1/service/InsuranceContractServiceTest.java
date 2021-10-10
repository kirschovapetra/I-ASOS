package sk.stuba.fei.uim.asos.assignment1.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import sk.stuba.fei.uim.asos.assignment1.AssignmentApplication;
import sk.stuba.fei.uim.asos.assignment1.insurance.domain.AbstractInsuranceContract;
import sk.stuba.fei.uim.asos.assignment1.insurance.service.IInsuranceContractService;
import sk.stuba.fei.uim.asos.assignment1.user.domain.AbstractUser;
import sk.stuba.fei.uim.asos.assignment1.user.domain.User;
import sk.stuba.fei.uim.asos.assignment1.user.service.IUserService;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;
import static sk.stuba.fei.uim.asos.assignment1.AssignmentApplication.addContract;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:config.xml"})
public class InsuranceContractServiceTest {

    private final static Logger log = Logger.getLogger(InsuranceContractServiceTest.class.getSimpleName());

    @Autowired
    private IInsuranceContractService<? extends AbstractInsuranceContract, ?> contractService;

    @Autowired
    private IUserService<? extends AbstractUser, ?> userService;

    private Class<? extends AbstractInsuranceContract> contractClass;
    private AbstractUser user;

    @BeforeEach
    public void getClasses() throws Throwable {
        user = AssignmentApplication.addUser(userService);
        addContract(contractService, user);

        Reflections reflections = new Reflections("sk.stuba.fei.uim.asos.assignment1.insurance");
        Type[] actualTypes = ((ParameterizedTypeImpl) contractService.getClass().getGenericInterfaces()[0]).getActualTypeArguments();
        contractClass = (Class) actualTypes[0];
        assert contractClass.getSuperclass().getSimpleName().equals("AbstractInsuranceContract");
        Set classes = reflections.getSubTypesOf(contractClass);
        contractClass = (Class) classes.stream().filter(clazz -> !Modifier.isAbstract(((Class) clazz).getModifiers()))
                .findAny()
                .orElseThrow(() -> new IllegalStateException("Cannot find non-abstract InsuranceContract class!"));
    }

    @Test
    public void shouldCreateContract() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        AbstractInsuranceContract contract = contractClass.newInstance();
        assertNull(contract.getId());
        populateInsurer(contract);
        contract = ((IInsuranceContractService<AbstractInsuranceContract, ?>) contractService).create(contract);
        log.info("Create contract: [id:" + contract.getId() + "] " + contract);
        assertNotNull(contract.getId());
    }

    @Test
    public void shouldUpdateContract() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        AbstractInsuranceContract contract = contractService.getAll().stream().findAny().orElseThrow(() -> new IllegalStateException("Cannot find any contract!"));
        AbstractInsuranceContract contract1 = addContract(contractService, user);
        AbstractInsuranceContract alternative = contractClass.newInstance();
        alternative.setId(contract1.getId());
        populateInsurer(alternative);
        contract1 = ((IInsuranceContractService<AbstractInsuranceContract, ?>) contractService).update(alternative);
        log.info("Update contract [id:" + contract1.getId() + "] " + contract1);
        assertNotNull(contract1);
        assertEquals(contract1.getId(), alternative.getId());
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

    private void populateInsurer(AbstractInsuranceContract contract) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = contractClass.getMethod("setInsurer", User.class);
        method.invoke(contract, user);
    }

}
