/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gofood;

import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import koneksi.conek;

/**
 *
 * @author Naufal
 */
public class Order_menu extends javax.swing.JFrame {

    Model objek = new Model();
    private String id_restoran = objek.getUser();
    private int row;
    private void showTable(){
        DefaultTableModel tbl = new DefaultTableModel(){
                                public Class getColumnClass(int c) {
                                  switch (c) {
                                    case 0: return Boolean.class;
                                    default: return String.class;
                                  }   
                                } };
        tbl.addColumn("Pilih");
        tbl.addColumn("id_user");
        tbl.addColumn("An.");
        tbl.addColumn("kode_pesanan");
        tbl.addColumn("id_menu");
        tbl.addColumn("Menu");
        tbl.addColumn("Jumlah");
        tbl.addColumn("Harga");
        tbl.addColumn("Total");
        tbl.addColumn("Waktu");
        tbl.addColumn("Keterangan");
        tbl_terima.setModel(tbl);
        tbl_terima.getColumnModel().getColumn(0).setPreferredWidth(20);
        tbl_terima.getColumnModel().getColumn(2).setPreferredWidth(100);
        tbl_terima.getColumnModel().removeColumn(tbl_terima.getColumnModel().getColumn(1));
        tbl_terima.getColumnModel().removeColumn(tbl_terima.getColumnModel().getColumn(2));
        tbl_terima.getColumnModel().removeColumn(tbl_terima.getColumnModel().getColumn(2));
        
        tbl_terima.setShowHorizontalLines(true);
        try{
            Statement st = (Statement) conek.GetConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM data_pesanan WHERE id_restoran='"+id_restoran+"' AND status='Diantar'");
            while(rs.next()){
                tbl.addRow(new Object []{
                    false,
                    rs.getString("id_user"),
                    rs.getString("An."),
                    rs.getString("kode_pesanan"),
                    rs.getString("id_menu"),
                    rs.getString("menu_pesan"),
                    rs.getString("jumlah"),
                    objek.formatUang(rs.getString("harga")),
                    objek.formatUang(rs.getString("total")),
                    rs.getString("waktu"),
                    rs.getString("keterangan")
                });
                tbl_terima.setModel(tbl);
            }
            rs.close();
        }catch(SQLException e){
            e.getStackTrace();
            JOptionPane.showMessageDialog(null, "Pencarian gagal");
        }
        row = tbl.getRowCount();
        tbl_terima.setDefaultEditor(Object.class, null);
        showTable(tbl_terkirim,"Terkirim");
        showTable(tbl_batal,"Dibatalkan");
    }
    
    private void showTable(JTable table, String tbl_stat){
        try{
                Statement statement = (Statement) conek.GetConnection().createStatement();
                ResultSet res = statement.executeQuery("SELECT * FROM data_pesanan WHERE id_restoran='"+id_restoran+"' AND status='"+tbl_stat+"'");
                DefaultTableModel tbl = new DefaultTableModel();
                tbl.addColumn("An.");
                tbl.addColumn("Menu");
                tbl.addColumn("Jumlah");
                tbl.addColumn("Harga");
                tbl.addColumn("Total");
                tbl.addColumn("Waktu");
                tbl.addColumn("Keterangan");
                table.setModel(tbl);
                while (res.next()){
                    tbl.addRow(new Object []{
                        res.getString("An."),
                        res.getString("menu_pesan"),
                        res.getString("jumlah"),
                        objek.formatUang(res.getString("harga")),
                        objek.formatUang(res.getString("total")),
                        res.getString("keterangan"),
                    });
                    table.setModel(tbl);
                }
                table.setShowHorizontalLines(true);
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(rootPane, "Tabel Error!!!");
                }
        table.setDefaultEditor(Object.class, null);
    }
    public Order_menu() {
        initComponents();
        showTable();
        ireport_diterima.setIcon(objek.setUkuran(ireport_diterima, "img\\show-ireport.png"));
        ireport_terkirim.setIcon(objek.setUkuran(ireport_terkirim, "img\\show-ireport.png"));
        ireport_batal.setIcon(objek.setUkuran(ireport_batal, "img\\show-ireport.png"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        ireport_diterima = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_terima = new javax.swing.JTable();
        pil_semua = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_terkirim = new javax.swing.JTable();
        ireport_terkirim = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_batal = new javax.swing.JTable();
        ireport_batal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTabbedPane1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        ireport_diterima.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ireport_diterima.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ireport_diterimaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ireport_diterimaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ireport_diterimaMouseReleased(evt);
            }
        });

