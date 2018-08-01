/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes.frame;
import javax.swing.*;
import java.sql.*;
import tubes.koneksi.database.koneksi;

/**
 *
 * @author Shorfana
 */
public class frame_simulasiNilaiAkhir_if extends javax.swing.JFrame {

    /**
     * Creates new form frame_mahasiswa_if
     */
    // declarasi variabel program if
    koneksi dbsetting;
    String driver,database,user,pass;
    Object tabel;
    
    public frame_simulasiNilaiAkhir_if() {
        initComponents();
        dbsetting = new koneksi();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPassword");
        tabel_mahasiswa_if.setModel(tableModel);
        tampilComboif();
        
        nonaktifkan_teks();
        btn_simpan_if.setEnabled(false);
        btn_batal_if.setEnabled(false);
        btn_ubah_if.setEnabled(false);
        btn_hapus_if.setEnabled(false);
    }
    
    public void tampilkodemkif(){
       try {
            Connection kon = DriverManager.getConnection(database, user, pass);
            Statement stt = kon.createStatement();
            String SQL = "select kd_mk from t_mata_kuliah where nama_mk='"+cmb_mata_kuliah_if.getSelectedItem()+"'";
            ResultSet res = stt.executeQuery(SQL);
            while (res.next()){
                Object[] ob = new Object[1];
                ob[0]=  res.getString(1);
                
                txt_kodeMk_if.setText((String) ob[0]);
            }
            res.close();
            stt.close();
        } catch (Exception e) {
        } 
    }
    
    public void tampilComboif(){
       try {
            Connection kon = DriverManager.getConnection(database, user, pass);
            Statement stt = kon.createStatement();
            String SQL = "select nama_mk from t_mata_kuliah";
            ResultSet res = stt.executeQuery(SQL);
            while (res.next()){
                cmb_mata_kuliah_if.addItem(res.getString("nama_mk"));
                
            }
            res.close();
            stt.close();
        } catch (Exception e) {
        } 
    }
    
    
    
    public void membersihkan_teks(){
        txt_kodeMk_if.setText("");
        txt_prsAbsen_if.setText("");
        txt_prsTugas_if.setText("");
        txt_prsUTS_if.setText("");
        txt_prsUAS_if.setText("");
        txt_kehadiran_if.setText("");
        txt_tgs1_if.setText("");
        txt_tgs2_if.setText("");
        txt_tgs3_if.setText("");
        txt_uts_if.setText("");
        txt_uas_if.setText("");
    }
    
    public void nonaktifkan_teks(){
        txt_kodeMk_if.setEnabled(false);
        txt_prsAbsen_if.setEnabled(false);
        txt_prsTugas_if.setEnabled(false);
        txt_prsUTS_if.setEnabled(false);
        txt_prsUAS_if.setEnabled(false);
        txt_kehadiran_if.setEnabled(false);
        txt_tgs1_if.setEnabled(false);
        txt_tgs2_if.setEnabled(false);
        txt_tgs3_if.setEnabled(false);
        txt_uts_if.setEnabled(false);
        txt_uas_if.setEnabled(false);
    }
    
    public void aktif_teks(){
        txt_kodeMk_if.setEnabled(true);
        txt_prsAbsen_if.setEnabled(true);
        txt_prsTugas_if.setEnabled(true);
        txt_prsUTS_if.setEnabled(true);
        txt_prsUAS_if.setEnabled(true);
        txt_kehadiran_if.setEnabled(true);
        txt_tgs1_if.setEnabled(true);
        txt_tgs2_if.setEnabled(true);
        txt_tgs3_if.setEnabled(true);
        txt_uts_if.setEnabled(true);
        txt_uas_if.setEnabled(true);
    }
    int row = 0;
    public void tampil_field(){
        row = tabel_mahasiswa_if.getSelectedRow();
        txt_kodeMk_if.setText(tableModel.getValueAt(row, 0).toString());
        cmb_mata_kuliah_if.getModel().setSelectedItem(tableModel.getValueAt(row, 1).toString());
        txt_prsAbsen_if.setText(tableModel.getValueAt(row, 2).toString());
        txt_prsTugas_if.setText(tableModel.getValueAt(row, 3).toString());
        txt_prsUTS_if.setText(tableModel.getValueAt(row, 4).toString());
        txt_prsUAS_if.setText(tableModel.getValueAt(row, 5).toString());
        txt_kehadiran_if.setText(tableModel.getValueAt(row, 6).toString());
        txt_tgs1_if.setText(tableModel.getValueAt(row, 7).toString());
        txt_tgs2_if.setText(tableModel.getValueAt(row, 8).toString());
        txt_tgs3_if.setText(tableModel.getValueAt(row, 9).toString());
        txt_uts_if.setText(tableModel.getValueAt(row, 10).toString());
        txt_uas_if.setText(tableModel.getValueAt(row, 11).toString());
        
        btn_ubah_if.setEnabled(true);
        btn_hapus_if.setEnabled(true);
        
    }
    
