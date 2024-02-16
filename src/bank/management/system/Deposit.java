package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    
    JTextField amountD;
    JButton amountDB, backB;
    JLabel image, text;
    String pin;
    
    Deposit(String pin){
        this.pin = pin;
       
        setLayout(null);
               
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ATMScreen.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        text = new JLabel("Enter the amount to deposit");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(255, 250, 400, 30);
        image.add(text);
        
        amountD = new JTextField();
        amountD.setFont(new Font("Raleway", Font.BOLD, 16));
        amountD.setBounds(260, 290, 200, 30);
        image.add(amountD);
        
        amountDB = new JButton("Deposit");
        amountDB.setBounds(260, 350, 80, 30);
        amountDB.addActionListener(this);
        image.add(amountDB);
        
        backB = new JButton("Back");
        backB.setBounds(380, 350, 80, 30);
        backB.addActionListener(this);
        image.add(backB);
        
        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){        
        try{        
            String moneyD = amountD.getText();
            Date date = new Date();
            if(ae.getSource() == amountDB){
                if(amountD.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to Deposit");
                }
                else{
                    Conn con = new Conn();
                    String query = "insert into bankEntries values('"+pin+"', '"+date+"', 'Deposit', '"+moneyD+"')";
                    con.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs. "+moneyD+" Deposited Successfully!");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
            }
            else if(ae.getSource()==backB){
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
               
    public static void main(String[] args) {
        new Deposit("").setVisible(true);
    }
    
}
