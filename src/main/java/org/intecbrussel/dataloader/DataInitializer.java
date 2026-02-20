package org.intecbrussel.dataloader;

import lombok.RequiredArgsConstructor;
import org.intecbrussel.model.Media;
import org.intecbrussel.model.Prophet;
import org.intecbrussel.model.QuizQuestion;
import org.intecbrussel.model.StoryPhase;
import org.intecbrussel.repository.MediaRepository;
import org.intecbrussel.repository.ProphetRepository;
import org.intecbrussel.repository.QuizQuestionRepository;
import org.intecbrussel.repository.StoryPhaseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer  {

    private final ProphetRepository prophetRepository;
    private final StoryPhaseRepository storyPhaseRepository;
    private final MediaRepository mediaRepository;
    private final QuizQuestionRepository quizQuestionRepository;

    @Bean
    CommandLineRunner loadData() {
        return args -> {

            if(prophetRepository.count() > 0){
                return;
            }

            // =========================
            // PROPHET NUH
            // =========================

            Prophet noeh = new Prophet();
            noeh.setName("Noeh (AS)");
            noeh.setPeriod("Voor de Grote Vloed");
            noeh.setDescription(
                    "Profeet Nuh werd gezonden om zijn volk te leiden tot de aanbidding van Allah alleen. "
                            + "Ze hebben hem jarenlang afgewezen. Allah gaf hem de opdracht de Ark te bouwen."
            );



            // StoryPhase 1 - Calling the people

            StoryPhase noehPhase1 = new StoryPhase();
            noehPhase1.setTitle("De mensen oproepen tot de islam");
            noehPhase1.setOrderNumber(1);
            noehPhase1.setProphet(noeh);



            Media noehVideo = new Media();
            noehVideo.setType("VIDEO");
            noehVideo.setUrl("https://www.youtube.com/watch?v=tvWsAMUacQ4");
            noehVideo.setStoryPhase(noehPhase1);


            Media noehAudio = new Media();

            noehAudio.setType("AUDIO");

            noehAudio.setUrl("https://www.le-coran.com/coran-francais-sourate-71-0.html");

            noehAudio.setStoryPhase(noehPhase1);

            // Media toevoegen aan stroyPhase
            noehPhase1.setMedialist(List.of(noehVideo, noehAudio));


            QuizQuestion nuhQuiz1 = new QuizQuestion();
            nuhQuiz1.setQuestion("Wat moest profeet Noeh bouwen?");
            nuhQuiz1.setOptionsAnswer(List.of(
                    "Een paleis",
                    "Een ark",
                    "Een toren",
                    "Een huis"
            ));
            nuhQuiz1.setCorrectAnswer("Een ark");
            nuhQuiz1.setStoryPhase(noehPhase1);

            // Quiz toevoegen aan StoryPhase
            noehPhase1.setQuizQuestions(List.of(nuhQuiz1));

            // StoryPhase toevoegen aan Profeet
            noeh.setStoryPhases(List.of(noehPhase1));

            // Porfeet opslaan
            prophetRepository.save(noeh);


            // =========================
            // PROPHET MUSA
            // =========================

            Prophet musa = new Prophet();

            musa.setName("Musa (AS)");

            musa.setPeriod("Tijd van de Farao");

            musa.setDescription(
                    "De profeet Musa werd gezonden om de Israëlieten te bevrijden van de farao. "
                            + "Allah beschermde hem als baby en schonk hem later miracles."
            );



            // StoryPhase 1 - Birth of Musa

            StoryPhase musaPhase1 = new StoryPhase();

            musaPhase1.setTitle("Geboorte van Musa");

            musaPhase1.setOrderNumber(1);

            musaPhase1.setProphet(musa);



            Media musaVideo = new Media();

            musaVideo.setType("VIDEO");

            musaVideo.setUrl("https://www.youtube.com/watch?v=5HeiiplSlrA");

            musaVideo.setStoryPhase(musaPhase1);



            Media musaAudio = new Media();

            musaAudio.setType("AUDIO");

            musaAudio.setUrl("https://www.le-coran.com/coran-francais-sourate-28-0.html");

            musaAudio.setStoryPhase(musaPhase1);

            // Media toevoegen aan stroyPhase
            musaPhase1.setMedialist(List.of(musaVideo, musaAudio));


            QuizQuestion musaQuiz1 = new QuizQuestion();

            musaQuiz1.setQuestion("Waar werd Musa als baby geplaatst?");

            musaQuiz1.setOptionsAnswer(List.of(
                    "In de woestijn",
                    "In de rivier",
                    "In het paleis",
                    "In een grot"
            ));

            musaQuiz1.setCorrectAnswer("In de rivier");

            musaQuiz1.setStoryPhase(musaPhase1);

            // Quiz toevoegen aan StoryPhase
            musaPhase1.setQuizQuestions(List.of(musaQuiz1));


            // Porfeet opslaan
            prophetRepository.save(musa);


            // StoryPhase 2 - Musa and Pharaoh

            StoryPhase musaPhase2 = new StoryPhase();

            musaPhase2.setTitle("Musa confronteert de farao");

            musaPhase2.setOrderNumber(2);

            musaPhase2.setProphet(musa);



            QuizQuestion musaQuiz2 = new QuizQuestion();

            musaQuiz2.setQuestion("Wie was de vijand van Musa?");

            musaQuiz2.setOptionsAnswer(List.of(
                    "Farao",
                    "Koning",
                    "Soldaat",
                    "Handelaar"
            ));

            musaQuiz2.setCorrectAnswer("Farao");

            musaQuiz2.setStoryPhase(musaPhase2);

            // Quiz toevoegen aan StoryPhase
            musaPhase2.setQuizQuestions(List.of(musaQuiz2));

            // lijst van storyPhases
            musa.setStoryPhases(List.of(musaPhase1, musaPhase2));

            // Porfeet opslaan
            prophetRepository.save(musa);


            System.out.println("DATA LOADED SUCCESSFULLY");
        };
    }


}

