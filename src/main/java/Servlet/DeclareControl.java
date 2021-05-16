package Servlet;

import Logic.DatabaseHandler;
import Logic.Declare;
import Logic.Tax;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/declarecontrol")
public class DeclareControl extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ResultSet resSet = DatabaseHandler.getDeclare();

            List declares = new ArrayList();
            while (resSet.next()) {
                Declare dcl = new Declare();

                dcl.setDeclareID(resSet.getInt("iddeclar"));
                dcl.setNumber(resSet.getString("number"));
                dcl.setName(resSet.getString("name"));
                dcl.setSurname(resSet.getString("surname"));
                dcl.setTitle(resSet.getString("title"));
                dcl.setNalog(resSet.getString("nalog"));
                dcl.setIncomeD(resSet.getString("income"));
                dcl.setCostsD(resSet.getString("costs"));
                dcl.setFiscalD(resSet.getString("fiscal"));

                declares.add(dcl);
            }
            request.setAttribute("list", declares);
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/declarecheck.jsp");
            requestDispatcher.forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
