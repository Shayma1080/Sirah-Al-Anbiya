package org.intecbrussel.controller;

import org.intecbrussel.model.Prophet;
import org.intecbrussel.service.ProphetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/prophets")
public class ProphetController {

    private final ProphetService prophetService;

    public ProphetController(ProphetService prophetService) {
        this.prophetService = prophetService;
    }

    @GetMapping
    public List<Prophet> getAllProphets() {
        return prophetService.getAllProphets();
    }

    @GetMapping("/{id}")
    public Prophet getProphetById(@PathVariable Long id) {
        return prophetService.getProphetById(id).orElseThrow();
    }
}
