package br.edu.utfpr.todolist.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TaskCounterController", value = "/task-counter")
public class TaskCounterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer totalTasks = (Integer) getServletContext().getAttribute("tasksCounter");
        if (totalTasks == null) {
            totalTasks = 0;
        }
        totalTasks++;
        getServletContext().setAttribute("tasksCounter", totalTasks);

        response.sendRedirect("inicial");
    }
}
