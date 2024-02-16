package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Register3 extends JFrame implements ActionListener{
    
    JRadioButton currAcct, savAcct, FDAcct, RDAcct;
    JCheckBox debCard, interBank, psBook, chqBook, alert, mobBank, eStat;
    JButton submitB, cancelB;
    String formno;
    
    Register3(String formno){
        this.formno = formno;
        setLayout(null);
        setTitle("Application Form Page : 3");
               
        JLabel accDetails = new JLabel("Page 3 : Account Details");
        accDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        accDetails.setBounds(280, 90, 400, 40);
        add(accDetails);
        
        JLabel warning = new JLabel("All fields are required**");
        warning.setFont(new Font("Raleway", Font.BOLD, 12));
        warning.setForeground(Color.red);
        warning.setBounds(570, 120, 400, 40);
        add(warning);
        
        JLabel accType = new JLabel("Account Type");
        accType.setBounds(150, 170, 200, 40);
        accType.setFont(new Font("Raleway", Font.BOLD, 18));
        add(accType);
               
        currAcct = new JRadioButton("Current Account");
        currAcct.setBounds(180, 210, 200, 40);
        currAcct.setBackground(Color.white);
        currAcct.setFont(new Font("Raleway", Font.BOLD, 14));
        add(currAcct);
        
        savAcct = new JRadioButton("Saving Account");
        savAcct.setBounds(420, 210, 200, 40);
        savAcct.setBackground(Color.white);
        savAcct.setFont(new Font("Raleway", Font.BOLD, 14));
        add(savAcct);
        
        FDAcct = new JRadioButton("Fixed Deposit Account");
        FDAcct.setBounds(180, 240, 200, 40);
        FDAcct.setBackground(Color.white);
        FDAcct.setFont(new Font("Raleway", Font.BOLD, 14));
        add(FDAcct);
        
        RDAcct = new JRadioButton("Recurrring Deposit Account");
        RDAcct.setBounds(420, 240, 300, 40);
        RDAcct.setBackground(Color.white);
        RDAcct.setFont(new Font("Raleway", Font.BOLD, 14));
        add(RDAcct);
        
        ButtonGroup acctGroup = new ButtonGroup();
        acctGroup.add(currAcct);
        acctGroup.add(savAcct);
        acctGroup.add(FDAcct);
        acctGroup.add(RDAcct);
        
        JLabel ServReq = new JLabel("Services Required");
        ServReq.setBounds(150, 290, 400, 40);
        ServReq.setFont(new Font("Raleway", Font.BOLD, 18));
        add(ServReq);
        
        debCard = new JCheckBox("Debit Card");
        debCard.setBackground(Color.white);
        debCard.setFont(new Font("Releway", Font.BOLD, 14));
        debCard.setBounds(180, 340, 100, 40);
        add(debCard);
        
        interBank = new JCheckBox("Internet Banking");
        interBank.setBackground(Color.white);
        interBank.setFont(new Font("Releway", Font.BOLD, 14));
        interBank.setBounds(420, 340, 200, 40);
        add(interBank);
        
        psBook = new JCheckBox("Passbook");
        psBook.setBackground(Color.white);
        psBook.setFont(new Font("Releway", Font.BOLD, 14));
        psBook.setBounds(180, 390, 100, 40);
        add(psBook);
        
        mobBank = new JCheckBox("Mobile Banking");
        mobBank.setBackground(Color.white);
        mobBank.setFont(new Font("Releway", Font.BOLD, 14));
        mobBank.setBounds(420, 390, 200, 40);
        add(mobBank);
        
        chqBook = new JCheckBox("Cheque Book");
        chqBook.setBackground(Color.white);
        chqBook.setFont(new Font("Releway", Font.BOLD, 14));
        chqBook.setBounds(180, 440, 200, 40);
        add(chqBook);
        
        alert = new JCheckBox("Email & Text Alerts");
        alert.setBackground(Color.white);
        alert.setFont(new Font("Releway", Font.BOLD, 14));
        alert.setBounds(420, 440, 300, 40);
        add(alert);
        
        eStat = new JCheckBox("E-Statement");
        eStat.setBackground(Color.white);
        eStat.setFont(new Font("Releway", Font.BOLD, 14));
        eStat.setBounds(180, 490, 200, 40);
        add(eStat);
             
        cancelB = new JButton("Cancel");
        cancelB.setBackground(Color.BLACK);
        cancelB.setForeground(Color.WHITE);
        cancelB.setFont(new Font("Raleway", Font.BOLD, 14));
        cancelB.setBounds(240, 600, 100, 30);
        cancelB.addActionListener(this);
        add(cancelB);
        
        submitB = new JButton("Submit");
        submitB.setBackground(Color.BLACK);
        submitB.setForeground(Color.WHITE);
        submitB.setFont(new Font("Raleway", Font.BOLD, 14));
        submitB.setBounds(480, 600, 100, 30);
        submitB.addActionListener(this);
        add(submitB);
        
        getContentPane().setBackground(Color.white);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submitB){
            String accType = null;
            if(currAcct.isSelected()){
                accType = "Current Account";
            }
            else if(savAcct.isSelected()){
                accType = "Saving Account";
            }
            else if(FDAcct.isSelected()){
                accType = "Fixed Deposit Account";
            }
            else if(RDAcct.isSelected()){
                accType = "Recurrring Deposit Account";
            }
            
            Random ran = new Random();
            String cardno = "" + Math.abs(ran.nextLong() % 90000000L + 1020567000000000L);
            String pin = "" + Math.abs(ran.nextLong() % 9000L + 1000L);
            
            String facility = "";
            if(debCard.isSelected()){
                facility = facility + "  Debit_Card";
            }
            if(interBank.isSelected()){
                facility = facility + "  Internet_Banking";
            }
            if(psBook.isSelected()){
                facility = facility + "  Passbook";
            }
            if(mobBank.isSelected()){
                facility = facility + "  Mobile_Banking";
            }
            if(chqBook.isSelected()){
                facility = facility + "  Cheque_Book";
            }
            if(alert.isSelected()){
                facility = facility + "  Email_&_Text_Alerts";
            }
            if(eStat.isSelected()){
                facility = facility + "  E-Statement";
            }
            try{
                if(accType.equals("")){
                    JOptionPane.showMessageDialog(null, "Account Type is required*");
                }
                else{
                    Conn con = new Conn();
                    String query1 = "insert into registeration3 values('"+formno+"', '"+cardno+"', '"+accType+"', '"+pin+"', '"+facility+"')";
                    String query2 = "insert into login values('"+formno+"', '"+cardno+"', '"+pin+"')";
                    
                    con.s.executeUpdate(query1);
                    con.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardno + "\n PIN: "+ pin);
                                           
                    new BankPage().setVisible(true);
                    setVisible(false);
                }                     
            }
            catch(Exception e){
                System.out.println(e);
            } 
        }
        else if(ae.getSource() == cancelB){
            setVisible(false);
            new Login().setVisible(true);
        }    
    }
    
    public static void main(String args[]){
        new Register3("");
    }
}
