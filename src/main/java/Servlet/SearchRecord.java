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

@WebServlet("/searchrecord")
public class SearchRecord extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("idsearch");
        String data = null;
        try {
            data = DatabaseHandler.findRecord(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(data != null) {
            String[] strings = data.split("\\  ");

            request.setAttribute("1", strings[0]);
            request.setAttribute("2", strings[1]);
            request.setAttribute("3", strings[2]);
            request.setAttribute("4", strings[3]);
            request.setAttribute("5", strings[4]);
            request.setAttribute("6", strings[5]);

            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/foundrecord.jsp");
            requestDispatcher.forward(request, response);
        }
        else{
            System.out.println("ZAPISI NET");
            ////////////ТАКОЙ ЗАПИСИ НЕТ
        }
    }
}
