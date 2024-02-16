package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankPage extends JFrame implements ActionListener {
    JButton register, login;    
    BankPage(){
        setTitle("Welcome");        
        setLayout(null);
        
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image img2 = img1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel label = new JLabel(img3);
        label.setBounds(130, 10, 100, 100);
        add(label);
        
        JLabel text = new JLabel("Welcome to ABC Bank");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(240, 40, 500, 40);
        add(text);

        JLabel Text1 = new JLabel("New User?");
        Text1.setBounds(380, 185, 200, 30);
        add(Text1);
        
        JLabel Text2 = new JLabel("Already have an account?");
        Text2.setBounds(335, 275, 500, 30);
        add(Text2);

        login = new JButton("LOGIN");
        login.setBounds(360, 250, 100, 30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        
        register = new JButton("REGISTER");
        register.setBounds(330, 160, 150, 30);
        register.setBackground(Color.black);
        register.setForeground(Color.white);
        register.addActionListener(this);
        add(register);
                
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800, 480);
        setVisible(true);
        setLocation(300, 180);
    } 
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == register){
            setVisible(false);
            new Register1().setVisible(true);
        }
        
        else if(ae.getSource() == login){
            setVisible(false);
            new Login().setVisible(true);
        }   
    }
    
    public static void main(String args[]){
        new BankPage();
    }
    
}
