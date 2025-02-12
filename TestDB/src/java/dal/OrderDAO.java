/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import com.sun.jdi.connect.spi.Connection;
import java.sql.Date;
import java.util.Vector;
import model.Orders;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.catalina.servlets.DefaultServlet;

/**
 *
 * @author Asus
 */
public class OrderDAO  extends DBContext{
    
    public Vector<Orders> getAllOrder(String sql){
        Vector<Orders> list = new Vector<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
            Orders od = new Orders(rs.getDate(2), rs.getDouble(3), rs.getString(4));
            list.add(od);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public void insertOrder(Orders d){
    String sql ="INSERT INTO [dbo].[tblOrders]\n" +
"           ([orderDate]\n" +
"           ,[total]\n" +
"           ,[userID])\n" +
"     VALUES\n" +
"           (?,?,?)";
        try {
            PreparedStatement ptm = connection.prepareStatement(sql);
            ptm.setDate(1, d.getOrderDate());
            ptm.setDouble(2, d.getTotal());
            ptm.setString(3, d.getUserID());
            ptm.execute();
        } catch (Exception e) {
            e.getStackTrace();
        }
    
    }
    
//    public static void main(String[] args) {
//        String sql ="select * from tblOrders";
//        OrderDAO od = new OrderDAO();
//        Vector<Orders> listOd = od.getAllOrder(sql);
//        Orders o = new Orders(new Date(2025 - 1900, 1, 25), 300.120, "U005");
////        od.insertOrder(o);
//        listOd = od.getAllOrder(sql);
//        for(Orders or : listOd){
//            System.out.println(or);
//        }
//        
//    }
    
}
