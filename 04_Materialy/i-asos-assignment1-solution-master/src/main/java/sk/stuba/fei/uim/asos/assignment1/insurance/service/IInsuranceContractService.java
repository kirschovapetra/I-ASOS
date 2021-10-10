package sk.stuba.fei.uim.asos.assignment1.insurance.service;

import sk.stuba.fei.uim.asos.assignment1.insurance.domain.AbstractInsuranceContract;

import java.util.List;

/**
 * Interface pre Spring service pre správu poistných zmlúv.
 *
 * @param <T> Trieda poistnej zmluvy
 * @param <I> Trieda identifikátora používateľa
 */
public interface IInsuranceContractService<T extends AbstractInsuranceContract, I> {

    T create(T contract);

    T update(T contract);

    List<T> getAll();

    List<T> getByUserId(I userId);

}
