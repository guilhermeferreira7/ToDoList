package br.edu.utfpr.todolist.controller;

import br.edu.utfpr.todolist.model.domain.User;
import br.edu.utfpr.todolist.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CreateAccountController", value = "/criar-conta")
public class CreateAccountController extends HttpServlet {
    UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/create-account.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User userDB = userService.getByProperty("username", username);
        if (userDB != null) {
            request.setAttribute("flash.error", "Usuário já cadastrado");
            response.sendRedirect("criar-conta");
        } else {
            User user = new User(username, password);
            userService.save(user);
            request.getSession(true).setAttribute("login", user);
            response.sendRedirect("inicial");
        }
    }
}
