/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.CategoryDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Vector;
import model.Category;

/**
 *
 * @author Asus
 */
@WebServlet(name = "ServletCategory", urlPatterns = {"/ServletCategory"})
public class ServletCategory extends HttpServlet {

    public static final String sqlAll = "select * from tblCategories";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        CategoryDAO dao = new CategoryDAO();
        String service = request.getParameter("service");
        if (service == null) {
            service = "listCategory";
        }
        if (service.equals("addCategory")) {
            String categoryID, categoryName, describe;
            categoryID = request.getParameter("categoryID");
            categoryName = request.getParameter("categoryName");
            describe = request.getParameter("describe");

            Category c = new Category(categoryID, categoryName, describe);
            dao.insertCat(c);
            response.sendRedirect("ServletCategory");
        }
        if (service.equals("deleteCategory")) {
            String cID = request.getParameter("cID");
            dao.deleteCategory(cID);
            response.sendRedirect("ServletCategory");
        }
        if (service.equals("listCategory")) {
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet ServletProduct</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<form action=\"ServletCategory\" method=\"get\">\n"
                        + "            <p>Search by name : </p>\n"
                        + "            <input type=\"text\" name=\"categoryName\" required=\"\" />\n"
                        + "            <input type=\"submit\" name = \"submit\" value=\"Search\">\n"
                        + "            <input type=\"reset\" value=\"Reset\">\n"
                        + "            <input type=\"hidden\" name=\"service\" value=\"listCategory\">\n"
                        + "        </form>");
                out.println("<table border='1'>");
                out.println("<tr>");
                out.println(" <th>categoryID</th>");
                out.println("<th>categoryNameName</th>");
                out.println(" <th>describe</th>");
                out.println("<th>Update</th>");
                out.println("<th>Delete</th>");
                out.println("</tr>");

                Vector<Category> list;
                String submit = request.getParameter("submit");
                if (submit != null) {
                    String name = request.getParameter("categoryName");
                    list = dao.getAllCategory("select * from tblCategories where categoryName like '%" + name + "%'");
                } else {
                    list = dao.getAllCategory(sqlAll);
                }
                for (Category cate : list) {
                    out.print("<tr>\n"
                            + "                    <td>" + cate.getCategoryID() + "</td>\n"
                            + "                    <td>" + cate.getCategoryName() + "</td>\n"
                            + "                    <td>" + cate.getDescribe() + "</td>\n"
                            + "                    <td></td>\n"
                            + "                    <td><p><a href=\"ServletCategory?service=deleteCategory&cID=" + cate.getCategoryID() + "\">Delete</a></p></td>\n"
                            + "                </tr>");
                }
                out.println(" </table>    ");
                out.println("</body>");
                out.println("</html>");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
