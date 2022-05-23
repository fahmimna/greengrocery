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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ControllerBeli 
{
    ViewBeli viewBeli;
    ModelToko modelToko;
    
     public ControllerBeli(ViewBeli viewBeli, ModelToko modelToko)
     {
        this.viewBeli = viewBeli;
        this.modelToko = modelToko;

        int noNota = modelToko.getNota(); //generate nomor nota
        String no_nota = Integer.toString(noNota);
        int idOrder = modelToko.getIdOrder(); //generate id order
        String id_order = "P" + Integer.toString(idOrder);
        
        viewBeli.setNota(no_nota); //tampil nomor nota di view
        viewBeli.setIdOrder(id_order); //tampil id order di view
        
        if(modelToko.getBanyakKatalog() != 0) //tampil tabel sayur
        {
         String dataKatalog[][] = modelToko.readKatalog();
         viewBeli.tabel.setModel((new JTable(dataKatalog, viewBeli.namaKolom)).getModel());
        }
        
        if(modelToko.getBanyakKeranjang(id_order) != 0) //tampil tabel detail_pesanan
        {
         String dataKeranjang[][] = modelToko.readKeranjang(id_order);
         viewBeli.tabel2.setModel((new JTable(dataKeranjang, viewBeli.namaKolom2)).getModel());
        }

        modelToko.insertNota(no_nota); //insert nomor nota ke tabel nota
        modelToko.insertOrder(id_order, no_nota); //insert id order, nomor nota ke tabel pesanan
        
        viewBeli.btnAdd.addActionListener((ActionEvent e)-> //insert pesanan
        {  
           String idSayur = viewBeli.getIdSayur();
           String banyakPesan = viewBeli.getBanyak();
           
           modelToko.insertPesanan(id_order, idSayur, banyakPesan);

           String dataKeranjang[][] = modelToko.readKeranjang(id_order);
           viewBeli.tabel2.setModel(new JTable(dataKeranjang, viewBeli.namaKolom2).getModel());
           
           viewBeli.tfidsayur.setText("");
           viewBeli.tfbanyak.setText("");
           
        });
         
        viewBeli.btnDone.addActionListener((ActionEvent e)-> //ke rekap pesanan
        {
            int total = modelToko.updateNota(no_nota, id_order);
            String total_harga = Integer.toString(total);
            Nota nota = new Nota(no_nota, id_order, total_harga);
            viewBeli.dispose();
        });
        viewBeli.tabel2.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                int baris = viewBeli.tabel2.getSelectedRow();
                int kolom = viewBeli.tabel2.getSelectedColumn();
                
                String sayurterpilih = viewBeli.tabel2.getValueAt(baris, 0).toString();
                String banyakterpilih = viewBeli.tabel2.getValueAt(baris, 1).toString();
                
                viewBeli.tfidsayur.setText(sayurterpilih);
                viewBeli.tfbanyak.setText(banyakterpilih);
  
            viewBeli.btnDelete.addActionListener((ActionEvent x)-> //delete data
            {
                int input = JOptionPane.showConfirmDialog(null,
                "Are you sure want to delete ? " +sayurterpilih+ " ?", "Choose an option ...",JOptionPane.YES_NO_CANCEL_OPTION);
                if(input==0)
                {
                    modelToko.deleteOrder(id_order, sayurterpilih);
                    String dataKeranjang[][] = modelToko.readKeranjang(id_order);
                    viewBeli.tabel2.setModel(new JTable(dataKeranjang, viewBeli.namaKolom2).getModel());
                    viewBeli.tfidsayur.setText("");
                    viewBeli.tfbanyak.setText("");  
                    mouseClicked(null);
                }else
                {
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }    
            });

            viewBeli.btnEdit.addActionListener((ActionEvent ex)-> //update tabel
            {
                int banyak = Integer.parseInt(viewBeli.getBanyak());
                modelToko.editOrder(id_order, sayurterpilih, banyak);
                String dataKeranjang[][] = modelToko.readKeranjang(id_order);
                viewBeli.tabel2.setModel(new JTable(dataKeranjang, viewBeli.namaKolom2).getModel()); 
                viewBeli.tfidsayur.setText("");
                viewBeli.tfbanyak.setText("");
                mouseClicked(null);
            });
            }           
        });      
     }
     
}