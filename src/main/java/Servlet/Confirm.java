package Servlet;

import Logic.DatabaseHandler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/confirm")
public class Confirm extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String decID = request.getParameter("decID");
        try {
            boolean flag = DatabaseHandler.declined(decID);
            if (flag == true){
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/decline.jsp");
                requestDispatcher.forward(request,response);
            }
            else{
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/nodeclar.jsp");
                requestDispatcher.forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
