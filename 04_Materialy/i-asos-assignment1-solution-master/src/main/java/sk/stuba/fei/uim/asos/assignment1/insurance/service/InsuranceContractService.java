package sk.stuba.fei.uim.asos.assignment1.insurance.service;

import sk.stuba.fei.uim.asos.assignment1.insurance.domain.InsuranceContract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class InsuranceContractService implements IInsuranceContractService<InsuranceContract, Long> {

    private final AtomicLong idCounter;
    private final Map<Long, InsuranceContract> contracts;

    public InsuranceContractService() {
        idCounter = new AtomicLong(0);
        contracts = new HashMap<>();
    }

    @Override
    public InsuranceContract create(InsuranceContract contract) {
        contract.setId(idCounter.incrementAndGet());
        contracts.put(contract.getId(), contract);
        return contract;
    }

    @Override
    public InsuranceContract update(InsuranceContract contract) {
        if (!contracts.containsKey(contract.getId()))
            throw new IllegalArgumentException("Contract id:" + contract.getId() + " has not been found!");
        return contracts.put(contract.getId(), contract);
    }

    @Override
    public List<InsuranceContract> getAll() {
        return new ArrayList<>(contracts.values());
    }

    @Override
    public List<InsuranceContract> getByUserId(Long userId) {
        return contracts.values().stream().filter(insuranceContract -> insuranceContract.getInsurer().getId().equals(userId))
                .collect(Collectors.toList());
    }
}
