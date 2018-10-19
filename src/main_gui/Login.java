/*
 * Name: Dattran
 * Date:
 * Project's name: Library Manage System
 * Teacher's name:
 * Class name: VUW-IT 15
 * Name of anyone who help you:
 * Brief Discription: system for managing lib system
 */
package main_gui;

import librarian_gui.MainManage;
import static main_controller.connectDataP.conn;
import users_gui.MainUser;
import main_controller.connectDataP;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author dattr
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    Statement stmt = null;
    ResultSet rs = null;
    connectDataP cn = new connectDataP();
    public static String USERNAME;
    public int SCREEN_WIDTH;
    public int SCREEN_HEIGHT;
    public Login() {
        initComponents();
        cn.Connected();
        getSizeWindow();
        this.setBounds((SCREEN_WIDTH - this.getWidth())/2, (SCREEN_HEIGHT - this.getHeight())/2,
                this.getWidth(), this.getHeight());
    }

    public void getSizeWindow(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit tk = this.getToolkit(); 
        Dimension dm = tk.getScreenSize();
        SCREEN_WIDTH = dm.width;
        SCREEN_HEIGHT = dm.height;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        loginButton = new javax.swing.JButton();
        registerButton = new javax.swing.JButton();
        librarianloginButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("username");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("password");

        loginButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        loginButton.setText("login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        registerButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        registerButton.setText("register");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        librarianloginButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        librarianloginButton.setText("librarian login");
        librarianloginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                librarianloginButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("LIBRARY MANAGE SYSTEM");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(215, 215, 215))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(username)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(librarianloginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(librarianloginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(173, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // TODO add your handling code here:
        try{
            login1(username.getText(), password.getText());
            System.out.println(""+username.getText());
            System.out.println(""+password.getText());
        }catch(Exception ex){
            //JOptionPane.showMessageDialog(null, "user name or password incorrect");
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        // TODO add your handling code here:
        RegisterForm rf = new RegisterForm();
        rf.setVisible(true);
    }//GEN-LAST:event_registerButtonActionPerformed
   
    private void librarianloginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_librarianloginButtonActionPerformed
        // TODO add your handling code here:
        if(username.getText().equals("")) 
            JOptionPane.showMessageDialog(null, "enter username");
        else if(password.getText().equals(""))
            JOptionPane.showMessageDialog(null, "enter password");
        else {
            
            try {
                stmt = conn.createStatement();
                rs = stmt.executeQuery("select * from admininfo");
                while (rs.next()) {
                        String name1 = rs.getString(1);  
                        String name2 = rs.getString(2);
                        if(username.getText().equals(name1) && password.getText().equals(name2)) {
                            USERNAME = name1;
                            MainManage mm = new MainManage();
                            mm.setVisible(true);
                            this.dispose();
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "user name or password incorrect");
                        }
                }
            } catch (SQLException ex) {}
        }
                
    }//GEN-LAST:event_librarianloginButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String args[]) {
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    
    public void login1(String username, String password){
        int i = 0;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from userinfo");
            while (rs.next()) {
                    String name1 = rs.getString(1);  
                    String name2 = rs.getString(2);
                    System.out.println(""+name1);
                    System.out.println(""+name2);
                    if(username.equals(name1) && password.equals(name2)) {
                        USERNAME = name1;
                        MainUser mu = new MainUser();
                        mu.setVisible(true);
                        dispose();
                        i++;
                        System.out.println("login successful");
                    }
            }  if(i == 0)   JOptionPane.showMessageDialog(null, "Incorrect username or password");
        } catch (SQLException ex) {}
    
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JButton librarianloginButton;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField password;
    private javax.swing.JButton registerButton;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
