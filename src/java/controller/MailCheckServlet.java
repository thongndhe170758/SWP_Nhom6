/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;
import dal.CustomerDAO;
import entity.Account;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;




/**
 *
 * @author Admin
 */
public class MailCheckServlet extends HttpServlet {
    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String userCode = request.getParameter("code");
    PrintWriter pr = response.getWriter();
    String verificationCode = (String) request.getSession().getAttribute("code");
    
    if (verificationCode != null && verificationCode.equals(userCode)) {
        Account x = (Account) request.getSession().getAttribute("curr");
        CustomerDAO dao = new CustomerDAO();
        boolean check=dao.addAccount(x);
        if(check){
             response.sendRedirect("Home");
        }
        
       
    } else {
       pr.println("Verification code is incorrect");
       
        
    }
}

  }