/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectakhir;
/**
 *
 * @author HP
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ControllerTambah {
    ViewTambah viewTambah;
    ModelToko modelToko;
     ControllerTambah(ViewTambah viewTambah, ModelToko modelToko) {
        this.viewTambah = viewTambah;
        this.modelToko = modelToko;
        
        if(modelToko.getBanyakKatalog()!= 0){
            String dataKatalog[][] = modelToko.readKatalog();
            viewTambah.tabel.setModel((new JTable(dataKatalog, viewTambah.namaKolom)).getModel());
        }else{
            JOptionPane.showMessageDialog(null,"Empty Data");
            
        }
        viewTambah.btnAdd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               if (viewTambah.getIdSayur().equals("")
                        || viewTambah.getNamaSayur().equals("")
                        || viewTambah.getHargaSayur().equals("")){
                    JOptionPane.showMessageDialog(null,"Field cannot be empty");
                }else {
                    String id_sayur = viewTambah.getIdSayur();
                    String nama_sayur = viewTambah.getNamaSayur();
                    String harga_sayur = viewTambah.getHargaSayur();

                    modelToko.insertSayur(id_sayur, nama_sayur, harga_sayur);
                    viewTambah.tfidsayur.setText("");
                    viewTambah.tfnamasayur.setText("");
                    viewTambah.tfhargasayur.setText("");

                    String dataKatalog[][]= modelToko.readKatalog();
                    viewTambah.tabel.setModel((new JTable(dataKatalog, viewTambah.namaKolom)).getModel());
                } //To change body of generated methods, choose Tools | Templates.
            }
        });
         viewTambah.tabel.addMouseListener (new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                int baris = viewTambah.tabel.getSelectedRow();
                int kolom = viewTambah.tabel.getSelectedColumn();
                String dataterpilih = viewTambah.tabel.getValueAt(baris, 0).toString();
                System.out.println(dataterpilih);
                
                String id_sayur =viewTambah.tabel.getValueAt(baris, 0).toString();
                viewTambah.tfidsayur.setText(id_sayur);
                String nama_sayur =viewTambah.tabel.getValueAt(baris, 1).toString();
                viewTambah.tfnamasayur.setText(nama_sayur);
                String harga_sayur =viewTambah.tabel.getValueAt(baris, 2).toString();
                viewTambah.tfhargasayur.setText(harga_sayur);
                
                
                viewTambah.btnEdit.addActionListener(new ActionListener(){
                     @Override
                     public void actionPerformed(ActionEvent e){ 

                            String id_sayur = viewTambah.getIdSayur();
                            String nama_sayur = viewTambah.getNamaSayur();
                            String harga_sayur = viewTambah.getHargaSayur();
                            modelToko.updateSayur( id_sayur,nama_sayur, harga_sayur);


                        String dataKatalog[][]= modelToko.readKatalog();
                        viewTambah.tabel.setModel(new JTable(dataKatalog, viewTambah.namaKolom).getModel());

                    }
                });
                
                viewTambah.btnDelete.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e){
                        int input =JOptionPane.showConfirmDialog(null, "Do you want to delete Vegetable Id" + dataterpilih + " ?" , "Select Options...." , JOptionPane.YES_NO_CANCEL_OPTION);
                        if(input==0){
                            modelToko.deleteSayur(dataterpilih);
                            String dataKatalog[][]= modelToko.readKatalog();
                            viewTambah.tabel.setModel(new JTable(dataKatalog, viewTambah.namaKolom).getModel());
                        }else{
                            JOptionPane.showMessageDialog(null,"Not So Deleted");
                        }
                   }
                });
            }
        });
     }     
}

