package br.com.featureflagestudo.task;

import br.com.featureflagestudo.task.dto.TaskRegisterDto;
import br.com.featureflagestudo.task.dto.TaskUpdateDto;
import br.com.featureflagestudo.task.entities.Task;
import br.com.featureflagestudo.task.enums.TaskStatus;
import io.getunleash.Unleash;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final Unleash unleash;

    public Task createTask(TaskRegisterDto task) {
        Task newTask = TaskMapper.map(task);
        newTask.setStatus(TaskStatus.PENDING);
        return taskRepository.save(newTask);
    }

    public Task updateTask(Long taskId, TaskUpdateDto taskUpdateDto) {
        Task existingTask = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        if (taskUpdateDto.title() != null) {
            existingTask.setTitle(taskUpdateDto.title());
        }
        if (taskUpdateDto.description() != null) {
            existingTask.setDescription(taskUpdateDto.description());
        }
        if (taskUpdateDto.status() != null) {
            existingTask.setStatus(taskUpdateDto.status());
        }
        if (unleash.isEnabled("task.priority") && taskUpdateDto.priority() != null) {
            existingTask.setPriority(taskUpdateDto.priority());
        }
        return taskRepository.save(existingTask);
    }

    public Task getTaskById(Long taskId) {
        return taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public void deleteTask(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        taskRepository.delete(task);
    }
}