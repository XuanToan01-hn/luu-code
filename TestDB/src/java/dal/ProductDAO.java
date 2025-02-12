/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;
import model.Product;
import org.apache.tomcat.dbcp.dbcp2.PoolingConnection;

/**
 *
 * @author Asus
 */
public class ProductDAO extends DBContext {

    public Vector<Product> getAllProduct(String sql) {
        Vector<Product> listCategory = new Vector<>();
        try {
            PreparedStatement ptm = connection.prepareStatement(sql);
            ResultSet rs = ptm.executeQuery();
            while (rs.next()) {
                Product c = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4),
                        rs.getInt(5), rs.getString(6), rs.getDate(7), rs.getDate(8), rs.getInt(9));
                listCategory.add(c);
            }
        } catch (SQLException ex) {
            ex.getStackTrace();
        }
        return listCategory;
    }

    public void insertProduct1(Product p) {
        String sql = " INSERT INTO [dbo].[tblProducts]\n"
                + "           ([productName]\n"
                + "           ,[image]\n"
                + "           ,[price]\n"
                + "           ,[quantity]\n"
                + "           ,[categoryID]\n"
                + "           ,[importDate]\n"
                + "           ,[usingDate])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ptm = connection.prepareStatement(sql);
            ptm.setString(1, p.getProductName());
            ptm.setString(2, p.getImage());
            ptm.setDouble(3, p.getPrice());
            ptm.setInt(4, p.getQuantity());
            ptm.setString(5, p.getCategoryID());
            ptm.setDate(6, p.getImportDate());
            ptm.setDate(7, p.getUsingDate());
            ptm.executeUpdate();

        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void insertProduct2(Product p) {
        String sql = "INSERT INTO [dbo].[tblProducts]\n"
                + "           ([productName]\n"
                + "           ,[image]\n"
                + "           ,[price]\n"
                + "           ,[quantity]\n"
                + "           ,[categoryID]\n"
                + "           ,[importDate]\n"
                + "           ,[usingDate]\n"
                + "           ,[status])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?)";
        try {

            PreparedStatement ptm = connection.prepareStatement(sql);
            ptm.setString(1, p.getProductName());
            ptm.setString(2, p.getImage());
            ptm.setDouble(3, p.getPrice());
            ptm.setInt(4, p.getQuantity());
            ptm.setString(5, p.getCategoryID());
            ptm.setDate(6, p.getImportDate());
            ptm.setDate(7, p.getUsingDate());
            ptm.setInt(8, p.getStatus());
            ptm.executeUpdate();

        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public Product searchProducts(int productID) {
        String sql = "select * from tblProducts where productID = ? ";
        try {
            PreparedStatement ptm = connection.prepareStatement(sql);
            ptm.setInt(1, productID);
            ResultSet rs = ptm.executeQuery();
            if (rs.next()) {
                Product p = new Product(productID, rs.getString(2), rs.getString(3),
                        rs.getDouble(4), rs.getInt(5), 
                        rs.getString(6), rs.getDate(7), rs.getDate(8),rs.getInt(9));
                return p;
            }
        } catch (SQLException ex) {
            ex.getStackTrace();
        }

        return null;
    }

    public void updateProduct(Product p) {
        String sql = "UPDATE [dbo].[tblProducts]\n"
                + "   SET [productName] = ?\n"
                + "      ,[image] = ?\n"
                + "      ,[price] = ?\n"
                + "      ,[quantity] = ?\n"
                + "      ,[categoryID] = ?\n"
                + "      ,[importDate] = ?\n"
                + "      ,[usingDate] = ?\n"
                + " WHERE productID =?";

        try {
            PreparedStatement ptm = connection.prepareStatement(sql);
            ptm.setString(1, p.getProductName());
            ptm.setString(2, p.getImage());
            ptm.setDouble(3, p.getPrice());
            ptm.setInt(4, p.getQuantity());
            ptm.setString(5, p.getProductName());
            ptm.setDate(6, p.getImportDate());
            ptm.setDate(7, p.getUsingDate());
            ptm.setInt(8, p.getStatus());
            ptm.setInt(9, p.getProductID());
            ptm.execute();
        } catch (SQLException ex) {
            ex.getStackTrace();
        }
    }

    public int deleteProduct1(int id) {
        String sql = "DELETE FROM [dbo].[tblProducts] WHERE productID = ?";
        try {
            PreparedStatement ptm = connection.prepareStatement(sql);
            ptm.setInt(1, id);
            int n =ptm.executeUpdate();
            return n;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void changeStatus(int id, int status) {
        String sql = "UPDATE tblProducts SET status = ? WHERE productID = ?";
        try {
            PreparedStatement ptm = connection.prepareStatement(sql);
            ptm.setInt(1, status);
            ptm.setInt(2, id);
            ptm.executeUpdate();
            System.out.println("Product status updated successfully.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteProduct2(int id) {
        Product product = searchProducts(id);
        if (product != null) {
            if (product.getStatus() == 1) {
                changeStatus(id, 0);
                System.out.println("Product status change successfully ! ");
            } else {
                System.out.println("Product is already, cannot change ! ");
            }
        } else {
            System.out.println("Product not found.");
        }
    }

//    public static void main(String[] args) {
//        String s = "select * from tblProducts";
//
//        ProductDAO uDAO = new ProductDAO();
//        Vector<Product> listUser = uDAO.getAllProduct(s);
//
//        Product p1 = new Product("Thuốc đau bụng", "ss1.img", 2000, 40,
//                "C005", new Date(2025 - 1900, 1, 15), new Date(2025 - 1900, 1, 16), 0);
//        Product p2 = new Product("Ao nhu qq", "ss.img", 1020, 31,
//                "C005", new Date(2025 - 1900, 1, 25), new Date(2025 - 1900, 1, 16));
//
////        Product j = uDAO.searchProducts(p1.getProductID());
////        if (j != null) {
////            System.out.println("found");
////        }
//        uDAO.insertProduct2(p1);
////        uDAO.deleteProduct2(9);
//////        listUser = uDAO.getAllProduct(s);
////        uDAO.deleteProduct2(6);
////        for (Product user : listUser) {
////            System.out.println(user);
////        }
//
////        Product p = uDAO.searchProducts(2);
////        if (p != null) {
////            System.out.println(p.getStatus());
////        } else {
////            System.out.println("Not found");
////        }
//
//    }

}
