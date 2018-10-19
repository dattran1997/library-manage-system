/*
 * Name: Dattran
 * Date:
 * Project's name: Library Manage System
 * Teacher's name:
 * Class name: VUW-IT 15
 * Name of anyone who help you:
 * Brief Discription: system for managing lib system
 */
package users_controller;

import static main_controller.connectDataP.conn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static main_gui.Login.USERNAME;

/**
 *
 * @author dattr
 */
public class UserUnregister_c {
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement ptmt = null;
    DefaultTableModel model ;
    
    
    
    public void delete(String username,String bookname){
        String delete = "delete from registerbook1 where username = ? and bookname = ?";
        PreparedStatement ptmt = null;
        try {
            ptmt = conn.prepareStatement(delete); // hàm xóa 
            ptmt.setString(1,USERNAME);  // cột 0 trong bảng ứng cột 1 trong data
            ptmt.setString(2,bookname);
            ptmt.execute();
        } catch (SQLException ex) {
            System.out.println("");
        }
    }
    
    public void fixStatus(String status,String namebook){
        PreparedStatement ptmt = null;
        String Update = "update book1 set status = ? where bookname = '"+namebook+"'";
        System.out.println(""+namebook);
        try {
                ptmt = conn.prepareStatement(Update);
                ptmt.setString(1, status);
                int kt = ptmt.executeUpdate(); 
                if(kt != 0){
                    //JOptionPane.showMessageDialog(null, "status ok");
                }else System.out.println("status fail");
                ptmt.close();
            } catch (SQLException ex) {
                System.out.println("error status");
            }
    }
    
    public boolean  fixRemain(String username ){
        Statement stmt = null; 
        ResultSet rs = null;
        PreparedStatement ptmt = null;
        String update = "update userinfo set remain = ? where username = '"+username+"'";
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from userinfo where username like '"+username+"'");
            while (rs.next()){
                int number = rs.getInt(7);
                ptmt = conn.prepareStatement(update);
                
                if(number < 5){
                    number = number + 1;
                    System.out.println(""+number);
                    ptmt.setInt(1,number);
                    int kt = ptmt.executeUpdate();
                    if(kt != 0){
                        JOptionPane.showMessageDialog(null, "remain plus succesful");
                    }
                    
                    return true; 
                }
            }
        }catch(Exception ex){
            System.out.println("loi fix remain");
        }
        JOptionPane.showMessageDialog(null, "you have no book to unregister");
        return false;
    }

}
