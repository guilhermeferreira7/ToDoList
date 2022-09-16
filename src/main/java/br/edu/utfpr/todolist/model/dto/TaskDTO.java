package br.edu.utfpr.todolist.model.dto;

import br.edu.utfpr.todolist.model.domain.User;
import lombok.Data;
import lombok.NonNull;

@Data
public class TaskDTO {
    @NonNull
    private String taskName;
    @NonNull
    private String description;
    @NonNull
    private boolean isCompleted;
    @NonNull
    private String dataCreated;

    private String dataCompleted;

    @NonNull
    private User user;

}
