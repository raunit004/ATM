package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signuptwo extends JFrame implements ActionListener
{
    JTextField aadhar,pan;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion, category, income, education, occupation;
    String formno;
    Signuptwo(String formno)
    {
        this.formno=formno;
        setLayout(null);
        
        setTitle("New Account Application Form: PAGE 2");
        
        JLabel additionalDetails=new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,30));
        additionalDetails.setBounds(240, 30, 400, 40);
        add(additionalDetails);
        
        JLabel reli=new JLabel("Religion: ");
        reli.setFont(new Font("Raleway",Font.BOLD,20));
        reli.setBounds(100, 150, 100, 30);
        add(reli);
        
        String valReligion[]={"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion=new JComboBox(valReligion);
        religion.setBounds(300, 150, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);
                
        JLabel cate=new JLabel("Category: ");
        cate.setFont(new Font("Raleway",Font.BOLD,20));
        cate.setBounds(100, 200, 160, 30);
        add(cate);
        
        String valCategory[]={"General", "OBC", "SC", "ST", "Others"};
        category=new JComboBox(valCategory);
        category.setBounds(300, 200, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);
        
        JLabel inco=new JLabel("Income: ");
        inco.setFont(new Font("Raleway",Font.BOLD,20));
        inco.setBounds(100, 250, 140, 30);
        add(inco);
        
        String valIncome[]={"Nil", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000", "More Than 10,00,000"};
        income=new JComboBox(valIncome);
        income.setBounds(300, 250, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);
        
        JLabel edu=new JLabel("Educational");
        edu.setFont(new Font("Raleway",Font.BOLD,20));
        edu.setBounds(100, 300, 440, 30);
        add(edu);
                
        JLabel quali=new JLabel("Qualification: ");
        quali.setFont(new Font("Raleway",Font.BOLD,20));
        quali.setBounds(100, 330, 140, 30);
        add(quali);
        
        String valEducation[]={"No Education","10th Pass","12th Pass","Graduate","Post Graduate","Doctorate","Others"};
        education=new JComboBox(valEducation);
        education.setBounds(300, 320, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);
        
        JLabel occu=new JLabel("Occupation: ");
        occu.setFont(new Font("Raleway",Font.BOLD,20));
        occu.setBounds(100, 400, 160, 30);
        add(occu);
        
        String valOccupation[]={"No Occupation","Salaried","Self-Employed","Business","Student","Retired","Others"};
        occupation=new JComboBox(valOccupation);
        occupation.setBounds(300, 400, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        JLabel panNumber=new JLabel("PAN Number: ");
        panNumber.setFont(new Font("Raleway",Font.BOLD,20));
        panNumber.setBounds(100, 450, 140, 30);
        add(panNumber);
        
        pan=new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD, 14));
        pan.setBounds(300, 450, 400, 30);
        add(pan);
        
        JLabel aadharNumber=new JLabel("Aadhar Number: ");
        aadharNumber.setFont(new Font("Raleway",Font.BOLD,20));
        aadharNumber.setBounds(100, 500, 180, 30);
        add(aadharNumber);
        
        aadhar=new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD, 14));
        aadhar.setBounds(300, 500, 400, 30);
        add(aadhar);
        
        JLabel seniorcitizen=new JLabel("Senior Citizen: ");
        seniorcitizen.setFont(new Font("Raleway",Font.BOLD,20));
        seniorcitizen.setBounds(100, 550, 180, 30);
        add(seniorcitizen);
        
        syes=new JRadioButton("Yes");
        syes.setBounds(300,550,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno=new JRadioButton("No");
        sno.setBounds(450,550,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup citizen=new ButtonGroup();
        citizen.add(syes);
        citizen.add(sno);
        
        JLabel account=new JLabel("Existing Account: ");
        account.setFont(new Font("Raleway",Font.BOLD,20));
        account.setBounds(100, 600, 180, 30);
        add(account);
        
        eyes=new JRadioButton("Yes");
        eyes.setBounds(300,600,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno=new JRadioButton("No");
        eno.setBounds(450,600,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup existing=new ButtonGroup();
        existing.add(eyes);
        existing.add(eno);
        
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
        String formno=this.formno;
        String Sreligion=(String) religion.getSelectedItem();
        String Scategory=(String) category.getSelectedItem();
        String Sincome=(String) income.getSelectedItem();
        String Seducation=(String) education.getSelectedItem();
        String Soccupation=(String) occupation.getSelectedItem();
        String Seniorcitizen=null;
        if(syes.isSelected())
        {
            Seniorcitizen="Yes";
        }
        else if(sno.isSelected())
        {
            Seniorcitizen="No";
        }
        String ExistingAccount=null;
        if(eyes.isSelected())
        {
            ExistingAccount="Yes";
        }
        else if(eno.isSelected())
        {
            ExistingAccount="No";
        }
        String Span=pan.getText();
        String Saadhar=aadhar.getText();
        
        try
        {
            Conn c=new Conn();
            String query="insert into Signuptwo values('"+formno+"','"+Sreligion+"','"+Scategory+"','"+Sincome+"','"+Seducation+"','"+Soccupation+"','"+Span+"','"+Saadhar+"','"+ExistingAccount+"','"+Seniorcitizen+"')";
            c.s.executeUpdate(query);
            
            setVisible(false);
            new Signupthree(formno);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public static void main(String args[])
    {
        new Signuptwo("");
    }
}
