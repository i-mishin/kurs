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

@WebServlet("/taxcheck")
public class TaxCheck extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forma = request.getParameter("form");
        String workers = request.getParameter("workers");
        String vv = request.getParameter("vv");

        List taxes = new ArrayList();

        taxes = DatabaseHandler.taxCheck(forma, workers, vv);

        request.setAttribute("list", taxes);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/firmoutput.jsp");
        requestDispatcher.forward(request, response);
    }
}
