package atm;
import java.sql.*;
public class Conn 
{
    Connection c;
    Statement s;
    public Conn()
    {
        try
        {
            c=DriverManager.getConnection("jdbc:mysql:///atm", "root", "Usccsql@7543");
            s=c.createStatement();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
