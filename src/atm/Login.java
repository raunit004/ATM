package atm;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener
{
    JButton signin, signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    Login() 
    {
        setTitle("Automated Teller Machine");
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        
        JLabel label=new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);
        
        JLabel text=new JLabel("Welcome to ATM ");
        text.setFont(new Font("Osward", Font.BOLD, 40));
        text.setBounds(200, 40, 400, 40);
        add(text);
        
        JLabel cardno=new JLabel("Card No. ");
        cardno.setFont(new Font("Raleway", Font.BOLD, 25));
        cardno.setBounds(120, 150, 250, 30);
        add(cardno);
        
        cardTextField=new JTextField();
        cardTextField.setBounds(300, 150, 230, 30);
        add(cardTextField);
        
        JLabel pin=new JLabel("PIN ");
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(120, 220, 250, 40);
        add(pin);
        
        pinTextField=new JPasswordField();
        pinTextField.setBounds(300, 230, 230, 30);
        add(pinTextField);
        
        signin=new JButton("SIGN IN");
        signin.setBounds(300, 300, 100, 30);
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.WHITE);
        signin.addActionListener(this);
        add(signin);
        
        clear=new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup=new JButton("SIGN UP");
        signup.setBounds(320, 350, 200, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == clear)
        {
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource() == signin)
        {
            Conn conn=new Conn();
            String cardnumber=cardTextField.getText();
            String pinnumber=pinTextField.getText();
            String query="select * from login where Card_Number='"+cardnumber+"'and Pin_Number='"+pinnumber+"'";
            try
            {
                ResultSet rs=conn.s.executeQuery(query);
                if(rs.next())
                {
                    setVisible(false);
                    new Transactions(cardnumber,pinnumber).setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                }
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
            setVisible(false);
        }
        else if(ae.getSource() == signup)
        {
            setVisible(false);
            new Signupone().setVisible(true);
        }
    }
    public static void main(String[] args) 
    {
        new Login();
    }
}
