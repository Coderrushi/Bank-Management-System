package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton loginB, clearB;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
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
        
        JLabel acctno = new JLabel("Card No.: ");
        acctno.setFont(new Font("Osward", Font.BOLD, 28));
        acctno.setBounds(150, 150, 400, 40);
        add(acctno);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(340, 155, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);
        
        JLabel pin = new JLabel("PIN: ");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(150, 220, 200, 40);
        add(pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(340, 225, 230, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);
        
        loginB = new JButton("LOGIN");
        loginB.setBounds(280, 300, 100, 30);
        loginB.setBackground(Color.black);
        loginB.setForeground(Color.white);
        loginB.addActionListener(this);
        add(loginB);
        
        clearB = new JButton("CLEAR");
        clearB.setBounds(410, 300, 100, 30);
        clearB.setBackground(Color.black);
        clearB.setForeground(Color.white);
        clearB.addActionListener(this);
        add(clearB);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800, 480);
        setLocation(300, 180);
        setVisible(true);
    } 
    
    public void actionPerformed(ActionEvent ae) {
        try{       
            if(ae.getSource() == loginB){
                Conn con = new Conn();               
                String cardno = cardTextField.getText();  
                String pin = pinTextField.getText();
                String query = "select * from login where cardNumber = '"+cardno+"' and PIN = '"+pin+"'";
                ResultSet rs = con.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please enter correct Card Number or PIN");
                }            
            }
            else if(ae.getSource() == clearB){
                cardTextField.setText("");
                pinTextField.setText("");          
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String args[]) {
        new Login().setVisible(true);
    }
    
}
