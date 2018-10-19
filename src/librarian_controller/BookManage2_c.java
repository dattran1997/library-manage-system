/*
 * Name: Lương Cao Đức
 * Date:
 * Project's name: Library Manage System
 * Teacher's name:
 * Class name: VUW-IT 15
 * Name of anyone who help you:
 * Brief Discription: system for managing lib system
 */
package librarian_controller;

import static main_controller.connectDataP.conn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Lương Cao Đức
 */
public class BookManage2_c {
    
    public void RegisterBook(String namebook,int quantity){
        PreparedStatement ptmt = null;
        String insert = "insert into book1 values(?,?,?,?)"; 
        try {
                ptmt = conn.prepareStatement(insert);
                ptmt.setString(1, namebook); 
                ptmt.setString(2,"valid"); 
                ptmt.setInt(3, quantity); 
                ptmt.setInt(4, quantity); 
                
                int kt = ptmt.executeUpdate();
                if(kt != 0){
                    JOptionPane.showMessageDialog(null, "book added");
                }else System.out.println("add fail");
                ptmt.close();
            } catch (SQLException ex) {
            System.out.println("loi query");
            } 
    }
    public boolean check(String namebook, int number){
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from book1");
            while (rs.next()) { 
                    String name1 = rs.getString(1);  
                    if(namebook.equals(name1)) {
                        System.out.println("book already exist");
                        JOptionPane.showMessageDialog(null, "book already exist");
                        return false;
                    }
            }
        } catch (SQLException ex) {
            System.out.println("fail");
        }
        return true;
    }
}