        tbl_terima.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_terima.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tbl_terima.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_terimaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_terima);

        pil_semua.setBackground(new java.awt.Color(255, 255, 255));
        pil_semua.setText("Pilih Semua");
        pil_semua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pil_semua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pil_semuaActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("Kirimkan Pesanan Terpilih");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setText("Batalkan Pesan terpilih");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("* Double klik untuk melihat Detail pesanan");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(pil_semua)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 259, Short.MAX_VALUE)
                        .addComponent(ireport_diterima, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(11, 11, 11))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ireport_diterima, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pil_semua)
                            .addComponent(jButton1)
                            .addComponent(jButton2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Pesanan Diterima", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tbl_terkirim.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_terkirim.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tbl_terkirim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_terkirimMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_terkirim);

        ireport_terkirim.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ireport_terkirim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ireport_terkirimMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ireport_terkirimMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ireport_terkirimMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ireport_terkirim, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ireport_terkirim, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Pesanan Terkirim ", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tbl_batal.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_batal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tbl_batal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_batalMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_batal);

        ireport_batal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ireport_batal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ireport_batalMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ireport_batalMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ireport_batalMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ireport_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ireport_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Pesanan Batal ", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ireport_diterimaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ireport_diterimaMouseClicked
        String command = "SELECT * FROM data_pesanan WHERE id_restoran='"+id_restoran+"' AND status='Diantar'";
        String laporan = "order.jrxml";
        objek.getLaporan(command, laporan);
    }//GEN-LAST:event_ireport_diterimaMouseClicked

    private void ireport_diterimaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ireport_diterimaMousePressed
        ireport_diterima.setIcon(objek.setUkuran(ireport_diterima, "img\\show-ireport-clicked.png"));
    }//GEN-LAST:event_ireport_diterimaMousePressed

    private void ireport_diterimaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ireport_diterimaMouseReleased
        ireport_diterima.setIcon(objek.setUkuran(ireport_diterima, "img\\show-ireport.png"));
    }//GEN-LAST:event_ireport_diterimaMouseReleased

    private void ireport_terkirimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ireport_terkirimMouseClicked
        String command = "SELECT * FROM data_pesanan WHERE id_restoran='"+id_restoran+"' AND status='Terkirim'";
        String laporan = "order.jrxml";
        objek.getLaporan(command, laporan);
    }//GEN-LAST:event_ireport_terkirimMouseClicked

    private void ireport_terkirimMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ireport_terkirimMousePressed
        ireport_terkirim.setIcon(objek.setUkuran(ireport_terkirim, "img\\show-ireport-clicked.png"));
    }//GEN-LAST:event_ireport_terkirimMousePressed

    private void ireport_terkirimMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ireport_terkirimMouseReleased
        ireport_terkirim.setIcon(objek.setUkuran(ireport_terkirim, "img\\show-ireport.png"));
    }//GEN-LAST:event_ireport_terkirimMouseReleased

    private void ireport_batalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ireport_batalMouseClicked
        String command = "SELECT * FROM data_pesanan WHERE id_restoran='"+id_restoran+"' AND status='DiBatalkan'";
        String laporan = "order.jrxml";
        objek.getLaporan(command, laporan);
    }//GEN-LAST:event_ireport_batalMouseClicked

    private void ireport_batalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ireport_batalMousePressed
        ireport_batal.setIcon(objek.setUkuran(ireport_batal, "img\\show-ireport-clicked.png"));
    }//GEN-LAST:event_ireport_batalMousePressed

    private void ireport_batalMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ireport_batalMouseReleased
        ireport_batal.setIcon(objek.setUkuran(ireport_batal, "img\\show-ireport.png"));
    }//GEN-LAST:event_ireport_batalMouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TableModel model = tbl_terima.getModel();
        ArrayList<String> kode = new ArrayList<>();
        ArrayList<String> id_menu = new ArrayList<>();
        ArrayList<String> menu = new ArrayList<>();
        ArrayList<String> id_user = new ArrayList<>();
        int n = 0;
        for (int i = 0; i < row; i++) {
            System.out.println(model.getValueAt(i, 0).toString());
            if(Boolean.valueOf(model.getValueAt(i, 0).toString())){
                id_user.add(model.getValueAt(i, 1).toString());
                kode.add(model.getValueAt(i, 3).toString());
                id_menu.add(model.getValueAt(i, 4).toString());
                menu.add(model.getValueAt(i, 5).toString());
                n++;
            }
        }
        if(n>0){
            String kondisi;
            String restoran = objek.getString("restoran", "id_restoran='"+id_restoran+"'", "restoran");
            for (int i = 0; i < kode.size(); i++) {
                kondisi = "kode_pesanan='"+kode.get(i)+"' AND id_menu='"+id_menu.get(i)+"'";
                objek.editRow("data_pesanan", "status='Terkirim'", kondisi, null, null);
                objek.setTabel("pesan", "NULL,'"+id_user.get(i)+"','"+restoran+"','Pesanan "+menu.get(i)+" telah dikirim. Selamat menikmati',1", null, "Pesanan Gagal terkirim");
            }
            showTable();
            pil_semua.setSelected(false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void pil_semuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pil_semuaActionPerformed
        TableModel model = tbl_terima.getModel();
        if(pil_semua.isSelected()){
            for (int i = 0; i < model.getRowCount(); i++) {
                model.setValueAt(true, i, 0);
            }
        }else{
            for (int i = 0; i < model.getRowCount(); i++) {
                model.setValueAt(false, i, 0);
            }
        }
    }//GEN-LAST:event_pil_semuaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        TableModel model = tbl_terima.getModel();
        ArrayList<String> kode = new ArrayList<>();
        ArrayList<String> id_menu = new ArrayList<>();
        ArrayList<String> menu = new ArrayList<>();
        ArrayList<String> id_user = new ArrayList<>();
        ArrayList<Integer> biaya = new ArrayList<>();
        int n = 0;
        for (int i = 0; i < row; i++) {
            if(Boolean.valueOf(model.getValueAt(i, 0).toString())){
                id_user.add(model.getValueAt(i, 1).toString());
                kode.add(model.getValueAt(i, 3).toString());
                id_menu.add(model.getValueAt(i, 4).toString());
                biaya.add(Integer.parseInt(model.getValueAt(i, 8).toString().replace(".", "")));
                menu.add(model.getValueAt(i, 5).toString());
                n++;
            }
        }
        if(n>0){
            String message = "Pesanan yang dibatalkan tidak dapat diubah Dan Uang akan di kebalikan ke pelanggan.\nApakah Anda Yakin Membatalkan pesanan?";
            int confirm = JOptionPane.showConfirmDialog(null, message,"Pembatalan",JOptionPane.YES_NO_OPTION);
            if(confirm==0){
                String kondisi;
                String restoran = objek.getString("restoran", "id_restoran='"+id_restoran+"'", "restoran");
                int saldo;
                String smg = objek.getKey();
                for (int i = 0; i < n; i++) {
                    saldo = objek.getInt("user", "username='"+id_user.get(i)+"'", "saldo");
                    saldo += biaya.get(i);
                    objek.editRow("user", "saldo="+saldo, "username='"+id_user.get(i)+"'", null, "Gagal Menambahkan Saldo");
                    kondisi = "kode_pesanan='"+kode.get(i)+"' AND id_menu='"+id_menu.get(i)+"'";
                    objek.editRow("data_pesanan", "status='Dibatalkan'", kondisi, null, null);
                    message = "Maaf, Pesanan "+menu.get(i)+" kami batalkan.\n Uang Sebesar Rp."+biaya.get(i)+" kami kembalikan. \n\n kode pesanan:"+kode.get(i);
                    objek.setTabel("pesan", "NULL,'"+id_user.get(i)+"','"+restoran+"','"+message+"',1", null, "Gagal Mengrimkan Pesan");
                }
            }
            showTable();
            pil_semua.setSelected(false);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbl_terimaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_terimaMouseClicked
        if(evt.getClickCount()==2){
            int index = tbl_terima.getSelectedRow();
            TableModel model = tbl_terima.getModel();
            String nama = model.getValueAt(index, 2).toString();
            String menu = model.getValueAt(index, 5).toString();
            String jumlah = model.getValueAt(index, 6).toString();
            String harga = model.getValueAt(index, 7).toString();
            String total = model.getValueAt(index, 8).toString();
            String keterangan = model.getValueAt(index, 10).toString();
            String Message = "Atas Nama : "+nama+"\n"
                    + "Menu : "+menu+"\n"
                    + "Jumlah Pesanan : "+jumlah+"\n"
                    + "harga : "+harga+"\n"
                    + "Total Harga : "+total+"\n"
                    + "Keterangan : "+keterangan;
            JOptionPane.showMessageDialog(null, Message, "Info Pesanan", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_tbl_terimaMouseClicked

    private void tbl_terkirimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_terkirimMouseClicked
        int index = tbl_terkirim.getSelectedRow();
        TableModel model = tbl_terkirim.getModel();
        String nama = model.getValueAt(index, 0).toString();
        String menu = model.getValueAt(index, 1).toString();
        String jumlah = model.getValueAt(index, 2).toString();
        String harga = model.getValueAt(index, 3).toString();
        String total = model.getValueAt(index, 4).toString();
        String keterangan = model.getValueAt(index, 5).toString();
        String Message = "Atas Nama : "+nama+"\n"
                + "Menu : "+menu+"\n"
                + "Jumlah Pesanan : "+jumlah+"\n"
                + "harga : "+harga+"\n"
                + "Total Harga : "+total+"\n"
                + "Keterangan : "+keterangan;
        JOptionPane.showMessageDialog(null, Message, "Info Pesanan", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_tbl_terkirimMouseClicked

    private void tbl_batalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_batalMouseClicked
        int index = tbl_terkirim.getSelectedRow();
        TableModel model = tbl_terkirim.getModel();
        String nama = model.getValueAt(index, 0).toString();
        String menu = model.getValueAt(index, 1).toString();
        String jumlah = model.getValueAt(index, 2).toString();
        String harga = model.getValueAt(index, 3).toString();
        String total = model.getValueAt(index, 4).toString();
        String keterangan = model.getValueAt(index, 5).toString();
        String Message = "Atas Nama : "+nama+"\n"
                + "Menu : "+menu+"\n"
                + "Jumlah Pesanan : "+jumlah+"\n"
                + "harga : "+harga+"\n"
                + "Total Harga : "+total+"\n"
                + "Keterangan : "+keterangan;
        JOptionPane.showMessageDialog(null, Message, "Info Pesanan", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_tbl_batalMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        new AdminFrame().setVisible(true);
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(Order_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Order_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Order_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Order_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Order_menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ireport_batal;
    private javax.swing.JLabel ireport_diterima;
    private javax.swing.JLabel ireport_terkirim;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JCheckBox pil_semua;
    private javax.swing.JTable tbl_batal;
    private javax.swing.JTable tbl_terima;
    private javax.swing.JTable tbl_terkirim;
    // End of variables declaration//GEN-END:variables
}
