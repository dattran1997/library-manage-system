/*
 * Name: Lương Cao Đức
 * Date:
 * Project's name: Library Manage System
 * Teacher's name:
 * Class name: VUW-IT 15
 * Name of anyone who help you:
 * Brief Discription: system for managing lib system
 */
package librarian_gui;

import static main_gui.Login.USERNAME;
import static main_controller.connectDataP.conn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import librarian_controller.BorrowManage2_c;

/**
 *
 * @author Lương Cao Đức
 */
public class BorrowManage2 extends javax.swing.JPanel {

    /**
     * Creates new form BorrowManage2
     */
    DefaultTableModel model = new DefaultTableModel();
    Statement stmt = null;
    PreparedStatement ptmt = null;
    ResultSet rs = null;
    public BorrowManage2() {
        initComponents();
         model = (DefaultTableModel) Table.getModel();
    }
// chỉnh sao cho cái trong = cái ngoài - 10
    public void start(){
        Start.setText("");
    }
    public void View(){
        clearTable();
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from borrowbook");
            while (rs.next()) {
                /// hien thi tren table
                model.addRow(new Object[]{rs.getString(1),rs.getString(2)}); 
            }
        }catch(Exception ex){}
    }
    public void clearTable(){
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }
    
    public void delete(int index,String bookname){
        String delete = "delete from borrowbook where username = ? and bookname = ?";
        PreparedStatement ptmt = null;
        try {
            String delString = (String) Table.getValueAt(index, 0); // trả về chuỗi đầu trong data
            
            ptmt = conn.prepareStatement(delete); // hàm xóa 
            ptmt.setString(1,delString);  // cột 0 trong bảng ứng cột 1 trong data
            ptmt.setString(2,bookname);
            ptmt.execute();
        } catch (SQLException ex) {
            System.out.println("fail");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        searchButton = new javax.swing.JButton();
        searchbook = new javax.swing.JTextField();
        Start = new javax.swing.JLabel();
        accept = new javax.swing.JButton();

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "username", "book"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Table);

        searchButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        searchButton.setText("search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        Start.setText("jLabel1");

        accept.setText("returned");
        accept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Start))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(searchbook, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(accept, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 30, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchbook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(accept, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(Start)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    BorrowManage2_c bm2c = new BorrowManage2_c();
    private void acceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptActionPerformed
        try{
            int index  = Table.getSelectedRow();
            String username = (String) Table.getValueAt(index, 0);
            String bookname = (String) Table.getValueAt(index, 1);
            bm2c.accept(username , bookname);
            delete(index,bookname);
            bm2c.update(bookname);
            View();
        }catch(Exception ex){
            System.out.println("accept error");
        }
    }//GEN-LAST:event_acceptActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        Searching();
        //View();
        searchbook.setText("");
    }//GEN-LAST:event_searchButtonActionPerformed

     public void Searching(){
        clearTable(); //dọn bảng
        String text = searchbook.getText();
        if(text.equals("")){
           View();
        }else
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from borrowbook where username like '%"+text+"%'");
            while(rs.next()){
                    model.addRow(new Object[]{rs.getString(1),rs.getString(2)});
                }
        } catch (SQLException ex) {
            System.out.println("cant load");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Start;
    private javax.swing.JTable Table;
    private javax.swing.JButton accept;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchbook;
    // End of variables declaration//GEN-END:variables
}
