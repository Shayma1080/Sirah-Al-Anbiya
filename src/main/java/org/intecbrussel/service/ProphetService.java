package org.intecbrussel.service;

import org.intecbrussel.model.Prophet;
import org.intecbrussel.repository.ProphetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProphetService {

    private final ProphetRepository prophetRepository;

    public ProphetService(ProphetRepository prophetRepository) {
        this.prophetRepository = prophetRepository;
    }

    public List<Prophet> getAllProphets() {
        return prophetRepository.findAll();
    }

    public Optional<Prophet> getProphetById(Long id) {
        return prophetRepository.findById(id);
    }

}
