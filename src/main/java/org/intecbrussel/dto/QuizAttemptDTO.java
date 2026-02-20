package org.intecbrussel.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class QuizAttemptDTO {
    private Long id;
    private Long userId;
    private Long questionId;
    private String userAnswer;
    private boolean correct;

    public QuizAttemptDTO(Long id, Long userId, Long questionId, String userAnswer, boolean correct) {
        this.id = id;
        this.userId = userId;
        this.questionId = questionId;
        this.userAnswer = userAnswer;
        this.correct = correct;
    }
}
