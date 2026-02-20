package org.intecbrussel.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class ProphetDTO {
    private Long id;
    private String name;
    private String period;
    private String description;
    private List<StoryPhaseDTO> storyPhases;
}
