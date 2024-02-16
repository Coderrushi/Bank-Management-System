package bank.management.system;

import java.sql.*;
        
public class Conn {
    Connection c;
    Statement s;
    
    public Conn(){
        try {
            c = DriverManager.getConnection("jdbc:mysql:///BankManagementDatabase", "root", "Rushikesh@265");
            s = c.createStatement();         
        }
        catch(Exception e){
            System.out.println("Connection failed" + e);
        }      
    }   
}
