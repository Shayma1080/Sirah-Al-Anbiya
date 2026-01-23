package org.intecbrussel.model;

import java.util.List;

public class QuizQuestion {
    private Long id;
    private String question;
    private List<String> optionsAnswer; // antwoord kiezen
    private String correctAnswer; // 1 juiste antwoord
    private StroyPhase storyPhase;
}
