package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 

public class Register2 extends JFrame implements ActionListener{ 
    
    JTextField pannoTextField, aadharnoTextField;
    JButton next;
    JRadioButton yes, no;
    JComboBox educationbox, incomebox, occupationbox;
    String formno;

    Register2(String formno, String fullName) {
        this.formno = formno;
        setLayout(null);
        setTitle("Application Form Page 2");
        
        JLabel addDetails = new JLabel("Page 2 : Additional Details");
        addDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        addDetails.setBounds(280, 90, 400, 40);
        add(addDetails);
        
        JLabel warning = new JLabel("All fields are required**");
        warning.setFont(new Font("Raleway", Font.BOLD, 12));
        warning.setForeground(Color.red);
        warning.setBounds(570, 140, 200, 30);
        add(warning);
        
        JLabel educational = new JLabel("Educational");
        educational.setFont(new Font("Raleway", Font.BOLD, 20));
        educational.setBounds(100, 180, 200, 30);
        add(educational);
        
        JLabel Qualification = new JLabel("Qualification:");
        Qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        Qualification.setBounds(100, 210, 200, 30);
        add(Qualification);
        
        String eduarr[] = {"Select...", "Non-Graduate", "Graduate", "Post-Graduate", "Other"};
        educationbox = new JComboBox(eduarr);
        educationbox.setFont(new Font("Raleway", Font.BOLD, 14));
        educationbox.setBackground(Color.white);
        educationbox.setBounds(300, 195, 400, 30);
        add(educationbox);

        
        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 260, 150, 40);
        add(income);
        
        String incomearr[] = {"Select..", "<= 2,50,000", "<= 6,00,000", "> 6,00,000"};
        incomebox = new JComboBox(incomearr);
        incomebox.setFont(new Font("Raleway", Font.BOLD, 14));
        incomebox.setBackground(Color.white);
        incomebox.setBounds(300, 260, 400, 30);
        add(incomebox);
                
        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 310, 150, 40);
        add(occupation);
        
        String occuparr[] = {"Select...", "Student", "Service/Job", "Business", "Senior Citizen", "Other"};
        occupationbox = new JComboBox(occuparr);
        occupationbox.setFont(new Font("Raleway", Font.BOLD, 14));
        occupationbox.setBackground(Color.white);
        occupationbox.setBounds(300, 310, 400, 30);
        add(occupationbox);
        
        JLabel panno = new JLabel("Pan Number:");
        panno.setFont(new Font("Raleway", Font.BOLD, 20));
        panno.setBounds(100, 360, 150, 40);
        add(panno);
        
        pannoTextField = new JTextField();
        pannoTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pannoTextField.setBounds(300, 360, 400, 30);
        add(pannoTextField);
        
        JLabel aadharno = new JLabel("Aadhar Number:");
        aadharno.setFont(new Font("Raleway", Font.BOLD, 20));
        aadharno.setBounds(100, 410, 250, 40);
        add(aadharno);
                
        aadharnoTextField = new JTextField();
        aadharnoTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharnoTextField.setBounds(300, 410, 400, 30);
        add(aadharnoTextField);
        
        JLabel existacc = new JLabel("Existing Account:");
        existacc.setFont(new Font("Raleway", Font.BOLD, 20));
        existacc.setBounds(100, 460, 300, 40);
        add(existacc);
        
        yes = new JRadioButton("Yes");
        yes.setBounds(300, 460, 60 ,30);
        yes.setBackground(Color.white);
        add(yes);
        
        no = new JRadioButton("No");
        no.setBounds(400, 460, 60 ,30);
        no.setBackground(Color.white);
        add(no);
        
        ButtonGroup existaccGroup = new ButtonGroup();
        existaccGroup.add(yes);
        existaccGroup.add(no);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 620, 80, 30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.white);
        
        setSize(850,800);
        setLocation(350, 10);
        setVisible(true);        
    }
    
    public void actionPerformed(ActionEvent ae){
                
        //String formno = "" + rnum;
        String educational = (String) educationbox.getSelectedItem();
        String income = (String) incomebox.getSelectedItem();
        String occupation = (String) occupationbox.getSelectedItem();
        String panno = (String) pannoTextField.getText();
        String aadharno = (String) aadharnoTextField.getText();
        
        String existacc = null;
        if(yes.isSelected()){
            existacc = "Yes";
        }
        else if(no.isSelected()){
            existacc = "No";
        }
        
        try{
            if ((educational.equals("")) || (income.equals("")) || (occupation.equals("")) || (panno.equals("")) || (aadharno.equals(""))) {
                JOptionPane.showMessageDialog(null, "Field/s are not filled*");
            }
            else{
                Conn con = new Conn();
                String query = "insert into registeration2 values('"+formno+"', '"+educational+"', '"+income+"', '"+occupation+"', '"+panno+"', '"+aadharno+"', '"+existacc+"')";
                con.s.executeUpdate(query);
                
                setVisible(false);
                new Register3(formno).setVisible(true);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }
       
    public static void main(String args[]){
        new Register2("", "");
    }
  
} 
    

