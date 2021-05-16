package Servlet;

import Logic.DatabaseHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/createrecord")
public class CreateRecord extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String category = request.getParameter("category");
        String month = request.getParameter("month");
        String income = request.getParameter("income");
        String single = request.getParameter("single");
        String eased = request.getParameter("eased");
        String number = request.getParameter("number");

        String statement = DatabaseHandler.recordAdd(category, month, income, single, eased, number);
        response.sendRedirect("result.jsp");

    }
}
