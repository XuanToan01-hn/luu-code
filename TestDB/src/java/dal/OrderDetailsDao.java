/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.Vector;
import model.OrderDetail;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Asus
 */
public class OrderDetailsDao extends DBContext {

    public Vector<OrderDetail> getAllOD(String sql) {
        Vector<OrderDetail> odList = new Vector<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OrderDetail od = new OrderDetail(rs.getInt(1), rs.getDouble(2), rs.getInt(3),
                        rs.getInt(4), rs.getInt(5));
                odList.add(od);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return odList;
    }

    public void insertOD(OrderDetail o) {
        String sql = "INSERT INTO [dbo].[tblOrderDetails]\n"
                + "           ([price]\n"
                + "           ,[quantity]\n"
                + "           ,[orderID]\n"
                + "           ,[productID])\n"
                + "     VALUES\n"
                + "           (?,?,?,?)";
        String check = "select COUNT(*)\n"
                + "from tblOrderDetails o where o.detailID = ?";

        try {
            PreparedStatement ptm2 = connection.prepareStatement(check);
            ptm2.setInt(1, o.getDetailID());
            ResultSet rs =ptm2.executeQuery();
            if(rs.next() && rs.getInt(1)>0){
                System.out.println("Detail ID are exist!");
                return;
            }
            
            PreparedStatement ptm = connection.prepareStatement(sql);
            ptm.setDouble(1, o.getPrice());
            ptm.setInt(2, o.getQuantity());
            ptm.setInt(3, o.getOrderID());
            ptm.setInt(4, o.getProductID());
            ptm.execute();
        } catch (Exception e) {
        }
    }

//    public static void main(String[] args) {
//        String sql = "select * from tblOrderDetailsl";
//        OrderDetailsDao odd = new OrderDetailsDao();
//        Vector<OrderDetail> listOD = odd.getAllOD(sql);
//        OrderDetail o = new OrderDetail(123.456, 19, 3, 4);
//
//        odd.insertOD(o);
//        listOD = odd.getAllOD(sql);
//        for (OrderDetail od : listOD) {
//            System.out.println(od);
//        }
//
//    }

}
