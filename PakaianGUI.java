/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bab10CRUD;

import bab10CRUD.BajuGUI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class PakaianGUI extends javax.swing.JFrame {
 //Mengambil nilai dari class untuk digunakan pada Gui_Invetory_Baju = new InventoryBaju(); 
     public Connection conn;
    String jenis, ukuran,penyewa;
    int Harga;
    String Lastjenis, Lastukuran, Lastharga, LastPenyewa;
    /**
     * Creates new form PakaianGUI
     */
    public PakaianGUI() {
        initComponents();
        koneksi();
        tampil();
        tampil_Baju();
        txtjenis.requestFocus();
        
    }
    public void koneksi() {
        try {
            conn = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/oop_inven?user=root&password=");
        } catch (SQLException e) {
            Logger.getLogger(PakaianGUI.class.getName()).log(Level.SEVERE, null, e);
        } catch (Exception es) {
            Logger.getLogger(PakaianGUI.class.getName()).log(Level.SEVERE, null, es);
        }
    }
    public void tampil() {
        DefaultTableModel tabelhead = new DefaultTableModel();
        tabelhead.addColumn("Jenis_Pakaian");
        tabelhead.addColumn("Ukuran");
        tabelhead.addColumn("Harga");
       
        
        try {
            koneksi();
            String sql = "SELECT * FROM tb_pakaian";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while (res.next()) {
                tabelhead.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3),});
            }
            tbl_model.setModel(tabelhead);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "BELUM TERKONEKSI");
        }
    }



    public void tampil_Baju() {
        try {
            String sql = "SELECT tb_pakaian FROM tb_baju order by Jenis_Baju asc";
            Statement stt = conn.createStatement();
            ResultSet res = stt.executeQuery(sql);
            while (res.next()) {
                Object[] ob = new Object[3];
                ob[0] = res.getString(1);
                jComboBox1.addItem((String) ob[0]);
            }
            res.close();
            stt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void insert() {
        try {
            jenis = txtjenis.getText();
            penyewa = jComboBox1.getSelectedItem().toString();
            Harga = Integer.parseInt(txtharga.getText());
           ukuran= txtukuran.getText();
            Statement statement = conn.createStatement();
           statement.executeUpdate("INSERT INTO tb_pakaian VALUES('" + jenis + "','" + penyewa + "','"  + Harga + "')");
            statement.close();
            JOptionPane.showMessageDialog(null, "Berhasil Memasukan Data Transaksi!" + "\n");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
        refresh();
    }

    public void update() {
        jenis = txtjenis.getText();
        penyewa = jComboBox1.getSelectedItem().toString();
        Harga = Integer.parseInt(txtharga.getText());
        ukuran = txtukuran.getText();
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("UPDATE tb_pakaian SET Jenis_Pakaian='" + jenis + "'," + "Ukuran='" + ukuran + "',"
                    + "Harga='" + Harga + "' WHERE Jenis_Pakaian = '" + Lastjenis + "'");
            statement.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "Update Data Transaksi Berhasil!");
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        refresh();
    }

    public void delete() {
        int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin akan menghapus data ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            try {
                String sql = "DELETE FROM tb_pakaian WHERE Jenis_Pakaian='" + Lastjenis + "'";
                java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Transaksi Berhasil di hapus");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error : " + e);
            }
        }
        refresh();
    }

    public void cari() {
        try {
            try (Statement statement = conn.createStatement()) {
                String sql = "SELECT * FROM tb_pakaian WHERE `Jenis_Pakaian`  LIKE '%" + txtCari.getText() + "%'";
                ResultSet rs = statement.executeQuery(sql); //menampilkan data dari sql query
                if (rs.next()) // .next() = scanner method
                {
                    txtjenis.setText(rs.getString(1));
                    jComboBox1.setSelectedItem(rs.getString(2));
                    txtharga.setText(rs.getString(4));
                    txtukuran.setText(rs.getString(5));
                } else {
                    JOptionPane.showMessageDialog(null, "Data yang Anda cari tidak ada");
                }
            }
        } catch (Exception ex) {
            System.out.println("Error." + ex);
        }
    }

    public void refresh() {
        new PakaianGUI().setVisible(true);
        this.setVisible(false);
    }

    public void clear() {
        txtjenis.setText("");
       jComboBox1.setSelectedIndex(0);
        txtharga.setText("");
        txtukuran.setText("");

        Lastjenis = "";
        LastPenyewa = "";
        Lastharga = "";
        Lastukuran= "";
    }
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtukuran = new javax.swing.JTextField();
        txtharga = new javax.swing.JTextField();
        btncek = new javax.swing.JButton();
        txtjenis = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_model = new javax.swing.JTable();
        txt_hps = new javax.swing.JButton();
        txt_btl = new javax.swing.JButton();
        txt_cls = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        txt_jenis = new javax.swing.JButton();
        btnCari = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Inventory Pakaian");

        jLabel2.setText("Jenis Pakaian");

        jLabel3.setText("Ukuran");

        jLabel4.setText("Harga");

        txtukuran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtukuranActionPerformed(evt);
            }
        });

        txtharga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthargaActionPerformed(evt);
            }
        });

        btncek.setText("Cek");
        btncek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncekActionPerformed(evt);
            }
        });

        tbl_model.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Jenis Pakaian", "Harga", "Ukuran"
            }
        ));
        tbl_model.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_modelMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_model);

        txt_hps.setText("Hapus");
        txt_hps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hpsActionPerformed(evt);
            }
        });

        txt_btl.setText("Batal");
        txt_btl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_btlActionPerformed(evt);
            }
        });

        txt_cls.setText("Close");
        txt_cls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_clsActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--jenis" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        txt_jenis.setText("Jenis Baju");

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btncek)
                        .addGap(18, 18, 18)
                        .addComponent(txt_hps)
                        .addGap(18, 18, 18)
                        .addComponent(txt_btl))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(txt_jenis))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtjenis, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtukuran)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtharga, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(txt_cls))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(85, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtjenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtukuran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_jenis)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCari)
                            .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncek, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_hps)
                    .addComponent(txt_btl)
                    .addComponent(txt_cls))
                .addContainerGap(391, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtukuranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtukuranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtukuranActionPerformed

    private void txthargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthargaActionPerformed

    private void btncekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncekActionPerformed
        // TODO add your handling code here:
        // Menampilkan pesan dialog bahwa data telah ditambahkan ke tabel
       insert();
    }//GEN-LAST:event_btncekActionPerformed

    private void txt_clsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_clsActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_txt_clsActionPerformed

    private void txt_btlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_btlActionPerformed
        // TODO add your handling code here:
      clear();
        
    }//GEN-LAST:event_txt_btlActionPerformed

    private void txt_hpsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hpsActionPerformed
        delete();

    }//GEN-LAST:event_txt_hpsActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        cari();
    }//GEN-LAST:event_btnCariActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void tbl_modelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_modelMouseClicked
        // TODO add your handling code here:
        int tabel = tbl_model.getSelectedRow();
        Lastjenis = tbl_model.getValueAt(tabel, 0).toString();
        LastPenyewa = tbl_model.getValueAt(tabel, 1).toString();
        Lastharga = tbl_model.getValueAt(tabel, 2).toString();
        ukuran = tbl_model.getValueAt(tabel, 3).toString();
        

        txtjenis.setText(Lastjenis);
        jComboBox1.setSelectedItem(LastPenyewa);
        txtharga.setText(Lastharga);
        txtukuran.setText(Lastukuran);
    }//GEN-LAST:event_tbl_modelMouseClicked

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
            java.util.logging.Logger.getLogger(PakaianGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PakaianGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PakaianGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PakaianGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PakaianGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btncek;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_model;
    private javax.swing.JTextField txtCari;
    private javax.swing.JButton txt_btl;
    private javax.swing.JButton txt_cls;
    private javax.swing.JButton txt_hps;
    private javax.swing.JButton txt_jenis;
    private javax.swing.JTextField txtharga;
    private javax.swing.JTextField txtjenis;
    private javax.swing.JTextField txtukuran;
    // End of variables declaration//GEN-END:variables
}
