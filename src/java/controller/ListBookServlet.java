/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;


import dal.*;
import entity.*;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;



/**
 *
 * @author Admin
 */
public class ListBookServlet extends HttpServlet {
//@Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter pr = response.getWriter();
//        DAO dao = new DAO();
//        ArrayList<book_detail> b = dao.getBookDetails();
//        request.setAttribute("bookdetail", b);
//        if(b==null){
//            pr.print("nulll");
//        }
//        
////        request.getRequestDispatcher("showbook.jsp").forward(request, response);
//    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter pr = response.getWriter();
    DAO dao = new DAO();
    ArrayList<book_detail> b = dao.getBookDetails();
    request.setAttribute("bookdetail", b);

    if (b == null) {
        pr.print("null");
    } else {
       request.setAttribute("bookdetail", b);
       request.getRequestDispatcher("showbook.jsp").forward(request, response);
}


    

}}
