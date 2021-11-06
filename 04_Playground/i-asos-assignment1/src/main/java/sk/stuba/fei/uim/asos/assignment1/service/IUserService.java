package sk.stuba.fei.uim.asos.assignment1.service;

import sk.stuba.fei.uim.asos.assignment1.domain.user.AbstractUser;

import java.util.List;

/**
 * Interface pre Spring service spravujúcu používateľov
 *
 * @param <T> Trieda používateľa
 * @param <I> Trieda identifikátora používateľa
 */
public interface IUserService<T extends AbstractUser, I> {

    T add(T user);

    T update(T user);

    List<T> getAll();

    T getOne(I id);

}
