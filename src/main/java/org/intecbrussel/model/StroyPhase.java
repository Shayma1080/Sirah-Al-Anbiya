package org.intecbrussel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StroyPhase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int orderNumber;

    // StoryPhase hoort bij 1 prophet
    @ManyToOne
    @JoinColumn(name = "prophet_id")
    private Prophet prophet;

    // StroyPhase ken meerde Media entries hebben
    @OneToMany(mappedBy = "storyPhase",cascade = CascadeType.ALL)
    private List<Media> medialist;

    // StoryPhase kan meerdere quizvragen hebben
    @OneToMany(mappedBy = "storyPhase", cascade = CascadeType.ALL)
    private List<QuizQuestion> quizQuestions;
}
