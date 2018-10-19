package main_controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author dattr
 */
public class connectDataP {
        // add thu vien cua sqlite vao
    public static Connection conn = null;
    String url = "jdbc:sqlite::resource:"+ getClass().getResource("library.sqlite").toString(); 
//    String url = "jdbc:sqlite:library.sqlite"; 
    public Connection connecting(){
        try {
            
            Class.forName("org.sqlite.JDBC");  
            
            conn = DriverManager.getConnection(url);
            System.out.println("done");
        } catch (ClassNotFoundException ex) {
            System.out.println("library");
        } catch (SQLException ex) {
            System.out.println("url");
        }
        return conn;
    }
    public void Connected(){
        conn = connecting();
    }
    public void Close() throws SQLException{
        if(conn != null) conn.close();
    }

}