    private javax.swing.table.DefaultTableModel tableModel = getDefaultTableModel();
    private javax.swing.table.DefaultTableModel getDefaultTableModel() {
        return new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"kode mk","Nama M.K","Persentase Absen","Persentase Tugas",""
                        + "Persentase UTS","Persentase UAS", "Absensi", "Tgs "
                        + "1","Tgs 2","Tgs 3","UTS","UAS","Nilai Absen","Nilai"
                        + " Tugas","Nilai UTS","Nilai UAS","Nilai Akhir","Index"
                        + "", "Keterangan"}
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false
                    , false, false, false, false, false, false, false, false, false
                    , false
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
        panelIsi2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txt_kodeMk_if = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_prsAbsen_if = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_mahasiswa_if = new javax.swing.JTable();
        btn_tambah_if = new javax.swing.JButton();
        btn_ubah_if = new javax.swing.JButton();
        btn_hapus_if = new javax.swing.JButton();
        btn_simpan_if = new javax.swing.JButton();
        btn_batal_if = new javax.swing.JButton();
        btn_keluar_if = new javax.swing.JButton();
        cmb_mata_kuliah_if = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_prsTugas_if = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_prsUTS_if = new javax.swing.JTextField();
        txt_prsUAS_if = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_kehadiran_if = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_tgs1_if = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txt_tgs2_if = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txt_tgs3_if = new javax.swing.JTextField();
        txt_uts_if = new javax.swing.JTextField();
        txt_uas_if = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelJudul.setBackground(new java.awt.Color(102, 102, 102));
        panelJudul.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("FORM SIMULASI NILAI AKHIR ");

        javax.swing.GroupLayout panelJudulLayout = new javax.swing.GroupLayout(panelJudul);
        panelJudul.setLayout(panelJudulLayout);
        panelJudulLayout.setHorizontalGroup(
            panelJudulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelJudulLayout.createSequentialGroup()
                .addContainerGap(291, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(216, 216, 216))
        );
        panelJudulLayout.setVerticalGroup(
            panelJudulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJudulLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel1.add(panelJudul, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 790, 60));

