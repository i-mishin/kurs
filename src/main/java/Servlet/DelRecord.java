package Servlet;

import Logic.DatabaseHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/delrecord")
public class DelRecord extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String delID = request.getParameter("delId");

        try {
            DatabaseHandler.delRecord(delID);
            response.sendRedirect("result.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
