package Servlet;

import Logic.DatabaseHandler;
import Logic.Tax;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/viewrecord")
public class ViewRecord extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ResultSet resSet = DatabaseHandler.getRecords();
            //String[] strings = data.split("\\*");
            //String element = strings[0];

           /* String[] mas = data.split(" ");
            request.setAttribute("mas", mas);*/
            List taxes = new ArrayList();
            while (resSet.next()) {
                Tax tax = new Tax();
                tax.settaxId(resSet.getInt("idtax"));
                tax.setTaxcategory(resSet.getString("taxcategory"));
                tax.setMonth(resSet.getString("month"));
                tax.setIncome(resSet.getString("income"));
                tax.setSingle(resSet.getString("single"));
                tax.setSimplyfied(resSet.getString("simplyfied"));
               /* */

                taxes.add(tax);
            }
            request.setAttribute("list", taxes);
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/view.jsp");
            requestDispatcher.forward(request, response);
            } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
