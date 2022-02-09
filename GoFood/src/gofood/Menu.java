package gofood;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Menu extends javax.swing.JFrame {

    Model model_menu = new Model();
    private String user = model_menu.getUser();
    private long tot = 0;
    private int porsi, harga;
    private String favorite = null;
    private void favorit(){
        favorite = model_menu.getString("favorite", "user='"+user+"' AND id_menu='"+model_menu.getId_menu()+"'", "menu");
        if (favorite==null){
            fav.setIcon(model_menu.setUkuran(fav, "img\\favorite.png"));
        }else{
            fav.setIcon(model_menu.setUkuran(fav, "img\\favorited.png"));
        }
    }
    public Menu() {
        initComponents();
        l_menu.setText(model_menu.getLabel());
        g_menu.setIcon(model_menu.setUkuran(g_menu,model_menu.getSumber()));
        d_menu.setText(model_menu.getDesk());
        lharga_menu.setText(model_menu.getL_harga());
        if(model_menu.getDiskon()>0){
            dis_menu.setText(model_menu.getL_diskon());
            model_menu.coret(dis_menu);
        }else{
            dis_menu.setText("");
        }
        harga = model_menu.getHarga();
        tot = harga;
        harga_menu.setText("Rp. "+tot);
        Restoran.setText(model_menu.getRestoran());
        favorit();
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
        g_menu = new javax.swing.JLabel();
        lharga_menu = new javax.swing.JLabel();
        l_menu = new javax.swing.JLabel();
        jml_menu = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        dis_menu = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        d_menu = new javax.swing.JTextArea();
        harga_menu = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Restoran = new javax.swing.JLabel();
        fav = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        pesan = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ket = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GoFood");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lharga_menu.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lharga_menu.setText("Rp.10.000,-");

        l_menu.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        l_menu.setText("PAKET GEPREK BENSU NASI DAUN JERUK !");

        jml_menu.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        jml_menu.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jml_menuStateChanged(evt);
            }
        });

        dis_menu.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        dis_menu.setForeground(new java.awt.Color(255, 0, 0));
        dis_menu.setText("Rp. 15.000 ");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Jumlah Porsi");

        jScrollPane1.setFocusable(false);

        d_menu.setEditable(false);
        d_menu.setColumns(20);
        d_menu.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        d_menu.setRows(5);
        jScrollPane1.setViewportView(d_menu);

        harga_menu.setEditable(false);
        harga_menu.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Harga Total");

        Restoran.setText("Resto");

        fav.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fav.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                favMouseClicked(evt);
            }
        });

        pesan.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        pesan.setText("Pesan");
        pesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesanActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jButton2.setText("Batal");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(pesan, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pesan)
                    .addComponent(jButton2))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel4.setText("Catatan Pemesan :");

        ket.setColumns(20);
        ket.setRows(5);
        jScrollPane2.setViewportView(ket);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(fav, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jml_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(lharga_menu)
                                            .addGap(19, 19, 19)
                                            .addComponent(dis_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(58, 58, 58)
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(harga_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(23, 23, 23)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
                            .addContainerGap())
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(154, 154, 154)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Restoran)
                            .addComponent(l_menu)
                            .addComponent(g_menu, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addContainerGap(515, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(l_menu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Restoran)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(g_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fav, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lharga_menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(dis_menu)
                                .addComponent(jLabel4)))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jml_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(harga_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)))))
                .addGap(11, 11, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(241, 241, 241)
                    .addComponent(jLabel1)
                    .addGap(143, 143, 143)))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (model_menu.getFrame().equals("main")){
            new MainFrame().setVisible(true);
        }else if (model_menu.getFrame().equals("search")){
            new SearchFrame().setVisible(true);
        }else{
            new User().setVisible(true);
        }
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jml_menuStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jml_menuStateChanged
        porsi = Integer.parseInt(jml_menu.getValue().toString());
        tot = porsi * harga;
        harga_menu.setText("Rp. "+tot);
    }//GEN-LAST:event_jml_menuStateChanged

    private void pesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesanActionPerformed
        String k_pesanan = model_menu.getString("data_pesanan", "id_user='"+user+"' AND status='Dipesan'", "kode_pesanan");
        String An = model_menu.getString("user", "username='"+user+"'", "nama");
        String restoran = model_menu.getRestoran();
        String id_restoran = model_menu.getId_restoran();
        String menu = model_menu.getLabel();
        int jumlah = Integer.parseInt(jml_menu.getValue().toString());
        String keterangan = ket.getText();
        Calendar kal = new GregorianCalendar();
        String waktu = kal.get(Calendar.YEAR)+"/"+kal.get(Calendar.MONTH)+"/"+kal.get(Calendar.DAY_OF_MONTH)+" "+kal.get(Calendar.HOUR_OF_DAY)+":"+kal.get(Calendar.MINUTE);
