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

@WebServlet("/graphics")
public class Graphics extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fiscalSum = null;
        try {
            fiscalSum = DatabaseHandler.fiscalStat();
            String[] strings = fiscalSum.split("\\|");

            String income = strings[0];
            String single = strings[1];
            String simplyfied = strings[2];

            request.setAttribute("income", strings[0]);
            request.setAttribute("single", strings[1]);
            request.setAttribute("simplyfied", strings[2]);

            String catResult = DatabaseHandler.categoryStat();
            String[] strings1 = catResult.split(" ");

            String citizenSum = strings1[0];
            String ieSum = strings1[1];

            request.setAttribute("citizens", strings1[0]);
            request.setAttribute("ie", strings1[1]);

            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/graphics.jsp");
            requestDispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
