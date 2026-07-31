package br.com.featureflagestudo.task.dto;

import br.com.featureflagestudo.task.enums.TaskPriority;

public record TaskRegisterDto(
        String title,
        String description,
        TaskPriority priority
) {
}
