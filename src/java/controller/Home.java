/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.DAO;
import entity.Category;
import entity.bookGerne;
import entity.book_show;
import entity.merchandise;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author taote
 */
@WebServlet(name="Home", urlPatterns={"/home"})
public class Home extends HttpServlet {
   
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
            out.println("<title>Servlet Home</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Home at " + request.getContextPath () + "</h1>");
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
         response.setContentType("text/html;charset=UTF-8");
         DAO u = new DAO();
         List<merchandise> lst = u.getMerch();
         request.setAttribute("lst",lst);
         
         List<Category> lst1 = new ArrayList<>();
          lst1 = u.getCategory();
          request.setAttribute("lst1", lst1);
         
          List<book_show> itemList = u.getBooks();
          request.setAttribute("itemList", itemList);
          
          List<bookGerne> genreList = u.getBookGern();
           request.setAttribute("genreList", genreList);
           
         request.getRequestDispatcher("home.jsp").forward(request, response);
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
        DAO u = new DAO();
          // Retrieve the categoryId from the AJAX request
    int categoryId = Integer.parseInt(request.getParameter("categoryId"));

    // Get the book list for the specific category
    List<book_show> bookList = u.getBooksByCategoryId(categoryId);

    // Generate the HTML content for the book list
    String categoryItemsHtml = generateCategoryItemsHtml(bookList);

    // Return the HTML response
    response.setContentType("text/html");
    response.getWriter().write(categoryItemsHtml);
}

// DAO method to retrieve the book list by category ID


// Generate the HTML content for the book list
private String generateCategoryItemsHtml(List<book_show> bookList) {
    StringBuilder htmlBuilder = new StringBuilder();

    for (book_show book : bookList) {
        htmlBuilder.append("<div class=\"col-sm-3\">");
        htmlBuilder.append("<div class=\"product-image-wrapper\">");
        htmlBuilder.append("<div class=\"single-products\">");
        htmlBuilder.append("<div class=\"productinfo text-center\">");
        htmlBuilder.append("<img src=\"").append(book.getImage()).append("\" alt=\"\" />");
        htmlBuilder.append("<h2>").append(book.getPrice()).append("$</h2>");
        htmlBuilder.append("<p class=\"item-name\">").append(book.getName()).append("</p>");
        htmlBuilder.append("<a href=\"productdetail?productid=").append(book.getId()).append("\" class=\"btn btn-default add-to-cart\"><i class=\"fa fa-shopping-cart\"></i>In Detail</a>");
        htmlBuilder.append("</div>");
        htmlBuilder.append("</div>");
        htmlBuilder.append("</div>");
        htmlBuilder.append("</div>");
    }

    return htmlBuilder.toString();
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
