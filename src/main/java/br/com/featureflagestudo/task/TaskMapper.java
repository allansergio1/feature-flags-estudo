package br.com.featureflagestudo.task;

import br.com.featureflagestudo.task.dto.TaskDto;
import br.com.featureflagestudo.task.dto.TaskRegisterDto;
import br.com.featureflagestudo.task.entities.Task;

public class TaskMapper {

    private TaskMapper() {}

    public static Task map(TaskRegisterDto task) {
        return Task.builder()
                .title(task.title())
                .description(task.description())
                .priority(task.priority())
                .build();
    }

    public static TaskDto map(Task task) {
        return TaskDto.builder()
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getStatus())
                .priority(task.getPriority())
                .archived(task.isArchived())
                .build();
    }
}
