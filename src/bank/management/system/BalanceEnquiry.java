package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
    
    JLabel image, text;
    JButton backB;
    String pin;
    
    BalanceEnquiry(String pin){
        this.pin = pin;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ATMScreen.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0, 0, 900 ,900);
        add(image);
        
        backB = new JButton("BACK");
        backB.setBounds(400, 510, 150, 30);
        backB.setBackground(Color.black);
        backB.setForeground(Color.white);    
        backB.addActionListener(this);
        image.add(backB);
        int balance = 0;
        try{
            Conn con = new Conn();
            String query = "select * from bankEntries where PIN = '"+pin+"'";
            ResultSet rs = con.s.executeQuery(query);
            while(rs.next()){
                if(rs.getString("transactionType").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }
                else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        text = new JLabel("Your Current Balance is Rs. "+balance);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.red);
        text.setBounds(230, 320, 500, 40);
        image.add(text);
                
        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);       
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pin).setVisible(true);
    }    
    
    public static void main(String[] args){
        new BalanceEnquiry("").setVisible(true);
    }
}
