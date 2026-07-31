package br.com.featureflagestudo.task.entities;

import br.com.featureflagestudo.task.enums.TaskPriority;
import br.com.featureflagestudo.task.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    @Enumerated(EnumType.STRING)
    private TaskPriority priority;
    private boolean archived;

    public void archive() {
        this.archived = true;
    }
}
