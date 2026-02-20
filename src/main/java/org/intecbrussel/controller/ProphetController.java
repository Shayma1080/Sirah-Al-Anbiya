package org.intecbrussel.controller;

import org.intecbrussel.dto.MediaDTO;
import org.intecbrussel.dto.ProphetDTO;
import org.intecbrussel.dto.QuizQuestionDTO;
import org.intecbrussel.dto.StoryPhaseDTO;
import org.intecbrussel.model.Prophet;
import org.intecbrussel.model.StoryPhase;
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
    public List<ProphetDTO> getAllProphets() {
        return prophetService.getAllProphets()
                .stream()
                .map(p -> {
                    ProphetDTO dto = new ProphetDTO();
                    dto.setId(p.getId());
                    dto.setName(p.getName());
                    dto.setPeriod(p.getPeriod());
                    dto.setDescription(p.getDescription());

                    dto.setStoryPhases(
                            p.getStoryPhases().stream()
                                    .map(sp -> {
                                        StoryPhaseDTO spDto = new StoryPhaseDTO();
                                        spDto.setId(sp.getId());
                                        spDto.setTitle(sp.getTitle());
                                        spDto.setOrderNumber(sp.getOrderNumber());
                                        // eventueel medias en quizQuestions toevoegen
                                        return spDto;
                                    }).toList()
                    );

                    return dto;
                }).toList();
    }

    @GetMapping("/{id}")
    public ProphetDTO getProphet(@PathVariable Long id){
        return prophetService.getProphetDTOById(id);
    }

    private ProphetDTO mapToDTO(Prophet prophet){
        ProphetDTO dto = new ProphetDTO();
        dto.setId(prophet.getId());
        dto.setName(prophet.getName());
        dto.setPeriod(prophet.getPeriod());
        dto.setDescription(prophet.getDescription());
        dto.setStoryPhases(
                prophet.getStoryPhases().stream()
                        .map(this::mapStoryPhaseDTO)
                        .toList()
        );
        return dto;
    }

    private StoryPhaseDTO mapStoryPhaseDTO(StoryPhase sp){
        StoryPhaseDTO dto = new StoryPhaseDTO();
        dto.setId(sp.getId());
        dto.setTitle(sp.getTitle());
        dto.setOrderNumber(sp.getOrderNumber());
        dto.setMedias(sp.getMedialist().stream()
                .map(m -> {
                    MediaDTO mdto = new MediaDTO();
                    mdto.setId(m.getId());
                    mdto.setType(m.getType());
                    mdto.setUrl(m.getUrl());
                    return mdto;
                }).toList());
        dto.setQuizQuestions(sp.getQuizQuestions().stream()
                .map(q -> {
                    QuizQuestionDTO qdto = new QuizQuestionDTO();
                    qdto.setId(q.getId());
                    qdto.setQuestion(q.getQuestion());
                    qdto.setOptionsAnswer(q.getOptionsAnswer());
                    return qdto;
                }).toList());
        return dto;
    }
}
