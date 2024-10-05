package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener
{
    //int balance=0;
    JButton back;
    String cardnumber,pinnumber;
    BalanceEnquiry(String cardnumber,String pinnumber)
    {
        this.cardnumber=cardnumber;
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        back=new JButton("Back");
        back.setBounds(370,500,100,30);
        back.addActionListener(this);
        image.add(back);
        
        Conn c=new Conn();
        
        try
        {
            int balance=0;
            ResultSet rs=c.s.executeQuery("select * from bank where Card_Number ='"+cardnumber+"'and Pin_Number='"+pinnumber+"'");
            while(rs.next())
            {
                if(rs.getString("type").equals("Deposit"))
                {
                    balance+=Integer.parseInt(rs.getString("amount"));
                }
                else
                {
                    balance-=Integer.parseInt(rs.getString("amount"));
                }
            }
            JLabel text=new JLabel("Your current account balance is Rs. "+balance);
            text.setForeground(Color.WHITE);
            text.setBounds(170, 300, 400, 30);
            image.add(text);

            setSize(900,900);
            setLocation(300,0);
            //setUndecorated(true);
            setVisible(true);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        
        //JLabel text=new JLabel("Your current account balance is Rs. "+balance);
//        text.setForeground(Color.WHITE);
//        text.setBounds(170, 300, 400, 30);
//        image.add(text);
//        
//        setSize(900,900);
//        setLocation(300,0);
//        //setUndecorated(true);
//        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        //setVisible(false);
        new Transactions(cardnumber,pinnumber).setVisible(true);
    }
    public static void main(String args[])
    {
        new BalanceEnquiry("","");
    }
}
