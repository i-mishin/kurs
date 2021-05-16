package Servlet;

import Logic.DatabaseHandler;

import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.sql.SQLException;

@javax.servlet.annotation.WebServlet("/registration")
public class Registration extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        boolean flag;
        String reglogin = request.getParameter("reglog");
        String regpassword = request.getParameter("regpass");
        //System.out.println("login = " + reglogin + " password = " + regpassword);
        try {
            flag = DatabaseHandler.userAdd(reglogin, regpassword);
            System.out.println("flag = " + flag);
           if(flag == false){
                response.sendRedirect("error.jsp");
            }
            else{
               response.sendRedirect("result.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
