package org.intecbrussel.controller;

import org.intecbrussel.dto.QuizAnswerDTO;
import org.intecbrussel.dto.QuizAttemptDTO;
import org.intecbrussel.model.QuizAttempt;
import org.intecbrussel.model.QuizQuestion;
import org.intecbrussel.model.StoryPhase;
import org.intecbrussel.service.QuizService;
import org.springframework.web.bind.annotation.*;
import org.intecbrussel.dto.QuizQuestionDTO;
import java.util.stream.Collectors;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    public final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/storyphase/{storyPhaseId}")
    public List<QuizQuestionDTO> getQuestions(@PathVariable Long storyPhaseId) {
        return quizService.getQuestionsByStoryPhase(storyPhaseId)
                .stream()
                .map(q -> new QuizQuestionDTO(q.getId(), q.getQuestion(), q.getOptionsAnswer()))
                .collect(Collectors.toList());
    }

    @PostMapping("/submit")
    public QuizAttemptDTO submitAnswer(@RequestBody QuizAnswerDTO dto) {
        QuizAttempt attempt = quizService.submitAnswer(
                dto.getUserId(),
                dto.getQuestionId(),
                dto.getAnswer()
        );

        return new QuizAttemptDTO(
                attempt.getId(),
                attempt.getUser().getId(),
                attempt.getQuizQuestion().getId(),
                attempt.getUserAnswer(),
                attempt.isCorrect()
        );
    }
}
