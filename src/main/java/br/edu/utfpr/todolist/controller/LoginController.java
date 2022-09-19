package br.edu.utfpr.todolist.controller;

import br.edu.utfpr.todolist.model.domain.User;
import br.edu.utfpr.todolist.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User userDB = userService.getByProperty("username", username);
        if (userDB == null) {
            request.setAttribute("flash.error", "Usuário não existe ou senha errada");
            response.sendRedirect("/to-do-list");
        } else if (!userDB.getPassword().equals(password)) {
            request.setAttribute("flash.error", "Usuário não existe ou senha errada");
            response.sendRedirect("/to-do-list");
        } else {
            request.getSession(true).setAttribute("login", userDB);
            response.sendRedirect("inicial");
        }
    }
}
