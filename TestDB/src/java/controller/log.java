/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dal.UserDAO;
import java.util.Vector;
import model.User;

/**
 *
 * @author Asus
 */
@WebServlet(name = "log", urlPatterns = {"/log"})
public class log extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String ERROR = "invalid.html";
    private static final String SUCCESS = "ok.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = ERROR;
        try {
            /* TODO output your page here. You may use following sample code. */
            String s1 = request.getParameter("userID");
            String s2 = request.getParameter("password");
            UserDAO u = new UserDAO();
            boolean check = u.checkLogin(s1, s2);
            if (check) {
                url = SUCCESS;
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet log</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet log at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            response.sendRedirect(url);
        }
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
        processRequest(request, response);
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
//        String s1 = request.getParameter("userID");
//        String s2 = request.getParameter("password");
//        UserDAO u = new UserDAO();
//        PrintWriter out = response.getWriter();
//        Vector<User> users = u.getAllUser("select * from tblUsers");
//        boolean ok = false;
//        for (User us : users) {
//            if (us.getUserID().equals(s1) && us.getPassword().equals(s2)) {
////             response.sendRedirect("welcome.jsp");
//                ok = true;
//                break;
//            }
//        }
//        if (ok) {
//            response.sendRedirect("ok.jsp");
//        } else {
//            response.sendRedirect("invalid.html");
//        }
        
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
