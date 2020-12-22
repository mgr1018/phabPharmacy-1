package Website;

import java.sql.*;
import java.util.ArrayList;

//DAO = data access object
public class LoginDAO {
    public static boolean validate(String email_in,String pass_in){
        boolean status=false;
        try{
            String dbUrl = System.getenv("JDBC_DATABASE_URL");
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(dbUrl);

            PreparedStatement ps=con.prepareStatement("select * from users where email=? and passw=?");
            ps.setString(1,email_in);
            ps.setString(2,pass_in);

            ResultSet rs=ps.executeQuery();
            status=rs.next();

        }catch(Exception e){System.out.println(e);}
        return status;
    }
    public static String getName(String email_in,String pass_in){
        String userName="";
        try{
            String dbUrl = System.getenv("JDBC_DATABASE_URL");
            Class.forName("org.postgresql.Driver");
            Connection con=DriverManager.getConnection(dbUrl);

            PreparedStatement ps=con.prepareStatement("select * from users where email=? and passw=?");
            ps.setString(1,email_in);
            ps.setString(2,pass_in);

            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                userName = rs.getString("fname");
            }
        }catch(Exception e){System.out.println(e);}
        return userName;
    }
    public static void addUser(String fname_in,String lname_in, String email_in,String pass_in, String cardno_in, String postcode_in){
        try{
            String dbUrl = System.getenv("JDBC_DATABASE_URL");
            Class.forName("org.postgresql.Driver");
            Connection con=DriverManager.getConnection(dbUrl);

            PreparedStatement ps=con.prepareStatement("insert into users (fname,lname,email,passw,cardno,postcode) values(?,?,?,?,?,?)");
            ps.setString(1,fname_in);
            ps.setString(2,lname_in);
            ps.setString(3,email_in);
            ps.setString(4,pass_in);
            ps.setString(5,cardno_in);
            ps.setString(6,postcode_in);

            ps.executeUpdate();
            ps.close();
        }catch(Exception e){System.out.println(e);}
    }
    public static String getProductInfo(int n){
        //ProductInfo pi = new ProductInfo();
        String out="";
        try{
            String dbUrl = System.getenv("JDBC_DATABASE_URL");
            Class.forName("org.postgresql.Driver");
            Connection con=DriverManager.getConnection(dbUrl);

            PreparedStatement ps=con.prepareStatement("select * from products where id=?");
            ps.setString(1, String.valueOf(n));
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                out = rs.getString("name");
            }

        }catch(Exception e){System.out.println(e);}
        return out;
    }

}

