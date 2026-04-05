
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.HeadlessException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class frmUsers extends javax.swing.JInternalFrame {

    Connection conn;
    Statement  st;
    ResultSet rs;
    
    int flag = 0, user_id_increment;
    
    public frmUsers() {
        initComponents();
        displayUser();
    }
    
    

    //Functions to displaying the records from mysql
    private void displayUser(){
        
      try{
        DefaultTableModel model = (DefaultTableModel) jTableDisplayUser.getModel();
        conn = (Connection) DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/bscs_database", "root", "");
        st = (Statement) conn.createStatement();
        
        String query = "Select * from tbluser order by UserID ASC";
        rs = st.executeQuery(query);
        
        while(rs.next()){
            String uid = rs.getString("UserID");
            String uname = rs.getString("Username");
            String upass = rs.getString("Password");
            
            model.addRow(new Object[]{ uid, uname, upass });
        }
        rs.close();
        st.close();
        conn.close();
        }
      catch(SQLException e) {
          
      }   
       
}
    private void database_connection(){
    try{
         conn = (Connection) DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/bscs_database", "root", "");
        st = (Statement) conn.createStatement();
     
     }catch(SQLException e){
          JOptionPane.showMessageDialog(null, e, "Message", JOptionPane.WARNING_MESSAGE);
     }
    }
    
    
    
    //function for add record
    private void addrecord(){
      try {
            //Calling the function for the database connection
                database_connection();
               
                String insert = "Insert into tbluser VALUES('"+user_id_increment+"','" + txtusername.getText() + "','" + txtpassword.getText() + "')";
                st.executeUpdate(insert);
                 
               JOptionPane.showMessageDialog(null, "Record successfully added.");
                
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Message", JOptionPane.WARNING_MESSAGE);
        }
       
    }
    
//function for edit record    
    private void editrecord(){
        
        
    }
    
    private void cancel(){
        dispose();
        frmUsers user = new frmUsers();
        frmHome.jDesktopPane_Main.add(user);
        user.show();
    }
    
     private void AutoUserID() {
        try {
            //Calling the function for the database connection
                database_connection();
                
            String query = "Select UserID from tbluser";
            rs = st.executeQuery(query);
            rs.last();
            
            int getrow = rs.getRow();
              user_id_increment=getrow+1;
              
              txtUserID.setText(user_id_increment+"");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }
        
        
    }
     
     
     private void edit_user(){
         
         //database_connection();
         try{
              database_connection();
             
         String update = "Update tbluser set Username ='"+txtusername.getText()+"',Password = '"+txtpassword.getText()+"' WHERE UserID = '"+txtUserID.getText()+"'";
         st.executeUpdate(update);
         JOptionPane.showMessageDialog(null, "Record successfully updated.");
         
                
                 
         }catch(HeadlessException | SQLException e){
             JOptionPane.showMessageDialog(null, e);
         }
     }
     
     private void delete(){
         DefaultTableModel model = (DefaultTableModel) jTableDisplayUser.getModel();
          if(jTableDisplayUser.getSelectedRowCount()==1){
              model.removeRow(jTableDisplayUser.getSelectedRow());
              
              
              
              
          }
         
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnedit = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUserID = new javax.swing.JTextField();
        txtpassword = new javax.swing.JPasswordField();
        btnsave = new javax.swing.JButton();
        btncancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDisplayUser = new javax.swing.JTable();
        btnadd = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtusername = new javax.swing.JTextField();

        setIconifiable(true);
        setMaximizable(true);
        setTitle("User Maintenance");

        btnedit.setText("EDIT");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });

        btndelete.setText("DELETE");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel1.setText("Username:");

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel2.setText("Password:");

        txtUserID.setEditable(false);
        txtUserID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserIDActionPerformed(evt);
            }
        });

        btnsave.setText("Save");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        btncancel.setText("CLOSE");
        btncancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelActionPerformed(evt);
            }
        });

        jTableDisplayUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UserID", "Username", "Password"
            }
        ));
        jTableDisplayUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDisplayUserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableDisplayUser);

        btnadd.setText("ADD");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel3.setText("UserID:");

        txtusername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusernameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(btnadd)
                        .addGap(18, 18, 18)
                        .addComponent(btnedit)
                        .addGap(26, 26, 26)
                        .addComponent(btndelete)
                        .addGap(26, 26, 26)
                        .addComponent(btnsave)
                        .addGap(18, 18, 18)
                        .addComponent(btncancel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jLabel3)
                                .addGap(49, 49, 49))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnadd)
                    .addComponent(btnedit)
                    .addComponent(btndelete)
                    .addComponent(btnsave)
                    .addComponent(btncancel))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        // TODO add your handling code here:
        flag = 2;
        txtusername.setEditable(true);
        txtpassword.setEditable(true);
        txtusername.requestFocus();
        btnsave.setEnabled(true);
        btncancel.setText("CANCEL");
        
    }//GEN-LAST:event_btneditActionPerformed

    private void txtUserIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserIDActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        // TODO add your handling code here:
        try{

            if(txtusername.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Please input username.");
                txtusername.requestFocus();

            }else if(txtpassword.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Please input password.");
                txtpassword.requestFocus();

            }else{
                if(flag == 1){
                    addrecord();
                    cancel();
                }
                else if(flag == 2){
                    edit_user();
                    cancel();
                    btncancel.setText("CLOSE");
                    
                  
                    }

            }

        }catch(HeadlessException e){
            JOptionPane.showMessageDialog(this, e);

        }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void btncancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelActionPerformed
        // TODO add your handling code here:
        
       String get=btncancel.getText();
       
       if(get.equals("CANCEL")){
           cancel();
       }else{
           dispose();
       
       }
        
    }//GEN-LAST:event_btncancelActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        // TODO add your handling code here:
        flag = 1;
        btnsave.setEnabled(true);
        btnadd.setEnabled(false);
        btncancel.setText("CANCEL");
    }//GEN-LAST:event_btnaddActionPerformed

    private void jTableDisplayUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDisplayUserMouseClicked
        // TODO add your handling code here:
        
        btnadd.setEnabled(false);
        btnedit.setEnabled(true);
        btnsave.setEnabled(false);
        btndelete.setEnabled(true);
        
        
        
        int row = jTableDisplayUser.getSelectedRow();
        txtUserID.setText(jTableDisplayUser.getModel().getValueAt(row, 0).toString());
        txtusername.setText(jTableDisplayUser.getModel().getValueAt(row, 1).toString());
        txtpassword.setText(jTableDisplayUser.getModel().getValueAt(row, 2).toString());
        
        txtusername.setEditable(false);
        txtpassword.setEditable(false);
    }//GEN-LAST:event_jTableDisplayUserMouseClicked

    private void txtusernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusernameActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
        delete();
        
       
        
    }//GEN-LAST:event_btndeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btncancel;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnsave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDisplayUser;
    private javax.swing.JTextField txtUserID;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
