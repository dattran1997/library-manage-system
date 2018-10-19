/*
 * Name: Nguyễn Thế Đại + Lương Cao Đức
 * Date:
 * Project's name: Library Manage System
 * Teacher's name:
 * Class name: VUW-IT 15
 * Name of anyone who help you:
 * Brief Discription: system for managing lib system
 */
package librarian_gui;

import static main_controller.connectDataP.conn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import librarian_controller.BookManage1_c;

/**
 *
 * @author Nguyễn Thế Đại
 */
//605 555
public class BookManage1 extends javax.swing.JPanel {

    /**
     * Creates new form BookManage1
     */
    DefaultTableModel model = new DefaultTableModel();
    Statement stmt = null;
    PreparedStatement ptmt = null;
    ResultSet rs = null;
    public BookManage1() {
        initComponents();
        model = (DefaultTableModel) Table.getModel();
    }
    public void start(){
        Start.setText("");
    }
    public void View(){
        clearTable();
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from book1");
            while (rs.next()) {
                /// hien thi tren table
                model.addRow(new Object[]{rs.getString(1),rs.getString(3),rs.getString(4)}); 
            }
        }catch(Exception ex){}
    }
    public void clearTable(){
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }
    
    public void delete(int index){
        String delete = "delete from book1 where bookname = ?";
        PreparedStatement ptmt = null;
        try {
            String delString = (String) Table.getValueAt(index, 0); // trả về chuỗi đầu trong data
            //System.out.println(""+delString);
            ptmt = conn.prepareStatement(delete); // hàm xóa 
            ptmt.setString(1,delString);  // cột 0 trong bảng ứng cột 1 trong data
            ptmt.execute();
        } catch (SQLException ex) {
            System.out.println("");
        }
    }
    
    public void Searching(){
        clearTable(); //dọn bảng
        String text = searchbook.getText();
        if(text.equals("")){
           View();
        }else
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from book1 where name like '"+text+"'");
            while(rs.next()){
                    model.addRow(new Object[]{rs.getString(1)});
                }
        } catch (SQLException ex) {
            System.out.println("cant load");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchbook = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        deletebookButton = new javax.swing.JButton();
        detailButton = new javax.swing.JButton();
        addcopyButton = new javax.swing.JButton();
        searchbutton = new javax.swing.JButton();
        Start = new javax.swing.JLabel();

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "book name", "quantity", "remain"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Table);

        deletebookButton.setText("delete book");
        deletebookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebookButtonActionPerformed(evt);
            }
        });

        detailButton.setText("detail");
        detailButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailButtonActionPerformed(evt);
            }
        });

        addcopyButton.setText("add copy");
        addcopyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addcopyButtonActionPerformed(evt);
            }
        });

        searchbutton.setText("search");
        searchbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbuttonActionPerformed(evt);
            }
        });

        Start.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchbook, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(searchbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Start)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(deletebookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(addcopyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(detailButton, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Start)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchbutton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(searchbook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addcopyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(detailButton, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deletebookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void deletebookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebookButtonActionPerformed
        try{
            int index  = Table.getSelectedRow();
            delete(index);
            clearTable();
            View();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "choose one book");
        }
    }//GEN-LAST:event_deletebookButtonActionPerformed
    BookManage1_c bmc = new BookManage1_c();
    private void addcopyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addcopyButtonActionPerformed
        try{
            int index  = Table.getSelectedRow();
            String namebook = (String) Table.getValueAt(index, 0);
            bmc.addbook(namebook);
            View();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "choose book");
        }
    }//GEN-LAST:event_addcopyButtonActionPerformed

    private void searchbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbuttonActionPerformed
        Searching();
    }//GEN-LAST:event_searchbuttonActionPerformed

    private void detailButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailButtonActionPerformed
        // TODO add your handling code here:
        try{
            int index = Table.getSelectedRow();
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "choose book");
        }
    }//GEN-LAST:event_detailButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Start;
    private javax.swing.JTable Table;
    private javax.swing.JButton addcopyButton;
    private javax.swing.JButton deletebookButton;
    private javax.swing.JButton detailButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchbook;
    private javax.swing.JButton searchbutton;
    // End of variables declaration//GEN-END:variables
}