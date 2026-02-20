package org.intecbrussel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuizQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1000)
    private String question;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> optionsAnswer; // antwoord kiezen

    private String correctAnswer; // 1 juiste antwoord

    @ManyToOne
    @JoinColumn(name = "story_phase_id")
    private StoryPhase storyPhase;

    // 1 vraag kan meerde attemps hebben
    @OneToMany(mappedBy ="quizQuestion",cascade = CascadeType.ALL)
    private List<QuizAttempt> quizAttempt;
}
