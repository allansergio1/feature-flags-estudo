package br.com.featureflagestudo.task.dto;

import br.com.featureflagestudo.task.entities.TaskStatus;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {

    private String title;
    private String description;
    private TaskStatus status;
}
