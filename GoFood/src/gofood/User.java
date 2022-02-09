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
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import koneksi.conek;

/**
 *
 * @author Naufal
 */
public class User extends javax.swing.JFrame {

    Model objek = new Model();
    private String user = objek.getUser();
    private void tabvisible(){
        P_favorite.setVisible(false);
        P_antar.setVisible(false);
        P_terkirim.setVisible(false);
        P_batal.setVisible(false);
    }
    private int showTable(){
        DefaultTableModel tbl = new DefaultTableModel(){
                                    public Class getColumnClass(int c) {
                                      switch (c) {
                                        case 0: return Boolean.class;
                                        default: return String.class;
                                      }   
                                    } };
        tbl.addColumn("Pilih");
        tbl.addColumn("id_menu");
        tbl.addColumn("Restoran");
        tbl.addColumn("Menu");
        tbl.addColumn("Harga");
        TFav.setModel(tbl);
        TFav.getColumnModel().getColumn(0).setMaxWidth(40);
        TFav.getColumnModel().getColumn(2).setMaxWidth(80);
        TFav.getColumnModel().getColumn(4).setMaxWidth(100);
        TableColumnModel tcm = TFav.getColumnModel();
        tcm.removeColumn(tcm.getColumn(1));
        TFav.setShowHorizontalLines(true);
        TFav.setDefaultEditor(Object.class, null);
        try{
            Statement statement = (Statement) conek.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM favorite WHERE user='"+user+"'");
            while(res.next()){
                tbl.addRow(new Object []{
                    false,
                    res.getString("id_menu"),
                    res.getString("restoran"),
                    res.getString("menu"),
                    "Rp."+objek.formatUang(res.getString("Harga"))
                });
                TFav.setModel(tbl);
            }
        }catch(SQLException e){}
        return tbl.getRowCount();
    }
    private int showTable(JTable table, String kondisi){
        DefaultTableModel tbl = new DefaultTableModel(){
                                    public Class getColumnClass(int c) {
                                      switch (c) {
                                        case 0: return Boolean.class;
                                        default: return String.class;
                                      }   
                                    } };
        tbl.addColumn("Pilih");
        tbl.addColumn("kode Pesanan");
        tbl.addColumn("Total Harga");
        tbl.addColumn("Waktu");
        table.setModel(tbl);
        table.getColumnModel().getColumn(0).setMaxWidth(40);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.setShowHorizontalLines(true);
        table.setDefaultEditor(Object.class, null);
        ArrayList<String> kode = new ArrayList<String>();
        try{
            Statement statement = (Statement) conek.GetConnection().createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM data_pesanan WHERE id_user='"+user+"' AND status='"+kondisi+"'");
            while(rs.next()){
                if(!kode.contains(rs.getString("kode_pesanan"))){
                    tbl.addRow(new Object []{
                        false,
                        rs.getString("kode_pesanan"),
                        "Rp "+objek.formatUang(rs.getString("total")),
                        rs.getString("waktu"),
                    });
                    kode.add(rs.getString("kode_pesanan"));
                    table.setModel(tbl);
                }
            }
        }catch(SQLException e){}
        return tbl.getRowCount();
    }
    
