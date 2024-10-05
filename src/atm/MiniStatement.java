package atm;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame
{
    String cardnumber, pinnumber;
    MiniStatement(String cardnumber, String pinnumber)
    {
        this.cardnumber=cardnumber;
        this.pinnumber=pinnumber;
        setTitle("Mini Statement");
        setLayout(null);
        
        JLabel mini=new JLabel();
        add(mini);
        
        JLabel bank=new JLabel("HELOS BANK");
        bank.setBounds(150,10,100,20);
        add(bank);
        
        JLabel card=new JLabel();
        card.setBounds(20,40,300,20);
        add(card);
        
        JLabel balance=new JLabel();
        balance.setBounds(20,80,300,20);
        add(balance);
        
        try
        {
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from login where Card_Number='"+cardnumber+"' and Pin_Number='"+pinnumber+"'");
            while(rs.next())
            {
                card.setText("Card Number: "+rs.getString("Card_Number").substring(0, 4)+"XXXXXXXX"+ rs.getString("Card_Number").substring(12));
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        
        try
        {
            Conn conn=new Conn();
            int bal=0;
            ResultSet rs=conn.s.executeQuery("select * from bank where Card_Number='"+cardnumber+"' and Pin_Number='"+pinnumber+"'");
            while(rs.next())
            {
                mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br>");
                if(rs.getString("type").equals("Deposit"))
                {
                    bal+=Integer.parseInt(rs.getString("amount"));
                }
                else
                {
                    bal-=Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your current account balance is Rs. "+bal);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        mini.setBounds(20,100,400,600);
        
        setSize(400,850);
        setLocation(10,10);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    public static void main(String args[])
    {
        new MiniStatement("","");
    }
}
