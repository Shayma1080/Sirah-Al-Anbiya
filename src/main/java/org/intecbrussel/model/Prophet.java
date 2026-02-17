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
public class Prophet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String period;
    @Column(length = 2000)
    private String description;

    // 1 prophet kan in meerdere story phases hebben

    @OneToMany(mappedBy = "prophet", cascade = CascadeType.ALL)
    private List<StoryPhase> stroyPhases;

    // 1 prophet kan in meerde UserProgress entries voorkomen
    @OneToMany(mappedBy = "prophet", cascade = CascadeType.ALL)
    private List<UserProgress> userProgress;
}




