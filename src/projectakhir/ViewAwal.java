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
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class ViewAwal extends JFrame 
{
    JButton btnLoginAdmin = new JButton("LOGIN ADMIN");
    JButton btnBeliSayur = new JButton("ORDER NOW");
    JLabel judul = new JLabel("G R E E N G R O C E R Y");
    
    public ViewAwal()
    {
     setTitle("Menu Awal");
     setDefaultCloseOperation(EXIT_ON_CLOSE);
     setVisible(true);
     setLayout(null);
     setSize(400,300);
     setLocation(500,100);
     this.getContentPane().setBackground(Color.GREEN);
     
   add(judul);
        judul.setBounds(50, 10, 300, 50);
        judul.setForeground(new java.awt.Color(43, 84, 128));
        judul.setFont(new Font("Algerian",Font.BOLD,28));
        add(btnLoginAdmin);
        btnLoginAdmin.setBounds(95, 75, 200, 50);
        btnLoginAdmin.setForeground(new java.awt.Color(255, 255, 255));
        btnLoginAdmin.setFont(new Font("Aharoni",Font.BOLD,18));
        btnLoginAdmin.setBackground(new java.awt.Color(43, 84, 128));
        add(btnBeliSayur);
        btnBeliSayur.setBounds(95, 150, 200, 50);
        btnBeliSayur.setForeground(new java.awt.Color(255, 255, 255));
        btnBeliSayur.setFont(new Font("Aharoni",Font.BOLD,18));
        btnBeliSayur.setBackground(new java.awt.Color(43, 84, 128));
     
    btnBeliSayur.addActionListener(new ActionListener()
     {
         @Override
         public void actionPerformed(ActionEvent e)
         {  
              Beli beli = new Beli();
             dispose();
         }
     });
     
   btnLoginAdmin.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
               login Login = new login();
                dispose();
            }
        });
       
   }
    
}