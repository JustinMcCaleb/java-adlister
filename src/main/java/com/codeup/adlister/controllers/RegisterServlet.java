package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.Users;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: show the registration form
        request.getRequestDispatcher("/WEB-INF/users/register.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: ensure the submitted information is valid *
        // TODO: create a new user based off of the submitted information *
        // TODO: if a user was successfully created, send them to their profile *

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if(username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            response.sendRedirect("/register");
        } else {
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setEmail(email);
            newUser.setPassword(password);

            request.getSession().setAttribute("user", username);

            Users userDao = DaoFactory.getUsersDao();
            userDao.insert(newUser);

            response.sendRedirect("/profile");
        }
    }
}
