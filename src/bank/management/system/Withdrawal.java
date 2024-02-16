package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener{
    
    JLabel image, text;
    JTextField amountW;
    JButton amountWB, backB;
    String pin;
    
    Withdrawal(String pin){
        this.pin = pin;
        
        setLayout(null);
          
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ATMScreen.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        text = new JLabel("Enter the amount to withdraw");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(255, 250, 400, 30);
        image.add(text);
        
        amountW = new JTextField();
        amountW.setFont(new Font("Raleway", Font.BOLD, 16));
        amountW.setBounds(255, 280, 200, 30);
        image.add(amountW);
        
        amountWB = new JButton("Withdraw");
        amountWB.setBounds(250, 490, 100, 30);
        amountWB.addActionListener(this);
        image.add(amountWB);
        
        backB = new JButton("Back");
        backB.setBounds(380, 490, 80, 30);
        backB.addActionListener(this);
        image.add(backB);
        
        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            String moneyW = amountW.getText();
            Date date = new Date();
            if(ae.getSource() == amountWB){
                if(amountW.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to withdraw");
                }
                else{
                    Conn con = new Conn();
                    String query = "select * from bankEntries where PIN = '"+pin+"'";
                    ResultSet rs = con.s.executeQuery(query); 
                    int balance = 0;
                    while(rs.next()){
                        if(rs.getString("transactionType").equals("Deposit")){
                            balance += Integer.parseInt(rs.getString("amount"));                           
                        }
                        else{
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }
                   
                    if(balance < Integer.parseInt(moneyW)){
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }
                    
                    String query1 = "insert into bankEntries values('"+pin+"', '"+date+"', 'Withdrawal', '"+moneyW+"')";
                    con.s.executeUpdate(query1);
                    JOptionPane.showMessageDialog(null, "Rs. "+moneyW+" Withdrawn Successfully!");
                    
                    setVisible(false);
                    new Transactions(pin).setVisible(true);                   
                }
            }
            else if(ae.getSource() == backB){
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    
    public static void main(String[] args) {
        new Withdrawal("").setVisible(true);
    }
}
