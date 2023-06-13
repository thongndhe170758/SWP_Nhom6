/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.DAO;
import dal.OrderDAO;
import entity.Account;
import entity.Book_Cart;
import entity.Cart;
import entity.CategoryGenreInfo;
import entity.Item;
import entity.bookImage;
import entity.book_detail;
import entity.book_show;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author taote
 */
@WebServlet(name="CheckOut", urlPatterns={"/checkout"})
public class CheckOut extends HttpServlet {
   
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
            out.println("<title>Servlet CheckOut</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckOut at " + request.getContextPath () + "</h1>");
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

       processRequest(request, response);
         
    } 
    public static void main(String[] args) {
         
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
         Account ac = null;
          Object a = session.getAttribute("curr");
          if(a!=null){
              ac = (Account)a;
              OrderDAO odb = new OrderDAO();
               try {
                   odb.addOrder(ac, cart);
               } catch (SQLException ex) {
                   Logger.getLogger(CheckOut.class.getName()).log(Level.SEVERE, null, ex);
               }
               session.removeAttribute("cart");
               session.setAttribute("size", 0);
               response.sendRedirect("product");    
// try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet CheckOut</title>");  
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>ID " + ac.getIdAccount() + "</h1>");
//            out.println("<h1>ID " + ac.getName() + "</h1>");
//            out.println("<h1>email " + ac.getEmail() + "</h1>");
//            
//            out.println("</body>");
//            out.println("</html>");
//        }
          }else{
              response.sendRedirect("login.jsp");
          }
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
