
import java.awt.BorderLayout;
import javax.swing.JOptionPane;




public class frmHome extends javax.swing.JFrame {

    
    public frmHome() {
        initComponents();
        
        //this code is to maximize
        this.setLayout(new BorderLayout());
        this.add(jDesktopPane_Main, BorderLayout.CENTER);
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane_Main = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu_User = new javax.swing.JMenu();
        jMenuItem_User = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MONITORING SYSTEM FOR BILIRAN PROVINCE STATE UNIVERSITY SCHOLARS");

        jDesktopPane_Main.setBackground(new java.awt.Color(51, 51, 255));
        jDesktopPane_Main.setForeground(new java.awt.Color(255, 255, 51));

        javax.swing.GroupLayout jDesktopPane_MainLayout = new javax.swing.GroupLayout(jDesktopPane_Main);
        jDesktopPane_Main.setLayout(jDesktopPane_MainLayout);
        jDesktopPane_MainLayout.setHorizontalGroup(
            jDesktopPane_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 631, Short.MAX_VALUE)
        );
        jDesktopPane_MainLayout.setVerticalGroup(
            jDesktopPane_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );

        jMenu_User.setText("User");

        jMenuItem_User.setText("Admin");
        jMenuItem_User.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_UserActionPerformed(evt);
            }
        });
        jMenu_User.add(jMenuItem_User);

        jMenuItem1.setText("Student");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu_User.add(jMenuItem1);

        jMenuBar1.add(jMenu_User);

        jMenu2.setText("Transactions");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Reports");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane_Main)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane_Main)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem_UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_UserActionPerformed
        // TODO add your handling code here:
        
        frmlogin admin = new frmlogin();
        jDesktopPane_Main.add(admin);
        admin.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem_UserActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        frmlist student = new frmlist();
        jDesktopPane_Main.add(student);
        student.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(frmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane jDesktopPane_Main;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem_User;
    private javax.swing.JMenu jMenu_User;
    // End of variables declaration//GEN-END:variables
}
