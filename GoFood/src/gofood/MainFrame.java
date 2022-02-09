package gofood;
import com.sun.glass.events.KeyEvent;
import javax.swing.JOptionPane;


public class MainFrame extends javax.swing.JFrame {

    Model objek = new Model();
    private String user = objek.getUser();
    private void showSaldo(){
        String saldo = "Rp "+objek.formatUang(objek.getString("user", "username='"+user+"'", "saldo"));
        uang.setText(saldo);
    }
    public MainFrame() {
        initComponents();
        utama1.setIcon(objek.setUkuran(utama1,"img\\restoran\\gofood\\Ayam.jpg"));
        utama2.setIcon(objek.setUkuran(utama2,"img\\restoran\\gofood\\burger.jpg"));
        utama3.setIcon(objek.setUkuran(utama3,"img\\restoran\\gofood\\Ayam Bakar.jpg"));
        objek.coret(prm1);
        objek.coret(prm2);
        objek.coret(prm3);
        home.setIcon(objek.setUkuran(home,"img\\Home.png"));
        bayar.setIcon(objek.setUkuran(bayar,"img\\Bayar.png"));
        transfer.setIcon(objek.setUkuran(transfer, "img\\transfer.png"));
        isi.setIcon(objek.setUkuran(isi,"img\\TopUp.png"));
        promo.setIcon(objek.setUkuran(promo,"img\\Promo.png"));
        gofood.setIcon(objek.setUkuran(gofood, "img\\icon.png"));
        search.setIcon(objek.setUkuran(search, "img\\search.png"));
        gopay.setIcon(objek.setUkuran(gopay, "img\\gopay.png"));
        showSaldo();
        if(objek.getString("data_pesanan", "id_user='"+user+"' AND status='Dipesan'", "id_user")==null){
            pesanan.setIcon(objek.setUkuran(pesanan,"img\\pesan.png"));
        }else{
            pesanan.setIcon(objek.setUkuran(pesanan,"img\\apesan.png"));
        }
        if(objek.getString("pesan", "baca=1 AND id_user='"+user+"'", "pesan")==null){
            akun.setIcon(objek.setUkuran(akun,"img\\Akun.png"));
        }else{
            akun.setIcon(objek.setUkuran(akun,"img\\aAkun.png"));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        home = new javax.swing.JButton();
        pesanan = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        akun = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        gofood = new javax.swing.JLabel();
        txtsearch = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        uang = new javax.swing.JLabel();
        gopay = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        promo = new javax.swing.JLabel();
        isi = new javax.swing.JLabel();
        transfer = new javax.swing.JLabel();
        bayar = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        scrollPane1 = new java.awt.ScrollPane();
        jPanel5 = new javax.swing.JPanel();
        prm1 = new javax.swing.JLabel();
        label_1 = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        Pesan1 = new javax.swing.JButton();
        utama1 = new javax.swing.JLabel();
        pesan2 = new javax.swing.JButton();
        utama2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        prm2 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        utama3 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        prm3 = new javax.swing.JLabel();
        search = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GoFood");
        setResizable(false);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setForeground(new java.awt.Color(47, 99, 189));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        home.setBackground(new java.awt.Color(255, 255, 255));
        home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        home.setMargin(new java.awt.Insets(0, 0, 0, 0));

        pesanan.setBackground(new java.awt.Color(255, 255, 255));
        pesanan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pesanan.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pesanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keranjangMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Pesanan");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keranjangMouseClicked(evt);
            }
        });

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
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(pesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(akun, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(akun, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pesanan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addGap(17, 17, 17))
        );

        txtsearch.setBackground(new java.awt.Color(242, 242, 242));
        txtsearch.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtsearch.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtsearchKeyPressed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(47, 99, 189));

        jPanel3.setBackground(new java.awt.Color(45, 60, 184));

        uang.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        uang.setForeground(new java.awt.Color(255, 255, 255));
        uang.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        uang.setText("Rp. 0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gopay, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(uang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uang)
                    .addComponent(gopay, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7))
        );

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Isi Saldo");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                isiMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Bayar");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Promo");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                promoMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tranfer");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        promo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        promo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                promoMouseClicked(evt);
            }
        });

        isi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        isi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                isiMouseClicked(evt);
            }
        });

        transfer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        transfer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        bayar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bayar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(transfer, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(isi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(promo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(promo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(isi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(jLabel4)
                                .addComponent(jLabel2))
                            .addComponent(jLabel5)))
                    .addComponent(transfer, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel15.setText("Hot Promo !!");

        prm1.setForeground(new java.awt.Color(255, 0, 0));
        prm1.setText("Rp. 15.000 ");

        label_1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        label_1.setText("NASI DAUN JERUK !");
        label_1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                promo1MouseClicked(evt);
            }
        });

        label1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        label1.setText("PAKET GEPREK BENSU");
        label1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                promo1MouseClicked(evt);
            }
        });

        Pesan1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        Pesan1.setText("Pesan");
        Pesan1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Pesan1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                promo1MouseClicked(evt);
            }
        });

        utama1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        utama1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                promo1MouseClicked(evt);
            }
        });

        pesan2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        pesan2.setText("Pesan");
        pesan2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pesan2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                promo2MouseClicked(evt);
            }
        });

        utama2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        utama2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                promo2MouseClicked(evt);
            }
        });

        jLabel13.setText("Rp. 16.000,-");

        prm2.setForeground(new java.awt.Color(255, 0, 0));
        prm2.setText("Rp. 20.000 ");

        label2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        label2.setText("Blenger Burger");
        label2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                promo2MouseClicked(evt);
            }
        });

        jLabel10.setText("Rp.10.000,-");

        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel18.setText("Ayam Bakar");
        jLabel18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                promo3MouseClicked(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jButton7.setText("Pesan");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                promo3MouseClicked(evt);
            }
        });

        utama3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        utama3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                promo3MouseClicked(evt);
            }
        });

        jLabel17.setText("Rp. 17.000,-");

        prm3.setForeground(new java.awt.Color(255, 0, 0));
        prm3.setText("Rp. 23.000 ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(utama3, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                    .addComponent(utama2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(utama1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label2)
                    .addComponent(label_1)
                    .addComponent(label1)
                    .addComponent(jLabel18)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(prm3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel10)
                        .addGap(9, 9, 9)
                        .addComponent(prm1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pesan1))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(prm2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pesan2)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1)
                .addGap(2, 2, 2)
                .addComponent(label_1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(utama1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(prm1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Pesan1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 35, Short.MAX_VALUE)
                .addComponent(label2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(utama2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(prm2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13))
                    .addComponent(pesan2))
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(utama3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prm3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17)
                    .addComponent(jButton7))
                .addContainerGap())
        );

        scrollPane1.add(jPanel5);

        search.setBackground(new java.awt.Color(0, 0, 0));
        search.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel15)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(scrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE))
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(txtsearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))))
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(gofood, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(gofood, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addGap(5, 5, 5)
                .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void promo3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_promo3MouseClicked
        objek.setMenu("1");
        objek.setFrame("main");
        new Menu().setVisible(true);
        dispose();
    }//GEN-LAST:event_promo3MouseClicked

    private void promo2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_promo2MouseClicked
        objek.setMenu("3");
        objek.setFrame("main");
        new Menu().setVisible(true);
        dispose();
    }//GEN-LAST:event_promo2MouseClicked

    private void promo1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_promo1MouseClicked
        objek.setMenu("2");
        objek.setFrame("main");
        new Menu().setVisible(true);
        dispose();
    }//GEN-LAST:event_promo1MouseClicked

    private void promoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_promoMouseClicked
        JOptionPane.showMessageDialog(null, "Gratis Ongkir untuk setiap pemesanan menggunakan GoPay\n"
            + "*kode Promo = \" "+objek.getCode()+" \" ");
    }//GEN-LAST:event_promoMouseClicked

    private void isiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_isiMouseClicked
        String isi = JOptionPane.showInputDialog("Masukkan Nominal Uang");
        if (isi != null){
            int saldo = objek.getInt("user", "username='"+user+"'", "saldo");
            saldo += Integer.parseInt(isi);
            objek.editRow("user", "saldo="+saldo, "username='"+user+"'", "Saldo Anda berhasil di tambahkan", "Saldo Anda gagal di tambahkan");
            showSaldo();
        }
    }//GEN-LAST:event_isiMouseClicked

    private void keranjangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keranjangMouseClicked
        new pesan().setVisible(true);
        dispose();
    }//GEN-LAST:event_keranjangMouseClicked

    private void AkunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AkunMouseClicked
        new User().setVisible(true);
        dispose();
    }//GEN-LAST:event_AkunMouseClicked

    private void txtsearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            objek.setKey(txtsearch.getText());
            new SearchFrame().setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_txtsearchKeyPressed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        String kode = null;
        kode = JOptionPane.showInputDialog("Masukkan Kode Pembayaran");
        if(kode!= null){
            kode = kode.replaceAll("-", "");
            String id_user = objek.getString("data_pesanan", "kode_pesanan='"+kode+"' AND status='Dipesan'", "id_user");
            if(id_user!=null){
                String nama = objek.getString("user", "username='"+id_user+"'", "nama");
                int tot = objek.getTotal(kode) + objek.getOngkir();
                String message;
                if(id_user.equals(user)){
                    message = "Apakah Anda yakin akan membayar Rp."+tot+",- (termasuk Ongkir) Untuk Pesanan Anda?";
                }else{
                    message = "Apakah Anda yakin akan membayar Rp."+tot+",- (termasuk Ongkir) kepada An. "+nama+" ?";
                }
                int confirm_user = JOptionPane.showConfirmDialog(null, message,"Confirm payment",JOptionPane.YES_NO_OPTION);
                if(confirm_user==0){
                    int pilih = JOptionPane.showConfirmDialog(null, "Apakah anda ingin menggunakan kode promo?","Promo",JOptionPane.YES_NO_OPTION);
                    if(pilih==0){
                        boolean ulang = true;
                        while(ulang){
                            String input = JOptionPane.showInputDialog("Masukkan kode Promo");
                            if(input.toUpperCase().equals(objek.getCode())){
                                tot -=objek.getOngkir();
                                JOptionPane.showMessageDialog(null, "Promo berhasil di gunakan, Total pembayaran Rp. "+tot+",-");
                                ulang=false;
                            }else{
                                int lagi = JOptionPane.showConfirmDialog(null, "Kode promo anda salah!\n Apakah anda Ingin coba lagi?","Promo",JOptionPane.YES_NO_OPTION);
                                if(lagi==1){
                                    ulang=false;
                                }
                            }
                        }
                    }
                    int saldo = objek.getInt("user", "username='"+user+"'", "saldo");
                    if(tot<=saldo){
                        saldo = saldo - tot;
                        objek.editRow("user", "saldo="+saldo, "username='"+user+"'", null, "Gagal Mengakses saldo");
                        objek.editRow("data_pesanan", "status='Diantar'", "kode_pesanan='"+kode+"'", "pembayaran berhasil dilakukan", "Pembayaran Gagal");
                        if(!id_user.equals(user)){
                            String pemberi = objek.getString("user", "username='"+user+"'", "nama");
                            message = "Pesanan Anda dengan kode pesanan "+kode+" telah dibayarkan oleh "+pemberi;
                            objek.setTabel("pesan", "NULL,'"+id_user+"','"+pemberi+"','"+message+"',1", null, "pesan gagal kirim");
                        }
                        showSaldo();
                    }else{
                        JOptionPane.showMessageDialog(null, "Uang anda Tidak cukup");
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null, "Kode Pembayaran Anda salah");
            }
        }
    }//GEN-LAST:event_jLabel5MouseClicked

    private void searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseClicked
        objek.setKey(txtsearch.getText());
        new SearchFrame().setVisible(true);
        dispose();
    }//GEN-LAST:event_searchMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        String id_user = null, id_nama;
        int confirm, id_saldo;
        boolean ulang = true;
        int saldo = objek.getInt("user", "username='"+user+"'", "saldo");
        while(ulang){
            id_user = JOptionPane.showInputDialog("Masukkan Username Tujuan");
            id_nama = objek.getString("user", "username='"+id_user+"'", "nama");
            if(id_nama!= null){
                confirm = JOptionPane.showConfirmDialog(null, "Apakah benar An. "+id_nama+" ?","Confirm transfer",JOptionPane.YES_NO_OPTION);
                if(confirm == 0){
                    id_saldo = objek.getInt("user", "username='"+id_user+"'", "saldo");
                    String transfer = JOptionPane.showInputDialog("Masukkan Jumlah saldo transfer");
                    if(transfer!=null){
                        int in_saldo = Integer.parseInt(transfer.replace(".", ""));
                        if(saldo>in_saldo){
                            String pemberi = objek.getString("user", "username='"+user+"'", "nama");
                            saldo -= in_saldo;
                            id_saldo+=in_saldo;
                            objek.editRow("user", "saldo="+id_saldo, "username='"+id_user+"'", "Transfer Saldo Rp. "+objek.formatUang(""+in_saldo)+" kepada An."+id_nama+" Berhasil Dilakukan", "Tranfer gagal dilakukan");
                            objek.editRow("user", "saldo="+saldo, "username='"+user+"'", null, "Tranfer gagal dilakukan");
                            objek.setTabel("pesan", "NULL,'"+id_user+"','"+pemberi+"', 'Anda Telah Menerima saldo Rp. "+in_saldo+" dari "+pemberi+"',1", null, "gagal membuat pesan");
                            showSaldo();
                            ulang = false;
                        }else{
                            JOptionPane.showMessageDialog(null, "Saldo yang anda miliki tidak cukup");
                            ulang = false;
                        }
                    }else{
                        ulang = false;
                    }
                }else{
                    ulang = false;
                }
            }else{
                JOptionPane.showMessageDialog(null, "Username Tidak ditemukan");
                ulang = false;
            }
        }
        
    }//GEN-LAST:event_jLabel2MouseClicked

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
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Pesan1;
    private javax.swing.JButton akun;
    private javax.swing.JLabel bayar;
    private javax.swing.JLabel gofood;
    private javax.swing.JLabel gopay;
    private javax.swing.JButton home;
    private javax.swing.JLabel isi;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label_1;
    private javax.swing.JButton pesan2;
    private javax.swing.JButton pesanan;
    private javax.swing.JLabel prm1;
    private javax.swing.JLabel prm2;
    private javax.swing.JLabel prm3;
    private javax.swing.JLabel promo;
    private java.awt.ScrollPane scrollPane1;
    private javax.swing.JLabel search;
    private javax.swing.JLabel transfer;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JLabel uang;
    private javax.swing.JLabel utama1;
    private javax.swing.JLabel utama2;
    private javax.swing.JLabel utama3;
    // End of variables declaration//GEN-END:variables
}
