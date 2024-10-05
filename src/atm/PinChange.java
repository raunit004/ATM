package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener
{
    JPasswordField pin,repin;
    JButton change,back;
    String cardnumber,pinnumber;
    PinChange(String cardnumber,String pinnumber)
    {
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("Change Your PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,20));
        text.setBounds(250, 300, 500, 35);
        image.add(text);
        
        JLabel pintext=new JLabel("New PIN");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System",Font.BOLD,16));
        pintext.setBounds(170, 350, 500, 35);
        image.add(pintext);
        
        pin=new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,16));
        pin.setBounds(300,355,150,20);
        image.add(pin);
        
        JLabel newpin=new JLabel("Re-Enter PIN");
        newpin.setForeground(Color.WHITE);
        newpin.setFont(new Font("System",Font.BOLD,16));
        newpin.setBounds(170, 380, 500, 35);
        image.add(newpin);
        
        repin=new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,16));
        repin.setBounds(300,385,150,20);
        image.add(repin);
        
        change=new JButton("Change");
        change.setBounds(355, 470, 130, 25);
        change.addActionListener(this);
        image.add(change);
        
        back=new JButton("BACK");
        back.setBounds(355, 500, 130, 25);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()==change)
        {
            try 
            {
                String npin=pin.getText();
                String rpin=pin.getText();

                if(!npin.equals(rpin))
                {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                
                if(npin.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please enter PIN");
                    return;
                }
                if(rpin.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                    return;
                }
                
                Conn conn=new Conn();
                String query1="update bank set Pin_Number='"+rpin+"' where Pin_Number='"+pinnumber+"'";
                conn.s.executeUpdate(query1);
                String query2="update login set Pin_Number='"+rpin+"' where Pin_Number='"+pinnumber+"'";
                conn.s.executeUpdate(query2);
                String query3="update signupthree set Pin_Number='"+rpin+"' where Pin_Number='"+pinnumber+"'";
                conn.s.executeUpdate(query3);
                
                
                JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
                
                setVisible(false);
                new Transactions(cardnumber,rpin).setVisible(true);
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
        else
        {
            setVisible(false);
            new Transactions(cardnumber,pinnumber).setVisible(true);
        }
    }
    public static void main(String args[])
    {
        new PinChange("","").setVisible(true);
    }
}
