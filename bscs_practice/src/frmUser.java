
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
 import java.awt.HeadlessException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class frmUser extends javax.swing.JFrame {

    Connection conn;
    Statement  st;
    ResultSet rs;
    
    
    int flag = 0, user_id_increment;

    public frmUser() {
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
        
        String query = "Select * from tblscholar order by ID ASC";
        rs = st.executeQuery(query);
        
        while(rs.next()){
            String id = rs.getString("ID");
            String studentID = rs.getString("StudentNumber");
            String last = rs.getString("LastName");
            String first = rs.getString("FirstName");
            String middle = rs.getString("MiddleInitial");
            String school = rs.getString("School");
            String program = rs.getString("Program");
            String scholar = rs.getString("Scholarship");
            
            model.addRow(new Object[]{ id, studentID, last, first, middle, school, program, scholar });
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
               
                String insert = "Insert into tblscholar VALUES('"+user_id_increment+"','" + txtstudentID.getText() + "','" + txtlast.getText() + "','"+ txtfirst.getText()+"','"+txtmiddle.getText()+"','" + txtschool.getText()+"','"+txtprogram.getText()+"','"+txtscholar.getText()+"')";
                st.executeUpdate(insert);
                 
               JOptionPane.showMessageDialog(null, "Record successfully added.");
             
                
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Message", JOptionPane.WARNING_MESSAGE);
        }
       
    }
    
   
    private void cancel(){
        dispose();
        frmUser user = new frmUser();
        //frmHome.jDesktopPane_Main.add(user);
        user.show();
    }
    
     private void AutoUserID() {
        try {
            //Calling the function for the database connection
                database_connection();
                
            String query = "Select ID from tblscholar";
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
         
         try{
              database_connection();
             
         String update = "Update tblscholar set StudentNumber ='"+txtstudentID.getText()+"', LastName = '"+txtlast.getText()+"', FirstName = '"+txtfirst.getText()+"', MiddleInitial = '"+txtmiddle.getText()+"', School = '"+txtschool.getText()+"', Program = '"+txtprogram.getText()+"', Scholarship = '"+txtscholar.getText()+"' WHERE ID = '"+txtUserID.getText()+"'";
         st.executeUpdate(update);
         
         JOptionPane.showMessageDialog(null, "Record successfully updated.");
                
         }catch(HeadlessException | SQLException e){
             JOptionPane.showMessageDialog(null, e);
         }
     }
      
      
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUserID = new javax.swing.JTextField();
        btnsave = new javax.swing.JButton();
        btncancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDisplayUser = new javax.swing.JTable();
        btnadd = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btndelete = new javax.swing.JButton();
        txtstudentID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtlast = new javax.swing.JTextField();
        txtfirst = new javax.swing.JTextField();
        txtschool = new javax.swing.JTextField();
        txtprogram = new javax.swing.JTextField();
        txtscholar = new javax.swing.JTextField();
        txtmiddle = new javax.swing.JTextField();
        txtsearch = new javax.swing.JTextField();
        btnsearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Yu Gothic Medium", 1, 12)); // NOI18N
        jLabel1.setText("Student ID:");

        jLabel2.setFont(new java.awt.Font("Yu Gothic Medium", 1, 12)); // NOI18N
        jLabel2.setText("Last Name:");

        txtUserID.setEditable(false);
        txtUserID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserIDActionPerformed(evt);
            }
        });

        btnsave.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnsave.setText("Save");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        btncancel.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
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
                "ID", "Student ID", "Last Name", "First Name", "Middle Initial", "School", "Program & Year ", "Scholarship"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableDisplayUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDisplayUserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableDisplayUser);

        btnadd.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnadd.setText("ADD");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        btnedit.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnedit.setText("EDIT");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Yu Gothic Medium", 1, 12)); // NOI18N
        jLabel3.setText("UserID:");

        btndelete.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btndelete.setText("DELETE");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        txtstudentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstudentIDActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Yu Gothic Medium", 1, 12)); // NOI18N
        jLabel4.setText("First Name:");

        jLabel5.setFont(new java.awt.Font("Yu Gothic Medium", 1, 12)); // NOI18N
        jLabel5.setText("School:");

        jLabel6.setFont(new java.awt.Font("Yu Gothic Medium", 1, 12)); // NOI18N
        jLabel6.setText("Program &Year level:");

        jLabel7.setFont(new java.awt.Font("Yu Gothic Medium", 1, 12)); // NOI18N
        jLabel7.setText("Scholarship:");

        jLabel8.setFont(new java.awt.Font("Yu Gothic Medium", 1, 12)); // NOI18N
        jLabel8.setText("Middle Initial:");

        txtscholar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtscholarActionPerformed(evt);
            }
        });

        txtmiddle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmiddleActionPerformed(evt);
            }
        });

        btnsearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnsearch.setText("Search");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(btnedit, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(btndelete)
                .addGap(58, 58, 58)
                .addComponent(btnsave)
                .addGap(65, 65, 65)
                .addComponent(btncancel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4))
                            .addComponent(jLabel8)
                            .addComponent(jLabel1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtlast, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtfirst, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtstudentID, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtmiddle, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5))
                                .addGap(57, 57, 57)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtscholar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtprogram, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtschool, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnsearch)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 883, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtschool, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtprogram, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtscholar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtstudentID, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtlast, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfirst, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmiddle, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncancel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnedit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserIDActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        // TODO add your handling code here:
        try{

            if(txtstudentID.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Please input student ID.");
                txtstudentID.requestFocus();

            }else if(txtlast.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Please input Last Name.");
                txtlast.requestFocus();

            }else if(txtfirst.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Please input first name");
                txtfirst.requestFocus();
                        
            }else if(txtmiddle.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Please input middle initial");
                txtmiddle.requestFocus();
                
            }else if(txtschool.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Please input school");
                txtschool.requestFocus();
                
            }else if(txtprogram.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Please input program and/or year level");
                txtprogram.requestFocus();
                
            }else if(txtscholar.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Please input type of scholarship");
                txtscholar.requestFocus();
                
            }
            
            
             if(txtstudentID.getText().isEmpty() || txtlast.getText().isEmpty() || txtfirst.getText().isEmpty() || txtmiddle.getText().isEmpty() || txtschool.getText().isEmpty() || txtprogram.getText().isEmpty() || txtscholar.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Please complete the form");
                }
            
            
             else{
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

    private void jTableDisplayUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDisplayUserMouseClicked
        // TODO add your handling code here:

        btnadd.setEnabled(false);
        btnedit.setEnabled(true);
        btnsave.setEnabled(false);
        btndelete.setEnabled(true);
        
        
        
        int row = jTableDisplayUser.getSelectedRow();
        txtUserID.setText(jTableDisplayUser.getModel().getValueAt(row, 0).toString());
        txtstudentID.setText(jTableDisplayUser.getModel().getValueAt(row, 1).toString());
        txtlast.setText(jTableDisplayUser.getModel().getValueAt(row, 2).toString());
        txtfirst.setText(jTableDisplayUser.getModel().getValueAt(row, 3).toString());
        txtmiddle.setText(jTableDisplayUser.getModel().getValueAt(row, 4).toString());       
        txtschool.setText(jTableDisplayUser.getModel().getValueAt(row, 5).toString());
        txtprogram.setText(jTableDisplayUser.getModel().getValueAt(row, 6).toString());
        txtscholar.setText(jTableDisplayUser.getModel().getValueAt(row, 7).toString());        
        
        txtstudentID.setEditable(false);
        txtlast.setEditable(false);
        txtfirst.setEditable(false);
        txtmiddle.setEditable(false);
        txtschool.setEditable(false);
        txtprogram.setEditable(false);
        txtscholar.setEditable(false);
    }//GEN-LAST:event_jTableDisplayUserMouseClicked

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        // TODO add your handling code here:
        flag = 1;
        btnsave.setEnabled(true);
        btnadd.setEnabled(false);
        btncancel.setText("CANCEL");
    }//GEN-LAST:event_btnaddActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        // TODO add your handling code here:
        flag = 2;
        txtstudentID.setEditable(true);
        txtlast.setEditable(true);
        txtfirst.setEditable(true);
        txtmiddle.setEditable(true);
        txtschool.setEditable(true);
        txtprogram.setEditable(true);
        txtscholar.setEditable(true);
        
        txtstudentID.requestFocus();
        btnsave.setEnabled(true);
        btncancel.setText("CANCEL");

    }//GEN-LAST:event_btneditActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
          try {
            btncancel.setText("Cancel");
           database_connection();
           
                if (JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record?", "Message",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                    String querys = "delete from tblscholar where ID ='" + txtUserID.getText() + "'";
                    st.executeUpdate(querys);

                    JOptionPane.showMessageDialog(null, "Record succesfully deleted.");
                    cancel();
                    
                } 
             
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Message", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void txtstudentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstudentIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstudentIDActionPerformed

    private void txtmiddleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmiddleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmiddleActionPerformed

    private void txtscholarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtscholarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtscholarActionPerformed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        // TODO add your handling code here:
        btnadd.setEnabled(false);
        btncancel.setText("CANCEL");
        try{
            database_connection();
            String sql = "Select * from tblscholar where StudentNumber = ?";
            PreparedStatement pst;
            pst = conn.prepareStatement(sql);
            pst.setString(1, txtsearch.getText());
            rs = pst.executeQuery();
            
            if (rs.next()){
                 txtUserID.setText(rs.getString("ID"));
                 txtstudentID.setText(rs.getString("StudentNumber"));
                 txtlast.setText(rs.getString("LastName"));
                 txtfirst.setText(rs.getString("FirstName"));
                 txtmiddle.setText(rs.getString("MiddleInitial"));
                 txtschool.setText(rs.getString("School"));
                 txtprogram.setText(rs.getString("Program"));
                 txtscholar.setText(rs.getString("Scholarship"));
                
            }
        }
        catch (Exception e){
            
        }
        
    }//GEN-LAST:event_btnsearchActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
                
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btncancel;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnsearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDisplayUser;
    private javax.swing.JTextField txtUserID;
    private javax.swing.JTextField txtfirst;
    private javax.swing.JTextField txtlast;
    private javax.swing.JTextField txtmiddle;
    private javax.swing.JTextField txtprogram;
    private javax.swing.JTextField txtscholar;
    private javax.swing.JTextField txtschool;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JTextField txtstudentID;
    // End of variables declaration//GEN-END:variables
}
