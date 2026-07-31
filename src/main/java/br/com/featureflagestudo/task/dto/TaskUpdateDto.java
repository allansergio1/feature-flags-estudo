package br.com.featureflagestudo.task.dto;

import br.com.featureflagestudo.task.enums.TaskPriority;
import br.com.featureflagestudo.task.enums.TaskStatus;

public record TaskUpdateDto(
        String title,
        String description,
        TaskStatus status,
        TaskPriority priority
) {
}