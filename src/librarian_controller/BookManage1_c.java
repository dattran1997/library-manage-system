/*
 * Name: Nguyễn Thế Đại
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
 * @author Nguyễn Thế Đại
 */
public class BookManage1_c {
    
    public void addbook(String name){
        String Update = "update book1 set quantity = ?,remain = ? where bookname = ?";
        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement ptmt = null;
        try {    
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from book1 where bookname = '"+name+"'");
            while(rs.next()){
                if(rs.getString(1).equals(name)){
                    int soluong = rs.getInt(3)+1;
                    int conlai = rs.getInt(4)+1;
                    //System.out.println(""+soluong+conlai);
                    ptmt = conn.prepareStatement(Update);
                    ptmt.setInt(1, soluong); //set theo thứ tự query
                    ptmt.setInt(2, conlai);
                    ptmt.setString(3, name);
                    int kt = ptmt.executeUpdate();
                    if(kt != 0){
                        JOptionPane.showMessageDialog(null, "add successful");
                    }
                    ptmt.close();
                }
            }
        } catch (SQLException ex) {
            System.out.println("fail");
        }
    }
}