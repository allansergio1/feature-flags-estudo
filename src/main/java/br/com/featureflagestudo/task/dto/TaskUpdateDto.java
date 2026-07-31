package br.com.featureflagestudo.task.dto;

import br.com.featureflagestudo.task.TaskStatus;

public record TaskUpdateDto(
        String title,
        String description,
        TaskStatus status
) {
}