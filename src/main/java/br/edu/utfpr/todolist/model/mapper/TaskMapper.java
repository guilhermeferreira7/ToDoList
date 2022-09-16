package br.edu.utfpr.todolist.model.mapper;

import br.edu.utfpr.todolist.model.domain.Task;
import br.edu.utfpr.todolist.model.dto.TaskDTO;

public class TaskMapper {

    public static Task toEntity(TaskDTO dto){
        Task entity = new Task(dto.getTaskName(), dto.getDescription(), dto.isCompleted(), dto.getDataCreated(), dto.getUser());
        return entity;
    }

    public static TaskDTO toDTO(Task entity){
        TaskDTO dto = new TaskDTO(entity.getTaskName(), entity.getDescription(),
                                  entity.isCompleted(), entity.getDataCreated(), entity.getUser());
        return dto;
    }
}
