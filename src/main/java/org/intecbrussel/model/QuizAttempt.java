package org.intecbrussel.model;

public class QuizAttempt {
    private Long id;
    private String userAnswer;
    private boolean correct;
    private User user;
    private QuizQuestion quizQuestion;
}
