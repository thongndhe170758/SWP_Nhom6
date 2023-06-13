/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.CustomerDAO;
import dal.DAO;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import entity.*;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashSet;

/**
 *
 * @author Admin
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        request.getRequestDispatcher("login.jsp").forward(request, response);
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
            request.setAttribute("ls", false);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            if (u.getRole().equals("admin")) {
                response.sendRedirect("admin.jsp");
            } else {
                response.sendRedirect("home");
            }
        }
        if (rememberMe) {
            // Set the "Keep me signed in" cookie
            SecureRandom secureRandom = new SecureRandom();
            byte[] tokenBytes = new byte[32];
            secureRandom.nextBytes(tokenBytes);
            String userToken = Base64.getUrlEncoder().withoutPadding().encodeToString(tokenBytes);

            Cookie cookie = new Cookie("remember_token", userToken);
            cookie.setMaxAge(60 * 60 * 24 * 30); // 30 days
            response.addCookie(cookie);
        }
    }
}
