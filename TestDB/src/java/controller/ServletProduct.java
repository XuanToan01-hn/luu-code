/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Vector;
import model.Product;
import java.sql.Date;

/**
 *
 * @author Asus
 */
@WebServlet(name = "ServletProduct", urlPatterns = {"/SPro"})
public class ServletProduct extends HttpServlet {

    private static final String sqlAll = "select * from tblProducts";
//    private static final String search = "select * from tblProducts where productName like '%a%'";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ProductDAO dao = new ProductDAO();
        String service = request.getParameter("service");
        if (service == null) {
            service = "listProduct";
        }
        if(service.equals("deleteProduct")){
        int pID=Integer.parseInt(request.getParameter("pID"));
        int n = dao.deleteProduct1(pID);
        response.sendRedirect("SPro");
        }
        if (service.equals("addProduct")) {
            String productName, image;
            double price;
            int quantity;
            String categoryID;
            Date importDate, usingDate;
            int status;
            productName = request.getParameter("productName");
            image = request.getParameter("image");
            price = Double.parseDouble(request.getParameter("price"));
            quantity = Integer.parseInt(request.getParameter("quantity"));
            categoryID = request.getParameter("categoryID ");
            importDate = Date.valueOf(request.getParameter("importDate"));
            usingDate = Date.valueOf(request.getParameter("usingDate"));
            status = Integer.parseInt(request.getParameter("status"));

            Product p = new Product(productName, image, price, quantity, categoryID, importDate, usingDate, status);
            dao.insertProduct2(p);
            response.sendRedirect("SPro");
        }

        if (service.equals("listProduct")) {
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet ServletProduct</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<form action=\"SPro\" method=\"get\">\n"
                        + "            <p>Search by name : </p>\n"
                        + "            <input type=\"text\" name=\"productName\" required=\"\" />\n"
                        + "            <input type=\"submit\" name = \"submit\" value=\"Search\">\n"
                        + "            <input type=\"reset\" value=\"Reset\">\n"
                        + "            <input type=\"hidden\" name=\"service\" value=\"listProduct\">\n"
                        + "        </form>");
                out.println("<table border='1'>");
                out.println("<tr>");
                out.println(" <th>productID</th>");
                out.println("<th>productName</th>");
                out.println(" <th>image</th>");
                out.println("<th>price</th>");
                out.println(" <th>quantity</th>");
                out.println("<th>categoryID</th>");
                out.println("<th>importDate</th>");
                out.println("<th>usingDate</th>");
                out.println(" <th>status</th>");
                out.println("<th>Update</th>");
                out.println("<th>Delete</th>");
                out.println("</tr>");
                
                Vector<Product> list;
                String submit = request.getParameter("submit");
                if(submit!=null){
                    String name = request.getParameter("productName");
                list = dao.getAllProduct("select * from tblProducts where productName like '%"+name+"%'");
                }
                
                else list = dao.getAllProduct(sqlAll);
                for (Product product : list) {
                    out.print("<tr>\n"
                            + "                    <td>" + product.getProductID() + "</td>\n"
                            + "                    <td>" + product.getProductName() + "</td>\n"
                            + "                    <td>" + product.getImage() + "</td>\n"
                            + "                    <td>" + product.getPrice() + "</td>\n"
                            + "                    <td>" + product.getQuantity() + "</td>\n"
                            + "                    <td>" + product.getCategoryID() + "</td>\n"
                            + "                    <td>" + product.getImportDate() + "</td>\n"
                            + "                    <td>" + product.getUsingDate() + "</td>\n"
                            + "                    <td>" + product.getStatus() + "</td>\n"
                            + "                    <td></td>\n"
                            + "                    <td><p><a href=\"SPro?service=deleteProduct&pID=PRODUCT_ID\">Delete</a></p></td>\n"
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
