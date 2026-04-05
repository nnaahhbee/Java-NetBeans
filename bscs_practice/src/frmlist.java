
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;


public class frmlist extends javax.swing.JInternalFrame {

     Connection conn;
    Statement  st;
    ResultSet rs;
    
    int flag = 0, user_id_increment;
    
    public frmlist() {
        initComponents();
        displayUser();
        center();
    }
    
    private void center(){
        Dimension desktopSize = frmHome.jDesktopPane_Main.getSize();
        Dimension intersize = this.getSize();
        this.setLocation((desktopSize.width - intersize.width)/2,
        (desktopSize.height- intersize.height)/2);
 }
    
    

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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDisplayUser = new javax.swing.JTable();
        btnclose = new javax.swing.JButton();

        setTitle("Biliran Province State University Official List of Scholars");

        jTableDisplayUser.setAutoCreateRowSorter(true);
        jTableDisplayUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Student ID", "Last Name", "First Name", "Middle Initial", "School", "Program&Year", "Scolarship"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableDisplayUser);

        btnclose.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnclose.setText("Close");
        btnclose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1013, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnclose, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnclose, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncloseActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btncloseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnclose;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDisplayUser;
    // End of variables declaration//GEN-END:variables
}
