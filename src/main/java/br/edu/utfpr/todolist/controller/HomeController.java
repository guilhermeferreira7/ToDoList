package br.edu.utfpr.todolist.controller;

import br.edu.utfpr.todolist.model.domain.User;
import br.edu.utfpr.todolist.service.UserService;

import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "HomeController", value = "/inicial")
public class HomeController extends HttpServlet {

    UserService userService = new UserService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer totalTasks = (Integer) getServletContext().getAttribute("tasksCounter");
        if (totalTasks == null) {
            totalTasks = 0;
        }
        getServletContext().setAttribute("tasksCounter", totalTasks);

        request.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User userDB = userService.getByProperty("username", username);
        if (userDB == null) {
            response.sendRedirect("/to-do-list");
        } else if (!userDB.getPassword().equals(password)) {
            response.sendRedirect("/to-do-list");
        } else {
            request.getSession(true).setAttribute("login", userDB);
            response.sendRedirect("inicial");
        }

    }

}
