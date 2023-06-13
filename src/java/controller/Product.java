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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author taote
 */
@WebServlet(name = "Product", urlPatterns = {"/product"})
public class Product extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Home</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Home at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    public static void main(String[] args) {
        DAO u = new DAO();

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
        request.setAttribute("lst", lst);

        List<Category> lst1 = new ArrayList<>();
        lst1 = u.getCategory();
        request.setAttribute("lst1", lst1);

        String merchID = request.getParameter("merchid");
        request.setAttribute("merchID", merchID);
        String cateID = request.getParameter("cateID");
        request.setAttribute("cateID", cateID);
        String gerneID = request.getParameter("gerneID");
        request.setAttribute("gerneID", gerneID);
        String itemName = request.getParameter("searchInput");
        request.setAttribute("searchInput", itemName);

        if (merchID != null) {

            String index = request.getParameter("index");
            if (index == null) {
                index = "1";
            }
            int IDmer = Integer.parseInt(merchID);
            int indexPage = Integer.parseInt(index);
            List<book_show> itemList = u.getBooksByMerchandiseId2(IDmer, indexPage);
            request.setAttribute("itemList", itemList);
            request.setAttribute("indexPage", indexPage);
            int getPageCount = u.GetNumberPageMerch(IDmer);
            request.setAttribute("pageCount", getPageCount);

        } else if (cateID != null) {
            String index = request.getParameter("index");
            if (index == null) {
                index = "1";
            }
            int IDcat = Integer.parseInt(cateID);
            int indexPage = Integer.parseInt(index);
            List<book_show> itemList = u.getBooksByCategory(IDcat, indexPage);
            request.setAttribute("itemList", itemList);
            request.setAttribute("indexPage", indexPage);
            int getPageCount = u.GetNumberPageCategory(IDcat);
            request.setAttribute("pageCount", getPageCount);
        } else if (gerneID != null) {
            String index = request.getParameter("index");
            if (index == null) {
                index = "1";
            }
            int IDgerne = Integer.parseInt(gerneID);
            int indexPage = Integer.parseInt(index);
            List<book_show> itemList = u.getBooksByGerne(IDgerne, indexPage);
            request.setAttribute("itemList", itemList);
            request.setAttribute("indexPage", indexPage);
            int getPageCount = u.GetNumberPageGerne(IDgerne);
            request.setAttribute("pageCount", getPageCount);
        } else if (itemName != null) {
            String index = request.getParameter("index");
            if (index == null) {
                index = "1";
            }
            int indexPage = Integer.parseInt(index);
            List<book_show> itemList = u.searchBookByName(itemName, indexPage);
            request.setAttribute("itemList", itemList);
            request.setAttribute("indexPage", indexPage);
            int getPageCount = u.countPageByBookName(itemName);
            request.setAttribute("pageCount", getPageCount);
        } else {
            String index = request.getParameter("index");
            if (index == null) {
                index = "1";
            }

            int indexPage = Integer.parseInt(index);
            List<book_show> itemList = u.getBooksByPage(indexPage);
            request.setAttribute("itemList", itemList);
            request.setAttribute("indexPage", indexPage);
            int getPageCount = u.GetNumberPage();
            request.setAttribute("pageCount", getPageCount);

        }

        List<bookGerne> genreList = u.getBookGern();
        request.setAttribute("genreList", genreList);

        request.getRequestDispatcher("product.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
