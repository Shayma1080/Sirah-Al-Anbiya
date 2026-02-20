package org.intecbrussel.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizQuestionDTO {
    private Long id;
    private String question;
    private List<String> optionsAnswer;
}
