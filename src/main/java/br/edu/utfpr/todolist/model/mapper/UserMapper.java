package br.edu.utfpr.todolist.model.mapper;

import br.edu.utfpr.todolist.model.domain.User;
import br.edu.utfpr.todolist.model.dto.UserDTO;

public class UserMapper {

    public static User toEntity(UserDTO dto){
        User entity = new User(dto.getUsername(), dto.getPassword());
        return entity;
    }

    public static UserDTO toDTO(User entity){
        UserDTO dto = new UserDTO(entity.getUsername(), entity.getPassword());
        return dto;
    }
}
