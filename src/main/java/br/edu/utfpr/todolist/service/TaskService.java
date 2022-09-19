package br.edu.utfpr.todolist.service;

import br.edu.utfpr.todolist.model.dao.TaskDAO;
import br.edu.utfpr.todolist.model.domain.Task;
import br.edu.utfpr.todolist.model.domain.User;

import java.util.List;


public class TaskService extends AbstractService<Long, Task>{

    public TaskService() {
        dao = new TaskDAO();
    }

}
