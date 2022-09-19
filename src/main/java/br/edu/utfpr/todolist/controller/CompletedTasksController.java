package br.edu.utfpr.todolist.controller;

import br.edu.utfpr.todolist.model.domain.Task;
import br.edu.utfpr.todolist.model.domain.User;
import br.edu.utfpr.todolist.service.TaskService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CompletedTasksController", value = "/tarefas-concluidas")
public class CompletedTasksController extends HttpServlet {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    TaskService taskService = new TaskService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User login = (User) request.getSession(true).getAttribute("login");
        List<Task> tasks = taskService.listByForeignOrObjectProperty("user", login);
        List<Task> completedTasks = new ArrayList<>();

        for (Task task: tasks) {
            if (task.isCompleted()) {
                completedTasks.add(task);
            }
        }

        request.setAttribute("tasks", completedTasks);

        request.getRequestDispatcher("/WEB-INF/view/completed-tasks.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Task task = taskService.getById(id);

        LocalDateTime now = LocalDateTime.now();
        String dataCompleted = dtf.format(now);

        task.setCompleted(true);
        task.setDataCompleted(dataCompleted);
        taskService.update(task);

    }
}
