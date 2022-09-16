package br.edu.utfpr.todolist.service;

import br.edu.utfpr.todolist.model.dao.UserDAO;
import br.edu.utfpr.todolist.model.domain.User;


public class UserService extends AbstractService<Long, User>{

    public UserService() {
        dao = new UserDAO();
    }
}
