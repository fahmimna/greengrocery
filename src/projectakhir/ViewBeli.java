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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class ViewBeli extends JFrame
{
    JLabel judul = new JLabel("ORDER NOW");
    JLabel lnota = new JLabel ("No. Nota");
    JLabel tfnota = new JLabel();
    JLabel lidorder = new JLabel ("ID Order");
    JLabel tfidorder = new JLabel();
    JLabel lidsayur = new JLabel("ID Sayur");
    JTextField tfidsayur = new JTextField();
    JLabel lbanyak = new JLabel("Banyak pesanan (kg)");
    JTextField tfbanyak = new JTextField();
    JLabel lkatalog = new JLabel("Katalog Sayur");
    JLabel lkeranjang = new JLabel ("Keranjang Anda");
    
    JButton btnAdd = new JButton("ADD TO CART");
    JButton btnDone = new JButton("DONE");
    JButton btnDelete = new JButton("DELETE");
    JButton btnEdit = new JButton("EDIT");
    JButton btnExit = new JButton("EXIT");
    JButton btnBack = new JButton("BACK");
    
    JTable tabel;
    JTable tabel2;
    DefaultTableModel tableModel; 
    DefaultTableModel tableModel2;
    JScrollPane scrollPane;
    JScrollPane scrollPane2;
    Object namaKolom[] = {"ID Sayur", "Nama Sayur", "Harga/kg (Rp)"};
    Object namaKolom2[] = {"ID Sayur", "Banyak Pesanan (kg)", "Total (Rp)"};
    
    public ViewBeli()
    {
      tableModel = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);
        
        tableModel2 = new DefaultTableModel(namaKolom2, 0);
        tabel2 = new JTable(tableModel2);
        scrollPane2 = new JScrollPane(tabel2);        
        
        setTitle("Data Pesanan");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(900, 600);
        setLocation(200, 50); 
        this.getContentPane().setBackground(Color.YELLOW);
      
        add(judul);
        judul.setBounds(370, 30, 200, 30);
        judul.setForeground(new java.awt.Color(43, 84, 128));
        judul.setFont(new Font("Algerian",Font.BOLD,30));
        add(lnota);
        lnota.setBounds(30, 100, 120, 20);
        lnota.setForeground(new java.awt.Color(43, 84, 128));
        add(tfnota);
        tfnota.setBounds(180, 100, 150, 20);
        add(lidorder);
        lidorder.setBounds(30, 130, 120, 20);
        lidorder.setForeground(new java.awt.Color(43, 84, 128));
        add(tfidorder);
        tfidorder.setBounds(180, 130, 150, 20);
        add(lidsayur);
        lidsayur.setBounds(30, 160, 120, 20);
        lidsayur.setForeground(new java.awt.Color(43, 84, 128));
        add(tfidsayur);
        tfidsayur.setBounds(180, 160, 150, 20);
        add(lbanyak);
        lbanyak.setBounds(30, 190, 120, 20);
        lbanyak.setForeground(new java.awt.Color(43, 84, 128));
        add(tfbanyak);
        tfbanyak.setBounds(180, 190, 150, 20);
        add(btnAdd);
        btnAdd.setBounds(180, 220, 120, 30);
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setFont(new Font("Aharoni",Font.BOLD,15));
        btnAdd.setBackground(new java.awt.Color(43, 84, 128));

        add(btnDone);
        btnDone.setBounds(550, 130, 100, 30);
        btnDone.setForeground(new java.awt.Color(255, 255, 255));
        btnDone.setFont(new Font("Aharoni",Font.BOLD,15));
        btnDone.setBackground(new java.awt.Color(43, 84, 128));
        add(btnDelete);
        btnDelete.setBounds(675, 130, 100, 30);
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setFont(new Font("Aharoni",Font.BOLD,15));
        btnDelete.setBackground(new java.awt.Color(43, 84, 128));
        add(btnEdit);
        btnEdit.setBounds(550, 170, 100, 30);
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setFont(new Font("Aharoni",Font.BOLD,15));
        btnEdit.setBackground(new java.awt.Color(43, 84, 128));
        add(btnExit);
        btnExit.setBounds(675, 170, 100, 30);
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setFont(new Font("Aharoni",Font.BOLD,15));
        btnExit.setBackground(new java.awt.Color(43, 84, 128));
        add(btnBack);
        btnBack.setBounds(612, 210, 100, 30);
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setFont(new Font("Aharoni",Font.BOLD,15));
        btnBack.setBackground(new java.awt.Color(43, 84, 128));
        
        add(lkatalog);
        lkatalog.setBounds(125, 270, 120, 20);
        lkatalog.setForeground(new java.awt.Color(43, 84, 128));
        add(scrollPane);
        scrollPane.setBounds(25, 300, 300, 240);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
 
        add(lkeranjang);
        lkeranjang.setBounds(575, 270, 120, 20);
        lkeranjang.setForeground(new java.awt.Color(43, 84, 128));
        add(scrollPane2);
        scrollPane2.setBounds(400, 300, 450, 240);
        scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); 
        
        btnExit.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
            }
        });
        
        btnBack.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ViewAwal view = new ViewAwal();
                dispose();
            }
        });
    }
    
    public String getIdSayur()
    {
        return tfidsayur.getText();
    }
    
    public String getBanyak()
    {
        return tfbanyak.getText();
    }
    
    public void setNota (String no_nota)
    {
        tfnota.setText(no_nota);
    }    
    
    public void setIdOrder (String id_order)
    {
        tfidorder.setText(id_order);
    } 
}