    private int row1, row2, row3, row4;
    public User() {
        initComponents();
        profile.setIcon(objek.setUkuran(profile, objek.getString("user", "username='"+user+"'", "profile")));
        home.setIcon(objek.setUkuran(home,"img\\Home.png"));
        akun.setIcon(objek.setUkuran(akun,"img\\Akun.png"));
        name.setText(objek.getString("user", "username='"+user+"'", "nama"));
        username.setText(user);
        ireport_fav.setIcon(objek.setUkuran(ireport_fav, "img\\show-ireport.png"));
        ireport_antar.setIcon(objek.setUkuran(ireport_antar, "img\\show-ireport.png"));
        ireport_terkirim.setIcon(objek.setUkuran(ireport_terkirim, "img\\show-ireport.png"));
        ireport_batal.setIcon(objek.setUkuran(ireport_batal, "img\\show-ireport.png"));
        setting.setIcon(objek.setUkuran(setting, "img\\setting.png"));
        if(objek.getString("data_pesanan", "id_user='"+user+"' AND status='Dipesan'", "id_user")==null){
            pesanan.setIcon(objek.setUkuran(pesanan,"img\\pesan.png"));
        }else{
            pesanan.setIcon(objek.setUkuran(pesanan,"img\\apesan.png"));
        }
        if(objek.getString("pesan", "baca=1 AND id_user='"+user+"'", "pesan")==null){
            inbox.setIcon(objek.setUkuran(inbox, "img\\read.png")); 
        }else{
            inbox.setIcon(objek.setUkuran(inbox, "img\\unread.png"));
        }
        tabvisible();
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
        inbox = new javax.swing.JLabel();
        profile = new javax.swing.JLabel();
        setting = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        ireport_fav = new javax.swing.JLabel();
        P_favorite = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TFav = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        pil_fav = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        ireport_antar = new javax.swing.JLabel();
        P_antar = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TDiantar = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        pil_antar = new javax.swing.JCheckBox();
        P_terkirim = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TKirim = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        pil_kirim = new javax.swing.JCheckBox();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        ireport_terkirim = new javax.swing.JLabel();
        P_batal = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TBatal = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        pil_batal = new javax.swing.JCheckBox();
        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        ireport_batal = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        home = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        pesanan = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        akun = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        inbox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inbox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inboxMouseClicked(evt);
            }
        });

        profile.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        setting.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                settingMouseClicked(evt);
            }
        });

        name.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name.setText("Klik Untuk Ubah Nama");
        name.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        name.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        username.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        username.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        username.setText("username");
        username.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3FavoriteMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setText("Favorite");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3FavoriteMouseClicked(evt);
            }
        });

        ireport_fav.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ireport_fav.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ireport_favMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ireport_favMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ireport_favMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(106, 106, 106)
                .addComponent(ireport_fav, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ireport_fav, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );

        P_favorite.setBackground(new java.awt.Color(255, 255, 255));
        P_favorite.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        TFav.setModel(new javax.swing.table.DefaultTableModel(
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
        TFav.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TFav.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TFavMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TFav);

        jButton1.setText("Hapus yang terpilih");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        pil_fav.setBackground(new java.awt.Color(255, 255, 255));
        pil_fav.setText("Pilih Semua");
        pil_fav.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pil_favActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout P_favoriteLayout = new javax.swing.GroupLayout(P_favorite);
        P_favorite.setLayout(P_favoriteLayout);
        P_favoriteLayout.setHorizontalGroup(
            P_favoriteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_favoriteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(P_favoriteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(P_favoriteLayout.createSequentialGroup()
                        .addComponent(pil_fav)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        P_favoriteLayout.setVerticalGroup(
            P_favoriteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_favoriteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(P_favoriteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pil_fav)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel4.setText("Pesanan Sedang Di Antar");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        ireport_antar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ireport_antar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ireport_antarMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ireport_antarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ireport_antarMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(ireport_antar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ireport_antar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );

        P_antar.setBackground(new java.awt.Color(255, 255, 255));
        P_antar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        TDiantar.setModel(new javax.swing.table.DefaultTableModel(
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
        TDiantar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TDiantar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TDiantarMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TDiantar);

        jButton2.setText("Batalkan Pesanan Terpilih");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        pil_antar.setBackground(new java.awt.Color(255, 255, 255));
        pil_antar.setText("Pilih Semua");
        pil_antar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pil_antar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pil_antarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout P_antarLayout = new javax.swing.GroupLayout(P_antar);
        P_antar.setLayout(P_antarLayout);
        P_antarLayout.setHorizontalGroup(
            P_antarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_antarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(P_antarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(P_antarLayout.createSequentialGroup()
                        .addComponent(pil_antar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        P_antarLayout.setVerticalGroup(
            P_antarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_antarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(P_antarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pil_antar)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addContainerGap())
        );

        P_terkirim.setBackground(new java.awt.Color(255, 255, 255));
        P_terkirim.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        TKirim.setModel(new javax.swing.table.DefaultTableModel(
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
        TKirim.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TKirim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TKirimMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TKirim);

        jButton3.setText("Hapus yang terpilih");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        pil_kirim.setBackground(new java.awt.Color(255, 255, 255));
        pil_kirim.setText("Pilih Semua");
        pil_kirim.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pil_kirim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pil_kirimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout P_terkirimLayout = new javax.swing.GroupLayout(P_terkirim);
        P_terkirim.setLayout(P_terkirimLayout);
        P_terkirimLayout.setHorizontalGroup(
            P_terkirimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_terkirimLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(P_terkirimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(P_terkirimLayout.createSequentialGroup()
                        .addComponent(pil_kirim)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        P_terkirimLayout.setVerticalGroup(
            P_terkirimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_terkirimLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(P_terkirimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pil_kirim)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel6.setText("Pesanan Terkirim");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(59, 59, 59)
                .addComponent(ireport_terkirim, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ireport_terkirim, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );

        P_batal.setBackground(new java.awt.Color(255, 255, 255));
        P_batal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        TBatal.setModel(new javax.swing.table.DefaultTableModel(
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
        TBatal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TBatal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBatalMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(TBatal);

        jButton4.setText("Hapus yang terpilih");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        pil_batal.setBackground(new java.awt.Color(255, 255, 255));
        pil_batal.setText("Pilih Semua");
        pil_batal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pil_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pil_batalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout P_batalLayout = new javax.swing.GroupLayout(P_batal);
        P_batal.setLayout(P_batalLayout);
        P_batalLayout.setHorizontalGroup(
            P_batalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_batalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(P_batalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(P_batalLayout.createSequentialGroup()
                        .addComponent(pil_batal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        P_batalLayout.setVerticalGroup(
            P_batalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_batalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(P_batalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pil_batal)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8FavoriteMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel8.setText("Pesanan Dibatalkan");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8FavoriteMouseClicked(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(49, 49, 49)
                .addComponent(ireport_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ireport_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMouseClicked(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Beranda");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMouseClicked(evt);
            }
        });

        pesanan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pesanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pesananMouseClicked(evt);
            }
        });

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Pesanan");
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pesananMouseClicked(evt);
            }
        });

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Akun");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        akun.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(akun, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(pesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(home, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(akun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(P_favorite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(P_antar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(P_terkirim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(P_batal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inbox, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(profile, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(setting, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inbox, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(setting, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(profile, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(P_favorite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(P_antar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(P_terkirim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(P_batal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void inboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inboxMouseClicked
        new Inbox().setVisible(true);
        dispose();
    }//GEN-LAST:event_inboxMouseClicked

    private void settingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingMouseClicked
        new setting().setVisible(true);
        dispose();
    }//GEN-LAST:event_settingMouseClicked

    private void ireport_favMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ireport_favMouseClicked
        String command = "SELECT * FROM favorite WHERE user='"+user+"'";
        String laporan = "Favorite.jrxml";
        objek.getLaporan(command, laporan);
    }//GEN-LAST:event_ireport_favMouseClicked

    private void ireport_favMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ireport_favMousePressed
        ireport_fav.setIcon(objek.setUkuran(ireport_fav, "img\\show-ireport-clicked.png"));
    }//GEN-LAST:event_ireport_favMousePressed

    private void ireport_favMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ireport_favMouseReleased
        ireport_fav.setIcon(objek.setUkuran(ireport_fav, "img\\show-ireport.png"));
    }//GEN-LAST:event_ireport_favMouseReleased

    private void jLabel3FavoriteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3FavoriteMouseClicked
        if(!P_favorite.isVisible()){
            tabvisible();
            row1 = showTable();
            P_favorite.setVisible(true);
        }else{
            P_favorite.setVisible(false);
        }
    }//GEN-LAST:event_jLabel3FavoriteMouseClicked

    private void TFavMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TFavMouseClicked
        if(evt.getClickCount() == 2){
            int index = TFav.getSelectedRow();
            TableModel model = TFav.getModel();
            String menu = model.getValueAt(index, 0).toString();
            objek.setMenu(menu);
            if(objek.isPublish()){
                objek.setFrame("akun");
                new Menu().setVisible(true);
                dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Maaf, Menu ini Sedang tidak tersedia");
            }
        }
    }//GEN-LAST:event_TFavMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TableModel model = TFav.getModel();
        ArrayList<String> row = new ArrayList<>();
        int n = 0;
        for (int i = 0; i < row1; i++) {
            if(Boolean.valueOf(model.getValueAt(i, 0).toString())){
                row.add(model.getValueAt(i, 1).toString());
                n++;
            }
        }
        row.forEach((id) -> {
            objek.delRow("favorite", "user='"+user+"' AND id_menu='"+id+"'", null, "Menu gagal dihapus");
        });
        pil_fav.setSelected(false);
        row1 = showTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void pil_favActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pil_favActionPerformed
        TableModel model = TFav.getModel();
        if(pil_fav.isSelected()){
            for (int i = 0; i < model.getRowCount(); i++) {
                model.setValueAt(true, i, 0);
            }
        }else{
            for (int i = 0; i < model.getRowCount(); i++) {
                model.setValueAt(false, i, 0);
            }
        }
    }//GEN-LAST:event_pil_favActionPerformed

    private void ireport_antarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ireport_antarMouseClicked
        String command = "SELECT * FROM data_pesanan WHERE id_user='"+user+"' AND status='Diantar'";
        String laporan = "riwayat.jrxml";
        objek.getLaporan(command, laporan);
    }//GEN-LAST:event_ireport_antarMouseClicked

    private void ireport_antarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ireport_antarMousePressed
        ireport_antar.setIcon(objek.setUkuran(ireport_antar, "img\\show-ireport-clicked.png"));
    }//GEN-LAST:event_ireport_antarMousePressed

    private void ireport_antarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ireport_antarMouseReleased
        ireport_antar.setIcon(objek.setUkuran(ireport_antar, "img\\show-ireport.png"));
    }//GEN-LAST:event_ireport_antarMouseReleased

    private void TDiantarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TDiantarMouseClicked
        if(evt.getClickCount() == 2){
            int index = TDiantar.getSelectedRow();
            TableModel model = TDiantar.getModel();
            String kode = model.getValueAt(index, 1).toString();
            String command = "SELECT * FROM data_pesanan WHERE id_user='"+user+"' AND kode_pesanan='"+kode+"' AND status='Diantar'";
            String laporan = "pesanan.jrxml";
            objek.getLaporan(command, laporan);
        }
    }//GEN-LAST:event_TDiantarMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int confirm = JOptionPane.showConfirmDialog(null, "Anda akan mendapat uang kembali jika pesanan dibatalkan \n Apakah Anda yakin akan Menghapus pesanan ini?","konfimasi hapus",JOptionPane.YES_NO_OPTION);
        if(confirm==0){
            TableModel model = TDiantar.getModel();
            ArrayList<String> row = new ArrayList<>();
            int n = 0;
            for (int i = 0; i < row2; i++) {
                if(Boolean.valueOf(model.getValueAt(i, 0).toString())){
                    row.add(model.getValueAt(i, 1).toString());
                    n++;
                }
            }
            int saldo ;
            for (int i=0; i< row.size(); i++) {
                saldo = objek.getInt("user", "username='"+user+"'", "saldo");
                saldo += objek.getInt("data_pesanan", "id_user='"+user+"' AND kode_pesanan='"+row.get(i)+"' AND status='Diantar'", "total");
                objek.editRow("data_pesanan", "status='Dibatalkan'", "id_user='"+user+"' AND kode_pesanan='"+row.get(i)+"' AND status='Diantar'", null, "Gagal Menghapus Pesanan");
                objek.editRow("user", "saldo="+saldo, "username='"+user+"'", null, "gagal Mengakses akun");
            }
            pil_antar.setSelected(false);
            row2 = showTable(TDiantar,"Diantar");
            row4 = showTable(TBatal, "Dibatalkan");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void pil_antarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pil_antarActionPerformed
        TableModel model = TDiantar.getModel();
        if(pil_antar.isSelected()){
            for (int i = 0; i < model.getRowCount(); i++) {
                model.setValueAt(true, i, 0);
            }
        }else{
            for (int i = 0; i < model.getRowCount(); i++) {
                model.setValueAt(false, i, 0);
            }
        }
    }//GEN-LAST:event_pil_antarActionPerformed

    private void TKirimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TKirimMouseClicked
        if(evt.getClickCount() == 2){
            int index = TKirim.getSelectedRow();
            TableModel model = TKirim.getModel();
            String kode = model.getValueAt(index, 1).toString();
            String command = "SELECT * FROM data_pesanan WHERE id_user='"+user+"' AND kode_pesanan='"+kode+"' AND status='Terkirim'";
            String laporan = "pesanan.jrxml";
            objek.getLaporan(command, laporan);
        }
    }//GEN-LAST:event_TKirimMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin akan Menghapus pesanan ini?","konfimasi hapus",JOptionPane.YES_NO_OPTION);
        if(confirm==0){
            TableModel model = TKirim.getModel();
            ArrayList<String> row = new ArrayList<String>();
            int n = 0;
            for (int i = 0; i < row3; i++) {
                if(Boolean.valueOf(model.getValueAt(i, 0).toString())){
                    row.add(model.getValueAt(i, 1).toString());
                    n++;
                }
            }
            row.forEach((kode) -> {
                objek.delRow("data_pesanan", "id_user='"+user+"' AND kode_pesanan='"+kode+"' AND status='Terkirim'", null, "Menu gagal dihapus");
            });
            pil_kirim.setSelected(false);
            row3 = showTable(TKirim, "Terkirim");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void pil_kirimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pil_kirimActionPerformed
        TableModel model = TKirim.getModel();
        if(pil_kirim.isSelected()){
            for (int i = 0; i < model.getRowCount(); i++) {
                model.setValueAt(true, i, 0);
            }
        }else{
            for (int i = 0; i < model.getRowCount(); i++) {
                model.setValueAt(false, i, 0);
            }
        }
    }//GEN-LAST:event_pil_kirimActionPerformed

    private void ireport_terkirimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ireport_terkirimMouseClicked
        String command = "SELECT * FROM data_pesanan WHERE id_user='"+user+"' AND status='Terkirim'";
        String laporan = "riwayat.jrxml";
        objek.getLaporan(command, laporan);
    }//GEN-LAST:event_ireport_terkirimMouseClicked

    private void ireport_terkirimMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ireport_terkirimMousePressed
        ireport_terkirim.setIcon(objek.setUkuran(ireport_terkirim, "img\\show-ireport-clicked.png"));
    }//GEN-LAST:event_ireport_terkirimMousePressed

    private void ireport_terkirimMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ireport_terkirimMouseReleased
        ireport_terkirim.setIcon(objek.setUkuran(ireport_terkirim, "img\\show-ireport.png"));
    }//GEN-LAST:event_ireport_terkirimMouseReleased

    private void ireport_batalMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ireport_batalMouseReleased
        ireport_batal.setIcon(objek.setUkuran(ireport_batal, "img\\show-ireport.png"));
    }//GEN-LAST:event_ireport_batalMouseReleased

    private void ireport_batalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ireport_batalMousePressed
        ireport_batal.setIcon(objek.setUkuran(ireport_batal, "img\\show-ireport-clicked.png"));
    }//GEN-LAST:event_ireport_batalMousePressed

    private void ireport_batalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ireport_batalMouseClicked
        String command = "SELECT * FROM data_pesanan WHERE id_user='"+user+"' AND status='Dibatalkan'";
        String laporan = "riwayat.jrxml";
        objek.getLaporan(command, laporan);
    }//GEN-LAST:event_ireport_batalMouseClicked

    private void jLabel8FavoriteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8FavoriteMouseClicked
        if(!P_batal.isVisible()){
            tabvisible();
            row4 = showTable(TBatal,"Dibatalkan");
            P_batal.setVisible(true);
        }else{
            P_batal.setVisible(false);
        }
    }//GEN-LAST:event_jLabel8FavoriteMouseClicked

    private void pil_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pil_batalActionPerformed
        TableModel model = TBatal.getModel();
        if(pil_batal.isSelected()){
            for (int i = 0; i < model.getRowCount(); i++) {
                model.setValueAt(true, i, 0);
            }
        }else{
            for (int i = 0; i < model.getRowCount(); i++) {
                model.setValueAt(false, i, 0);
            }
        }
    }//GEN-LAST:event_pil_batalActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin akan Menghapus pesanan ini?","konfimasi hapus",JOptionPane.YES_NO_OPTION);
        if(confirm==0){
            TableModel model = TBatal.getModel();
            ArrayList<String> row = new ArrayList<>();
            int n = 0;
            for (int i = 0; i < row4; i++) {
                if(Boolean.valueOf(model.getValueAt(i, 0).toString())){
                    row.add(model.getValueAt(i, 1).toString());
                    n++;
                }
            }
            row.forEach((id) -> {
                objek.delRow("data_pesanan", "id_user='"+user+"' AND kode_pesanan='"+id+"' AND status='Dibatalkan'", null, "Menu gagal dihapus");
            });
            pil_batal.setSelected(false);
            row4 = showTable(TBatal, "Dibatalkan");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void TBatalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBatalMouseClicked
        if(evt.getClickCount() == 2){
            int index = TBatal.getSelectedRow();
            TableModel model = TBatal.getModel();
            String kode = model.getValueAt(index, 1).toString();
            String command = "SELECT * FROM data_pesanan WHERE id_user='"+user+"' AND kode_pesanan='"+kode+"' AND status='Dibatalkan'";
            String laporan = "pesanan.jrxml";
            objek.getLaporan(command, laporan);
        }
    }//GEN-LAST:event_TBatalMouseClicked

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
        new MainFrame().setVisible(true);
        dispose();
    }//GEN-LAST:event_homeMouseClicked

    private void pesananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pesananMouseClicked
        new pesan().setVisible(true);
        dispose();
    }//GEN-LAST:event_pesananMouseClicked

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        if(!P_terkirim.isVisible()){
            tabvisible();
            row3 = showTable(TKirim,"Terkirim");
            P_terkirim.setVisible(true);
        }else{
            P_terkirim.setVisible(false);
        }
    }//GEN-LAST:event_jPanel7MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        if(!P_antar.isVisible()){
            tabvisible();
            row2 = showTable(TDiantar,"Diantar");
            P_antar.setVisible(true);
        }else{
            P_antar.setVisible(false);
        }
    }//GEN-LAST:event_jPanel4MouseClicked

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
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel P_antar;
    private javax.swing.JPanel P_batal;
    private javax.swing.JPanel P_favorite;
    private javax.swing.JPanel P_terkirim;
    private javax.swing.JTable TBatal;
    private javax.swing.JTable TDiantar;
    private javax.swing.JTable TFav;
    private javax.swing.JTable TKirim;
    private javax.swing.JLabel akun;
    private javax.swing.JLabel home;
    private javax.swing.JLabel inbox;
    private javax.swing.JLabel ireport_antar;
    private javax.swing.JLabel ireport_batal;
    private javax.swing.JLabel ireport_fav;
    private javax.swing.JLabel ireport_terkirim;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel name;
    private javax.swing.JLabel pesanan;
    private javax.swing.JCheckBox pil_antar;
    private javax.swing.JCheckBox pil_batal;
    private javax.swing.JCheckBox pil_fav;
    private javax.swing.JCheckBox pil_kirim;
    private javax.swing.JLabel profile;
    private javax.swing.JLabel setting;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
