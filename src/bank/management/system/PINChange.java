package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PINChange extends JFrame implements ActionListener{
    JPasswordField npinTextF, rpinTextF;
    JButton changeB, backB;
    String pin;
        
    PINChange(String pin){
        this.pin = pin;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ATMScreen.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
               
        JLabel Text = new JLabel("CHANGE YOUR PIN");
        Text.setFont(new Font("System", Font.BOLD, 20));
        Text.setBounds(270, 220, 400, 40);
        image.add(Text);

        JLabel npinText = new JLabel("Enter new PIN");
        npinText.setFont(new Font("System", Font.BOLD, 14));
        npinText.setBounds(190, 370, 400, 40);
        image.add(npinText);
        
        npinTextF = new JPasswordField();
        npinTextF.setFont(new Font("System", Font.BOLD, 14));
        npinTextF.setBounds(320, 380, 200, 25);
        image.add(npinTextF);     
        
        JLabel rpinText = new JLabel("Re-enter new PIN");
        rpinText.setFont(new Font("System", Font.BOLD, 14));
        rpinText.setBounds(190, 430, 400, 40);
        image.add(rpinText);
        
        rpinTextF = new JPasswordField();
        rpinTextF.setFont(new Font("System", Font.BOLD, 14));
        rpinTextF.setBounds(320, 440, 200, 25);
        image.add(rpinTextF);
        
        changeB = new JButton("CHANGE");
        changeB.setBounds(240, 485, 100, 30);
        changeB.setBackground(Color.black);
        changeB.setForeground(Color.white);
        changeB.addActionListener(this);
        image.add(changeB);
        
        backB = new JButton("BACK");
        backB.setBounds(390, 485, 100, 30);
        backB.setBackground(Color.black);
        backB.setForeground(Color.white);    
        backB.addActionListener(this);
        image.add(backB);
        
        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);       
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            String npin = npinTextF.getText();
            String rpin = rpinTextF.getText();

            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
            
            if(ae.getSource() == changeB){
                if(npinTextF.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Enter new PIN");
                }
                if(rpinTextF.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Re-enter new PIN");
                }
            
                Conn con = new Conn();
                String query1 = "update registeration3 set PIN = '"+rpin+"' where PIN = '"+pin+"'";
                String query2 = "update login set PIN = '"+rpin+"' where PIN = '"+pin+"'";
                String query3 = "update bankEntries set PIN = '"+rpin+"' where PIN = '"+pin+"'";
            
                con.s.executeUpdate(query1);
                con.s.executeUpdate(query2);
                con.s.executeUpdate(query3);
            
                JOptionPane.showMessageDialog(null, "PIN changed Successfully!");
                setVisible(false);
                new Transactions(rpin).setVisible(true);
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
    
    public static void main(String[] args){
        new PINChange("").setVisible(true);
    }
}
