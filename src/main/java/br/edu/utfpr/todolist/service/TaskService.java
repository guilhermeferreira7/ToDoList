package br.edu.utfpr.todolist.service;

import br.edu.utfpr.todolist.model.dao.TaskDAO;
import br.edu.utfpr.todolist.model.domain.Task;


public class TaskService extends AbstractService<Long, Task>{

    public TaskService() {
        dao = new TaskDAO();
    }
}
