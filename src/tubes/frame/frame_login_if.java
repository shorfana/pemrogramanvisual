/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes.frame;

import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import tubes.koneksi.database.koneksi;
/**
 *
 * @author Shorfana
 */
public class frame_login_if extends javax.swing.JFrame {

    /**
     * Creates new form frame_login_if
     */
    koneksi dbsetting;
    String driver,database,user,pass;
    public frame_login_if() {
        initComponents();
        dbsetting = new koneksi();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPassword");
        
        
    }
    int percobaan = 0;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_username_if = new javax.swing.JTextField();
        txt_password_if = new javax.swing.JPasswordField();
        btn_login_if = new javax.swing.JButton();
        lbl_daftar_if = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Bebas Neue Bold", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LOGIN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(241, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(242, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 550, 100));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("USERNAME");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, -1, 20));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PASSWORD");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, -1, 20));

        txt_username_if.setBackground(new java.awt.Color(102, 102, 102));
        txt_username_if.setForeground(new java.awt.Color(255, 255, 255));
        txt_username_if.setText("fdsfafads");
        txt_username_if.setBorder(null);
        jPanel3.add(txt_username_if, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 129, 20));

        txt_password_if.setBackground(new java.awt.Color(102, 102, 102));
        txt_password_if.setForeground(new java.awt.Color(255, 255, 255));
        txt_password_if.setBorder(null);
        jPanel3.add(txt_password_if, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 129, 20));

        btn_login_if.setText("LOGIN");
        btn_login_if.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_login_ifActionPerformed(evt);
            }
        });
        jPanel3.add(btn_login_if, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, -1, -1));

        lbl_daftar_if.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_daftar_if.setText("Belum punyak akun? daftar disini");
        lbl_daftar_if.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_daftar_ifMouseClicked(evt);
            }
        });
        jPanel3.add(lbl_daftar_if, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, -1, -1));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 130, 10));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 130, 10));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 410, 190));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 571, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_login_ifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_login_ifActionPerformed
        try {
            Connection kon = DriverManager.getConnection(database, user, pass);
            Statement stt = kon.createStatement();
            String SQL = "SELECT * FROM pengguna WHERE username='"+txt_username_if.getText()+"' AND password='"+txt_password_if.getText()+"'";

            ResultSet res = stt.executeQuery(SQL);
            if(res.next()){
                if(txt_username_if.getText().equals(res.getString("username")) && txt_password_if.getText().equals(res.getString("password"))){
                    JOptionPane.showMessageDialog(this, "Berhasil Masuk");
                    frame_utama_if f = new frame_utama_if();
                    f.setVisible(true);
                    this.setVisible(false);
                }
            }else{
                percobaan += 1;
                if (percobaan == 1){
                    JOptionPane.showMessageDialog(this, "Username atau password salah \nKesempatan anda login 2 kali lagi");
                }else if(percobaan ==2){
                    JOptionPane.showMessageDialog(this, "Username atau password salah \nKesempatan anda login 1 kali lagi");
                }else {
                    JOptionPane.showMessageDialog(this, "Username atau password salah \nKesempatan anda sudah abis, sistem akan keluar");
                    System.exit(0);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
    }//GEN-LAST:event_btn_login_ifActionPerformed

    private void lbl_daftar_ifMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_daftar_ifMouseClicked
        // TODO add your handling code here:
        frame_daftar_if frmdaftar = new frame_daftar_if();
        frmdaftar.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lbl_daftar_ifMouseClicked

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
            java.util.logging.Logger.getLogger(frame_login_if.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frame_login_if.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frame_login_if.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frame_login_if.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frame_login_if().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_login_if;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl_daftar_if;
    private javax.swing.JPasswordField txt_password_if;
    private javax.swing.JTextField txt_username_if;
    // End of variables declaration//GEN-END:variables
}
