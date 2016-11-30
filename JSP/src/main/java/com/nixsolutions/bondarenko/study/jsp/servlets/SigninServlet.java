package com.nixsolutions.bondarenko.study.jsp.servlets;

import com.nixsolutions.bondarenko.study.jsp.user.library.JdbcUserDao;
import com.nixsolutions.bondarenko.study.jsp.user.library.User;
import com.nixsolutions.bondarenko.study.jsp.user.library.UserLibraryRole;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class SigninServlet extends HttpServlet {
    private static String SIGNIN_ERROR_MESSAGE = "Incorrect login or password!";

    private JdbcUserDao jdbcUserDao = new JdbcUserDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("signin.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        try {
            boolean incorrectLoginOrPassword = false;
            User user = jdbcUserDao.findByLogin(login);
            if (user != null) {
                if (user.getPassword().equals(password)) {
                    request.getSession().setAttribute("currentUser", user);
                    if (user.getRole().getName().equals(UserLibraryRole.USER.getName())) {
                        request.setAttribute("user", user);
                        response.sendRedirect("/home.jsp");
                    } else if (user.getRole().getName().equals(UserLibraryRole.ADMIN.getName())) {
                        response.sendRedirect("/admin");
                    }
                } else {
                    incorrectLoginOrPassword = true;
                }
            } else {
                incorrectLoginOrPassword = true;
            }
            if (incorrectLoginOrPassword) {
                request.setAttribute("login", login);
                request.setAttribute("errorMessage", SIGNIN_ERROR_MESSAGE);
                request.getRequestDispatcher("signin.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            //TODO show error page
            request.getRequestDispatcher("signin.jsp").forward(request, response);
        }
    }
}
