package sk.stuba.fei.uim.asos.assignment1.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import sk.stuba.fei.uim.asos.assignment1.AssignmentApplication;
import sk.stuba.fei.uim.asos.assignment1.user.domain.AbstractUser;
import sk.stuba.fei.uim.asos.assignment1.user.service.IUserService;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.reflect.Type;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:config.xml"})
public class UserServiceTest {

    private final static Logger log = Logger.getLogger(UserServiceTest.class.getSimpleName());

    @Autowired
    private IUserService<? extends AbstractUser, ?> userService;

    private Class<? extends AbstractUser> userClass;

    @BeforeEach
    public void getActualClasses() {
        AssignmentApplication.addUser(userService);
        Type[] actualTypes = ((ParameterizedTypeImpl) userService.getClass().getGenericInterfaces()[0]).getActualTypeArguments();
        userClass = (Class) actualTypes[0];
        assert userClass.getSuperclass().getSimpleName().equals("AbstractUser");
    }


    @Test
    public void shouldAddNewUser() throws IllegalAccessException, InstantiationException {
        AbstractUser user = userClass.newInstance();
        assertNull(((AbstractUser) user).getId());
        user = ((IUserService<AbstractUser, ?>) userService).add(user);
        log.info("Created user: [id:" + user.getId() + "] " + user);
        assertNotNull(((AbstractUser) user).getId());
    }

    @Test
    public void shouldUpdateUser() throws IllegalAccessException, InstantiationException {
        AbstractUser user = userService.getAll().stream().findAny().orElseThrow(() -> new IllegalStateException("Cannot find any user!"));
        AbstractUser newUser = userClass.newInstance();
        newUser.setId(user.getId());
        user = ((IUserService<AbstractUser, ?>) userService).update(newUser);
        log.info("Updated user [id: " + user.getId() + "]" + user);
        assertNotNull(user);
        assertEquals(user.getId(), newUser.getId());
    }

    @Test
    public void shouldGetAllUsers() {
        List users = userService.getAll();
        log.info("Number of users: " + users.size());
        assertFalse(users.isEmpty());
        assertTrue(users.stream().allMatch(u -> u instanceof AbstractUser));
    }

    @Test
    public void shouldGetOneUser() {
        AbstractUser user = userService.getAll().stream().findAny().orElseThrow(() -> new IllegalStateException("Cannot find any user!"));
        user = ((IUserService<AbstractUser, Object>) userService).getOne(user.getId());
        log.info("Find user [id:" + user.getId() + "] " + user);
        assertNotNull(user);
    }
}
