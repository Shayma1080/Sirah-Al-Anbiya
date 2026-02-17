package org.intecbrussel.controller;

import org.intecbrussel.model.QuizAttempt;
import org.intecbrussel.model.QuizQuestion;
import org.intecbrussel.model.StoryPhase;
import org.intecbrussel.service.QuizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    public final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/storyphase/{storyPhaseId}")
    public List<QuizQuestion> getQuestions(@PathVariable Long storyPhaseId) {
        return quizService.getQuestionsByStoryPhase(storyPhaseId);
    }

    @GetMapping("/submit")
    public QuizAttempt submitAnswer(
            @RequestParam Long userId,
            @RequestParam Long questionId,
            @RequestParam String answer
    ){
        return quizService.submitAnswer(userId, questionId, answer);
    }
}
