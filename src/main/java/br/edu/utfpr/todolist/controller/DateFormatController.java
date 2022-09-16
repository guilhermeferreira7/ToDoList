package br.edu.utfpr.todolist.controller;

import br.edu.utfpr.todolist.model.domain.Task;
import br.edu.utfpr.todolist.model.domain.User;
import br.edu.utfpr.todolist.service.TaskService;
import br.edu.utfpr.todolist.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "DateFormatController", value = "/formata-data")
public class DateFormatController extends HttpServlet {
    TaskService taskService = new TaskService();
    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime dateNow = ( LocalDateTime ) request.getAttribute("date");

        Integer totalTasks = (Integer) getServletContext().getAttribute("tasksCounter");
        if (totalTasks == null) {
            totalTasks = 0;
        }

        totalTasks++;
        getServletContext().setAttribute("tasksCounter", totalTasks);

        String date = dtf.format(dateNow);
        String taskName = (String) request.getAttribute("taskName");
        String taskDescription = (String) request.getAttribute("taskDescription");

        User user = (User) request.getSession(true).getAttribute("login");
        Task task = new Task(taskName, taskDescription, false, date, user);

        taskService.save(task);

        response.sendRedirect("inicial");
    }
}
