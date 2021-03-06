/*
 * Name: Lương Cao Đức
 * Project's name: Library Manage System
 * Teacher's name:
 * Class name: VUW-IT 15
 * Name of anyone who help you:
 * Brief Discription: system for managing lib system
 */
package librarian_gui;

import static main_controller.connectDataP.conn;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lương Cao Đức
 */
public class BorrowManage3 extends javax.swing.JPanel {

    /**
     * Creates new form BorrowManage3
     */
    Statement stmt = null;
    ResultSet rs = null;
    DefaultTableModel model = new DefaultTableModel();
    public BorrowManage3() {
        initComponents();
        model = (DefaultTableModel) Table.getModel();
    }
    
    public void start(){
        Start.setText("return book");
    }
    
    public void View(){
        clearTable();
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from returnbook");
            while (rs.next()) {
                /// hien thi tren table
                model.addRow(new Object[]{rs.getString(1),rs.getString(2)}); 
            }
        }catch(Exception ex){
            System.out.println("view error");
        }
    }
    public void clearTable(){
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
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
            rs = stmt.executeQuery("select * from returnbook where username like '%"+text+"%'");
            while(rs.next()){
                    model.addRow(new Object[]{rs.getString(1),rs.getString(2)});
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

        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        searchbook = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        Start = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(430, 351));

        Table.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "username", "book"
            }
        ));
        jScrollPane1.setViewportView(Table);

        searchButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        searchButton.setText("search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Start)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchbook, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(Start)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchbook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        Searching();
        searchbook.setText("");
        //View();
    }//GEN-LAST:event_searchButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Start;
    private javax.swing.JTable Table;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchbook;
    // End of variables declaration//GEN-END:variables
}
