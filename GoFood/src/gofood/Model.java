package gofood;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.font.TextAttribute;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import com.mysql.jdbc.Statement;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import koneksi.conek;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;


public class Model {

    /**
     * @param aFrame the frame to set
     */
    // Static variabel untuk menyimpan/meanggil data data
    private static String restoran, id_restoran,label, sumber, l_harga, l_diskon , desk, id_menu, frame, key, user;
    private static int harga, diskon;
    private static boolean editmenu, publish;
    // final variabel untuk kode agar tidak dapat di ubah
    private final String code = "AMIK";
    private final int ongkir = 10000;
    
    // Setting ukuran gambar tombol agar dapat di ubah
    public ImageIcon setUkuran(JButton item,String src){
        ImageIcon my_img = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource(src)));
        Image img = my_img.getImage();
        Image img2 = img.getScaledInstance(item.getWidth(), item.getHeight(), Image.SCALE_SMOOTH);
        return new ImageIcon(img2);
    }
    
    // Setting ukuran gambar pada label agar dapat di ubah
    public ImageIcon setUkuran(JLabel item,String src){
        ImageIcon my_img;
        if(src.contains(":")){
            my_img = new ImageIcon(src);
        }else{
            my_img = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource(src)));
        }
        Image img = my_img.getImage();
        Image img2 = img.getScaledInstance(item.getWidth(), item.getHeight(), Image.SCALE_SMOOTH);
        return new ImageIcon(img2);
    }
    
    // Memuncukan tulisan tercoret untuk diskon
    public void coret(JLabel text){
        Font font = new Font("arial", Font.PLAIN, 12);
        Map fontAttr = font.getAttributes();
        fontAttr.put (TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
        Font myFont = new Font(fontAttr);
        text.setFont (myFont);
    }
    
    // fungsi untuk memasukkan data dari mysql Database ke static variabel
    public void setMenu(String id_menu){
        try{
            Statement st = (Statement) conek.GetConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from menu where id_menu='"+id_menu+"'");
            if(rs.next()){
                id_restoran = rs.getString("id_restoran");
                label = rs.getString("menu");
                sumber = rs.getString("gambar_menu");
                harga = rs.getInt("harga_menu");
                l_harga = "Rp. "+formatUang(String.valueOf(getHarga()))+",-";
                diskon = rs.getInt("diskon_menu");
                l_diskon = "Rp. "+formatUang(String.valueOf(getDiskon()))+",-";
                desk = rs.getString("deskripsi_menu");
                publish = rs.getBoolean("publish");
            }
            st.close();
            rs.close();
            this.id_menu = id_menu; 
            restoran = getString("restoran","id_restoran='"+id_restoran+"'","restoran");
        }catch (SQLException f){
            JOptionPane.showMessageDialog(null, "Menu Tidak tersedia");
        }
    }
    
    // fungsi untuk memformat uang 100000000 menjadi 100.000.000
    public String formatUang(String str){
        String m = "";
        if (str!=null){
            char[] ank = str.toCharArray();
            List list = new ArrayList();
            int i=0;
            for(char digit : ank){
                list.add(i, digit);
                i++;
            }
            int z =0;
            while(i>0){
                if (z%3==0){
                    list.add(i, ".");
                }
                z++;
                i--;
            }
            list.remove(list.size()-1);
            for(Object a : list){
                m+=a;
            }
        }
        return m;
    }
    
    // Memasukan nilai ke dalam tabel
    void setTabel(String table, String value, String sukses, String gagal){
        try{
            Statement statement = (Statement) conek.GetConnection().createStatement();
            statement.executeUpdate("INSERT INTO "+table+" VALUES("+value+");");
            statement.close();
            if (sukses != null){
                JOptionPane.showMessageDialog(null, sukses);
            }
        } catch (HeadlessException | SQLException t){
            JOptionPane.showMessageDialog(null, t);
        }
    }
    
    // Mengubah nilai dalam tabel
    void editRow(String table, String[] c_ubah, String[] value, String kondisi, String sukses, String gagal){
        String a="";
        for (int i=0; i<c_ubah.length; i++){
            if(value[i].equals("NULL")){
                a += c_ubah[i]+"="+value[i];
            }else{
                a += c_ubah[i]+"='"+value[i]+"'";
            }
            if(i<c_ubah.length-1){
                a +=",";
            }
        }
        try{
            Statement statement = (Statement) conek.GetConnection().createStatement();
            
            statement.executeUpdate("UPDATE "+table+" SET "+a+" WHERE "+kondisi);
            statement.close();
            if (sukses != null){
                JOptionPane.showMessageDialog(null, sukses);
            }
        } catch (SQLException t){
            if (gagal !=null){
                JOptionPane.showMessageDialog(null, t);
            }
        }
    }
    
    // Mengubah nilai dalam tabel
    void editRow(String table, String value, String kondisi, String sukses, String gagal){
        try{
            Statement statement = (Statement) conek.GetConnection().createStatement();
            statement.executeUpdate("UPDATE "+table+" SET "+value+" WHERE "+kondisi);
            statement.close();
            if (sukses != null){
                JOptionPane.showMessageDialog(null, sukses);
            }
        } catch (SQLException t){
                JOptionPane.showMessageDialog(null, t);
        }
    }
    
    // mencari nilai dalam tabel dengan pengembalian false jika tidak ditemukan dan true jika di temukan 
    boolean searchValue(String tabel, String kolom, String key){
        boolean ada = false;
        try{
            Statement st = (Statement) conek.GetConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM "+tabel+" ORDER BY "+kolom);
            while (rs.next()){
                if(rs.getString(kolom).equals(key)){
                    ada=true;
                }
            }
        }catch (SQLException f){
            JOptionPane.showMessageDialog(null, "Error...!!! Value Not Exist!!!");
        }
        return ada;
    }
    
    // mencari nilai dalam tabel dengan pengembalian String. pengembalian null jika tidak ditemukan 
    String getString(String tabel, String kondisi, String column){
        String found = null;
        try{
            Statement statement = (Statement) conek.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM "+tabel+" WHERE "+kondisi);
            if (res.next()){
                found = res.getString(column);
            }
            statement.close();
            res.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return found;
    }
    
    int getInt(String tabel, String kondisi, String column){
        int found = 0;
        try{
            Statement statement = (Statement) conek.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("SELECT "+column+" FROM "+tabel+" WHERE "+kondisi);
            if (res.next()){
                found = res.getInt(column);
            }
        }catch(SQLException e){
        }
        return found;
    }
    
    // menghapus baris pada table database
    void delRow(String tabel, String kondisi, String berhasil, String gagal){
            try{
                Statement statement = (Statement) conek.GetConnection().createStatement();
                statement.executeUpdate("DELETE from "+tabel+" where "+kondisi+";");
                statement.close();
                if (berhasil!=null){
                    JOptionPane.showMessageDialog(null, berhasil);
                }
            } catch(Exception t){
                JOptionPane.showMessageDialog(null,t);
            }
    }    
    
    // untuk memperbaharu nilai string lokasi file/directory
    String getlokasi(String lokasi){
        String gambar="";
        int f=0;
        for (int i = 0; i < lokasi.length(); i++) {
            if(lokasi.charAt(2)== lokasi.charAt(i)){
                gambar += lokasi.substring(f, i);
                gambar +="\\";
                f=i;
            }
        }
        return (gambar + lokasi.substring(f,lokasi.length()));
    }
    
    // fungsi menampilkan file
    void getLaporan(String command, String laporan){
        try {
            Statement statement = (Statement) conek.GetConnection().createStatement();
            ResultSet rs = statement.executeQuery(command);
            JasperPrint jasperPrint; 
            JRResultSetDataSource jrRS = new JRResultSetDataSource(rs); 
            JasperReport jasperReport = JasperCompileManager.compileReport("./src/gofood/ireport/"+laporan); 
            jasperPrint = JasperFillManager.fillReport(jasperReport, null, jrRS);
            JRViewer aViewer = new JRViewer(jasperPrint); 
            JDialog viewer = new JDialog(); 
            viewer.setTitle(".: Jasper Report :."); 
            viewer.setAlwaysOnTop(true);
            viewer.getContentPane().add(aViewer); 
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
            viewer.setBounds(0,0,screenSize.width, screenSize.height);
            viewer.setVisible(true); 

        statement.close();
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Laporan gak ada "+e);
        }
    }
    
    // fungsi salin file
    void copyfile(String orginal_file, String output_file){
        File from = new File(orginal_file);
        File to = new File(output_file);
        try{
            Files.copy(from.toPath(), to.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    // fungsi Menjumlahkan pesanan
    int getTotal(String kode_pesanan){
        int jumlah_harga = 0;
        try{
            Statement stm = (Statement) conek.GetConnection().createStatement();
            ResultSet res = stm.executeQuery("SELECT SUM(total) as total FROM data_pesanan WHERE kode_pesanan='"+kode_pesanan+"'");
            if(res.next()){
                jumlah_harga = res.getInt("total");
            }
            stm.close();
            res.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Gagal Memdapatkan total harga pesanan");
        }
        return jumlah_harga;
    }
    
    // fungsi menghapus file/directory
    void deldata(String src){
        src = System.getProperty("user.dir")+"\\src\\gofood\\img\\"+src;
        File delfile = new File(src);
        if(delfile.exists()){
            if(delfile.isDirectory()){
                File[] file = delfile.listFiles();
                for(File item : file){
                    item.delete();
                }
                delfile.delete();
            }else{
                delfile.delete();
            }
        }else{
            JOptionPane.showMessageDialog(null, "file : "+src+"\n tidak ditemukan");
        }
    }
    
    // fungsi mengubah nama file/directory
    void ubahData(String src, String new_src){
        src = System.getProperty("user.dir")+"\\src\\gofood\\img\\"+src;
        File dir = new File(src);
        if (dir.exists()) {
            File newDir = new File(dir.getParent() +"\\"+ new_src);
            dir.renameTo(newDir);
        }else{
            JOptionPane.showMessageDialog(null, "file : "+src+"\n tidak ditemukan");
        }
    }
    
    public String getRestoran() {
        return restoran;
    }

    public String getId_restoran() {
        return id_restoran;
    }

    public String getLabel() {
        return label;
    }

    public String getSumber() {
        return sumber;
    }

    public String getL_harga() {
        return l_harga;
    }

    public String getL_diskon() {
        return l_diskon;
    }

    public String getDesk() {
        return desk;
    }

    public String getFrame() {
        return frame;
    }

    public String getKey() {
        return key;
    }

    public String getUser() {
        return user;
    }

    public boolean isEditmenu() {
        return editmenu;
    }

    public int getHarga() {
        return harga;
    }

    public int getDiskon() {
        return diskon;
    }

    public String getCode() {
        return code;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setUser(String User) {
        this.user = User;
    }

    public String getId_menu() {
        return id_menu;
    }

    public int getOngkir() {
        return ongkir;
    }

    public void setEditmenu(boolean editmenu) {
        this.editmenu = editmenu;
    }

    public boolean isPublish() {
        return publish;
    }
}