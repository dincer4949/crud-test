import java.sql.*;

public class DbData {
    //Database Credentials
    private static String dbUrl; // table details
    private static String dbUser;
    private static String dbPass;
    //Database Index
    private static String header;
    private static String context;
    private static Date date;
    public DbData(String url, String user, String password) {
        url=dbUrl;
        user=dbUser;
        password=dbPass;

        try{
            Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public DbData(){
        dbUrl="jdbc:mysql://avnadmin:AVNS_b1GW5bgz7-zCbovjbiz@approject-dannyzincher-a05d.b.aivencloud.com:28101/defaultdb?ssl-mode=REQUIRED";
        dbUser="avnadmin";
        dbPass="AVNS_b1GW5bgz7-zCbovjbiz";

        try{
            Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
            PreparedStatement prestmt = con.prepareStatement("SELECT * FROM blog");
            ResultSet rs = prestmt.executeQuery();
            while(rs.next()){

                header = rs.getString("header");
                context = rs.getString("context");
                date = rs.getDate("date");

            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public String getHeader(){
        return header;
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
