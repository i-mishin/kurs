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
import java.util.Arrays;

@WebServlet("/fstat")
public class FiscalStat extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String fiscalSum = DatabaseHandler.fiscalStat();
            String[] strings = fiscalSum.split("\\|");

            request.setAttribute("income", strings[0]);
            request.setAttribute("single", strings[1]);
            request.setAttribute("simplyfied", strings[2]);
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/fstatistics.jsp");
            requestDispatcher.forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
