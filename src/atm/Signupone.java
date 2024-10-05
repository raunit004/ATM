package atm;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

public class Signupone extends JFrame implements ActionListener
{
    long random;
    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pincodeTextField;
    JButton next;
    JRadioButton male, female, married, unmarried, mOthers, Gothers;
    JDateChooser date;
    Signupone()
    {
        setLayout(null);
        Random ran=new Random();
        random=Math.abs((ran.nextLong()%9000L)+1000L);
        
        JLabel formno=new JLabel("Application Form No. "+random);
        formno.setFont(new Font("Raleway",Font.BOLD,40));
        formno.setBounds(140, 20, 600, 40);
        add(formno);
        
        JLabel personalDetails=new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,30));
        personalDetails.setBounds(240, 80, 400, 40);
        add(personalDetails);
        
        JLabel name=new JLabel("Name: ");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100, 150, 100, 30);
        add(name);
        
        nameTextField=new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        nameTextField.setBounds(300, 150, 400, 30);
        add(nameTextField);
        
        JLabel fname=new JLabel("Father's Name: ");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100, 200, 160, 30);
        add(fname);
        
        fnameTextField=new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        fnameTextField.setBounds(300, 200, 400, 30);
        add(fnameTextField);
        
        JLabel dob=new JLabel("Date of Birth: ");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100, 250, 140, 30);
        add(dob);
        
        date=new JDateChooser();
        date.setFont(new Font("Raleway",Font.BOLD, 14));
        date.setBounds(300, 250, 200, 30);
        add(date);
        
        JLabel gender=new JLabel("Gender: ");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100, 300, 140, 30);
        add(gender);
        
        male=new JRadioButton("Male");
        male.setBounds(300, 300, 60, 30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female=new JRadioButton("Female");
        female.setBounds(400, 300, 80, 30);
        female.setBackground(Color.WHITE);
        add(female);
        
        Gothers=new JRadioButton("Others");
        Gothers.setBounds(500, 300, 80, 30);
        Gothers.setBackground(Color.WHITE);
        add(Gothers);
        
        ButtonGroup genderGroup=new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(Gothers);
        
        JLabel email=new JLabel("Email: ");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100, 350, 140, 30);
        add(email);
        
        emailTextField=new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        emailTextField.setBounds(300, 350, 400, 30);
        add(emailTextField);
        
        JLabel maritalStatus=new JLabel("Marital Status: ");
        maritalStatus.setFont(new Font("Raleway",Font.BOLD,20));
        maritalStatus.setBounds(100, 400, 160, 30);
        add(maritalStatus);
        
        married=new JRadioButton("Married");
        married.setBounds(300, 400, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried=new JRadioButton("Unmarried");
        unmarried.setBounds(400, 400, 100, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        mOthers=new JRadioButton("Others");
        mOthers.setBounds(500, 400, 100, 30);
        mOthers.setBackground(Color.WHITE);
        add(mOthers);
        
        ButtonGroup maritalGroup=new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(mOthers);
        
        JLabel address=new JLabel("Address: ");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100, 450, 140, 30);
        add(address);
        
        addressTextField=new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        addressTextField.setBounds(300, 450, 400, 30);
        add(addressTextField);
        
        JLabel city=new JLabel("City: ");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100, 500, 140, 30);
        add(city);
        
        cityTextField=new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        cityTextField.setBounds(300, 500, 400, 30);
        add(cityTextField);
        
        JLabel state=new JLabel("State: ");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100, 550, 140, 30);
        add(state);
        
        stateTextField=new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        stateTextField.setBounds(300, 550, 400, 30);
        add(stateTextField);
        
        JLabel pincode=new JLabel("Pincode: ");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100, 600, 140, 30);
        add(pincode);
        
        pincodeTextField=new JTextField();
        pincodeTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        pincodeTextField.setBounds(300, 600, 400, 30);
        add(pincodeTextField);
        
        next=new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD, 14));
        next.setBounds(600, 660, 100, 30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        String formno=""+random;
        String name=nameTextField.getText();
        String fname=fnameTextField.getText();
        String dob=((JTextField) date.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected())
        {
            gender="Male";
        }
        else if(female.isSelected())
        {
            gender="Female";
        }
        else if(Gothers.isSelected())
        {
            gender="Others";
        }
        String email=emailTextField.getText();
        String marital=null;
        if(married.isSelected())
        {
            marital="Married";
        }
        else if(unmarried.isSelected())
        {
            marital="Unmarried";
        }
        else if(mOthers.isSelected())
        {
            marital="Others";
        }
        String address=addressTextField.getText();
        String city=cityTextField.getText();
        String state=stateTextField.getText();
        String pincode=pincodeTextField.getText();
        
        try
        {
            if(name.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Name is Required");
            }
            else
            {
                Conn c=new Conn();
                String query="insert into Signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new Signuptwo(formno).setVisible(true);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public static void main(String args[])
    {
        new Signupone();
    }
}
