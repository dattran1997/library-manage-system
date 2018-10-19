/*
 * Name: Dattran
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
import java.sql.SQLException;

/**
 *
 * @author dattr
 */
public class UserManage_c {
    
    public void delete(String username){
        String delete = "delete from userinfo where username = ?";
        PreparedStatement ptmt = null;
        try {    
            ptmt = conn.prepareStatement(delete); // hàm xóa 
            ptmt.setString(1,username);  // cột 0 trong bảng ứng cột 1 trong data
            ptmt.execute();
        } catch (SQLException ex) {
            System.out.println("fail");
        }
    }
}
