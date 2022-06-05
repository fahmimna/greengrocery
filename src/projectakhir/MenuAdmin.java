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
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import java.awt.event.*;
import javax.swing.*;

public class MenuAdmin extends JFrame{
    
    JLabel judul = new JLabel("DASHBOARD");
    JButton btnTambahSayur = new JButton("ADD");
    JButton btnRiwayat = new JButton("PURCHASE");
    JButton btnBack = new JButton("BACK");
    JButton btnExit = new JButton("EXIT");
    
    public MenuAdmin(){
        setTitle("Dashboard");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(500, 350);
        setLocation(500, 100);
        this.getContentPane().setBackground(Color.YELLOW);

        add(judul);
        judul.setBounds(150, 30, 200, 30);
        judul.setForeground(new java.awt.Color(43, 84, 128));
        judul.setFont(new Font("Algerian",Font.BOLD,30));
        add(btnTambahSayur);
        btnTambahSayur.setBackground(new java.awt.Color(43, 84, 128));
        btnTambahSayur.setForeground((Color.white));
        btnTambahSayur.setFont(new Font("Aharoni",Font.BOLD,18));
        btnTambahSayur.setBounds(50, 70, 175, 80);
        add(btnRiwayat);
        btnRiwayat.setBackground(new java.awt.Color(43, 84, 128));
        btnRiwayat.setForeground((Color.white));
        btnRiwayat.setFont(new Font("Aharoni",Font.BOLD,18));
        btnRiwayat.setBounds(250, 70, 175, 80);
        add(btnBack);
        btnBack.setBackground(new java.awt.Color(43, 84, 128));
        btnBack.setForeground((Color.white));
        btnBack.setFont(new Font("Aharoni",Font.BOLD,18));
        btnBack.setBounds(50, 180, 175, 80);
        add(btnExit);
        btnExit.setBackground(new java.awt.Color(43, 84, 128));
        btnExit.setForeground((Color.white));
        btnExit.setFont(new Font("Aharoni",Font.BOLD,18));
        btnExit.setBounds(250, 180, 175, 80);

        btnRiwayat.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Riwayat riwayat = new Riwayat();
                dispose();
            }
        });
        
         btnTambahSayur.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Tambah tambah = new Tambah();
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
         
         btnExit.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
            }
        });
    }
}
