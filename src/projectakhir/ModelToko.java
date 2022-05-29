/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectakhir;
/**
 *
 * @author HP
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Random;
import javax.swing.JOptionPane;

public class ModelToko {
    String PtotalHarga;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/toko_sayur";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;
    
    public ModelToko(){
      
        try //koneksi database
        {
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected");
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Connection Failed");
        }
    }
    public void insertSayur(String id_sayur, String nama_sayur, String harga_sayur)//insert sayur
    {
          try
        {
            String sql = "INSERT INTO `sayur` (`id_sayur`, `nama_sayur`, `harga_sayur`)"
                    + "VALUES ('"+id_sayur+"', '"+nama_sayur+"', '"+harga_sayur+"')";  
            statement.executeUpdate(sql);
        }
        catch(Exception sql)
        {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());            
        }
    }
    public void updateSayur(String id_sayur, String nama_sayur, String harga_sayur) //update sayur
    {
         try {
      
            String sql = "UPDATE `sayur` SET `id_sayur` = '"+id_sayur+"', `nama_sayur` = '"+nama_sayur+"', `harga_sayur` = '"+harga_sayur+"' WHERE `id_sayur` = '"+id_sayur+"'";  
            statement.executeUpdate(sql);
        } catch(SQLException sql){
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage()); 
        }
    }
    public void deleteSayur(String id_sayur)//delete buah
    {
         try{
            String query = "DELETE FROM `sayur` WHERE `id_sayur` = '"+id_sayur+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");       
        }catch(SQLException sql){
            System.out.println(sql.getMessage());
        }
    }
    public void deleteRiwayat(String no_nota)
    {
       try{
            String query = "DELETE FROM `nota` WHERE `no_nota` = '"+no_nota+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");       
        }catch(SQLException sql){
            System.out.println(sql.getMessage());
        }  
    }
        
    public void insertNota(String no_nota)//insertnomer nota ke table nota
    {
         LocalDate current = LocalDate.now();
        try
        {
            String sql = "INSERT INTO `nota` (`no_nota`, `tanggal_nota`, `total`)"
                    + "VALUES ('"+no_nota+"', '"+current+"', '"+0+"')";  
            statement.executeUpdate(sql);
        }
        catch(Exception sql)
        {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());            
        }
    }
    public int updateNota(String no_nota, String id_order)
    {
        try
        {
            int total = 0;
            statement = koneksi.createStatement();
            String query = "Select SUM(`detail_pesanan`.`total_harga`) as total_harga from `nota` JOIN `pesanan` ON "
                    + "`pesanan`.`no_nota` = `pesanan`.`no_nota` JOIN `detail_pesanan` ON `pesanan`.`id_order` = `detail_pesanan`.`id_order`"
                    + " WHERE `nota`.`no_nota` = '"+no_nota+"' AND `detail_pesanan`.`id_order` = '"+id_order+"'";
            ResultSet resultSet = statement.executeQuery(query);  
            while (resultSet.next())
            {
                String hrg = resultSet.getString("total_harga");
                total = Integer.parseInt(hrg);
            }
            
            String totalHarga = Integer.toString(total);
            
            String sql = "UPDATE `nota` SET `total` = '"+totalHarga+"' WHERE `no_nota` = '"+no_nota+"'";
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(sql);
            return total;
             }
        catch(Exception sql)
        {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());      
            return 0;
        }  
    }
    
    public void insertOrder(String id_order, String no_nota) //insert nomor nota & id order ke tabel pesanan
    {
        try
        {
            String query = "INSERT INTO `pesanan` (`id_order`, `no_nota`)"
                    + "VALUES ('"+id_order+"', '"+no_nota+"')";
            statement.executeUpdate(query);
        }
        catch(Exception sql)
        {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());            
        }
    }
     public void insertPesanan(String id_order, String idSayur, String banyakPesan) //insert detail_pesanan
     {
          try
        {
            String query = "INSERT INTO `detail_pesanan` (`id_order`, `id_sayur`, `banyak_pesanan`, `total_harga`)"
                    + "VALUES ('"+id_order+"', '"+idSayur+"', '"+banyakPesan+"', '"+0+"')";
            statement.executeUpdate(query);
        }
        catch(Exception sql)
        {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());            
        }
        this.updateHarga(id_order, idSayur);
     }      
    public void updateHarga(String id_order, String idSayur)//update total harga sayur yang dibeli (banyak pesanan x harga sayur)
    {
        try
        {
            int total = 0;
            statement = koneksi.createStatement();
            String query = "Select * from `sayur` JOIN `detail_pesanan` ON `sayur`.`id_sayur` = `detail_pesanan`.`id_sayur` "
                    + "JOIN `pesanan` ON `pesanan`.`id_order` = `detail_pesanan`.`id_order` JOIN `nota` ON"
                    + "`nota`.`no_nota` = `pesanan`.`no_nota` WHERE `pesanan`.`id_order` = '"+id_order+"'"
                    + "AND `detail_pesanan`.`id_sayur` = '"+idSayur+"'";
            ResultSet resultSet = statement.executeQuery(query);  
            while (resultSet.next())
            {
                String hrg = resultSet.getString("harga_sayur");
                String byk = resultSet.getString("banyak_pesanan");
                int harga = Integer.parseInt(hrg);
                int banyak = Integer.parseInt(byk);
                total = harga*banyak;
            }
         String totalHarga = Integer.toString(total);
            
            String sql = "UPDATE `detail_pesanan` SET `total_harga` = '"+totalHarga+"' WHERE `id_order` = '"+id_order+"'"
                    + "AND `id_sayur` = '"+idSayur+"'";
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(sql);
            
        }
        catch(Exception sql)
        {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());            
        }        
    }
    public void deleteOrder(String id_order, String id_sayur)//hapus data di detail_pesanan (hapus data terpilih di keranjang)
    {
        try{
            String query = "DELETE FROM `detail_pesanan` WHERE `id_order` = '"+id_order+"'"
                    + "AND `id_sayur` = '"+id_sayur+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Deleted");
        }catch(SQLException sql){
            System.out.println(sql.getMessage());
        }     
    }
    public void editOrder(String id_order, String id_sayur, int banyak)//edit banyak pesanan yang udah dipilih/diinput
    {
         try
        {
            String query = "UPDATE `detail_pesanan` SET `banyak_pesanan` = '"+banyak+"' WHERE `id_order` = '"+id_order+"'"
                    + "AND `id_sayur` = '"+id_sayur+"'";
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);
            System.out.println("Updated");
            JOptionPane.showMessageDialog(null, "Data Edited");
            this.updateHarga(id_order, id_sayur);
        }
        catch(Exception sql)
        {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }    
    }
    public int getNota()
    {
        Random r = new Random();
        int noNota = (r.nextInt(9999-1000)+1000);
        return noNota;
    }
    public int getIdOrder()
    {
         Random r2 = new Random();
        int idOrder = (r2.nextInt(999-100)+100);
        return idOrder;
    }
    public int getBanyakKeranjang(String id_order)
    {
        int jmlData = 0;
        try
        {
            statement = koneksi.createStatement();
            String query = "SELECT * FROM `detail_pesanan` WHERE `id_order` = '"+id_order+"';";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                jmlData++;
            }
            return jmlData;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    public String[][]readKeranjang(String id_order)
    {
         try
        {
            int jmlData = 0;
            
            String data[][] = new String[getBanyakKeranjang(id_order)][3];
            String query = "SELECT * FROM `detail_pesanan` WHERE `id_order` = '"+id_order+"';";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                data[jmlData][0] = resultSet.getString("id_sayur");
                data[jmlData][1] = resultSet.getString("banyak_pesanan");
                data[jmlData][2] = resultSet.getString("total_harga");
                jmlData++;
            }
            return data;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    public int getBanyakKatalog()
    {
         int jmlData = 0;
        try
        {
            statement = koneksi.createStatement();
            String query = "Select * from `sayur`";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                jmlData++;
            }
            return jmlData;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    public String[][] readKatalog()
    {
       try
        {
            int jmlData = 0;
            String data[][] = new String[getBanyakKatalog()][3];
            String query = "SELECT * FROM `sayur`;";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                data[jmlData][0] = resultSet.getString("id_sayur");
                data[jmlData][1] = resultSet.getString("nama_sayur");
                data[jmlData][2] = resultSet.getString("harga_sayur");
                jmlData++;
            }
            return data;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }  
    }
    public int getBanyakRiwayat()
    {
        int jmlData = 0;
        try
        {
            statement = koneksi.createStatement();
            String query = "Select * from `nota`";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                jmlData++;
            }
            return jmlData;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    public String[][] readRiwayat()
    {
         try
        {
            int jmlData = 0;
            String data[][] = new String[getBanyakRiwayat()][3];
            String query = "SELECT * FROM `nota`;";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                data[jmlData][0] = resultSet.getString("no_nota");
                data[jmlData][1] = resultSet.getString("tanggal_nota");
                data[jmlData][2] = resultSet.getString("total");
                jmlData++;
            }
            return data;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    public int getBanyakKeranjangNota(String id_order)//untuk nota
    {
        int jmlData = 0;
        try
        {
            statement = koneksi.createStatement();
            String query = "SELECT * FROM `detail_pesanan`,`sayur` WHERE `detail_pesanan`.`id_sayur` = `sayur`.`id_sayur` "
                    + "AND `detail_pesanan`.`id_order` = '"+id_order+"'";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                jmlData++;
            }
            return jmlData;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    public String[][]readKeranjangNota(String id_order)
    {
        try
        {
            int jmlData = 0;
            
            String data[][] = new String[getBanyakKeranjang(id_order)][4];
            String query = "SELECT * FROM `detail_pesanan`,`sayur` WHERE `detail_pesanan`.`id_sayur` = `sayur`.`id_sayur` "
                    + "AND `detail_pesanan`.`id_order` = '"+id_order+"'";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                data[jmlData][0] = resultSet.getString("id_sayur");
                data[jmlData][1] = resultSet.getString("banyak_pesanan");
                data[jmlData][2] = resultSet.getString("harga_sayur");
                data[jmlData][3] = resultSet.getString("total_harga");
                jmlData++;
            }
            return data;
        }
          catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
}
