/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.CustomerDAO;
import entity.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 *
 * @author Admin
 */
public class AddBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        request.getRequestDispatcher("addbook.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String email, pass;
        email = request.getParameter("email");
        pass = request.getParameter("pass");
        boolean rememberMe = request.getParameter("remember") != null;
        CustomerDAO dao = new CustomerDAO();
        Account u = dao.getAccount(email, pass);
        request.getSession().setAttribute("curr", u);
        if (u == null) {

        } else {
            if (u.getRole().equals("admin")) {
                response.sendRedirect("admin.jsp");
            } else {
                response.sendRedirect("home");
            }
            if (rememberMe) {
                // Set the "Keep me signed in" cookie
                Cookie cookie = new Cookie("remember_token", "user_token_value");
                cookie.setMaxAge(60 * 60 * 24 * 30); // 30 days
                response.addCookie(cookie);
            }
        }
    }

}
