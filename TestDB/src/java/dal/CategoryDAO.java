/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.Vector;
import model.Category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Asus
 */
public class CategoryDAO extends DBContext {

    public Vector<Category> getAllCategory(String sql) {

        Vector<Category> listCategory = new Vector<>();
        try {
            PreparedStatement ptm = connection.prepareStatement(sql);
            ResultSet rs = ptm.executeQuery();
            while (rs.next()) {
                Category c = new Category(rs.getString(1), rs.getString(2), rs.getString(3));
                listCategory.add(c);
            }
        } catch (SQLException ex) {
            ex.getStackTrace();
        }
        return listCategory;
    }

    public void insertCat(Category c) {
        String sql = "INSERT INTO [dbo].[tblCategories]\n"
                + "           ([categoryID]\n"
                + "           ,[categoryName]\n"
                + "           ,[describe])\n"
                + "     VALUES\n"
                + "           (?,?,?)";
        try {
            PreparedStatement ptm = connection.prepareStatement(sql);
            ptm.setString(1, c.getCategoryID());
            ptm.setString(2, c.getCategoryName());
            ptm.setString(3, c.getDescribe());
            ptm.execute();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
    
        public int deleteCategory(String id) {
        String sql1 = "DELETE FROM [dbo].[tblCategories]\n" +
"      WHERE categoryID=?";
        String sql2="select * from tblProducts p where p.categoryID = ?";
        int n=0;
        try {
            PreparedStatement ptm1 = connection.prepareStatement(sql1);
            PreparedStatement ptm2 = connection.prepareStatement(sql2);
            ptm2.setString(1, id);
            ResultSet rs = ptm2.executeQuery();
            if(!rs.next()){
            ptm1.setString(1, id);
            n=ptm1.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }


}
