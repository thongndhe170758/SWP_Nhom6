/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.DAO;
import dal.OrderDAO;
import entity.Book_Cart;
import entity.Cart;
import entity.Item;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author taote
 */
@WebServlet(name="Process", urlPatterns={"/process"})
public class Process extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Process</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Process at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession(true);
         Cart cart = null;
        Object o = session.getAttribute("cart");
        //co roi\
        if(o!=null){
            cart = (Cart)o;
        }else{
            cart = new Cart();
        }
        String tnum = request.getParameter("num").trim();
        String tid = request.getParameter("id");
        int id, num;
        try {
            id = Integer.parseInt(tid);
            num = Integer.parseInt(tnum);
            if((num == -1) && (cart.getQuantityById(id)<=1)){
                cart.removeItem(id);
            }else{
               DAO od = new DAO();
                Book_Cart b = od.getProductbyID(id);
                double price =b.getPrice();
                Item t = new Item(b, num, price);
                cart.addItem(t);    
            }
        } catch (Exception e) {
        }
        List<Item> list = cart.getItem();
         session.setAttribute("cart", cart);
        session.setAttribute("size", list.size());   
      request.getRequestDispatcher("cart.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
           HttpSession session = request.getSession(true);
        Cart cart = null;
        Object o = session.getAttribute("cart");
        //co roi\
        if(o!=null){
            cart = (Cart)o;
        }else{
            cart = new Cart();
        }
        int id = Integer.parseInt(request.getParameter("id"));
        cart.removeItem(id);
        List<Item> list = cart.getItem();
         session.setAttribute("cart", cart);
        session.setAttribute("size", list.size());   

      request.getRequestDispatcher("cart.jsp").forward(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
