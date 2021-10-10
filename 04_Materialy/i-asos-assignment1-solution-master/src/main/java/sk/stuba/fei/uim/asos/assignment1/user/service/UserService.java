package sk.stuba.fei.uim.asos.assignment1.user.service;

import sk.stuba.fei.uim.asos.assignment1.user.domain.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class UserService implements IUserService<User, Long> {

    private final AtomicLong idCounter;
    private final Map<Long, User> users;

    public UserService() {
        idCounter = new AtomicLong(0);
        users = new HashMap<>();
    }

    @Override
    public User add(User user) {
        user.setId(idCounter.incrementAndGet());
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public User update(User user) {
        if (!users.containsKey(user.getId()))
            throw new IllegalArgumentException("User id:" + user.getId() + " cannot be found!");
        return users.put(user.getId(), user);
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public User getOne(Long id) {
        return users.get(id);
    }
}
