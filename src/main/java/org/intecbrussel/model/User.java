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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String email;
    private String password;
    // 1 user kan meerde quizattempts hebben
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<QuizAttempt> quizAttempts;

    // 1 user kan meerde UserProgress entries hebben
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserProgress> userProgress;


}
