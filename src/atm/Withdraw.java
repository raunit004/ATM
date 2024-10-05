package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;

public class Withdraw extends JFrame implements ActionListener
{
    JTextField amount;
    JButton wdraw,back;
    String cardnumber,pinnumber;
    Withdraw(String cardnumber,String pinnumber)
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
        
        JLabel withdraw=new JLabel("Enter the Amount you want to withdraw");
        withdraw.setForeground(Color.WHITE);
        withdraw.setFont(new Font("System",Font.BOLD,16));
        withdraw.setBounds(180, 300, 400, 20);
        image.add(withdraw);
        
        amount=new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD,16));
        amount.setBounds(170,350,320,25);
        image.add(amount);
        
        wdraw=new JButton("Withdraw");
        wdraw.setBounds(355, 485, 150, 30);
        wdraw.addActionListener(this);
        image.add(wdraw);
        
        back=new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==wdraw)
        {
            String cardnumber=this.cardnumber;
            String pinnumber=this.pinnumber;
            String amt=amount.getText();
            Date date=new Date();
            if(ae.getSource()==back)
            {
                setVisible(false);
                new Transactions(cardnumber,pinnumber).setVisible(true);
            }
            if(amt.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
            }
            else
            {
                try
                {
                    Conn conn=new Conn();
                    
                    ResultSet rs=conn.s.executeQuery("select * from bank where Card_Number ='"+cardnumber+"'and Pin_Number='"+pinnumber+"'");
                    int balance=0;
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

                    if(ae.getSource()!= back && balance<Integer.parseInt(amt))
                    {
                        JOptionPane.showMessageDialog(null, "Insuffiecient Balance");
                        return;
                    }
                    String query="insert into bank values('"+cardnumber+"','"+pinnumber+"','"+date+"','Withdrawl','"+amt+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs. "+amt+" Debited Successfully");

                    setVisible(false);
                    new Transactions(cardnumber,pinnumber).setVisible(true);
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }
            }
        }
        else if(ae.getSource()==back)
        {
            setVisible(false);
            new Transactions(cardnumber,pinnumber).setVisible(true);
        }
    }
    public static void main(String args[])
    {
        new Withdraw("","");
    }
}
