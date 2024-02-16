package bank.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener{
    
    MiniStatement(String pin){
        setLayout(null);       
        
        JLabel bankName = new JLabel("ABC Bank");
        bankName.setFont(new Font("Raleway", Font.BOLD, 16));
        bankName.setBounds(200, 80,200, 30);
        add(bankName);
        
        JLabel cardno = new JLabel();
        cardno.setBounds(140, 150, 300, 20);
        add(cardno);
        
        JLabel bal = new JLabel();
        bal.setBounds(50, 200, 400, 30);
        add(bal);
        
        JLabel entries = new JLabel();
        entries.setBounds(50, 400, 500, 30);
        add(entries);
        
        try{
            Conn con = new Conn();
            ResultSet rs = con.s.executeQuery("select * from login where PIN = '"+pin+"'");
            while(rs.next()){
                cardno.setText("Card Number: "+rs.getString("cardNumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardNumber").substring(12));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        try{
            int balance = 0;
           Conn con1 = new Conn();
           ResultSet rs = con1.s.executeQuery("select * from bankEntries where PIN = '"+pin+"'");
           while(rs.next()){
               entries.setText(entries.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("transactionType") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
               if(rs.getString("transactionType").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } 
                else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
           }
           bal.setText("Your Current Balance is Rs: "+ balance);
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        
        setSize(500, 700);
        setLocation(480, 0);  
        getContentPane().setBackground(Color.white);
        setVisible(true);     
    }
    
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }
    
    public static void main(String[] args){
        new MiniStatement("");
    }
}
