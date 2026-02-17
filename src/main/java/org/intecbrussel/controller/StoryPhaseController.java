package org.intecbrussel.controller;

import org.intecbrussel.model.StoryPhase;
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

    public  StoryPhaseController(StoryPhaseService storyPhaseService) {
        this.storyPhaseService = storyPhaseService;
    }

    @GetMapping("/prophet/{prophetId}")
    public List<StoryPhase> getPhasesByProphet(@PathVariable Long prophetId) {
        return storyPhaseService.getPhaseByProphet(prophetId);
    }
}
