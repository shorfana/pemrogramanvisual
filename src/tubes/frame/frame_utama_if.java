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
public class frame_utama_if extends javax.swing.JFrame {

    
    
    public frame_utama_if() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        j_mahasiswa_if = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        j_data_matakuliah_if = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        j_data_nilai_if = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        j_simulasi_nilai_akhir_if = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menu_tentang_pembuat_if = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToolBar1.setRollover(true);

        j_mahasiswa_if.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubes/gambar/mahasiswa.png"))); // NOI18N
        j_mahasiswa_if.setText("Data Mahsiswa");
        j_mahasiswa_if.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                j_mahasiswa_ifMouseClicked(evt);
            }
        });
        jToolBar1.add(j_mahasiswa_if);
        jToolBar1.add(jSeparator1);

        j_data_matakuliah_if.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubes/gambar/clipboard.png"))); // NOI18N
        j_data_matakuliah_if.setText("Data Mata Kuliah");
        j_data_matakuliah_if.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                j_data_matakuliah_ifMouseClicked(evt);
            }
        });
        jToolBar1.add(j_data_matakuliah_if);
        jToolBar1.add(jSeparator2);

        j_data_nilai_if.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubes/gambar/1486164728-118_79708.png"))); // NOI18N
        j_data_nilai_if.setText("Data Nilai");
        j_data_nilai_if.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                j_data_nilai_ifMouseClicked(evt);
            }
        });
        jToolBar1.add(j_data_nilai_if);
        jToolBar1.add(jSeparator3);

        j_simulasi_nilai_akhir_if.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubes/gambar/zoom_search_icon-icons.com_75907.png"))); // NOI18N
        j_simulasi_nilai_akhir_if.setText("Simulasi Nilai Akhir");
        j_simulasi_nilai_akhir_if.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                j_simulasi_nilai_akhir_ifMouseClicked(evt);
            }
        });
        jToolBar1.add(j_simulasi_nilai_akhir_if);

        panel1.add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 80));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubes/gambar/faldi.jpg"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubes/gambar/iqbal.jpg"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("10116493");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("10116465");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Muhammad Iqbal Shorfana");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Faldi Favian");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(134, 134, 134))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(89, 89, 89))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 650, 390));

        getContentPane().add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jMenu1.setText("Menu");

        menu_tentang_pembuat_if.setText("Tentang Pembuat");
        menu_tentang_pembuat_if.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_tentang_pembuat_ifMouseClicked(evt);
            }
        });
        menu_tentang_pembuat_if.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_tentang_pembuat_ifActionPerformed(evt);
            }
        });
        jMenu1.add(menu_tentang_pembuat_if);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void j_mahasiswa_ifMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_j_mahasiswa_ifMouseClicked
        frame_mahasiswa_if mhs_if = new frame_mahasiswa_if();
        mhs_if.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_j_mahasiswa_ifMouseClicked

    private void j_data_matakuliah_ifMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_j_data_matakuliah_ifMouseClicked
        frame_matkul_if mhs_if = new frame_matkul_if();
        mhs_if.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_j_data_matakuliah_ifMouseClicked

    private void j_data_nilai_ifMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_j_data_nilai_ifMouseClicked
        frame_nilai_if_1 mhs_if = new frame_nilai_if_1();
        mhs_if.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_j_data_nilai_ifMouseClicked

    private void j_simulasi_nilai_akhir_ifMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_j_simulasi_nilai_akhir_ifMouseClicked
        frame_simulasiNilaiAkhir_if mhs_if = new frame_simulasiNilaiAkhir_if();
        mhs_if.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_j_simulasi_nilai_akhir_ifMouseClicked

    private void menu_tentang_pembuat_ifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_tentang_pembuat_ifActionPerformed
        frame_tentang_pembuat_if tentang = new frame_tentang_pembuat_if();
        tentang.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menu_tentang_pembuat_ifActionPerformed

    private void menu_tentang_pembuat_ifMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_tentang_pembuat_ifMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_menu_tentang_pembuat_ifMouseClicked

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
            java.util.logging.Logger.getLogger(frame_utama_if.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frame_utama_if.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frame_utama_if.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frame_utama_if.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frame_utama_if().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel j_data_matakuliah_if;
    private javax.swing.JLabel j_data_nilai_if;
    private javax.swing.JLabel j_mahasiswa_if;
    private javax.swing.JLabel j_simulasi_nilai_akhir_if;
    private javax.swing.JMenuItem menu_tentang_pembuat_if;
    private javax.swing.JPanel panel1;
    // End of variables declaration//GEN-END:variables
}
