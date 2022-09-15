package br.edu.utfpr.todolist.controller;

import br.edu.utfpr.todolist.model.domain.User;
import br.edu.utfpr.todolist.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LoginController", value = "/inicial")
public class LoginController extends HttpServlet {

    UserService userService = new UserService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            response.sendRedirect("inicial");
        }

    }

}
