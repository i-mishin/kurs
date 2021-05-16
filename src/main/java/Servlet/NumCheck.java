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

@WebServlet("/numconfirm")
public class NumCheck extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String unp = request.getParameter("unp");
        String data = null;
        try {
            data = DatabaseHandler.numCheck(unp);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(data.equals("nothing")){
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/nodeclar.jsp");
            requestDispatcher.forward(request, response);
        }
        else{
            String[] strings = data.split("\\*");

            request.setAttribute("1", strings[0]);
            request.setAttribute("2", strings[1]);
            request.setAttribute("3", strings[2]);
            request.setAttribute("4", strings[3]);
            request.setAttribute("5", strings[4]);
            request.setAttribute("6", strings[5]);
            request.setAttribute("7", strings[6]);
            request.setAttribute("8", strings[7]);
            request.setAttribute("9", strings[8]);

            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/userdeclare.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
