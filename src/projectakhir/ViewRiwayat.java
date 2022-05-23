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
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class ViewRiwayat extends JFrame{
    JLabel judul = new JLabel("PURCHASE HISTORY");
    JButton btnDelete = new JButton("DELETE");
    JButton btnExit = new JButton("EXIT");
    JButton btnBack = new JButton("BACK");
    
    JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    Object namaKolom[] = {"No Nota", "Tanggal Nota", "Total"};
    
    public ViewRiwayat(){
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
        judul.setBounds(300, 10, 300, 50);
        judul.setForeground(new java.awt.Color(43, 84, 128));
        judul.setFont(new Font("Bauhaus 93",Font.PLAIN,30));
        add(btnDelete);
        btnDelete.setBounds(675, 130, 100, 30);
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setFont(new Font("Aharoni",Font.BOLD,15));
        btnDelete.setBackground(new java.awt.Color(43, 84, 128));
        add(btnExit);
        btnExit.setBounds(675, 170, 100, 30);
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setFont(new Font("Aharoni",Font.BOLD,15));
        btnExit.setBackground(new java.awt.Color(43, 84, 128));
        add(btnBack);
        btnBack.setBounds(675, 210, 100, 30);
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setFont(new Font("Aharoni",Font.BOLD,15));
        btnBack.setBackground(new java.awt.Color(43, 84, 128));
        
        //TABEL
        add(scrollPane); 
        scrollPane.setBounds(20, 60, 600, 450);
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
        
}