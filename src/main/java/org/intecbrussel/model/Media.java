package org.intecbrussel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type; // Video, Image, Audio
    private String url;
    @ManyToOne
    @JoinColumn(name= "story_phase_id")
    private StroyPhase storyPhase;
}
