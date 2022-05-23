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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import javax.swing.JTable;

public class ControllerNota 
{
    ViewNota viewNota;
    ModelToko modelToko;
    String id_order, no_nota, total_harga;
    
    public ControllerNota(ViewNota viewNota, ModelToko modelToko, String no_nota, String id_order, String total_harga)
    {
        this.viewNota = viewNota;
        this.modelToko = modelToko;

        this.no_nota = no_nota;
        this.id_order = id_order;
        this.total_harga = total_harga;
        
        if(modelToko.getBanyakKeranjangNota(id_order) != 0)
        {
         String dataKeranjang[][] = modelToko.readKeranjangNota(id_order);
         viewNota.tabel.setModel((new JTable(dataKeranjang, viewNota.namaKolom)).getModel());
        }
        
        viewNota.btnBack.addActionListener((ActionEvent e)->
        {  
            ViewAwal viewAwal = new ViewAwal();
            viewNota.dispose();           
        });
        
        viewNota.setNota(no_nota);
        viewNota.setIdOrder(id_order);
        viewNota.setTotal(total_harga);
        
        LocalDate current = LocalDate.now();
        String tanggal = current.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
        
        viewNota.setTanggal(tanggal);
    }
}