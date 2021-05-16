package Servlet;

import Logic.DatabaseHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/adminenter")
public class AdminEnter extends HttpServlet {
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String adminlogin = request.getParameter("aLog");
        String adminpassword = request.getParameter("aPass");
        boolean result = false;

       try {
           result = DatabaseHandler.adminEnter(adminlogin, adminpassword);
       } catch (SQLException | ClassNotFoundException e) {
           e.printStackTrace();
       }

       if (result == true) {
           response.sendRedirect("admin.jsp");
       }
       else{
           response.sendRedirect("auth.jsp");
       }
    }
}
