package org.intecbrussel.dto;

import lombok.Data;

@Data
public class QuizAnswerDTO {
    private Long userId;
    private Long questionId;
    private String answer;

    public QuizAnswerDTO() {} // nodig voor JSON deserialisatie

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getQuestionId() { return questionId; }
    public void setQuestionId(Long questionId) { this.questionId = questionId; }

    public String getAnswer() { return answer; }
    public void setAnswer(String answer) { this.answer = answer; }
}
