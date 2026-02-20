package org.intecbrussel.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class MediaDTO {

    private Long id;
    private String type; // VIDEO of AUDIO
    private String url;
}
