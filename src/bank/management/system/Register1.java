package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class Register1 extends JFrame implements ActionListener{ 
    
    long rnum;
    JTextField nameTextField, emailTextField, addrTextField, cityTextField, stateTextField, pinCodeTextField;
    JButton next;
    JRadioButton M, F, married, unmarried, other;
    JDateChooser DateChooser;

    Register1() {
        setLayout(null);
        setTitle("Application Form Page 1");
        Random ran = new Random();
        rnum = Math.abs((ran.nextLong() % 9000L) + 1000L);
        
        JLabel formno = new JLabel("APPLICATION FORM NO.: " + rnum);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);
        
        JLabel perDetails = new JLabel("Page 1 : Personal Details");
        perDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        perDetails.setBounds(280, 90, 400, 40);
        add(perDetails);
        
        JLabel warning = new JLabel("All fields are required**");
        warning.setFont(new Font("Raleway", Font.BOLD, 12));
        warning.setForeground(Color.red);
        warning.setBounds(570, 120, 200, 30);
        add(warning);
        
        JLabel fullName = new JLabel("Full Name:");
        fullName.setFont(new Font("Raleway", Font.BOLD, 20));
        fullName.setBounds(100, 150, 100, 30);
        add(fullName);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300, 150, 400, 30);
        add(nameTextField);
        
        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 200, 150, 40);
        add(dob);
        
        DateChooser = new JDateChooser();
        DateChooser.setBounds(300, 200, 400, 30);
        DateChooser.setForeground(Color.black);
        add(DateChooser);
                
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 250, 150, 40);
        add(gender);
        
        M = new JRadioButton("Male");
        M.setBounds(300, 250, 60 ,30);
        M.setBackground(Color.white);
        add(M);
        
        F = new JRadioButton("Female");
        F.setBounds(400, 250, 80 ,30);
        F.setBackground(Color.white);
        add(F);
        
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(M);
        genderGroup.add(F);
        
        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 300, 150, 40);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300, 300, 400, 30);
        add(emailTextField);
        
        JLabel maritalS = new JLabel("Marital Status:");
        maritalS.setFont(new Font("Raleway", Font.BOLD, 20));
        maritalS.setBounds(100, 350, 150, 40);
        add(maritalS);
        
        married = new JRadioButton("Married");
        married.setBounds(300, 350, 80 ,30);
        married.setBackground(Color.white);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(460, 350, 100 ,30);
        unmarried.setBackground(Color.white);
        add(unmarried);
        
        other = new JRadioButton("Other");
        other.setBounds(640, 350, 60 ,30);
        other.setBackground(Color.white);
        add(other);
        
        ButtonGroup MaritalSGroup = new ButtonGroup();
        MaritalSGroup.add(married);
        MaritalSGroup.add(unmarried);
        MaritalSGroup.add(other);
        
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 400, 150, 40);
        add(address);
        
        addrTextField = new JTextField();
        addrTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addrTextField.setBounds(300, 400, 400, 30);
        add(addrTextField);
        
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 450, 150, 40);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(300, 450, 400, 30);
        add(cityTextField);
        
        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 500, 150, 40);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTextField.setBounds(300, 500, 400, 30);
        add(stateTextField);
        
        JLabel pinCode = new JLabel("Pin Code:");
        pinCode.setFont(new Font("Raleway", Font.BOLD, 20));
        pinCode.setBounds(100, 550, 150, 40);
        add(pinCode);
        
        pinCodeTextField = new JTextField();
        pinCodeTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pinCodeTextField.setBounds(300, 550, 400, 30);
        add(pinCodeTextField);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 620, 80, 30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.white);
        
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);        
    }
    
    public void actionPerformed(ActionEvent ae){
                
        String formno = "" + rnum;
        String fullName = nameTextField.getText();
        String dob = ((JTextField) DateChooser.getDateEditor().getUiComponent()).getText();
        
        String gender = null;
        if(M.isSelected()){
            gender = "Male";
        }
        else if(F.isSelected()){
            gender = "Female";
        }
        
        String email = emailTextField.getText();
        
        String maritalS = null;
        if(married.isSelected()){
            maritalS = "Married";
        }
        else if(unmarried.isSelected()){
            maritalS = "Unmarried";
        }
        else if(other.isSelected()){
            maritalS = "Other";
        }
        
        String address = addrTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pinCode = pinCodeTextField.getText();
        
        try{
            if ((fullName.equals("")) || (dob.equals("")) || (address.equals("")) || (city.equals("")) || (state.equals("")) || (pinCode.equals(""))) {
                JOptionPane.showMessageDialog(null, "Field/s are not filled*");
            }
            else{
                Conn con = new Conn();
                String query = "insert into registeration values('"+formno+"', '"+fullName+"', '"+dob+"', '"+gender+"', '"+email+"', '"+maritalS+"', '"+address+"', '"+city+"', '"+state+"', '"+pinCode+"')";
                con.s.executeUpdate(query);
                
                setVisible(false);
                new Register2(formno, fullName).setVisible(true);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }
       
    public static void main(String args[]){
        new Register1();
    }
  
}
