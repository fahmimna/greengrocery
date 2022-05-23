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
import javax.swing.JOptionPane;
import javax.swing.JTable;

class ControllerRiwayat {
    ViewRiwayat viewRiwayat;
    ModelToko modelToko;
    ControllerRiwayat(ViewRiwayat viewRiwayat, ModelToko modelToko) {
        this.viewRiwayat = viewRiwayat;
        this.modelToko = modelToko;
        
        if(modelToko.getBanyakRiwayat()!= 0){
            String dataKatalog[][] = modelToko.readRiwayat();
            viewRiwayat.tabel.setModel((new JTable(dataKatalog, viewRiwayat.namaKolom)).getModel());
        }else{
            JOptionPane.showMessageDialog(null,"Empty Data");
            
        }
        viewRiwayat.btnDelete.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e){
                int baris = viewRiwayat.tabel.getSelectedRow();
                int kolom = viewRiwayat.tabel.getSelectedColumn();
                String dataterpilih = viewRiwayat.tabel.getValueAt(baris, 0).toString();
                System.out.println(dataterpilih);
                
                int input =JOptionPane.showConfirmDialog(null, "Do you want to delete Vegetable ID?" + dataterpilih + " ?" , "Select Options...." , JOptionPane.YES_NO_CANCEL_OPTION);
                if(input==0){
                    modelToko.deleteRiwayat(dataterpilih);
                    String dataKatalog[][]= modelToko.readRiwayat();
                    viewRiwayat.tabel.setModel(new JTable(dataKatalog, viewRiwayat.namaKolom).getModel());
                }else{
                    JOptionPane.showMessageDialog(null,"Not So Deleted");
                }
           }
        });
        
    
    }
}
