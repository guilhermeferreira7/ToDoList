package br.edu.utfpr.todolist.controller;
import br.edu.utfpr.todolist.model.domain.User;

import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GetLoginController", value = "/getLogin")
public class GetLoginController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User loginUser = (User) request.getSession(true).getAttribute("login");

        if (loginUser != null) {
            String json = new Gson().toJson(loginUser);
            response.setContentType("plain/text");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        } else {
            response.getWriter().write("");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
