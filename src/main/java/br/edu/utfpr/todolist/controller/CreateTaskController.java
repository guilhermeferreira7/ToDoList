package br.edu.utfpr.todolist.controller;

import br.edu.utfpr.todolist.model.domain.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "TaskController", value = "/nova-tarefa")
public class CreateTaskController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/new-task.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String taskName = request.getParameter("taskName");
        String taskDescription = request.getParameter("taskDescription");
        LocalDateTime dateNow = LocalDateTime.now();

        request.setAttribute("date", dateNow);
        request.setAttribute("taskName", taskName);
        request.setAttribute("taskDescription", taskDescription);

        request.getRequestDispatcher("/formata-data").forward(request, response);
    }
}
