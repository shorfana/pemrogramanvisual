/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes.frame;

/**
 *
 * @author Shorfana
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;
import tubes.koneksi.database.koneksi;

public class frame_daftar_if extends javax.swing.JFrame {

    /**
     * Creates new form frame_daftar_if
     */
    koneksi dbsetting;
    String driver, database, user, pass;
    Object tabel;

    public frame_daftar_if() {
        initComponents();
        dbsetting = new koneksi();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPassword");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_username_if = new javax.swing.JTextField();
        btn_daftar_if = new javax.swing.JButton();
        lbl_punya_akun_if = new javax.swing.JLabel();
        j_password_if = new javax.swing.JPasswordField();
        j_confirm_ppass_if = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, 50));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, -1, 50));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Confirm Password");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, 50));

        txt_username_if.setBackground(new java.awt.Color(102, 102, 102));
        txt_username_if.setForeground(new java.awt.Color(255, 255, 255));
        txt_username_if.setBorder(null);
        jPanel3.add(txt_username_if, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 138, 20));

        btn_daftar_if.setText("Daftar");
        btn_daftar_if.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_daftar_ifActionPerformed(evt);
            }
        });
        jPanel3.add(btn_daftar_if, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 160, -1, -1));

        lbl_punya_akun_if.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_punya_akun_if.setText("Sudah punya akun???");
        lbl_punya_akun_if.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_punya_akun_ifMouseClicked(evt);
            }
        });
        jPanel3.add(lbl_punya_akun_if, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, -1, -1));

        j_password_if.setBackground(new java.awt.Color(102, 102, 102));
        j_password_if.setForeground(new java.awt.Color(255, 255, 255));
        j_password_if.setBorder(null);
        jPanel3.add(j_password_if, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 138, 20));

        j_confirm_ppass_if.setBackground(new java.awt.Color(102, 102, 102));
        j_confirm_ppass_if.setForeground(new java.awt.Color(255, 255, 255));
        j_confirm_ppass_if.setBorder(null);
        jPanel3.add(j_confirm_ppass_if, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 110, 138, 20));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 140, 10));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 140, 10));
        jPanel3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 140, 10));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 460, 230));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Bebas Neue Bold", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DAFTAR");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(231, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(232, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 550, 100));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_punya_akun_ifMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_punya_akun_ifMouseClicked
        // TODO add your handling code here:
        frame_login_if frmlogin = new frame_login_if();
        frmlogin.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lbl_punya_akun_ifMouseClicked

    private void btn_daftar_ifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_daftar_ifActionPerformed
        // TODO add your handling code here:
        String username = txt_username_if.getText();
        String password = j_password_if.getText();
        String cpassword = j_confirm_ppass_if.getText();
        
        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username tidak boleh kosong!");
            txt_username_if.requestFocus();
        } else if (password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Password tidak boleh kosong!");
            j_password_if.requestFocus();
        } else if (cpassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Confirm Password tidak boleh kosong!");
            j_confirm_ppass_if.requestFocus();
            
        } else if (!password.equals(cpassword)) {
            JOptionPane.showMessageDialog(this, "Password Tidak sama ");
            j_password_if.requestFocus();
        } else if (password.equals(cpassword)) {
            try {
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(
                        database,
                        user,
                        pass);
                Statement stt = kon.createStatement();
                String SQL = "INSERT INTO `pengguna` (`username`, `password`) "
                        + "VALUES ('" + username + "', '" + password + "')";
                stt.executeUpdate(SQL);
                JOptionPane.showMessageDialog(this, "Akun Berhasil didaftarkan \n"
                        + "Silahkan Login");
                frame_login_if frmlogin = new frame_login_if();
                frmlogin.setVisible(true);
                this.setVisible(false);
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Gagal Mendaftar");
            }            
        }
    }//GEN-LAST:event_btn_daftar_ifActionPerformed

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
            java.util.logging.Logger.getLogger(frame_daftar_if.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frame_daftar_if.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frame_daftar_if.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frame_daftar_if.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frame_daftar_if().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_daftar_if;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPasswordField j_confirm_ppass_if;
    private javax.swing.JPasswordField j_password_if;
    private javax.swing.JLabel lbl_punya_akun_if;
    private javax.swing.JTextField txt_username_if;
    // End of variables declaration//GEN-END:variables
}