        panelIsi.setBackground(new java.awt.Color(255, 255, 255));
        panelIsi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelIsi2.setBackground(new java.awt.Color(102, 102, 102));
        panelIsi2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelIsi2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Kode M.K");
        panelIsi2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 41, -1, -1));
        panelIsi2.add(txt_kodeMk_if, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 39, 132, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Presentase Absen");
        panelIsi2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 72, -1, -1));
        panelIsi2.add(txt_prsAbsen_if, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 70, 44, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nama Mata Kuliah");
        panelIsi2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 15, -1, -1));

        tabel_mahasiswa_if.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_mahasiswa_if.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_mahasiswa_ifMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_mahasiswa_if);

        panelIsi2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 1263, 138));

        btn_tambah_if.setBackground(new java.awt.Color(0, 0, 0));
        btn_tambah_if.setForeground(new java.awt.Color(255, 255, 255));
        btn_tambah_if.setText("Tambah");
        btn_tambah_if.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambah_ifActionPerformed(evt);
            }
        });
        panelIsi2.add(btn_tambah_if, new org.netbeans.lib.awtextra.AbsoluteConstraints(303, 392, -1, -1));

        btn_ubah_if.setBackground(new java.awt.Color(0, 0, 0));
        btn_ubah_if.setForeground(new java.awt.Color(255, 255, 255));
        btn_ubah_if.setText("Ubah");
        btn_ubah_if.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ubah_ifActionPerformed(evt);
            }
        });
        panelIsi2.add(btn_ubah_if, new org.netbeans.lib.awtextra.AbsoluteConstraints(429, 392, -1, -1));

        btn_hapus_if.setBackground(new java.awt.Color(0, 0, 0));
        btn_hapus_if.setForeground(new java.awt.Color(255, 255, 255));
        btn_hapus_if.setText("Hapus");
        btn_hapus_if.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapus_ifActionPerformed(evt);
            }
        });
        panelIsi2.add(btn_hapus_if, new org.netbeans.lib.awtextra.AbsoluteConstraints(569, 392, -1, -1));

        btn_simpan_if.setBackground(new java.awt.Color(0, 0, 0));
        btn_simpan_if.setForeground(new java.awt.Color(255, 255, 255));
        btn_simpan_if.setText("Simpan");
        btn_simpan_if.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpan_ifActionPerformed(evt);
            }
        });
        panelIsi2.add(btn_simpan_if, new org.netbeans.lib.awtextra.AbsoluteConstraints(722, 392, -1, -1));

        btn_batal_if.setBackground(new java.awt.Color(0, 0, 0));
        btn_batal_if.setForeground(new java.awt.Color(255, 255, 255));
        btn_batal_if.setText("Batal");
        panelIsi2.add(btn_batal_if, new org.netbeans.lib.awtextra.AbsoluteConstraints(864, 392, -1, -1));

        btn_keluar_if.setBackground(new java.awt.Color(0, 0, 0));
        btn_keluar_if.setForeground(new java.awt.Color(255, 255, 255));
        btn_keluar_if.setText("Keluar");
        btn_keluar_if.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_keluar_ifActionPerformed(evt);
            }
        });
        panelIsi2.add(btn_keluar_if, new org.netbeans.lib.awtextra.AbsoluteConstraints(977, 392, -1, -1));

        cmb_mata_kuliah_if.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_mata_kuliah_ifActionPerformed(evt);
            }
        });
        panelIsi2.add(cmb_mata_kuliah_if, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 13, 132, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("%");
        panelIsi2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 72, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Presentase Tugas");
        panelIsi2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 110, -1, -1));
        panelIsi2.add(txt_prsTugas_if, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 108, 44, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Presentase UTS");
        panelIsi2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 152, -1, -1));
        panelIsi2.add(txt_prsUTS_if, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 150, 44, -1));
        panelIsi2.add(txt_prsUAS_if, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 196, 44, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Presentase UAS");
        panelIsi2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 198, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Kehadiran");
        panelIsi2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(771, 21, -1, -1));
        panelIsi2.add(txt_kehadiran_if, new org.netbeans.lib.awtextra.AbsoluteConstraints(863, 19, 44, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Tugas 1");
        panelIsi2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(771, 52, -1, -1));
        panelIsi2.add(txt_tgs1_if, new org.netbeans.lib.awtextra.AbsoluteConstraints(863, 50, 44, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Tugas 2");
        panelIsi2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(771, 90, -1, -1));

        txt_tgs2_if.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tgs2_ifActionPerformed(evt);
            }
        });
        panelIsi2.add(txt_tgs2_if, new org.netbeans.lib.awtextra.AbsoluteConstraints(863, 88, 44, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Tugas 3");
        panelIsi2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(771, 122, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("%");
        panelIsi2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 110, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("%");
        panelIsi2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 152, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("%");
        panelIsi2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 198, 22, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("UTS");
        panelIsi2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(771, 160, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("UAS");
        panelIsi2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(771, 196, -1, -1));
        panelIsi2.add(txt_tgs3_if, new org.netbeans.lib.awtextra.AbsoluteConstraints(863, 120, 44, -1));
        panelIsi2.add(txt_uts_if, new org.netbeans.lib.awtextra.AbsoluteConstraints(863, 158, 44, -1));
        panelIsi2.add(txt_uas_if, new org.netbeans.lib.awtextra.AbsoluteConstraints(863, 196, 44, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Pertemuan");
        panelIsi2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 20, -1, -1));

        panelIsi.add(panelIsi2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1290, 450));

        jPanel1.add(panelIsi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, -1, 540));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmb_mata_kuliah_ifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_mata_kuliah_ifActionPerformed
        // TODO add your handling code here:
        tampilkodemkif();
    }//GEN-LAST:event_cmb_mata_kuliah_ifActionPerformed

    private void btn_tambah_ifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambah_ifActionPerformed
        // TODO add your handling code here:
        membersihkan_teks();
        txt_kodeMk_if.requestFocus();
        btn_simpan_if.setEnabled(true);
        btn_ubah_if.setEnabled(false);
        btn_hapus_if.setEnabled(false);
        btn_keluar_if.setEnabled(false);
        aktif_teks();
    }//GEN-LAST:event_btn_tambah_ifActionPerformed

    
    private void btn_simpan_ifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpan_ifActionPerformed
        // TODO add your handling code here:
        String data[] = new String[19];
        
        double pabsen_if = Double.valueOf(txt_prsAbsen_if.getText()) / 100;
        double hadir2_if = Double.valueOf(txt_kehadiran_if.getText());
        double hadir_if = Double.valueOf(txt_kehadiran_if.getText()) / 14;
        double nilaiAbsen = hadir_if * 100 * pabsen_if;
        double ptugas = Double.valueOf(txt_prsTugas_if.getText()) / 100;
        double tgs1 = Double.valueOf(txt_tgs1_if.getText());
        double tgs2 = Double.valueOf(txt_tgs2_if.getText());
        double tgs3 = Double.valueOf(txt_tgs3_if.getText());
        double nilaiTugas = ((tgs1+tgs2+tgs3)/3) * ptugas ;
        double puts = Double.valueOf(txt_prsUTS_if.getText()) ;
        double nilaiUTS = (Double.valueOf(txt_uts_if.getText()) * puts)/100;
        double puas = Double.valueOf(txt_prsUAS_if.getText()) ;
        double nilaiUAS = (Double.valueOf(txt_uas_if.getText()) * puas)/100;
        double nilaiAkhir =  (nilaiAbsen + nilaiTugas + nilaiUTS + nilaiUAS);
        String index = "";
        if(nilaiAkhir >=80 && nilaiAkhir <= 100 ){
            index = "A";
        }else if(nilaiAkhir >=68 && nilaiAkhir <= 79){
            index = "B";
        }else if(nilaiAkhir >=56 && nilaiAkhir <= 67){
            index="C";
        }else if(nilaiAkhir >=45 && nilaiAkhir <= 55){
            index="D";
        }else{
            index="E";
        }
        String keterangan = "";
        if(hadir2_if <= 11){
            keterangan="Tidak Lulus";
        }else if((index == "A" || index == "B" || index == "C") && hadir2_if >= 11){
            keterangan="LULUS";
        }else if((index == "D" || index == "E")){
            keterangan="Tidak Lulus";
        }
        
        if(txt_kodeMk_if.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kolom Kode MK Harus diisi");
            txt_kodeMk_if.requestFocus();
        }else if(txt_prsAbsen_if.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kolom Persentasi Absen Harus diisi");
            txt_prsAbsen_if.requestFocus();
        }else if(txt_prsTugas_if.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kolom Persentasi Tugas Harus diisi");
            txt_prsTugas_if.requestFocus();
        }else if(txt_prsUTS_if.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kolom Persentasi UTS Harus diisi");
            txt_prsUTS_if.requestFocus();
        }else if(txt_prsUAS_if.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kolom Persentasi UAS Harus diisi");
            txt_prsUAS_if.requestFocus();
        }else if(txt_kehadiran_if.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kolom Kehadiran Harus diisi");
            txt_kehadiran_if.requestFocus();
        }else if(hadir2_if > 14){
            JOptionPane.showMessageDialog(null, "Kolom Kehadiran Tidak Boleh Lebih Dari 14");
            txt_kehadiran_if.requestFocus();
            
        }else if(txt_tgs1_if.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kolom Tugas 1 Harus diisi");
            txt_tgs1_if.requestFocus();
        }else if(txt_tgs2_if.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kolom Tugas 2 Harus diisi");
            txt_tgs2_if.requestFocus();
        }else if(txt_tgs3_if.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kolom Tugas 3 Harus diisi");
            txt_tgs3_if.requestFocus();
        }else if(txt_uts_if.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kolom Nilai UTS Harus diisi");
            txt_uts_if.requestFocus();
        }else if(txt_uas_if.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kolom Nilai UAS Harus diisi");
            txt_uas_if.requestFocus();
        }else {
         if (JOptionPane.showConfirmDialog(null, "Apakah Data Sudah Benar?", "Peringatan!!!",
                 JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
             data[0] = txt_kodeMk_if.getText();
                data[1] = (String) cmb_mata_kuliah_if.getSelectedItem();
                data[2] = txt_prsAbsen_if.getText();
                data[3] = txt_prsTugas_if.getText();
                data[4] = txt_prsUTS_if.getText();
                data[5] = txt_prsUAS_if.getText();
                data[6] = txt_kehadiran_if.getText();
                data[7] = txt_tgs1_if.getText();
                data[8] = txt_tgs2_if.getText();
                data[9] = txt_tgs3_if.getText();
                data[10] = txt_uts_if.getText();
                data[11] = txt_uas_if.getText();
                data[12] = Double.toString(nilaiAbsen);
                data[13] = Double.toString(nilaiTugas);
                data[14] = Double.toString(nilaiUTS);
                data[15] = Double.toString(nilaiAbsen);
                data[16] = Double.toString(nilaiAkhir);
                data[17] = index;
                data[18] = keterangan;
                JOptionPane.showMessageDialog(this, "Data Berhasil Ditambah ketabel");
            tableModel.insertRow(0, data);
            
        }else{
             
         }
        }
    }//GEN-LAST:event_btn_simpan_ifActionPerformed

    private void tabel_mahasiswa_ifMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_mahasiswa_ifMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount()==1) {
            tampil_field();
        }
    }//GEN-LAST:event_tabel_mahasiswa_ifMouseClicked

    private void btn_ubah_ifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubah_ifActionPerformed
        // TODO add your handling code here:
        String data[] = new String[19];
        
        double pabsen_if = Double.valueOf(txt_prsAbsen_if.getText()) / 100;
        double hadir2_if = Double.valueOf(txt_kehadiran_if.getText());
        double hadir_if = Double.valueOf(txt_kehadiran_if.getText()) / 14;
        double nilaiAbsen = hadir_if * 100 * pabsen_if;
        double ptugas = Double.valueOf(txt_prsTugas_if.getText()) / 100;
        double tgs1 = Double.valueOf(txt_tgs1_if.getText());
        double tgs2 = Double.valueOf(txt_tgs2_if.getText());
        double tgs3 = Double.valueOf(txt_tgs3_if.getText());
        double nilaiTugas = ((tgs1+tgs2+tgs3)/3) * ptugas ;
        double puts = Double.valueOf(txt_prsUTS_if.getText()) ;
        double nilaiUTS = (Double.valueOf(txt_uts_if.getText()) * puts)/100;
        double puas = Double.valueOf(txt_prsUAS_if.getText()) ;
        double nilaiUAS = (Double.valueOf(txt_uas_if.getText()) * puas)/100;
        double nilaiAkhir =  (nilaiAbsen + nilaiTugas + nilaiUTS + nilaiUAS);
        String index = "";
        if(nilaiAkhir >=80 && nilaiAkhir <= 100 ){
            index = "A";
        }else if(nilaiAkhir >=68 && nilaiAkhir <= 79){
            index = "B";
        }else if(nilaiAkhir >=56 && nilaiAkhir <= 67){
            index="C";
        }else if(nilaiAkhir >=45 && nilaiAkhir <= 55){
            index="D";
        }else{
            index="E";
        }
        String keterangan = "";
        if(hadir2_if <= 11){
            keterangan="Tidak Lulus";
        }else if((index == "A" || index == "B" || index == "C") && hadir2_if >= 11){
            keterangan="LULUS";
        }else if((index == "D" || index == "E")){
            keterangan="Tidak Lulus";
        }
        
        if(txt_kodeMk_if.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kolom Kode MK Harus diisi");
            txt_kodeMk_if.requestFocus();
        }else if(txt_prsAbsen_if.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kolom Persentasi Absen Harus diisi");
            txt_prsAbsen_if.requestFocus();
        }else if(txt_prsTugas_if.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kolom Persentasi Tugas Harus diisi");
            txt_prsTugas_if.requestFocus();
        }else if(txt_prsUTS_if.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kolom Persentasi UTS Harus diisi");
            txt_prsUTS_if.requestFocus();
        }else if(txt_prsUAS_if.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kolom Persentasi UAS Harus diisi");
            txt_prsUAS_if.requestFocus();
        }else if(txt_kehadiran_if.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kolom Kehadiran Harus diisi");
            txt_kehadiran_if.requestFocus();
        }else if(hadir2_if > 14){
            JOptionPane.showMessageDialog(null, "Kolom Kehadiran Tidak Boleh Lebih Dari 14");
            txt_kehadiran_if.requestFocus();
            
        }else if(txt_tgs1_if.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kolom Tugas 1 Harus diisi");
            txt_tgs1_if.requestFocus();
        }else if(txt_tgs2_if.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kolom Tugas 2 Harus diisi");
            txt_tgs2_if.requestFocus();
        }else if(txt_tgs3_if.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kolom Tugas 3 Harus diisi");
            txt_tgs3_if.requestFocus();
        }else if(txt_uts_if.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kolom Nilai UTS Harus diisi");
            txt_uts_if.requestFocus();
        }else if(txt_uas_if.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kolom Nilai UAS Harus diisi");
            txt_uas_if.requestFocus();
        }else {
            if (JOptionPane.showConfirmDialog(null, "Yakin Data Mau Diubah?", "Peringatan!!!",
                 JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                data[0] = txt_kodeMk_if.getText();
            data[1] = (String) cmb_mata_kuliah_if.getSelectedItem();
            data[2] = txt_prsAbsen_if.getText();
            data[3] = txt_prsTugas_if.getText();
            data[4] = txt_prsUTS_if.getText();
            data[5] = txt_prsUAS_if.getText();
            data[6] = txt_kehadiran_if.getText();
            data[7] = txt_tgs1_if.getText();
            data[8] = txt_tgs2_if.getText();
            data[9] = txt_tgs3_if.getText();
            data[10] = txt_uts_if.getText();
            data[11] = txt_uas_if.getText();
            data[12] = Double.toString(nilaiAbsen);
            data[13] = Double.toString(nilaiTugas);
            data[14] = Double.toString(nilaiUTS);
            data[15] = Double.toString(nilaiAbsen);
            data[16] = Double.toString(nilaiAkhir);
            data[17] = index;
            data[18] = keterangan;
            JOptionPane.showMessageDialog(this, "Data Berhasil Diubah ke tabel");
            tableModel.removeRow(0);
            tableModel.insertRow(0, data);
            membersihkan_teks();
            btn_simpan_if.setEnabled(false);
            btn_ubah_if.setEnabled(false);
            btn_simpan_if.setEnabled(false);
                
            } else {
                
            }
        }
    }//GEN-LAST:event_btn_ubah_ifActionPerformed

    private void btn_hapus_ifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapus_ifActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Yakin Data Mau DIhapus?", "Peringatan!!!",
                 JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
            
            tableModel.removeRow(row);
            membersihkan_teks();
            JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        }else{
            
        }
        
        
    }//GEN-LAST:event_btn_hapus_ifActionPerformed

    private void btn_keluar_ifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_keluar_ifActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(null, "Yakin Data Mau ke menu utama?", "Peringatan!!!",
                 JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            frame_utama_if frm_login = new frame_utama_if();
        frm_login.setVisible(true);
        this.setVisible(false);
        }
        
    }//GEN-LAST:event_btn_keluar_ifActionPerformed

    private void txt_tgs2_ifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tgs2_ifActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tgs2_ifActionPerformed

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
            java.util.logging.Logger.getLogger(frame_simulasiNilaiAkhir_if.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frame_simulasiNilaiAkhir_if.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frame_simulasiNilaiAkhir_if.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frame_simulasiNilaiAkhir_if.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frame_simulasiNilaiAkhir_if().setVisible(true);
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
    private javax.swing.JComboBox<String> cmb_mata_kuliah_if;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelIsi;
    private javax.swing.JPanel panelIsi2;
    private javax.swing.JPanel panelJudul;
    private javax.swing.JTable tabel_mahasiswa_if;
    private javax.swing.JTextField txt_kehadiran_if;
    private javax.swing.JTextField txt_kodeMk_if;
    private javax.swing.JTextField txt_prsAbsen_if;
    private javax.swing.JTextField txt_prsTugas_if;
    private javax.swing.JTextField txt_prsUAS_if;
    private javax.swing.JTextField txt_prsUTS_if;
    private javax.swing.JTextField txt_tgs1_if;
    private javax.swing.JTextField txt_tgs2_if;
    private javax.swing.JTextField txt_tgs3_if;
    private javax.swing.JTextField txt_uas_if;
    private javax.swing.JTextField txt_uts_if;
    // End of variables declaration//GEN-END:variables

   
}
