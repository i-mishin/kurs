package Servlet;

import Logic.DatabaseHandler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/declare")
public class Declare extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String number = request.getParameter("number");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String title = request.getParameter("title");
        String nalog = request.getParameter("system");
        String income = request.getParameter("income");
        String costs = request.getParameter("costs");
        String vat = request.getParameter("vat");
        String reg = request.getParameter("reg");

        List declareList = new ArrayList();

        declareList = DatabaseHandler.declare(number, name, surname, title, nalog, income, costs, vat, reg);
        request.setAttribute("list", declareList);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/declareresult.jsp");
        requestDispatcher.forward(request, response);
    }
}
