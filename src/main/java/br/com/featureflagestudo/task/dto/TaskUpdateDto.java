package br.com.featureflagestudo.task.dto;

import br.com.featureflagestudo.task.entities.TaskStatus;

public record TaskUpdateDto(
        String title,
        String description,
        TaskStatus status
) {
}
