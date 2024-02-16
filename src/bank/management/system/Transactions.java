
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Transactions extends JFrame implements ActionListener{
    
    JButton deposit, withdrawal, fastCash, miniStatement, pinChange, balEnq, exit;
    String pin;
    Transactions(String pin){
        this.pin = pin;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ATMScreen.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Please Select an Option");
        text.setBounds(280, 220, 400, 50);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(160, 390, 130, 30);
        deposit.setBackground(Color.black);
        deposit.setForeground(Color.white);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawal = new JButton("Withdrawal");
        withdrawal.setBounds(440, 390, 130, 30);
        withdrawal.setBackground(Color.black);
        withdrawal.setForeground(Color.white);
        withdrawal.addActionListener(this);
        image.add(withdrawal);
        
        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(160, 430, 130, 30);
        fastCash.setBackground(Color.black);
        fastCash.setForeground(Color.white);
        fastCash.addActionListener(this);
        image.add(fastCash);
        
        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(440, 430, 130, 30);
        miniStatement.setBackground(Color.black);
        miniStatement.setForeground(Color.white);
        miniStatement.addActionListener(this);
        image.add(miniStatement);
        
        pinChange = new JButton("PIN Change");
        pinChange.setBounds(160, 470, 130, 30);
        pinChange.setBackground(Color.black);
        pinChange.setForeground(Color.white);
        pinChange.addActionListener(this);
        image.add(pinChange);
        
        balEnq = new JButton("Balance Enquiry");
        balEnq.setBounds(440, 470, 130, 30);
        balEnq.setBackground(Color.black);
        balEnq.setForeground(Color.white);
        balEnq.addActionListener(this);
        image.add(balEnq);
        
        exit = new JButton("Exit");
        exit.setBounds(440, 510, 130, 30);
        exit.setBackground(Color.black);
        exit.setForeground(Color.white);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);
        }
        else if(ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pin).setVisible(true);
        }
        else if(ae.getSource() == withdrawal){
            setVisible(false);
            new Withdrawal(pin).setVisible(true);
        }
        else if(ae.getSource() == fastCash){
            setVisible(false);
            new Fastcash(pin).setVisible(true);
        }
        else if(ae.getSource() == pinChange){
            setVisible(false);
            new PINChange(pin).setVisible(true);
        }
        else if(ae.getSource() == balEnq){
            setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);
        }
        else if(ae.getSource() == miniStatement){
            //setVisible(false);
            new MiniStatement(pin).setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new Transactions("");
    }
}
