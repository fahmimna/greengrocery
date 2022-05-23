package projectakhir;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class login extends JFrame{
    String pass="admin";
    String user="admin";
    final JTextField fuser = new JTextField(10);
    final JPasswordField fpass = new JPasswordField(10);
    
    JLabel luser = new JLabel("Username");
    JLabel lpass = new JLabel("Password");
    JButton btnOk = new JButton("LOGIN");
    JLabel judul = new JLabel("LOGIN ADMIN");
    
    public login(){
        setTitle("LOGIN ADMIN");
            setDefaultCloseOperation(3);
                setSize(400, 300);
                setLocation(500, 100);
                this.getContentPane().setBackground(Color.YELLOW);
        setLayout(null);
                add(luser);
                add(fuser);
                add(lpass);
                add(fpass);
                add(btnOk);
                add(judul);
                
        judul.setBounds(120, 10, 200, 50);
        judul.setBounds(120, 10, 200, 50);
        judul.setForeground(new java.awt.Color(43, 84, 128));
        judul.setFont(new Font("algerian",Font.PLAIN,30));
        luser.setBounds(20,70,120,40);
        luser.setForeground(new java.awt.Color(43, 84, 128));
        luser.setFont(new Font("Aharoni",Font.BOLD,18));
        fuser.setBounds(125,70,230,40);
        fuser.setForeground(new java.awt.Color(0, 0, 0));
        fuser.setFont(new Font("Aharoni",Font.PLAIN,15));
        lpass.setBounds(20,130,120,40);
        lpass.setForeground(new java.awt.Color(43, 84, 128));
        lpass.setFont(new Font("Aharoni",Font.BOLD,18));
        fpass.setBounds(125,130,230,40);
        fpass.setForeground(new java.awt.Color(0, 0, 0));
        fpass.setFont(new Font("Aharoni",Font.PLAIN,15));
        btnOk.setBounds(150,185,100,50);
        btnOk.setBackground(new java.awt.Color(43, 84, 128));
        btnOk.setForeground((Color.white));
        btnOk.setFont(new Font("Aharoni",Font.BOLD,18));
        
         btnOk.addActionListener((ActionEvent e) -> {
            if(user.equalsIgnoreCase(fuser.getText()) && pass.equalsIgnoreCase(fpass.getText()))
            {
                MenuAdmin admin = new MenuAdmin();
                admin.setVisible(true);
                dispose();}
            else 
            {
                JOptionPane.showMessageDialog(null, "Wrong Username or Password !");
            }

        });
                setVisible(true);
    }
}