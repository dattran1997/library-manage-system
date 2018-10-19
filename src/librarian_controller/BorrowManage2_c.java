/*
 * Name: Lương Cao Đức + Nguyễn Thế Đại
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
 * @author Lương Cao Đức + Nguyễn Thế Đại
 */
public class BorrowManage2_c {
    
    public void update(String name){
        String Update = "update book1 set remain = ? where bookname = ?";
        Statement stmt = null;
        PreparedStatement ptmt = null;
        ResultSet rs = null;
        try {    
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from book1 where bookname = '"+name+"'");
            while(rs.next()){
                    int remain = rs.getInt(4) + 1;
                    ptmt = conn.prepareStatement(Update);
                    ptmt.setInt(1, remain);
                    int kt = ptmt.executeUpdate();
                    if(kt != 0){
                        JOptionPane.showMessageDialog(null, "add successful");
                    }
                    ptmt.close();
            }
        } catch (SQLException ex) {
            System.out.println("fail");
        }
    }
    
    public void accept(String username,String bookname){
        
        PreparedStatement ptmt = null;
        String insert = "insert into returnbook values(?,?)";
        try {
                ptmt = conn.prepareStatement(insert);
                ptmt.setString(1, username);
                ptmt.setString(2, bookname);
                int kt = ptmt.executeUpdate();
                if(kt != 0){
                }
                ptmt.close();
            } catch (SQLException ex) {}
    }
}
