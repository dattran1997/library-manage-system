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
public class UserRegister_c {
    Statement stmt = null ;
    ResultSet rs = null ;
    PreparedStatement ptmt = null;
    DefaultTableModel model = null;
    
    
    int remain1;
    public String getRemain(){
        String query = "select * from userinfo where username like '"+USERNAME+"'";
        try{
            Statement stmt = null;
            ResultSet rs = null;
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()){
                remain1 = rs.getInt(7);
            }
        }catch(Exception ex) {
            System.out.println("get remain error");
        }
       return Integer.toString(remain1);
    }
    
    
     public boolean check(String USERNAME,String namebook){
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from registerbook1");
            while (rs.next()) {
                    String name1 = rs.getString(1);
                    String name2 = rs.getString(2);
                    if(USERNAME.equals(name1) && namebook.equals(name2)) {
                        JOptionPane.showMessageDialog(null, "book already registed");
                        return false;
                    }
            }
        } catch (SQLException ex) {
            System.out.println("fail");
        }
        return true;
    }
    
    public void sendRegister(String username,String namebook){
        PreparedStatement ptmt = null;
        String insert = "insert into registerbook1 values(?,?)";
        try {
                ptmt = conn.prepareStatement(insert);
                ptmt.setString(1, username);
                ptmt.setString(2, namebook);
                int kt = ptmt.executeUpdate();
                if(kt != 0){
                    JOptionPane.showMessageDialog(null, "sent");
                }
                ptmt.close();
            } catch (SQLException ex) {
            System.out.println("loi sql");
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
                
                if(number > 0){
                    number = number - 1;// giảm remain đi 1
                    System.out.println(""+number);
                    ptmt.setInt(1,number); // gan số vừa trừ vào database
                    int kt = ptmt.executeUpdate();// chạy query để kiểm tra dữ liệu nhập vào database
                    if(kt != 0){
                        JOptionPane.showMessageDialog(null, "remain succesful");
                    }
                    
                    return true; // hàm boolean chỉ trả về giá trị return đầu tiên, những giá trị sau true sẽ ko đc chạy
                }
            }
        }catch(Exception ex){
            System.out.println("loi fix remain");
        }
        JOptionPane.showMessageDialog(null, "you reach max 5 register book");
        return false;
    }
    
   
}
