/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;
import java.util.Vector;
import model.Role;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author Asus
 */
public class RoleDAO extends DBContext {
        
    public Vector<Role> getAllRole(String sql){
        Vector<Role> roleList = new Vector<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
             Role r = new Role(rs.getInt(1), rs.getString(2));
             roleList.add(r);
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roleList;
        
    }
    
    public void insertRole (Role r ){
    String sql = "INSERT INTO [dbo].[tblRoles]\n" +
"           ([roleName])\n" +
"     VALUES\n" +
"           (?)";
        try {
            PreparedStatement ptm = connection.prepareStatement(sql);
            ptm.setString(1, r.getRoleName());
            ptm.execute();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
    
//    public static void main(String[] args) {
//        String sql = "select * from tblRoles";
//        RoleDAO rd = new RoleDAO();
//        Vector<Role> listRole = rd.getAllRole(sql);
//        Role r = new Role("Tuanvm");
//        
////        rd.insertRole(r);
////        listRole = rd.getAllRole(sql);
////        for(Role rl : listRole){
////            System.out.println(rl);
////        }
//        System.out.println("Chuc mung nam moi !!");
//    }
    

}
