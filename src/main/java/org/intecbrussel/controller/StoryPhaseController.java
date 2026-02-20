package org.intecbrussel.controller;

import org.intecbrussel.dto.StoryPhaseDTO;
import org.intecbrussel.model.Prophet;
import org.intecbrussel.model.StoryPhase;
import org.intecbrussel.repository.ProphetRepository;
import org.intecbrussel.service.ProphetService;
import org.intecbrussel.service.StoryPhaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/storyphases")
public class StoryPhaseController {

    public final StoryPhaseService storyPhaseService;
    public final ProphetRepository prophetRepository;

    public  StoryPhaseController(StoryPhaseService storyPhaseService, ProphetRepository prophetRepository) {
        this.storyPhaseService = storyPhaseService;
        this.prophetRepository = prophetRepository;
    }

    @GetMapping("/prophet/{prophetId}")
    public List<StoryPhaseDTO> getPhasesByProphets(@PathVariable Long prophetId) {
        Prophet prophet = prophetRepository.findById(prophetId)
                .orElseThrow(() -> new RuntimeException("Profeet niet gevonden"));

        return prophet.getStoryPhases().stream()
                .map(sp -> {
                    StoryPhaseDTO dto = new StoryPhaseDTO();
                    dto.setId(sp.getId());
                    dto.setTitle(sp.getTitle());
                    dto.setOrderNumber(sp.getOrderNumber());
                    // geen medias of quizQuestions vullen
                    return dto;
                })
                .toList();
    }
}
