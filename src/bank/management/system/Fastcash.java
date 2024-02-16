package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;


public class Fastcash extends JFrame implements ActionListener{
    
    JLabel image, text;
    JButton fiveHund, tenHund, TwentyHund, fiftyHund, hundredHund, backB;
    String pin;
    
    Fastcash(String pin){
        this.pin = pin;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ATMScreen.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        text = new JLabel("Select amount to withdraw");
        text.setBounds(280, 340, 400, 50);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        fiveHund = new JButton("Rs. 500");
        fiveHund.setBounds(160, 390, 130, 30);
        fiveHund.setBackground(Color.black);
        fiveHund.setForeground(Color.white);
        fiveHund.addActionListener(this);
        image.add(fiveHund);
        
        tenHund = new JButton("Rs. 1000");
        tenHund.setBounds(440, 390, 130, 30);
        tenHund.setBackground(Color.black);
        tenHund.setForeground(Color.white);
        tenHund.addActionListener(this);
        image.add(tenHund);
        
        TwentyHund = new JButton("Rs. 2000");
        TwentyHund.setBounds(160, 430, 130, 30);
        TwentyHund.setBackground(Color.black);
        TwentyHund.setForeground(Color.white);
        TwentyHund.addActionListener(this);
        image.add(TwentyHund);
        
        fiftyHund = new JButton("Rs. 5000");
        fiftyHund.setBounds(440, 430, 130, 30);
        fiftyHund.setBackground(Color.black);
        fiftyHund.setForeground(Color.white);
        fiftyHund.addActionListener(this);
        image.add(fiftyHund);
        
        hundredHund = new JButton("Rs. 10000");
        hundredHund.setBounds(160, 470, 130, 30);
        hundredHund.setBackground(Color.black);
        hundredHund.setForeground(Color.white);
        hundredHund.addActionListener(this);
        image.add(hundredHund);
        
        backB = new JButton("Back");
        backB.setBounds(440, 470, 130, 30);
        backB.setBackground(Color.black);
        backB.setForeground(Color.white);
        backB.addActionListener(this);
        image.add(backB);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
       
    }
    
    public void actionPerformed(ActionEvent ae){       
        try {
            String amount = ((JButton)ae.getSource()).getText().substring(4); 
            Conn con = new Conn();
            ResultSet rs = con.s.executeQuery("select * from bankEntries where PIN = '"+pin+"'");
            int balance = 0;
            while (rs.next()) {
                if(rs.getString("transactionType").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } 
                else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            } 
            
            if(ae.getSource() != backB && balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                setVisible(false);
                new Transactions(pin).setVisible(true);
                return;
            }

            if (ae.getSource() == backB) {
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
            
            else{
                Date date = new Date();
                String query = "insert into bankEntries values('"+pin+"', '"+date+"', 'Withdrawal(FC)', '"+amount+"')";
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                    
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        } 
        catch (Exception e) {
            System.out.println(e);
        }                
    }
    
    public static void main(String[] args) {
        new Fastcash("").setVisible(true);
    }
}

