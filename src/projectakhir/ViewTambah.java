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

public class ViewTambah extends JFrame{
    JLabel judul = new JLabel("ADD VEGETABLES");
    JLabel lidsayur = new JLabel("ID Sayur");
    JTextField tfidsayur = new JTextField();
    JLabel lnamasayur = new JLabel("Nama Sayur");
    JTextField tfnamasayur = new JTextField();
    JLabel lhargasayur = new JLabel("Harga Sayur");
    JTextField tfhargasayur = new JTextField();
    
    JButton btnAdd = new JButton("ADD");
    JButton btnDelete = new JButton("DELETE");
    JButton btnEdit = new JButton("EDIT");
    JButton btnExit = new JButton("EXIT");
    JButton btnBack = new JButton("BACK");
    
    JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    Object namaKolom[] = {"ID Sayur", "Nama Sayur", "Harga/kg (Rp)"};
    
    public ViewTambah(){
         tableModel = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);
        
        setTitle("Data Pesanan");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(900, 600);
        setLocation(200, 50);
        this.getContentPane().setBackground(Color.YELLOW);
      
        add(judul);
        judul.setBounds(350, 30, 300, 30);
        judul.setForeground(new java.awt.Color(43, 84, 128));
        judul.setFont(new Font("Bauhaus 93",Font.PLAIN,30));
        add(lidsayur);
        lidsayur.setBounds(30, 100, 120, 20);
        add(tfidsayur);
        tfidsayur.setBounds(180, 100, 150, 20);
        add(lnamasayur);
        lnamasayur.setBounds(30, 130, 120, 20);
        add(tfnamasayur);
        tfnamasayur.setBounds(180, 130, 150, 20);
        add(lhargasayur);
        lhargasayur.setBounds(30, 160, 120, 20);
        add(tfhargasayur);
        tfhargasayur.setBounds(180, 160, 150, 20);
        add(btnAdd);
        btnAdd.setBounds(550, 130, 100, 30);
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setFont(new Font("Aharoni",Font.BOLD,15));
        btnAdd.setBackground(new java.awt.Color(43, 84, 128));
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
        btnBack.setBounds(615, 210, 100, 30);
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setFont(new Font("Aharoni",Font.BOLD,15));
        btnBack.setBackground(new java.awt.Color(43, 84, 128));
        
        //TABEL
        add(scrollPane); 
        scrollPane.setBounds(20, 200, 480, 300);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        //scrollpane-nya vertikal
        
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
                MenuAdmin Admin = new MenuAdmin();
                dispose();
            }
        });
    }
    
    public String getIdSayur()
    {
        return tfidsayur.getText();
    }
    public String getNamaSayur()
    {
        return tfnamasayur.getText();
    }
   public String getHargaSayur()
   {
       return tfhargasayur.getText();
   }
}