/*
 * Name: Dattran
 * Date:
 * Project's name: Library Manage System
 * Teacher's name:
 * Class name: VUW-IT 15
 * Name of anyone who help you:
 * Brief Discription: system for managing lib system
 */
package main_controller;

import static main_controller.connectDataP.conn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author dattr
 */
public class RegisterForm_c {
    
     public void RegisterUser(String username, String password, String fullname, String phonenumber, String email, String identitynumber,int remain){
        PreparedStatement ptmt = null;
        String insert = "insert into userinfo values(?,?,?,?,?,?,?)"; // theo thứ tự cột trong bảng
        try {
                ptmt = conn.prepareStatement(insert);
                ptmt.setString(1, username);
                ptmt.setString(2, password);
                ptmt.setString(3, fullname);
                ptmt.setString(4, phonenumber);
                ptmt.setString(5, email);
                ptmt.setString(6, identitynumber);
                ptmt.setInt(7, remain);
                int kt = ptmt.executeUpdate();
                if(kt != 0){
                    JOptionPane.showMessageDialog(null, "register sent");
                }else System.out.println("add fail");
                ptmt.close();
            } catch (SQLException ex) {}
    }
    
    public boolean check(String username){
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from userinfo");
            while (rs.next()) {
                    String name1 = rs.getString(1);
                    if(username.equals(name1)) {
                        JOptionPane.showMessageDialog(null, "user already valid");
                        return false;
                    }
            }
        } catch (SQLException ex) {
            System.out.println("fail");
        }
        return true;
    }
    
}
