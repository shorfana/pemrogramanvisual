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
public class frame_nilai_if_1 extends javax.swing.JFrame {

    /**
     * Creates new form frame_mahasiswa_if
     */
    // declarasi variabel program if
    koneksi dbsetting;
    String driver, database, user, pass;
    Object tabel;

    public frame_nilai_if_1() {
        initComponents();
        dbsetting = new koneksi();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPassword");
        tabel_nilai_if.setModel(tableModel);

        nonaktifkan_teks();
        btn_simpan_if.setEnabled(false);
        btn_batal_if.setEnabled(false);
        btn_ubah_if.setEnabled(false);
        btn_hapus_if.setEnabled(false);

        settableload();
        loadNamaMhs();
        loadMk();
    }
    String data[] = new String[17];

    private void settableload() {
        String stat = "";
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database, user, pass);
            Statement stt = kon.createStatement();
            String SQL = "SELECT t_mahasiswa.nama,t_mata_kuliah.nama_mk,"
                    + "t_nilai.* FROM t_mahasiswa JOIN t_nilai USING (nim) JOIN "
                    + "t_mata_kuliah using (kd_mk)";
            ResultSet res = stt.executeQuery(SQL);
            while (res.next()) {
                data[0] = res.getString("kd_nilai");
                data[1] = res.getString("nama");
                data[2] = res.getString("nama_mk");
                data[3] = res.getString("absensi");
                data[4] = res.getString("tgs1");
                data[5] = res.getString("tgs2");
                data[6] = res.getString("tgs3");
                data[7] = res.getString("uts");
                data[8] = res.getString("uas");
                data[9] = res.getString("nilai_absen");
                data[10] = res.getString("nilai_tugas");
                data[11] = res.getString("nilai_uts");
                data[12] = res.getString("nilai_uas");
                data[13] = res.getString("nilai");
                data[14] = res.getString("index");
                data[15] = res.getString("ket");
                // ambil tahun angktan
                String tanggal = res.getString("angkatan");
                String[] pecah = tanggal.split("-");
                String tahun = pecah[0];
                data[16] = tahun;

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

    public void loadNamaMhs() {
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database, user, pass);
            Statement stt = kon.createStatement();
            String SQL = "select nama from t_mahasiswa order by nama asc";
            ResultSet res = stt.executeQuery(SQL);
            while (res.next()) {
                Object[] ob = new Object[5];
                ob[0] = res.getString(1);

                cmb_namaMhs_if.addItem((String) ob[0]);
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

    public void loadMk() {
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database, user, pass);
            Statement stt = kon.createStatement();
            String SQL = "select nama_mk from t_mata_kuliah order by nama_mk asc";
            ResultSet res = stt.executeQuery(SQL);
            while (res.next()) {
                Object[] ob = new Object[1];
                ob[0] = res.getString(1);

                cmb_NamaMk_if.addItem((String) ob[0]);
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

    public void tampil_Mahasiswa() {
        if (cmb_namaMhs_if.getSelectedIndex() == 0) {
            txt_nim_if.setText("");
        } else {
            String stat = "";
            try {
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database, user, pass);
                Statement stt = kon.createStatement();
                String SQL = "Select nim from t_mahasiswa where nama='" + cmb_namaMhs_if.getSelectedItem() + "'";
                ResultSet res = stt.executeQuery(SQL);
                while (res.next()) {
                    Object[] ob = new Object[1];
                    ob[0] = res.getString(1);

                    txt_nim_if.setText((String) ob[0]);
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
    }

    public void tampil_Mk() {
        if (cmb_NamaMk_if.getSelectedIndex() == 0) {
            txt_kodeMk_if.setText("");
        } else {
            String stat = "";
            try {
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database, user, pass);
                Statement stt = kon.createStatement();
                String SQL = "Select kd_mk from t_mata_kuliah "
                        + "where nama_mk='" + cmb_NamaMk_if.getSelectedItem() + "'";
                ResultSet res = stt.executeQuery(SQL);
                while (res.next()) {
                    Object[] ob = new Object[1];
                    ob[0] = res.getString(1);

                    txt_kodeMk_if.setText((String) ob[0]);
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
    }

    private javax.swing.table.DefaultTableModel tableModel = getDefaultTableModel();

    private javax.swing.table.DefaultTableModel getDefaultTableModel() {
        return new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"Id", "Nama", "Nama M.K", "Absensi", "Tgs 1", "Tgs 2", "Tgs"
                    + " 3", "UTS", "UAS", "Nilai Absen", "Nilai Tugas", "Nilai "
                    + "UTS", "Nilai UAS", "Nilai Akhir", "Index", "Keterangan", "Angkatan"}
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
    }

    public void membersihkan_teks() {
        cmb_NamaMk_if.setSelectedIndex(0);
        cmb_namaMhs_if.setSelectedIndex(0);
        txt_nim_if.setText("");
        txt_kodeMk_if.setText("");
        txt_kehadiran_if.setText("");
        txt_tgs1_if.setText("");
        txt_tgs2_if.setText("");
        txt_tgs3_if.setText("");
        txt_uts_if.setText("");
        txt_uas_if.setText("");
        txt_angkatan_if.setValue(2018);
    }

    public void nonaktifkan_teks() {
        txt_nim_if.setEnabled(false);
        txt_kodeMk_if.setEnabled(false);
        txt_kehadiran_if.setEnabled(false);
        txt_tgs1_if.setEnabled(false);
        txt_tgs2_if.setEnabled(false);
        txt_tgs3_if.setEnabled(false);
        txt_uts_if.setEnabled(false);
        txt_uas_if.setEnabled(false);
    }

    public void aktif_teks() {
        txt_nim_if.setEnabled(true);
        txt_kodeMk_if.setEnabled(true);
        txt_kehadiran_if.setEnabled(true);
        txt_tgs1_if.setEnabled(true);
        txt_tgs2_if.setEnabled(true);
        txt_tgs3_if.setEnabled(true);
        txt_uts_if.setEnabled(true);
        txt_uas_if.setEnabled(true);
    }

    int row = -1;

    public void tampil_field() {
        row = tabel_nilai_if.getSelectedRow();
        cmb_namaMhs_if.getModel().setSelectedItem(tableModel.getValueAt(row, 1));
        cmb_NamaMk_if.getModel().setSelectedItem(tableModel.getValueAt(row, 2));
        txt_kehadiran_if.setText(tableModel.getValueAt(row, 3).toString());
        txt_tgs1_if.setText(tableModel.getValueAt(row, 4).toString());
        txt_tgs2_if.setText(tableModel.getValueAt(row, 5).toString());
        txt_tgs3_if.setText(tableModel.getValueAt(row, 6).toString());
        txt_uts_if.setText(tableModel.getValueAt(row, 7).toString());
        txt_uas_if.setText(tableModel.getValueAt(row, 8).toString());
        String angkatan = tableModel.getValueAt(row, 16).toString();
        txt_angkatan_if.setValue(Integer.valueOf(angkatan));
        btn_simpan_if.setEnabled(false);
        btn_ubah_if.setEnabled(true);
        btn_hapus_if.setEnabled(true);
        btn_batal_if.setEnabled(true);
        btn_tambah_if.setEnabled(false);
        aktif_teks();
    }

    static double nilaiAbsen(double kehadiran) {
        double nilaiAbsen = (((kehadiran / 14) * 100 * 5) / 100);
        return nilaiAbsen;
    }

    static double nilaiTugas(double tugas_1, double tugas_2, double tugas_3) {
        double nilaiTugas = (((tugas_1 + tugas_2 + tugas_3) / 3) * (0.25));
        return nilaiTugas;
    }

    static double nilaiUts(double uts) {
        double nilaiUts = uts * 30 / 100;
        return nilaiUts;
    }

    static double nilaiUas(double uas) {
        double nilaiUas = uas * 40 / 100;
        return nilaiUas;
    }

    static String index(double nilaiAkhir) {
        String index = "";
        if (nilaiAkhir >= 80 && nilaiAkhir <= 100) {
            index = "A";
        } else if (nilaiAkhir >= 68 && nilaiAkhir <= 79) {
            index = "B";
        } else if (nilaiAkhir >= 56 && nilaiAkhir <= 67) {
            index = "C";
        } else if (nilaiAkhir >= 45 && nilaiAkhir <= 55) {
            index = "D";
        } else if (nilaiAkhir <= 44) {
            index = "E";
        }
        return index;
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
        panelIsi = new javax.swing.JPanel();
        panelCaridata = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_cari_if = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        panelIsi2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_nim_if = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_kehadiran_if = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_nilai_if = new javax.swing.JTable();
        btn_tambah_if = new javax.swing.JButton();
        btn_ubah_if = new javax.swing.JButton();
        btn_hapus_if = new javax.swing.JButton();
        btn_simpan_if = new javax.swing.JButton();
        btn_batal_if = new javax.swing.JButton();
        btn_keluar_if = new javax.swing.JButton();
        cmb_namaMhs_if = new javax.swing.JComboBox<>();
        cmb_NamaMk_if = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_tgs1_if = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_tgs2_if = new javax.swing.JTextField();
        txt_tgs3_if = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_kodeMk_if = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_uts_if = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txt_uas_if = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txt_angkatan_if = new com.toedter.calendar.JYearChooser();
        panelJudul = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        panelIsi.setBackground(new java.awt.Color(255, 255, 255));

        panelCaridata.setBackground(new java.awt.Color(102, 102, 102));
        panelCaridata.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Pencarian Data Nilai Mahasiswa");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Masukan Data");

        txt_cari_if.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cari_ifKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panelCaridataLayout = new javax.swing.GroupLayout(panelCaridata);
        panelCaridata.setLayout(panelCaridataLayout);
        panelCaridataLayout.setHorizontalGroup(
            panelCaridataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCaridataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCaridataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCaridataLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txt_cari_if, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelCaridataLayout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))))
        );
        panelCaridataLayout.setVerticalGroup(
            panelCaridataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCaridataLayout.createSequentialGroup()
                .addGroup(panelCaridataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCaridataLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9))
                    .addGroup(panelCaridataLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCaridataLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCaridataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_cari_if, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        panelIsi2.setBackground(new java.awt.Color(102, 102, 102));
        panelIsi2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nama");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("NIM");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Kehadiran");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nama Mata Kuliah");

        tabel_nilai_if.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_nilai_if.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_nilai_ifMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_nilai_if);

        btn_tambah_if.setBackground(new java.awt.Color(0, 0, 0));
        btn_tambah_if.setForeground(new java.awt.Color(255, 255, 255));
        btn_tambah_if.setText("Tambah");
        btn_tambah_if.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambah_ifActionPerformed(evt);
            }
        });

        btn_ubah_if.setBackground(new java.awt.Color(0, 0, 0));
        btn_ubah_if.setForeground(new java.awt.Color(255, 255, 255));
        btn_ubah_if.setText("Ubah");
        btn_ubah_if.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ubah_ifActionPerformed(evt);
            }
        });

        btn_hapus_if.setBackground(new java.awt.Color(0, 0, 0));
        btn_hapus_if.setForeground(new java.awt.Color(255, 255, 255));
        btn_hapus_if.setText("Hapus");
        btn_hapus_if.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapus_ifActionPerformed(evt);
            }
        });

        btn_simpan_if.setBackground(new java.awt.Color(0, 0, 0));
        btn_simpan_if.setForeground(new java.awt.Color(255, 255, 255));
        btn_simpan_if.setText("Simpan");
        btn_simpan_if.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpan_ifActionPerformed(evt);
            }
        });

        btn_batal_if.setBackground(new java.awt.Color(0, 0, 0));
        btn_batal_if.setForeground(new java.awt.Color(255, 255, 255));
        btn_batal_if.setText("Batal");
        btn_batal_if.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batal_ifActionPerformed(evt);
            }
        });

        btn_keluar_if.setBackground(new java.awt.Color(0, 0, 0));
        btn_keluar_if.setForeground(new java.awt.Color(255, 255, 255));
        btn_keluar_if.setText("Keluar");
        btn_keluar_if.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_keluar_ifActionPerformed(evt);
            }
        });

        cmb_namaMhs_if.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Pilih Nama-" }));
        cmb_namaMhs_if.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_namaMhs_ifActionPerformed(evt);
            }
        });

        cmb_NamaMk_if.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Pilih Mata Kuliah-" }));
        cmb_NamaMk_if.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_NamaMk_ifActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Pertemuan");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Tugas 1");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Tugas 2");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Tugas 3");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Kode MK");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("UTS");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("UAS");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Angkatan");

        javax.swing.GroupLayout panelIsi2Layout = new javax.swing.GroupLayout(panelIsi2);
        panelIsi2.setLayout(panelIsi2Layout);
        panelIsi2Layout.setHorizontalGroup(
            panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIsi2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelIsi2Layout.createSequentialGroup()
                        .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelIsi2Layout.createSequentialGroup()
                                .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addGap(38, 38, 38)
                                .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmb_namaMhs_if, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_nim_if)))
                            .addGroup(panelIsi2Layout.createSequentialGroup()
                                .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(panelIsi2Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_tgs1_if, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelIsi2Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_kehadiran_if, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelIsi2Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_tgs2_if, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelIsi2Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_tgs3_if, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_uas_if, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_uts_if, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_kodeMk_if, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_NamaMk_if, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_angkatan_if, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelIsi2Layout.createSequentialGroup()
                        .addComponent(btn_tambah_if)
                        .addGap(48, 48, 48)
                        .addComponent(btn_ubah_if)
                        .addGap(59, 59, 59)
                        .addComponent(btn_hapus_if)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
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
                .addGap(17, 17, 17)
                .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelIsi2Layout.createSequentialGroup()
                        .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cmb_namaMhs_if, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_nim_if, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_kehadiran_if, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txt_tgs1_if, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txt_tgs2_if, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txt_tgs3_if, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelIsi2Layout.createSequentialGroup()
                        .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cmb_NamaMk_if, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txt_kodeMk_if, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txt_uts_if, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txt_uas_if, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(txt_angkatan_if, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_tambah_if)
                    .addComponent(btn_ubah_if)
                    .addComponent(btn_hapus_if)
                    .addComponent(btn_simpan_if)
                    .addComponent(btn_batal_if)
                    .addComponent(btn_keluar_if))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout panelIsiLayout = new javax.swing.GroupLayout(panelIsi);
        panelIsi.setLayout(panelIsiLayout);
        panelIsiLayout.setHorizontalGroup(
            panelIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelIsiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelIsi2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelCaridata, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelIsiLayout.setVerticalGroup(
            panelIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIsiLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(panelCaridata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelIsi2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelJudul.setBackground(new java.awt.Color(102, 102, 102));
        panelJudul.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("FORM NILAI MAHASISWA");

        javax.swing.GroupLayout panelJudulLayout = new javax.swing.GroupLayout(panelJudul);
        panelJudul.setLayout(panelJudulLayout);
        panelJudulLayout.setHorizontalGroup(
            panelJudulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJudulLayout.createSequentialGroup()
                .addGap(285, 285, 285)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelJudulLayout.setVerticalGroup(
            panelJudulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJudulLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelIsi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelJudul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelIsi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmb_namaMhs_ifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_namaMhs_ifActionPerformed
        // TODO add your handling code here:
        tampil_Mahasiswa();
    }//GEN-LAST:event_cmb_namaMhs_ifActionPerformed

    private void cmb_NamaMk_ifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_NamaMk_ifActionPerformed
        // TODO add your handling code here:
        tampil_Mk();
    }//GEN-LAST:event_cmb_NamaMk_ifActionPerformed

    private void tabel_nilai_ifMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_nilai_ifMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            aktif_teks();
            tampil_field();
        }
    }//GEN-LAST:event_tabel_nilai_ifMouseClicked

    private void btn_tambah_ifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambah_ifActionPerformed
        // TODO add your handling code here:
        membersihkan_teks();
        txt_nim_if.requestFocus();
        btn_simpan_if.setEnabled(true);
        btn_ubah_if.setEnabled(false);
        btn_hapus_if.setEnabled(false);
        btn_keluar_if.setEnabled(false);
        btn_batal_if.setEnabled(true);
        btn_tambah_if.setEnabled(false);

        aktif_teks();
    }//GEN-LAST:event_btn_tambah_ifActionPerformed

    private void btn_simpan_ifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpan_ifActionPerformed
        // TODO add your handling code here:

        String nim = txt_nim_if.getText();
        String kd_mk = txt_kodeMk_if.getText();
        String txtKehadiran = txt_kehadiran_if.getText();
        String txtTugas1 = txt_tgs1_if.getText();
        String txtTugas2 = txt_tgs2_if.getText();
        String txtTugas3 = txt_tgs3_if.getText();
        String txtUts = txt_uts_if.getText();
        String txtUas = txt_uas_if.getText();
        String angkatan = String.valueOf(txt_angkatan_if.getYear());

        //validasi
        if ((nim.isEmpty())) {
            JOptionPane.showMessageDialog(null, "NIM Tidak Boleh Kosong!!!", "WARNING", JOptionPane.WARNING_MESSAGE);
            txt_nim_if.requestFocus();
        } else if (kd_mk.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Kode M.K Tidak Boleh Kosong!!!", "WARNING", JOptionPane.WARNING_MESSAGE);
            txt_kodeMk_if.requestFocus();
        } else if (txtKehadiran.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Kehadiran Tidak Boleh Kosong!!!", "WARNING", JOptionPane.WARNING_MESSAGE);
            txt_kehadiran_if.requestFocus();
        } else if (txtTugas1.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tugas 1 Tidak Boleh Kosong!!!", "WARNING", JOptionPane.WARNING_MESSAGE);
            txt_tgs1_if.requestFocus();
        } else if (txtTugas2.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tugas 2 Tidak Boleh Kosong!!!", "WARNING", JOptionPane.WARNING_MESSAGE);
            txt_tgs2_if.requestFocus();
        } else if (txtTugas3.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tugas 3 Tidak Boleh Kosong!!!", "WARNING", JOptionPane.WARNING_MESSAGE);
            txt_tgs3_if.requestFocus();
        } else if (txtUts.isEmpty()) {
            JOptionPane.showMessageDialog(null, "UTS Tidak Boleh Kosong!!!", "WARNING", JOptionPane.WARNING_MESSAGE);
            txt_uts_if.requestFocus();
        } else if (txtUas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "UAS Tidak Boleh Kosong!!!", "WARNING", JOptionPane.WARNING_MESSAGE);
            txt_uas_if.requestFocus();
        } else if (Integer.valueOf(txtKehadiran) > 14) {
            JOptionPane.showMessageDialog(null, "Maksimal Kehadiran adalah 14!!!", "WARNING", JOptionPane.WARNING_MESSAGE);
            txt_kodeMk_if.requestFocus();
        } else {
            int pilihan = JOptionPane.showOptionDialog(this, "Data yakin sudah benar?",
                    "simpan", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (pilihan == JOptionPane.YES_OPTION) {

                double kehadiran = Double.valueOf(txt_kehadiran_if.getText());
                double tugas_1 = Double.valueOf(txt_tgs1_if.getText());
                double tugas_2 = Double.valueOf(txt_tgs2_if.getText());
                double tugas_3 = Double.valueOf(txt_tgs3_if.getText());
                double uts = Double.valueOf(txt_uts_if.getText());
                double uas = Double.valueOf(txt_uas_if.getText());
                double nilaiAbsen = nilaiAbsen(kehadiran);
                double nilaiTugas = nilaiTugas(tugas_1, tugas_2, tugas_3);
                double nilaiUts = nilaiUts(uts);
                double nilaiUas = nilaiUas(uas);
                double nilaiAkhir = nilaiAbsen + nilaiTugas + nilaiUts + nilaiUas;
                String index = index(nilaiAkhir);
                String keterangan = "";
                if (kehadiran < 11) {
                    keterangan = "TIDAK LULUS";
                } else if ((index == "A" || index == "B" || index == "C") && kehadiran >= 11) {
                    keterangan = "LULUS";
                } else if ((index == "D" || index == "E")) {
                    keterangan = "TIDAK LULUS";
                }

                try {
                    Class.forName(driver);
                    Connection kon = DriverManager.getConnection(
                            database,
                            user,
                            pass);
                    Statement stt = kon.createStatement();
                    String SQL = "INSERT INTO `t_nilai`(`nim`, `kd_mk`, "
                            + "`absensi`, `tgs1`, `tgs2`, `tgs3`, `uts`, `uas`, `"
                            + "nilai_absen`, `nilai_tugas`, `nilai_uts`, `nilai_uas`,"
                            + " `nilai`, `index`, `ket`,`angkatan`) VALUES ('" + nim
                            + "','" + kd_mk + "', '" + kehadiran + "' , "
                            + "'" + tugas_1 + "','" + tugas_2 + "','" + tugas_3 + "','"
                            + uts + "','" + uas + "','" + nilaiAbsen + "','" + nilaiTugas
                            + "','" + nilaiUts + "','" + nilaiUas + "','" + nilaiAkhir
                            + "','" + index + "','" + keterangan + "'," + angkatan + ")";

                    stt.executeUpdate(SQL);

                    tableModel.setRowCount(0);
                    settableload();
                    stt.close();
                    kon.close();
                    membersihkan_teks();
                    btn_simpan_if.setEnabled(false);
                    btn_keluar_if.setEnabled(true);
                    btn_tambah_if.setEnabled(true);
                    nonaktifkan_teks();
                    
                    JOptionPane.showMessageDialog(null, "Data Berhasil Di Simpan","Berhasil", JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,
                            ex.getMessage(), "Error",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }
        }
    }//GEN-LAST:event_btn_simpan_ifActionPerformed

    private void btn_ubah_ifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubah_ifActionPerformed
        // TODO add your handling code here:
        String nim = txt_nim_if.getText();
        String kd_mk = txt_kodeMk_if.getText();
        String txtKehadiran = txt_kehadiran_if.getText();
        String txtTugas1 = txt_tgs1_if.getText();
        String txtTugas2 = txt_tgs2_if.getText();
        String txtTugas3 = txt_tgs3_if.getText();
        String txtUts = txt_uts_if.getText();
        String txtUas = txt_uts_if.getText();
        String angkatan = String.valueOf(txt_angkatan_if.getYear());

        //validasi
        if ((nim.isEmpty())) {
            JOptionPane.showMessageDialog(null, "NIM Tidak Boleh Kosong!!!", "WARNING", JOptionPane.WARNING_MESSAGE);
            txt_nim_if.requestFocus();
        } else if (kd_mk.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Kode M.K Tidak Boleh Kosong!!!", "WARNING", JOptionPane.WARNING_MESSAGE);
            txt_kodeMk_if.requestFocus();
        } else if (txtKehadiran.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Kehadiran Tidak Boleh Kosong!!!", "WARNING", JOptionPane.WARNING_MESSAGE);
            txt_kehadiran_if.requestFocus();
        } else if (txtTugas1.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tugas 1 Tidak Boleh Kosong!!!", "WARNING", JOptionPane.WARNING_MESSAGE);
            txt_tgs1_if.requestFocus();
        } else if (txtTugas2.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tugas 2 Tidak Boleh Kosong!!!", "WARNING", JOptionPane.WARNING_MESSAGE);
            txt_tgs2_if.requestFocus();
        } else if (txtTugas3.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tugas 3 Tidak Boleh Kosong!!!", "WARNING", JOptionPane.WARNING_MESSAGE);
            txt_tgs3_if.requestFocus();
        } else if (txtUts.isEmpty()) {
            JOptionPane.showMessageDialog(null, "UTS Tidak Boleh Kosong!!!", "WARNING", JOptionPane.WARNING_MESSAGE);
            txt_uts_if.requestFocus();
        } else if (txtUas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "UAS Tidak Boleh Kosong!!!", "WARNING", JOptionPane.WARNING_MESSAGE);
            txt_uas_if.requestFocus();
        } else if (Integer.valueOf(txtKehadiran) > 14) {
            JOptionPane.showMessageDialog(null, "Maksimal Kehadiran adalah 14!!!", "WARNING", JOptionPane.WARNING_MESSAGE);
            txt_kodeMk_if.requestFocus();
        } else {
            int pilihan = JOptionPane.showOptionDialog(this, "Yakin ingin diubah?",
                    "Ubah", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (pilihan == JOptionPane.YES_OPTION) {

                double kehadiran = Double.valueOf(txt_kehadiran_if.getText());
                double tugas_1 = Double.valueOf(txt_tgs1_if.getText());
                double tugas_2 = Double.valueOf(txt_tgs2_if.getText());
                double tugas_3 = Double.valueOf(txt_tgs3_if.getText());
                double uts = Double.valueOf(txt_uts_if.getText());
                double uas = Double.valueOf(txt_uas_if.getText());
                double nilaiAbsen = nilaiAbsen(kehadiran);
                double nilaiTugas = nilaiTugas(tugas_1, tugas_2, tugas_3);
                double nilaiUts = nilaiUts(uts);
                double nilaiUas = nilaiUas(uas);
                double nilaiAkhir = nilaiAbsen + nilaiTugas + nilaiUts + nilaiUas;
                String index = index(nilaiAkhir);
                String keterangan = "";
                if (kehadiran < 11) {
                    keterangan = "TIDAK LULUS";
                } else if ((index == "A" || index == "B" || index == "C") && kehadiran >= 11) {
                    keterangan = "LULUS";
                } else if ((index == "D" || index == "E")) {
                    keterangan = "TIDAK LULUS";
                }

                try {
                    Class.forName(driver);
                    Connection kon = DriverManager.getConnection(
                            database,
                            user,
                            pass);
                    Statement stt = kon.createStatement();
                    String SQL = "UPDATE `t_nilai` SET `nim`='" + nim + "',"
                            + "`kd_mk`='" + kd_mk + "',"
                            + "`absensi`='" + kehadiran + "',"
                            + "`tgs1`='" + tugas_1 + "',"
                            + "`tgs2`='" + tugas_2 + "',"
                            + "`tgs3`='" + tugas_3 + "',"
                            + "`uts`='" + uts + "',"
                            + "`uas`='" + uas + "',"
                            + "`nilai_absen`='" + nilaiAbsen + "',"
                            + "`nilai_tugas`='" + nilaiTugas + "',"
                            + "`nilai_uts`='" + nilaiUts + "',"
                            + "`nilai_uas`='" + nilaiUas + "',"
                            + "`nilai`='" + nilaiAkhir + "',"
                            + "`index`='" + index + "',"
                            + "`ket`='" + keterangan + "',"
                            + "`angkatan`=" + angkatan + ""
                            + " WHERE kd_nilai = '" + tableModel.getValueAt(row, 0).toString() + "'";
                    stt.executeUpdate(SQL);

                    tableModel.setRowCount(0);
                    settableload();
                    stt.close();
                    kon.close();
                    membersihkan_teks();
                    btn_simpan_if.setEnabled(false);
                    btn_ubah_if.setEnabled(false);
                    btn_hapus_if.setEnabled(false);
                    btn_tambah_if.setEnabled(true);
                    nonaktifkan_teks();
                    
                    JOptionPane.showMessageDialog(null, "Data Berhasil Di Ubah","Berhasil", JOptionPane.INFORMATION_MESSAGE);

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

        int pilihan = JOptionPane.showOptionDialog(this, "Yakin ingin dihapus?",
                "Hapus", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        if (pilihan == JOptionPane.YES_OPTION) {
            try {
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(
                        database,
                        user,
                        pass);
                Statement stt = kon.createStatement();
                String SQL = "Delete From t_nilai where kd_nilai='"
                        + tableModel.getValueAt(row, 0).toString() + "'";

                stt.executeUpdate(SQL);
                tableModel.setRowCount(0);
                settableload();;
                stt.close();
                kon.close();
                membersihkan_teks();
                btn_simpan_if.setEnabled(false);
                btn_ubah_if.setEnabled(false);
                btn_hapus_if.setEnabled(false);
                btn_tambah_if.setEnabled(true);
                nonaktifkan_teks();

                JOptionPane.showMessageDialog(null, "Data Berhasil Di Hapus", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_btn_hapus_ifActionPerformed

    private void btn_batal_ifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batal_ifActionPerformed
        // TODO add your handling code here:
        membersihkan_teks();
        nonaktifkan_teks();
        btn_simpan_if.setEnabled(false);
        btn_ubah_if.setEnabled(false);
        btn_hapus_if.setEnabled(false);
        btn_keluar_if.setEnabled(true);
        btn_batal_if.setEnabled(false);
        btn_tambah_if.setEnabled(true);
    }//GEN-LAST:event_btn_batal_ifActionPerformed

    private void txt_cari_ifKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cari_ifKeyReleased
        // TODO add your handling code here:
        tableModel.setRowCount(0);
        String cari = txt_cari_if.getText();

        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(
                    database,
                    user,
                    pass);
            Statement stt = kon.createStatement();
            String SQL = "SELECT t_mahasiswa.nama,t_mata_kuliah.nama_mk,"
                    + "t_nilai.* FROM t_mahasiswa JOIN t_nilai USING (nim) JOIN "
                    + "t_mata_kuliah using (kd_mk) WHERE t_mahasiswa.nama LIKE "
                    + "'%" + cari + "%' OR t_mata_kuliah.nama_mk LIKE "
                    + "'%" + cari + "%'";

            ResultSet res = stt.executeQuery(SQL);
            while (res.next()) {
                data[0] = res.getString("kd_nilai");
                data[1] = res.getString("nama");
                data[2] = res.getString("nama_mk");
                data[3] = res.getString("absensi");
                data[4] = res.getString("tgs1");
                data[5] = res.getString("tgs2");
                data[6] = res.getString("tgs3");
                data[7] = res.getString("uts");
                data[8] = res.getString("uas");
                data[9] = res.getString("nilai_absen");
                data[10] = res.getString("nilai_tugas");
                data[11] = res.getString("nilai_uts");
                data[12] = res.getString("nilai_uas");
                data[13] = res.getString("nilai");
                data[14] = res.getString("index");
                data[15] = res.getString("ket");

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
    }//GEN-LAST:event_txt_cari_ifKeyReleased

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
            java.util.logging.Logger.getLogger(frame_nilai_if_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frame_nilai_if_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frame_nilai_if_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frame_nilai_if_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frame_nilai_if_1().setVisible(true);
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
    private javax.swing.JComboBox<String> cmb_NamaMk_if;
    private javax.swing.JComboBox<String> cmb_namaMhs_if;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel panelCaridata;
    private javax.swing.JPanel panelIsi;
    private javax.swing.JPanel panelIsi2;
    private javax.swing.JPanel panelJudul;
    private javax.swing.JTable tabel_nilai_if;
    private com.toedter.calendar.JYearChooser txt_angkatan_if;
    private javax.swing.JTextField txt_cari_if;
    private javax.swing.JTextField txt_kehadiran_if;
    private javax.swing.JTextField txt_kodeMk_if;
    private javax.swing.JTextField txt_nim_if;
    private javax.swing.JTextField txt_tgs1_if;
    private javax.swing.JTextField txt_tgs2_if;
    private javax.swing.JTextField txt_tgs3_if;
    private javax.swing.JTextField txt_uas_if;
    private javax.swing.JTextField txt_uts_if;
    // End of variables declaration//GEN-END:variables

}
