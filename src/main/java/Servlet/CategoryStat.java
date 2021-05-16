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

@WebServlet("/catstat")
public class CategoryStat extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String catResult = DatabaseHandler.categoryStat();
            String[] strings = catResult.split(" ");

            String citizenSum = strings[0];
            String ieSum = strings[1];

            request.setAttribute("citizens", strings[0]);
            request.setAttribute("ie", strings[1]);
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/catstatistics.jsp");
            requestDispatcher.forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
