package org.intecbrussel.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class StoryPhaseDTO {
    private Long id;
    private String title;
    private int orderNumber;
    private List<MediaDTO> medias;
    private List<QuizQuestionDTO> quizQuestions;
}
