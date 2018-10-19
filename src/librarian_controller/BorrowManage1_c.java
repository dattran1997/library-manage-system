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
public class BorrowManage1_c {
    
    public boolean check(String username,String namebook){
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from borrowbook");
            while (rs.next()) {
                    String name1 = rs.getString(1);
                    String name2 = rs.getString(2);
                    if(username.equals(name1) && namebook.equals(name2)) {
                        JOptionPane.showMessageDialog(null, "user already borrowed this book ");
                        return false;
                    }
            }
        } catch (SQLException ex) {
            System.out.println("fail");
        }
        return true;
    }
    public boolean update(String name){
        Statement stmt = null;
        PreparedStatement ptmt = null;
        ResultSet rs = null;
        String Update = "update book1 set remain = ? where bookname = ?";
        
        try {    
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from book1 where bookname = '"+name+"'");
            while(rs.next()){
                if(rs.getString(1).equals(name)){
                    if(rs.getInt(3) == 0){
                        JOptionPane.showMessageDialog(null, "out of book");
                        return false;
                    }
                    
                    else{
                        int conlai = rs.getInt(3) - 1;
                        ptmt = conn.prepareStatement(Update);
                        ptmt.setInt(1, conlai);
                        ptmt.setString(2, name);
                        int kt = ptmt.executeUpdate();
                        if(kt != 0){
                            JOptionPane.showMessageDialog(null, "add successful");
                        }
                        ptmt.close();
                    }
                }
            }
        } catch (SQLException ex) {
        }
        return true;
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
    
    public void accept(String username,String namebook){
        
        PreparedStatement ptmt = null;
        String insert = "insert into borrowbook values(?,?)";
        try {
                ptmt = conn.prepareStatement(insert);
                ptmt.setString(1, username);
                ptmt.setString(2, namebook);
                int kt = ptmt.executeUpdate();
                if(kt != 0){
                }
                ptmt.close();
            } catch (SQLException ex) {}
    }
    
    public void fixRemain(String username ){
        Statement stmt = null; 
        ResultSet rs = null;
        PreparedStatement ptmt = null;
        String update = "update userinfo set remain = ? where username = '"+username+"'";
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from userinfo where username like '"+username+"'");
            while (rs.next()){
                int number = rs.getInt(7) + 1;
                ptmt = conn.prepareStatement(update);
                ptmt.setInt(1,number);
                int kt = ptmt.executeUpdate();
                if(kt != 0){
                    JOptionPane.showMessageDialog(null, "remain plus succesful");
                }
            }
        }catch(Exception ex){
            System.out.println("loi fix remain");
        }
    }
    
    
}
