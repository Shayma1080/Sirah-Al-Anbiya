package org.intecbrussel.service;

import org.intecbrussel.model.StoryPhase;
import org.intecbrussel.repository.StoryPhaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoryPhaseService {

    public final StoryPhaseRepository storyPhaseRepository;

    public StoryPhaseService(StoryPhaseRepository storyPhaseRepository) {
        this.storyPhaseRepository = storyPhaseRepository;
    }

    public List<StoryPhase> getPhaseByProphet (Long prophetId) {
        return storyPhaseRepository.findByProphetIdOrderByOrderNumber(prophetId);
    }
}
