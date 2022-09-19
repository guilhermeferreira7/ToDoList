package br.edu.utfpr.todolist.model.mapper;

import br.edu.utfpr.todolist.model.domain.Task;
import br.edu.utfpr.todolist.model.dto.TaskDTO;
import br.edu.utfpr.todolist.model.dto.TaskDTOCompleted;

public class TaskMapper {

//    public static Task toEntity(TaskDTO dto){
//        Task entity = new Task(dto.getTaskName(), dto.getDescription(), dto.isCompleted(), dto.getDataCreated(), dto.getUser());
//        return entity;
//    }

    public static TaskDTO toDTO(Task entity){
        TaskDTO dto = new TaskDTO(entity.getId(), entity.getTaskName(), entity.getDescription(), entity.getDataCreated());
        return dto;
    }

    public static TaskDTOCompleted toDTOCompleted(Task entity){
        TaskDTOCompleted dto = new TaskDTOCompleted(entity.getTaskName(), entity.getDataCreated(), entity.getDataCompleted());
        return dto;
    }
}
