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
import static main_gui.Login.USERNAME;
import users_gui.UserInfo;

/**
 *
 * @author dattr
 */
public class UserInfo_c {
    Statement stmt = null;
    PreparedStatement ptmt = null;
    ResultSet rs = null;
    UserInfo ui = new UserInfo();
   
    
   public void update(String fullname, String phonenumber,String email, String identitynumber){
        
        String Update = "update userinfo set fullname = ?, phonenumber = ?, email = ?, ID =? where username = '"+USERNAME+"'";
        System.out.println(""+USERNAME);
      
        try {
                ptmt = conn.prepareStatement(Update);
                ptmt.setString(1, fullname);
                ptmt.setString(2, phonenumber);
                ptmt.setString(3, email);
                ptmt.setString(4, identitynumber);
                int kt = ptmt.executeUpdate(); 
                if(kt != 0){
                    JOptionPane.showMessageDialog(null, "update successful");
                }else System.out.println("update fail");
                ptmt.close();
            } catch (SQLException ex) {
                System.out.println("error sql");
            }
    }
}
