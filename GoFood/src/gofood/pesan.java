package gofood;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import koneksi.conek;
import javax.swing.table.TableColumnModel;


public class pesan extends javax.swing.JFrame {

    Model objek = new Model();
    private String user = objek.getUser();
    String key;
    int tot;
    boolean promo =false;
    int row;
    
    private void show_tabel(){
        if(key!=null){
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
            tbl.addColumn("Jumlah");
            tbl.addColumn("Harga");
            tbl.addColumn("Total");
            tabel.setModel(tbl);
            try{
                Statement statement = (Statement) conek.GetConnection().createStatement();
                ResultSet res = statement.executeQuery("SELECT * FROM data_pesanan WHERE kode_pesanan='"+key+"'");
                while (res.next()){
                    tbl.addRow(new Object []{
                        false,
                        res.getString("id_menu"),
                        res.getString("restoran"),
                        res.getString("menu_pesan"),
                        res.getString("jumlah"),
                        objek.formatUang(res.getString("harga")),
                        objek.formatUang(res.getString("total"))
                    });
                    tabel.setModel(tbl);
                }
                tabel.getColumnModel().getColumn(0).setMaxWidth(50);
                tabel.getColumnModel().getColumn(2).setMinWidth(60);
                tabel.getColumnModel().getColumn(3).setPreferredWidth(140);
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null, "Tabel Error!!!");
                }
        row = tbl.getRowCount();
        TableColumnModel tcm = tabel.getColumnModel();
        tcm.removeColumn(tcm.getColumn(1));
        tabel.setShowHorizontalLines(true);
        tabel.setDefaultEditor(Object.class, null);
        }
    }
    void promoEfek(){
        Total.setText(objek.formatUang(String.valueOf(tot)));
        int Ongkir = objek.getOngkir();
        String strOngkir = objek.formatUang(String.valueOf(Ongkir));
        if(promo){
            ongkir.setText("("+strOngkir+" - "+strOngkir+") 0");
            TP.setText(objek.formatUang(String.valueOf(tot)));
            TH.setText("Rp "+objek.formatUang(String.valueOf(tot)));
            batal.setVisible(true);
            txtpromo.setText("Promo Digunakan");
        }else{
            ongkir.setText(strOngkir);
            TP.setText(objek.formatUang(String.valueOf(tot+Ongkir)));
            TH.setText("Rp "+objek.formatUang(String.valueOf(tot+Ongkir)));
            batal.setVisible(false);
            txtpromo.setText("Tambahkan Promo");
        }
    }
    
    public pesan() {
        initComponents();
        home.setIcon(objek.setUkuran(home,"img\\Home.png"));
        pesanan.setIcon(objek.setUkuran(pesanan,"img\\pesan.png"));
        peta.setIcon(objek.setUkuran(peta, "img\\peta.png"));
        pembayaran.setIcon(objek.setUkuran(pembayaran, "img\\pay.png"));
        order.setIcon(objek.setUkuran(order, "img\\order.png"));
        batal.setIcon(objek.setUkuran(batal, "img\\close.png"));
        btn_tbl_pesan.setIcon(objek.setUkuran(btn_tbl_pesan, "img\\show-ireport.png"));
        alamat.setText(objek.getString("user", "username='"+user+"'", "alamat"));
        key = objek.getString("data_pesanan", "id_user='"+user+"' AND status='Dipesan'", "kode_pesanan");
        if(key!=null){
            tot = objek.getTotal(key);
            System.out.println(tot);
            show_tabel();
            panel_pesan1.setVisible(false);
            promoEfek();
            StringBuffer kode = new StringBuffer(key);
            for (int i = 4; i < key.length(); i+=4) {
                kode.insert(i, '-');
            }
            code.setText(kode.toString());
        }else{
            panelkode.setVisible(false);
            panel_pesan.setVisible(false);
            bayar.setVisible(false);
            detail.setVisible(false);
            panelbayar.setVisible(false);
            jPanel3.setVisible(false);
            paneldetail.setVisible(false);
            btn_tbl_pesan.setVisible(false);
            panel_pesan1.setVisible(true);
        }
        if(objek.getString("pesan", "baca=1 AND id_user='"+user+"'", "pesan")==null){
            akun.setIcon(objek.setUkuran(akun,"img\\Akun.png"));
        }else{
            akun.setIcon(objek.setUkuran(akun,"img\\aAkun.png"));
        }
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
        jPanel4 = new javax.swing.JPanel();
        home = new javax.swing.JButton();
        pesanan = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        akun = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        header = new javax.swing.JLabel();
        panelAlamat = new javax.swing.JPanel();
        peta = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        alamat = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        btn_tbl_pesan = new javax.swing.JLabel();
        pil_semua = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        panelbayar = new javax.swing.JPanel();
        pembayaran = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        txtpromo = new javax.swing.JLabel();
        batal = new javax.swing.JLabel();
        paneldetail = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Total = new javax.swing.JLabel();
        ongkir = new javax.swing.JLabel();
        TP = new javax.swing.JLabel();
        detail = new javax.swing.JLabel();
        bayar = new javax.swing.JLabel();
        panel_pesan = new javax.swing.JPanel();
        order = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        TH = new javax.swing.JLabel();
        panel_pesan1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelkode = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        code = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GoFood");

        jPanel1.setBackground(new java.awt.Color(236, 236, 236));
        jPanel1.setForeground(new java.awt.Color(47, 99, 189));
        jPanel1.setPreferredSize(new java.awt.Dimension(324, 664));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        home.setBackground(new java.awt.Color(255, 255, 255));
        home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        home.setMargin(new java.awt.Insets(0, 0, 0, 0));
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMouseClicked(evt);
            }
        });

        pesanan.setBackground(new java.awt.Color(255, 255, 255));
        pesanan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pesanan.setMargin(new java.awt.Insets(0, 0, 0, 0));

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Pesanan");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        akun.setBackground(new java.awt.Color(255, 255, 255));
        akun.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        akun.setMargin(new java.awt.Insets(0, 0, 0, 0));
        akun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AkunMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Beranda");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Akun");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AkunMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(pesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94)
                        .addComponent(akun, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(pesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(akun, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)))))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        header.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        header.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        header.setText("Pesanan");
        header.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(header)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelAlamat.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setText("Alamat Pengiriman");

        alamat.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        alamat.setText("Masukkan Alamat Anda");
        alamat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Ubah");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                alamatMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelAlamatLayout = new javax.swing.GroupLayout(panelAlamat);
        panelAlamat.setLayout(panelAlamatLayout);
        panelAlamatLayout.setHorizontalGroup(
            panelAlamatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlamatLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(peta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelAlamatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAlamatLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(panelAlamatLayout.createSequentialGroup()
                        .addComponent(alamat)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelAlamatLayout.setVerticalGroup(
            panelAlamatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlamatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAlamatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alamat)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAlamatLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(peta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No.", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        tabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        btn_tbl_pesan.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btn_tbl_pesan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_tbl_pesan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tbl_pesanMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_tbl_pesanMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_tbl_pesanMouseReleased(evt);
            }
        });

        pil_semua.setBackground(new java.awt.Color(255, 255, 255));
        pil_semua.setText("Pilih Semua");
        pil_semua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pil_semua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pil_semuaActionPerformed(evt);
            }
        });

        jButton2.setText("Hapus Menu Pesanan Terpilih");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setText("*klik 2x untuk ubah pesanan");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(pil_semua)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2))
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_tbl_pesan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(3, 3, 3)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pil_semua)
                            .addComponent(jButton2)))
                    .addComponent(btn_tbl_pesan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelbayar.setBackground(new java.awt.Color(255, 255, 255));

        pembayaran.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                promoMouseClicked(evt);
            }
        });

        txtpromo.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtpromo.setText("Tambahkan promo");
        txtpromo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                promoMouseClicked(evt);
            }
        });

        batal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                batalMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(txtpromo)
                .addGap(1, 1, 1)
                .addComponent(batal, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(batal, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtpromo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelbayarLayout = new javax.swing.GroupLayout(panelbayar);
        panelbayar.setLayout(panelbayarLayout);
        panelbayarLayout.setHorizontalGroup(
            panelbayarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelbayarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        panelbayarLayout.setVerticalGroup(
            panelbayarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelbayarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panelbayarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pembayaran, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        paneldetail.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel3.setText("Ongkos Kirim");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel2.setText("Total Pembayaran");

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel6.setText("Total Harga");

        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");

        Total.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        Total.setText("18.000");

        ongkir.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ongkir.setText("10.000");

        TP.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        TP.setText("28.000");

        javax.swing.GroupLayout paneldetailLayout = new javax.swing.GroupLayout(paneldetail);
        paneldetail.setLayout(paneldetailLayout);
        paneldetailLayout.setHorizontalGroup(
            paneldetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneldetailLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(paneldetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(paneldetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneldetailLayout.createSequentialGroup()
                        .addComponent(TP)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneldetailLayout.createSequentialGroup()
                        .addGroup(paneldetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Total, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ongkir))
                        .addGap(33, 33, 33))))
            .addGroup(paneldetailLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        paneldetailLayout.setVerticalGroup(
            paneldetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneldetailLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneldetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Total))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(paneldetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ongkir))
                .addGap(0, 0, 0)
                .addComponent(jLabel10)
                .addGap(0, 0, 0)
                .addGroup(paneldetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TP))
                .addContainerGap())
        );

        detail.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        detail.setText("Detail pembayaran");

        bayar.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        bayar.setText("Metode pembayaran");

        panel_pesan.setBackground(new java.awt.Color(255, 255, 255));

        order.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        order.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                orderMouseClicked(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel19.setText("Total Harga");

        TH.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        TH.setText("Rp 28.000");

        javax.swing.GroupLayout panel_pesanLayout = new javax.swing.GroupLayout(panel_pesan);
        panel_pesan.setLayout(panel_pesanLayout);
        panel_pesanLayout.setHorizontalGroup(
            panel_pesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_pesanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(order, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_pesanLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TH)
                .addGap(23, 23, 23))
        );
        panel_pesanLayout.setVerticalGroup(
            panel_pesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_pesanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_pesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(TH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(order, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        panel_pesan1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setText("Anda Belum Membuat Pesanan");

        javax.swing.GroupLayout panel_pesan1Layout = new javax.swing.GroupLayout(panel_pesan1);
        panel_pesan1.setLayout(panel_pesan1Layout);
        panel_pesan1Layout.setHorizontalGroup(
            panel_pesan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_pesan1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_pesan1Layout.setVerticalGroup(
            panel_pesan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_pesan1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        panelkode.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel11.setText("kode Pembayaran");

        code.setEditable(false);
        code.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        javax.swing.GroupLayout panelkodeLayout = new javax.swing.GroupLayout(panelkode);
        panelkode.setLayout(panelkodeLayout);
        panelkodeLayout.setHorizontalGroup(
            panelkodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelkodeLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        panelkodeLayout.setVerticalGroup(
            panelkodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelkodeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelkodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelAlamat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(paneldetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelbayar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bayar)
                    .addComponent(detail))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(panel_pesan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel_pesan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelkode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paneldetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelkode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bayar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelbayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_pesan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_pesan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 688, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
        new MainFrame().setVisible(true);
        dispose();
    }//GEN-LAST:event_homeMouseClicked

    private void alamatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alamatMouseClicked
        String getAlamat = JOptionPane.showInputDialog("Masukkan Alamat anda :");
        if(getAlamat != null){
            objek.editRow("user", "alamat='"+getAlamat+"'", "username = '"+user+"'", null, "Error gagal Menyimpan alamat");
            alamat.setText(getAlamat);
        }
    }//GEN-LAST:event_alamatMouseClicked

    private void orderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderMouseClicked
        int saldo = objek.getInt("user", "username='"+user+"'", "saldo");
        if(!promo){
            tot +=objek.getOngkir();
        }
        if(tot<=saldo){
            saldo -=tot;
            objek.editRow("user", "saldo="+saldo, "username='"+user+"'", null, "Gagal Mengakses saldo");
            objek.editRow("data_pesanan", "status='Diantar'", "kode_pesanan = '"+key+"'", "Pesanan Sedang di Antar, silahkan tuggu beberapa saat", "Pesanan Gagal");
            new MainFrame().setVisible(true);
            dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Uang anda Tidak cukup");
        }
    }//GEN-LAST:event_orderMouseClicked

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        if(evt.getClickCount()==2){
            int index = tabel.getSelectedRow();
            TableModel model = tabel.getModel();
            objek.setMenu(model.getValueAt(index, 1).toString());
            objek.setKey(key);
            objek.setFrame("pesan");
            new menu_pesan().setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_tabelMouseClicked

    private void promoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_promoMouseClicked
        boolean keluar = false;
        if(promo){
            int h = JOptionPane.showConfirmDialog(null, "Apa Anda yakin melepas Promo yang digunakan?");
            if (h==0){
                promo = false;
                promoEfek();
            }
        }else{
            do{
                try{
                    String code = JOptionPane.showInputDialog("Masukkan kode promo");
                    if (code==null){
                        keluar = true;
                    }
                    if (code.toUpperCase().equals(objek.getCode())){
                        promo = true;
                        JOptionPane.showMessageDialog(null, "kode Berhasil di pakai");
                        keluar = true;
                        promoEfek();
                    }else{
                        int k = JOptionPane.showConfirmDialog(null, "Code yang anda masukan salah.\nApa Anda ingin mecoba lagi?","Code Salah",JOptionPane.YES_NO_OPTION);
                        if (k==1){
                            keluar = true;
                        }
                    }
                } catch(NullPointerException e){
                }
            }while(!keluar);
        }
    }//GEN-LAST:event_promoMouseClicked

    private void batalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_batalMouseClicked
        int h = JOptionPane.showConfirmDialog(null, "Apa Anda yakin melepas Promo yang digunakan?");
        if (h==0){
            promo = false;
            promoEfek();
        }
    }//GEN-LAST:event_batalMouseClicked

    private void AkunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AkunMouseClicked
        new User().setVisible(true);
        dispose();
    }//GEN-LAST:event_AkunMouseClicked

    private void btn_tbl_pesanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tbl_pesanMousePressed
        btn_tbl_pesan.setIcon(objek.setUkuran(btn_tbl_pesan, "img\\show-ireport-clicked.png"));
    }//GEN-LAST:event_btn_tbl_pesanMousePressed

    private void btn_tbl_pesanMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tbl_pesanMouseReleased
        btn_tbl_pesan.setIcon(objek.setUkuran(btn_tbl_pesan, "img\\show-ireport.png"));
    }//GEN-LAST:event_btn_tbl_pesanMouseReleased

    private void btn_tbl_pesanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tbl_pesanMouseClicked
        String command = "SELECT * FROM data_pesanan WHERE kode_pesanan='"+key+"'";
        String laporan = "pesanan.jrxml";
        objek.getLaporan(command, laporan);
    }//GEN-LAST:event_btn_tbl_pesanMouseClicked

    private void pil_semuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pil_semuaActionPerformed
        TableModel model = tabel.getModel();
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
        TableModel model = tabel.getModel();
        int[] id_menu = new int[model.getRowCount()];
        int n = 0;
        for (int i = 0; i < row; i++) {
            if(Boolean.valueOf(model.getValueAt(i, 0).toString())){
                id_menu[n] = Integer.parseInt(model.getValueAt(i, 1).toString());
                n++;
            }
        }
        for (int id :  id_menu) {
            objek.delRow("data_pesanan", "kode_pesanan='"+key+"' AND id_menu="+id, null, "gagal menghapus pesanan");
        }
        show_tabel();
        pil_semua.setSelected(false);
        if(row==0){
            panelkode.setVisible(false);
            panel_pesan.setVisible(false);
            bayar.setVisible(false);
            detail.setVisible(false);
            panelbayar.setVisible(false);
            jPanel3.setVisible(false);
            paneldetail.setVisible(false);
            btn_tbl_pesan.setVisible(false);
            panel_pesan1.setVisible(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pesan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TH;
    private javax.swing.JLabel TP;
    private javax.swing.JLabel Total;
    private javax.swing.JButton akun;
    private javax.swing.JLabel alamat;
    private javax.swing.JLabel batal;
    private javax.swing.JLabel bayar;
    private javax.swing.JLabel btn_tbl_pesan;
    private javax.swing.JTextField code;
    private javax.swing.JLabel detail;
    private javax.swing.JLabel header;
    private javax.swing.JButton home;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel ongkir;
    private javax.swing.JLabel order;
    private javax.swing.JPanel panelAlamat;
    private javax.swing.JPanel panel_pesan;
    private javax.swing.JPanel panel_pesan1;
    private javax.swing.JPanel panelbayar;
    private javax.swing.JPanel paneldetail;
    private javax.swing.JPanel panelkode;
    private javax.swing.JLabel pembayaran;
    private javax.swing.JButton pesanan;
    private javax.swing.JLabel peta;
    private javax.swing.JCheckBox pil_semua;
    private javax.swing.JTable tabel;
    private javax.swing.JLabel txtpromo;
    // End of variables declaration//GEN-END:variables
}
