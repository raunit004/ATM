package atm;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener
{
    JButton deposit, withdrawl, fastcash, ministatement, pinchange, enquiry, exit;
    String cardnumber,pinnumber;
    Transactions(String cardnumber,String pinnumber)
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
        
        JLabel text=new JLabel("Please Select Your Choice");
        text.setBounds(235, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        deposit=new JButton("Deposit");
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl=new JButton("Cash Withdraw");
        withdrawl.setBounds(350, 415, 150, 30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash=new JButton("Fast Cash");
        fastcash.setBounds(170, 450, 150, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement=new JButton("Mini Statement");
        ministatement.setBounds(350, 450, 150, 30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange=new JButton("Pin Change");
        pinchange.setBounds(170, 485, 150, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        enquiry=new JButton("Balance Enquiry");
        enquiry.setBounds(350, 485, 150, 30);
        enquiry.addActionListener(this);
        image.add(enquiry);
        
        exit=new JButton("Exit");
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
            System.exit(0);
        }
        else if(ae.getSource()==deposit)
        {
            new Deposit(cardnumber,pinnumber).setVisible(true);
        }
        else if(ae.getSource()==withdrawl)
        {
            new Withdraw(cardnumber,pinnumber).setVisible(true);
        }
        else if(ae.getSource()==fastcash)
        {
            new FastCash(cardnumber,pinnumber).setVisible(true);
        }
        else if(ae.getSource()==pinchange)
        {
            new PinChange(cardnumber,pinnumber).setVisible(true);
        }
        else if(ae.getSource()==enquiry)
        {
            new BalanceEnquiry(cardnumber,pinnumber).setVisible(true);
        }
        else if(ae.getSource()==ministatement)
        {
            new MiniStatement(cardnumber,pinnumber).setVisible(true);
        }
    }
    public static void main(String args[])
    {
        new Transactions("","");
    }
}
