package br.com.featureflagestudo.task;

import br.com.featureflagestudo.task.dto.TaskDto;
import br.com.featureflagestudo.task.dto.TaskRegisterDto;
import br.com.featureflagestudo.task.dto.TaskUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskResource {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskRegisterDto taskRegisterDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(TaskMapper.map(taskService.createTask(taskRegisterDto)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(TaskMapper.map(taskService.getTaskById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable Long id, @RequestBody TaskUpdateDto taskUpdateDto) {
        return ResponseEntity.ok(TaskMapper.map(taskService.updateTask(id, taskUpdateDto)));
    }

    @PatchMapping("/{id}/archive")
    @ResponseStatus(HttpStatus.OK)
    public void archiveTask(@PathVariable Long id) {
        taskService.archiveTask(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
