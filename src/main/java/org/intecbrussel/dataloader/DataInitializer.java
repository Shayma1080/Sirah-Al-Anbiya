package org.intecbrussel.dataloader;

import lombok.RequiredArgsConstructor;
import org.intecbrussel.model.Prophet;
import org.intecbrussel.model.QuizQuestion;
import org.intecbrussel.model.StoryPhase;
import org.intecbrussel.repository.ProphetRepository;
import org.intecbrussel.repository.QuizQuestionRepository;
import org.intecbrussel.repository.StoryPhaseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final ProphetRepository prophetRepository;

    private String correctAnswer;

    private final QuizQuestionRepository quizQuestionRepository;


    @Override
    public void run(String... args) {

        Prophet musa = new Prophet();
        musa.setName("Prophet Musa (AS)");
        musa.setDescription("The story of Musa from birth to liberation of Bani Israel.");

        Prophet yusuf = new Prophet();
        yusuf.setName("Prophet Yusuf (AS)");
        yusuf.setDescription("The story of patience, betrayal and leadership.");

        prophetRepository.save(musa);
        prophetRepository.save(yusuf);
    }


}

