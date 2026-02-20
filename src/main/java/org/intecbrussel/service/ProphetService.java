package org.intecbrussel.service;

import jakarta.transaction.Transactional;
import org.intecbrussel.dto.MediaDTO;
import org.intecbrussel.dto.ProphetDTO;
import org.intecbrussel.dto.QuizQuestionDTO;
import org.intecbrussel.dto.StoryPhaseDTO;
import org.intecbrussel.model.Prophet;
import org.intecbrussel.repository.ProphetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
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

    public ProphetDTO getProphetDTOById(Long id){
        Prophet prophet = prophetRepository.findById(id).orElseThrow();

        // Hier map je alles naar DTO binnen de transactie
        ProphetDTO dto = new ProphetDTO();
        dto.setId(prophet.getId());
        dto.setName(prophet.getName());
        dto.setPeriod(prophet.getPeriod());
        dto.setDescription(prophet.getDescription());

        dto.setStoryPhases(
                prophet.getStoryPhases().stream().map(sp -> {
                    StoryPhaseDTO spDto = new StoryPhaseDTO();
                    spDto.setId(sp.getId());
                    spDto.setTitle(sp.getTitle());
                    spDto.setOrderNumber(sp.getOrderNumber());

                    spDto.setMedias(sp.getMedialist().stream().map(m -> {
                        MediaDTO mdto = new MediaDTO();
                        mdto.setId(m.getId());
                        mdto.setType(m.getType());
                        mdto.setUrl(m.getUrl());
                        return mdto;
                    }).toList());

                    spDto.setQuizQuestions(sp.getQuizQuestions().stream().map(q -> {
                        QuizQuestionDTO qdto = new QuizQuestionDTO();
                        qdto.setId(q.getId());
                        qdto.setQuestion(q.getQuestion());
                        qdto.setOptionsAnswer(q.getOptionsAnswer());
                        return qdto;
                    }).toList());

                    return spDto;
                }).toList()
        );

        return dto;
    }
}
