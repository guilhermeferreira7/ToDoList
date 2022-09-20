package br.edu.utfpr.todolist.controller;

import br.edu.utfpr.todolist.model.domain.User;
import br.edu.utfpr.todolist.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

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
            Cookie lastLogin = new Cookie("lastLogin", username);
            lastLogin.setMaxAge(120);
            response.addCookie(lastLogin);
            request.getSession(true).setAttribute("lastLogin", lastLogin.getValue());
            request.getSession(true).setAttribute("loginCounter", this.loginCounter(request, response).getValue());
            response.sendRedirect("inicial");
        }
    }

    public Cookie loginCounter(HttpServletRequest request, HttpServletResponse response) {
        Cookie loginCounter = new Cookie("loginCounter", "0");
        Cookie[] cookies = request.getCookies();

        for ( Cookie cookie: cookies) {
            if (cookie.getName().equals("loginCounter")) {
                loginCounter = cookie;
            }
        }

        Integer counter = Integer.valueOf(loginCounter.getValue());
        loginCounter.setValue(String.valueOf(counter + 1));
        response.addCookie(loginCounter);

        return loginCounter;
    }
}
