/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.Vector;
import model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Asus
 */
public class UserDAO extends DBContext {

    private static final String LOGIN = "select * from tblUsers where userID = ? and password =?";

    public boolean checkLogin(String userID, String password) {
        boolean result = false;
        try {
            PreparedStatement ptm = connection.prepareStatement(LOGIN);
            ptm.setString(1, userID);
            ptm.setString(2, password);
            ResultSet rs = ptm.executeQuery();
            if (rs.next()) {
                result = true;
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return result;
    }

    public Vector<User> getAllUser(String sql) {
        Vector<User> listUser = new Vector<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User u = new User(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
                listUser.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listUser;
    }

    public void insertUser(User u) {
        String checks = "select count(*)\n"
                + "from tblUsers u where u.userID =?";
        String sql = "INSERT INTO [dbo].[tblUsers]\n"
                + "           ([userID]\n"
                + "           ,[fullName]\n"
                + "           ,[password]\n"
                + "           ,[roleID]\n"
                + "           ,[address]\n"
                + "           ,[phone]\n"
                + "           ,[email]\n"
                + "           ,[activate])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?)";
//    private String userID, fullName, password;
//    private int roleID;
//    private String address, phone, email;
//    private int activate
        try {
            PreparedStatement ptm2 = connection.prepareCall(checks);
            ptm2.setString(1, u.getUserID());
            ResultSet rs = ptm2.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                System.out.println("User ID is exist!");
                return;
            }
            PreparedStatement ptm = connection.prepareStatement(sql);
            ptm.setString(1, u.getUserID());
            ptm.setString(2, u.getFullName());
            ptm.setString(3, u.getPassword());
            ptm.setInt(4, u.getRoleID());
            ptm.setString(5, u.getAddress());
            ptm.setString(6, u.getPhone());
            ptm.setString(7, u.getEmail());
            ptm.setInt(8, u.getActivate());
            ptm.execute();
            System.out.println("Insert successfully !");

        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public User searchUser(String userID) {
        String sql = "select * from tblUsers u where u.userID = ?";
        try {
            PreparedStatement ptm = connection.prepareStatement(sql);

            ptm.setString(1, userID);
            ResultSet rs = ptm.executeQuery();
            while (rs.next()) {
                User us = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
                return us;
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }
    
    public void changeActive(){
    
    }

//    public static void main(String[] args) {
//        String sql = "select * from tblUsers";
//        UserDAO ud = new UserDAO();
//        Vector<User> listUser = ud.getAllUser(sql);
//        User u = new User("U008", "ngumoihocfpt", "j97", 3,
//                "Ha Noi", "0908123456", "hehe@gmail.con", 0);
//
//        ud.insertUser(u);
////        listUser = ud.getAllUser(sql);
////        for (User us : listUser) {
////            System.out.println(us);
////        }
////        System.out.println("==========================");
////        User u1 = ud.searchUser("U001");
////        if (u1 != null) {
////            System.out.println(u1);
////        } else {
////            System.out.println("not found");
////        }
//
//    }

}
