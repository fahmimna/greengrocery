/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectakhir;

/**
 *
 * @author HP
 */
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewNota extends JFrame
{
    JLabel judul = new JLabel ("YOUR ORDER");
    JLabel lnota = new JLabel("No Nota");
    JLabel tfnota = new JLabel();
    JLabel lidorder = new JLabel("ID Order");
    JLabel tfidorder = new JLabel();
    JLabel ltotalharga = new JLabel("Total");
    JLabel tftotalharga = new JLabel();
    JLabel tftanggal = new JLabel ();
    JButton btnBack = new JButton ("MENU");
    
    JTable tabel;
    DefaultTableModel tableModel; 
    JScrollPane scrollPane;
    Object namaKolom[] = {"ID Sayur", "Banyak Pesanan (kg)", "Harga/kg (Rp)", "Total (Rp)"};
    
    public ViewNota(){
        tableModel = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);

        
        setTitle("Rekap Pesanan");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(900, 600);
        setLocation(200, 50);   
        this.getContentPane().setBackground(Color.YELLOW);
        
        add(judul);
        judul.setBounds(350, 30, 250, 30);
        judul.setForeground(new java.awt.Color(43, 84, 128));
        judul.setFont(new Font("Algerian",Font.BOLD,30));
        add(lnota);
        lnota.setBounds(30, 100, 120, 20);
        add(tfnota);
        tfnota.setBounds(180, 100, 150, 20);
        add(lidorder);
        lidorder.setBounds(30, 130, 120, 20);
        add(tfidorder);
        tfidorder.setBounds(180, 130, 150, 20);
        add(ltotalharga);
        ltotalharga.setBounds(600, 450, 120, 20);
        add(tftotalharga);
        tftotalharga.setBounds(750, 450, 120, 20);
        add(tftanggal);
        tftanggal.setBounds(650, 130, 200, 20);
        add(btnBack);
        btnBack.setBounds(30, 20, 80, 30);
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setFont(new Font("Aharoni",Font.BOLD,15));
        btnBack.setBackground(new java.awt.Color(43, 84, 128));
        
        add(scrollPane);
        scrollPane.setBounds(10, 175, 870, 240);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); 
    }
    
    public void setNota (String no_nota)
    {
        tfnota.setText(no_nota);
    }    
    
    public void setIdOrder (String id_order)
    {
        tfidorder.setText(id_order);
    }
    
    public void setTotal(String total_harga)
    {
        tftotalharga.setText("Rp " + total_harga);
    }
    
    public void setTanggal(String tanggal)
    {
        tftanggal.setText(tanggal);
    }
    
}