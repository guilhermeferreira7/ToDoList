package br.edu.utfpr.todolist.model.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class TaskDTOCompleted {
    @NonNull
    private String taskName;
    @NonNull
    private String dataCompleted;
    @NonNull
    private String dataCreated;

}
