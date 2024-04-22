import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbData {
    //Database Credentials
    private static String dbUrl; // table details
    private static String dbUser;
    private static String dbPass;
    //Database Index
    private static String header;
    private static String context;
    private static Date date;

    private List<String> headers;
    private List<String> contexts;
    private List<Date> dates;
   /* public DbData(String url, String user, String password) {
        url=dbUrl;
        user=dbUser;
        password=dbPass;

        try{
            Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
        }catch (SQLException e){
            System.out.println(e);
        }
    }*/

    public DbData(){

        headers = new ArrayList<>();
        contexts = new ArrayList<>();
        dates = new ArrayList<>();

        dbUrl="jdbc:mysql://avnadmin:AVNS_b1GW5bgz7-zCbovjbiz@approject-dannyzincher-a05d.b.aivencloud.com:28101/defaultdb?ssl-mode=REQUIRED";
        dbUser="avnadmin";
        dbPass="AVNS_b1GW5bgz7-zCbovjbiz";

        try{
            Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
            PreparedStatement prestmt = con.prepareStatement("SELECT * FROM blog");
            ResultSet rs = prestmt.executeQuery();
            while(rs.next()){

                headers.add(rs.getString("header"));
                contexts.add (rs.getString("context"));
                dates.add( rs.getDate("date"));


            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public String getHeader(int index){
        return headers.get(index);
    }

    public String getContext(){
        return context;
    }
    public Date getDate(){
        return date;
    }

    public void setHeader(String newHeader){
        try{
            Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
            PreparedStatement prestmt = con.prepareStatement("INSERT INTO `blog`(header) VALUES (?) ");

            prestmt.setString(1,newHeader);

            prestmt.executeUpdate();

        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void setContext(String newContext){
        try{
            Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
            PreparedStatement prestmt = con.prepareStatement("INSERT INTO `blog`(context) VALUES (?) ");

            prestmt.setString(1,newContext);

            prestmt.executeUpdate();

        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void setDate(Date newDate){
        try{
            Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
            PreparedStatement prestmt = con.prepareStatement("INSERT INTO `blog`(date) VALUES (?) ");

            prestmt.setDate(1,newDate);

            int rowsAffected = prestmt.executeUpdate();

        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }


}
