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
import java.util.Properties;

@WebServlet(name = "TaskController", value = "/nova-tarefa")
public class CreateTaskController extends HttpServlet {
    TaskService taskService = new TaskService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/new-task.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime dateNow = LocalDateTime.now();

        String taskName = request.getParameter("taskName");
        String taskDescription = request.getParameter("taskDescription");
        String date = dtf.format(dateNow);

        User user = (User) request.getSession(true).getAttribute("login");
        Task task = new Task(taskName, taskDescription, false, date, user);

        taskService.save(task);
        request.getRequestDispatcher("/task-counter").forward(request, response);
    }
}
