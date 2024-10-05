package atm;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener
{
    JButton rs100, rs500, rs1000, rs2000, rs5000, rs10000, exit;
    String cardnumber,pinnumber;
    FastCash(String cardnumber,String pinnumber)
    {
        this.cardnumber=cardnumber;
        this.pinnumber=pinnumber;
        
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("Select Withdrawl Amount");
        text.setBounds(235, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        rs100=new JButton("Rs 100");
        rs100.setBounds(170, 415, 150, 30);
        rs100.addActionListener(this);
        image.add(rs100);
        
        rs500=new JButton("Rs 500");
        rs500.setBounds(350, 415, 150, 30);
        rs500.addActionListener(this);
        image.add(rs500);
        
        rs1000=new JButton("Rs 1000");
        rs1000.setBounds(170, 450, 150, 30);
        rs1000.addActionListener(this);
        image.add(rs1000);
        
        rs2000=new JButton("Rs 2000");
        rs2000.setBounds(350, 450, 150, 30);
        rs2000.addActionListener(this);
        image.add(rs2000);
        
        rs5000=new JButton("Rs 5000");
        rs5000.setBounds(170, 485, 150, 30);
        rs5000.addActionListener(this);
        image.add(rs5000);
        
        rs10000=new JButton("Rs 10000");
        rs10000.setBounds(350, 485, 150, 30);
        rs10000.addActionListener(this);
        image.add(rs10000);
        
        exit=new JButton("Back");
        exit.setBounds(350, 520, 150, 30);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==exit)
        {
            setVisible(false);
            new Transactions(cardnumber,pinnumber).setVisible(true);
        }
        
        else
        {
            String amount=((JButton)ae.getSource()).getText().substring(3);
            Conn c=new Conn();
            
            try
            {
                ResultSet rs=c.s.executeQuery("select * from bank where Card_Number ='"+cardnumber+"'and Pin_Number='"+pinnumber+"'");
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
                
                if(ae.getSource()!= exit && balance<Integer.parseInt(amount))
                {
                    JOptionPane.showMessageDialog(null, "Insuffiecient Balance");
                    return;
                }
                
                Date date=new Date();
                String query="insert into bank values('"+cardnumber+"','"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                
                setVisible(false);
                new Transactions(cardnumber,pinnumber).setVisible(true);
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
            setVisible(false);
            new Transactions(cardnumber,pinnumber).setVisible(true);
        }
    }
    public static void main(String args[])
    {
        new FastCash("","");
    }
}
