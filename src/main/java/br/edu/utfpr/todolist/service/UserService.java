package br.edu.utfpr.todolist.service;

import br.edu.utfpr.todolist.model.dao.UserDAO;
import br.edu.utfpr.todolist.model.domain.User;

import java.util.Calendar;

public class UserService extends AbstractService<Long, User>{

    public UserService() {
        dao = new UserDAO();
    }
}
