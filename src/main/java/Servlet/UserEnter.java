package Servlet;

import Logic.DatabaseHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/userenter")
public class UserEnter extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userlogin = request.getParameter("uLog");
        String userpassword = request.getParameter("uPass");

        boolean result = false;

        try {
            result = DatabaseHandler.userEnter(userlogin, userpassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (result == true) {
            response.sendRedirect("user.jsp");
        }
        else{
            response.sendRedirect("auth.jsp");
        }
    }
}
