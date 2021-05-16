package Servlet;

import Logic.DatabaseHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/adduser")
public class AddUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean flag;
        String newLogin = request.getParameter("newLogin");
        String newPassword = request.getParameter("newPassword");
        //System.out.println("login = " + reglogin + " password = " + regpassword);
        response.sendRedirect("result.jsp");
    }
}
