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
public class frame_matkul_if extends javax.swing.JFrame {

    /**
     * Creates new form frame_mahasiswa_if
     */
    // declarasi variabel program if
    koneksi dbsetting;
    String driver, database, user, pass;
    Object tabel;

    public frame_matkul_if() {
        initComponents();
        dbsetting = new koneksi();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPassword");
        tabel_matakuliah_if.setModel(tableModel);

        nonaktifkan_teks();
        btn_simpan_if.setEnabled(false);
        btn_batal_if.setEnabled(false);
        btn_ubah_if.setEnabled(false);
        btn_hapus_if.setEnabled(false);

        settableload();
    }
    String data[] = new String[3];

    private void settableload() {
        String stat = "";
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database, user, pass);
            Statement stt = kon.createStatement();
            String SQL = "select * from t_mata_kuliah";
            ResultSet res = stt.executeQuery(SQL);
            while (res.next()) {
                data[0] = res.getString(1);
                data[1] = res.getString(2);
                String dateOri=res.getString(3);
                String[] pecah=dateOri.split("-");
                String tahun=pecah[0];
                
                data[2] = tahun;
               System.out.print(tahun);

                tableModel.addRow(data);
            }
            res.close();
            stt.close();
            kon.close();

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                    JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }

    public void membersihkan_teks() {
        txt_kodeMk_if.setText("");
        txt_namaMk_if.setText("");
    }

    public void nonaktifkan_teks() {
        txt_kodeMk_if.setEnabled(false);
        txt_namaMk_if.setEnabled(false);
    }

    public void aktif_teks() {
        txt_kodeMk_if.setEnabled(true);
        txt_namaMk_if.setEnabled(true);
    }

    int row = -1;

    public void tampilfield() {
        row = 0;
        row = tabel_matakuliah_if.getSelectedRow();
        txt_kodeMk_if.setText(tableModel.getValueAt(row, 0).toString());
        txt_namaMk_if.setText(tableModel.getValueAt(row, 1).toString());
        btn_simpan_if.setEnabled(false);
        btn_ubah_if.setEnabled(true);
        btn_hapus_if.setEnabled(true);
        btn_batal_if.setEnabled(false);
        aktif_teks();
    }

    private javax.swing.table.DefaultTableModel tableModel = getDefaultTableModel();

    private javax.swing.table.DefaultTableModel getDefaultTableModel() {
        return new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"Kode Mata Kuliah", "Nama Mata Kuliah", "tahun"}
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
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
        panelJudul = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelIsi = new javax.swing.JPanel();
        panelCaridata = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_cari_mk_if = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        panelIsi2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txt_kodeMk_if = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_namaMk_if = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_matakuliah_if = new javax.swing.JTable();
        btn_tambah_if = new javax.swing.JButton();
        btn_ubah_if = new javax.swing.JButton();
        btn_hapus_if = new javax.swing.JButton();
        btn_simpan_if = new javax.swing.JButton();
        btn_batal_if = new javax.swing.JButton();
        btn_keluar_if = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelJudul.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("FORM MATA KULIAH");

        javax.swing.GroupLayout panelJudulLayout = new javax.swing.GroupLayout(panelJudul);
        panelJudul.setLayout(panelJudulLayout);
        panelJudulLayout.setHorizontalGroup(
            panelJudulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelJudulLayout.createSequentialGroup()
                .addContainerGap(135, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(166, 166, 166))
        );
        panelJudulLayout.setVerticalGroup(
            panelJudulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJudulLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel1.add(panelJudul, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 490, 60));

        panelCaridata.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Pencarian Data Mata Kuliah");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Masukan Mata Kuliah");

        txt_cari_mk_if.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cari_mk_ifKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panelCaridataLayout = new javax.swing.GroupLayout(panelCaridata);
        panelCaridata.setLayout(panelCaridataLayout);
        panelCaridataLayout.setHorizontalGroup(
            panelCaridataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCaridataLayout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                .addGap(2, 2, 2))
            .addGroup(panelCaridataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(22, 22, 22)
                .addComponent(txt_cari_mk_if, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelCaridataLayout.setVerticalGroup(
            panelCaridataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCaridataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCaridataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCaridataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_cari_mk_if, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 17, Short.MAX_VALUE))
        );

        panelIsi2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Nomor M.K");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Nama M.K");

        tabel_matakuliah_if.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel_matakuliah_if.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_matakuliah_ifMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_matakuliah_if);

        btn_tambah_if.setText("Tambah");
        btn_tambah_if.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambah_ifActionPerformed(evt);
            }
        });

        btn_ubah_if.setText("Ubah");
        btn_ubah_if.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ubah_ifActionPerformed(evt);
            }
        });

        btn_hapus_if.setText("Hapus");
        btn_hapus_if.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapus_ifActionPerformed(evt);
            }
        });

        btn_simpan_if.setText("Simpan");
        btn_simpan_if.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpan_ifActionPerformed(evt);
            }
        });

        btn_batal_if.setText("Batal");
        btn_batal_if.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batal_ifActionPerformed(evt);
            }
        });

        btn_keluar_if.setText("Keluar");
        btn_keluar_if.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_keluar_ifActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelIsi2Layout = new javax.swing.GroupLayout(panelIsi2);
        panelIsi2.setLayout(panelIsi2Layout);
        panelIsi2Layout.setHorizontalGroup(
            panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIsi2Layout.createSequentialGroup()
                .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelIsi2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel4)
                        .addGap(23, 23, 23)
                        .addComponent(txt_kodeMk_if, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(24, 24, 24)
                        .addComponent(txt_namaMk_if, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelIsi2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(panelIsi2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_tambah_if)
                        .addGap(48, 48, 48)
                        .addComponent(btn_ubah_if)
                        .addGap(59, 59, 59)
                        .addComponent(btn_hapus_if)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                        .addComponent(btn_simpan_if)
                        .addGap(68, 68, 68)
                        .addComponent(btn_batal_if)
                        .addGap(62, 62, 62)
                        .addComponent(btn_keluar_if)))
                .addContainerGap())
        );
        panelIsi2Layout.setVerticalGroup(
            panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIsi2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_kodeMk_if, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txt_namaMk_if, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_tambah_if)
                    .addComponent(btn_ubah_if)
                    .addComponent(btn_hapus_if)
                    .addComponent(btn_simpan_if)
                    .addComponent(btn_batal_if)
                    .addComponent(btn_keluar_if))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout panelIsiLayout = new javax.swing.GroupLayout(panelIsi);
        panelIsi.setLayout(panelIsiLayout);
        panelIsiLayout.setHorizontalGroup(
            panelIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIsiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelCaridata, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelIsi2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelIsiLayout.setVerticalGroup(
            panelIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIsiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelCaridata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelIsi2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(panelIsi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 730, 430));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 731, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_tambah_ifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambah_ifActionPerformed
        // TODO add your handling code here:
        membersihkan_teks();
        txt_kodeMk_if.requestFocus();
        btn_simpan_if.setEnabled(true);
        btn_ubah_if.setEnabled(false);
        btn_hapus_if.setEnabled(false);
        btn_keluar_if.setEnabled(false);
        btn_batal_if.setEnabled(true);
        aktif_teks();
    }//GEN-LAST:event_btn_tambah_ifActionPerformed

    private void btn_batal_ifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batal_ifActionPerformed
        // TODO add your handling code here:
        membersihkan_teks();
        nonaktifkan_teks();
        btn_simpan_if.setEnabled(false);
        btn_ubah_if.setEnabled(false);
        btn_hapus_if.setEnabled(false);
        btn_keluar_if.setEnabled(true);
        btn_batal_if.setEnabled(false);
    }//GEN-LAST:event_btn_batal_ifActionPerformed

    private void tabel_matakuliah_ifMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_matakuliah_ifMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            tampilfield();
        }
    }//GEN-LAST:event_tabel_matakuliah_ifMouseClicked

    private void btn_simpan_ifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpan_ifActionPerformed
        // TODO add your handling code here:
        if (txt_kodeMk_if.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Kode M.K tidak boleh kosong, silahkan dilengkapi");
            txt_kodeMk_if.requestFocus();
        } else if (txt_namaMk_if.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Nama M.K tidak boleh kosong, silahkan dilengkapi");
            txt_namaMk_if.requestFocus();
        } else {
            try {
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(
                        database,
                        user,
                        pass);
                Statement stt = kon.createStatement();
                String SQL = "INSERT INTO t_mata_kuliah(kd_mk,"
                        + "nama_mk)"
                        + "VALUES"
                        + "('" + txt_kodeMk_if.getText() + "',"
                        + "' " + txt_namaMk_if.getText() + "')";

                stt.executeUpdate(SQL);

                tableModel.setRowCount(0);
                settableload();
                stt.close();
                kon.close();
                membersihkan_teks();
                btn_simpan_if.setEnabled(false);
                btn_keluar_if.setEnabled(true);
                nonaktifkan_teks();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,
                        ex.getMessage(), "Error",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        }
    }//GEN-LAST:event_btn_simpan_ifActionPerformed

    private void btn_ubah_ifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubah_ifActionPerformed
        // TODO add your handling code here:
        //validasi belum memilih row
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Belum Memilih Row !!!", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else {
            String kodeMk = txt_kodeMk_if.getText();
            String namaMk = txt_namaMk_if.getText();
            if (txt_kodeMk_if.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,
                        "Kode M.K tidak boleh kosong, silahkan dilengkapi");
            } else if (txt_namaMk_if.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,
                        "Nama M.K tidak boleh kosong, silahkan dilengkapi");
            } else {
                try {
                    Class.forName(driver);
                    Connection kon = DriverManager.getConnection(
                            database,
                            user,
                            pass);
                    Statement stt = kon.createStatement();
                    String SQL = "UPDATE t_mata_kuliah SET kd_mk='" + kodeMk + "', "
                            + "nama_mk='" + namaMk + "' WHERE kd_mk='"
                            + tableModel.getValueAt(row, 0).toString() + "';";

                    stt.executeUpdate(SQL);

                    tableModel.setRowCount(0);
                    settableload();
                    stt.close();
                    kon.close();
                    membersihkan_teks();
                    btn_simpan_if.setEnabled(false);
                    btn_ubah_if.setEnabled(false);
                    btn_hapus_if.setEnabled(false);
                    nonaktifkan_teks();
                    // set unselected row
                    row = -1;

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,
                            ex.getMessage(), "Error",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }
        }
    }//GEN-LAST:event_btn_ubah_ifActionPerformed

    private void btn_hapus_ifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapus_ifActionPerformed
        // TODO add your handling code here:
        //validasi belum meilih row
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Belum Memilih Row !!!", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(
                        database,
                        user,
                        pass);
                Statement stt = kon.createStatement();
                String SQL = "Delete From t_mata_kuliah where kd_mk='"
                        + tableModel.getValueAt(row, 0).toString() + "'";

                stt.executeUpdate(SQL);
                tableModel.removeRow(row);
                stt.close();
                kon.close();
                membersihkan_teks();
                btn_simpan_if.setEnabled(false);
                btn_ubah_if.setEnabled(false);
                btn_hapus_if.setEnabled(false);
                nonaktifkan_teks();
                // set unselected row
                row = -1;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_btn_hapus_ifActionPerformed

    private void txt_cari_mk_ifKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cari_mk_ifKeyReleased
        // TODO add your handling code here:
        tableModel.setRowCount(0);
        String cari;
        cari = txt_cari_mk_if.getText();
        String SQL = null;
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(
                    database,
                    user,
                    pass);
            Statement stt = kon.createStatement();
            SQL = "SELECT * FROM t_mata_kuliah WHERE kd_mk"
                    + " LIKE '%" + cari + "%' OR "
                    + "nama_mk LIKE '%" + cari + "%'";

            ResultSet res = stt.executeQuery(SQL);
            while (res.next()) {
                data[0] = res.getString(1);
                data[1] = res.getString(2);
                tableModel.addRow(data);
            }
            res.close();
            stt.close();
            kon.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    ex.getMessage(), "Error",
                    JOptionPane.INFORMATION_MESSAGE
            );
            System.exit(0);
        }
    }//GEN-LAST:event_txt_cari_mk_ifKeyReleased

    private void btn_keluar_ifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_keluar_ifActionPerformed
        // TODO add your handling code here:
        frame_utama_if frm_utama = new frame_utama_if();
        frm_utama.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_keluar_ifActionPerformed

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
            java.util.logging.Logger.getLogger(frame_matkul_if.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frame_matkul_if.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frame_matkul_if.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frame_matkul_if.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frame_matkul_if().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_batal_if;
    private javax.swing.JButton btn_hapus_if;
    private javax.swing.JButton btn_keluar_if;
    private javax.swing.JButton btn_simpan_if;
    private javax.swing.JButton btn_tambah_if;
    private javax.swing.JButton btn_ubah_if;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel panelCaridata;
    private javax.swing.JPanel panelIsi;
    private javax.swing.JPanel panelIsi2;
    private javax.swing.JPanel panelJudul;
    private javax.swing.JTable tabel_matakuliah_if;
    private javax.swing.JTextField txt_cari_mk_if;
    private javax.swing.JTextField txt_kodeMk_if;
    private javax.swing.JTextField txt_namaMk_if;
    // End of variables declaration//GEN-END:variables

}
