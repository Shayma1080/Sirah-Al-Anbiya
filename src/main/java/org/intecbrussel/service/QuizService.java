package org.intecbrussel.service;

import org.intecbrussel.model.QuizAttempt;
import org.intecbrussel.model.QuizQuestion;
import org.intecbrussel.model.User;
import org.intecbrussel.repository.QuizAttemptRepository;
import org.intecbrussel.repository.QuizQuestionRepository;
import org.intecbrussel.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    public final QuizQuestionRepository quizQuestionRepository;

    public final QuizAttemptRepository quizAttemptRepository;

    public final UserRepository userRepository;

    public QuizService(
            QuizQuestionRepository quizQuestionRepository,
            QuizAttemptRepository quizAttemptRepository,
            UserRepository userRepository
    ){
        this.quizQuestionRepository = quizQuestionRepository;
        this.quizAttemptRepository = quizAttemptRepository;
        this.userRepository = userRepository;
    }

    public List<QuizQuestion> getQuestionsByStoryPhase(Long storyPhaseId){
        return quizQuestionRepository.findByStoryPhaseId(storyPhaseId);
    }

    public QuizAttempt submitAnswer (Long userId, Long questionId, String userAnswer){

        User user = userRepository.findById(userId).orElseThrow();
        QuizQuestion question = quizQuestionRepository.findById(questionId).orElseThrow();

        boolean IsCorrect = question.getCorrectAnswer().equals(userAnswer);

        QuizAttempt attempt = new QuizAttempt();
        attempt.setUser(user);
        attempt.setQuizQuestion(question);
        attempt.setUserAnswer(userAnswer);
        attempt.setCorrect(IsCorrect);

        return quizAttemptRepository.save(attempt);
    }
}