//        Membuat tabel pesanan jika belum membuat
        if(k_pesanan==null){
            k_pesanan = "P"+kal.get(Calendar.YEAR)+kal.get(Calendar.MONTH)+kal.get(Calendar.DAY_OF_MONTH)+kal.get(Calendar.HOUR_OF_DAY)+kal.get(Calendar.MINUTE)+kal.get(Calendar.SECOND);
        }
        String id_menu = model_menu.getString("data_pesanan", "id_menu='"+model_menu.getId_menu()+"' AND kode_pesanan='"+k_pesanan+"'", "id_menu");
        if(id_menu==null){
            id_menu = model_menu.getId_menu();
            String values = "'"+user+"','"+An+"','"+k_pesanan+"','"+id_restoran+"',"+id_menu+",'"+restoran+"','"+menu+"',"+jumlah+","+harga+","+tot+",'Dipesan','"+waktu+"','"+keterangan+"'";
            System.out.println(values);
            model_menu.setTabel("data_pesanan", values, null, "data pesanan gagal di upload");
        }else{
            tot = model_menu.getInt("data_pesanan", "kode_pesanan='"+k_pesanan+"' AND id_menu="+id_menu, "total") + tot;
            jumlah = model_menu.getInt("data_pesanan", "kode_pesanan='"+k_pesanan+"' AND id_menu="+id_menu, "jumlah") + jumlah;
            String[] column = {"total", "jumlah", "keterangan"};
            String[] values = {String.valueOf(tot), String.valueOf(jumlah), keterangan};
            model_menu.editRow("data_pesanan", column, values, "kode_pesanan='"+k_pesanan+"' AND id_menu="+id_menu, null, "Pesanan Gagal ditambahkan");
        }
        
        if (model_menu.getFrame().equals("main")){
            new MainFrame().setVisible(true);
        }else if(model_menu.getFrame().equals("search")){
            new SearchFrame().setVisible(true);
        }else{
            new User().setVisible(true);
        }
        dispose();
    }//GEN-LAST:event_pesanActionPerformed

    private void favMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_favMouseClicked
        if (favorite!=null){
            model_menu.delRow("favorite", "user='"+user+"' AND id_menu="+model_menu.getId_menu(), "Menu Berhasil di Hapus dari daftar favorite", "Menu gagal di hapus Dari daftar favorite");
        }else{
            model_menu.setTabel("favorite", "'"+user+"','"+model_menu.getId_restoran()+"',"+model_menu.getId_menu()+",'"+model_menu.getRestoran()+"','"+model_menu.getLabel()+"',"+model_menu.getHarga(), "Menu Barhasil di tambahkan ke daftar favorite", "Gagal menambakan ke Daftar favorite");
        }
        favorit();
    }//GEN-LAST:event_favMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (model_menu.getFrame().equals("main")){
            new MainFrame().setVisible(true);
        }else if(model_menu.getFrame().equals("search")){
            new SearchFrame().setVisible(true);
        }else{
            new User().setVisible(true);
        }
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Restoran;
    private javax.swing.JTextArea d_menu;
    private javax.swing.JLabel dis_menu;
    private javax.swing.JLabel fav;
    private javax.swing.JLabel g_menu;
    private javax.swing.JTextField harga_menu;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jml_menu;
    private javax.swing.JTextArea ket;
    private javax.swing.JLabel l_menu;
    private javax.swing.JLabel lharga_menu;
    private javax.swing.JButton pesan;
    // End of variables declaration//GEN-END:variables
}
