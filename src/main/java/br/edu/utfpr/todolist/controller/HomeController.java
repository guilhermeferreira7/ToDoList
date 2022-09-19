package br.edu.utfpr.todolist.controller;

import br.edu.utfpr.todolist.model.domain.Task;
import br.edu.utfpr.todolist.model.domain.User;
import br.edu.utfpr.todolist.service.TaskService;
import br.edu.utfpr.todolist.service.UserService;

import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "HomeController", value = "/inicial")
public class HomeController extends HttpServlet {
    TaskService taskService = new TaskService();
    UserService userService = new UserService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User login = (User) request.getSession(true).getAttribute("login");
        if (login == null) {
            login = userService.getByProperty("username", request.getParameter("username"));
            request.getSession(true).setAttribute("login", login);
        }

        List<Task> tasks = taskService.listByForeignOrObjectProperty("user", login);
        List<Task> toDoTasks = new ArrayList<>();

        for (Task task: tasks) {
            if (!task.isCompleted()) {
                toDoTasks.add(task);
            }
        }

        request.setAttribute("tasks", toDoTasks);
        request.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
