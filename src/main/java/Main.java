import java.sql.*;

public class Main {

    static String url = "jdbc:postgresql://localhost:5432/postgres"; // table details
    static String username = "postgres";
    static String password = "dincer1";
    //MySql infos--------------------------------------------------------
    static String myUrl = "jdbc:mysql://sql3.freesqldatabase.com/sql3690872"; // table details
    static String myUser = "sql3690872";
    static String myPass = "dtEtTbcvvi";
    public static void main(String[] args) {

        getData();

    }

    public static void getData(){
        try{
            // Connection con = DriverManager.getConnection(url, username, password);
            Connection con = DriverManager.getConnection(myUrl, myUser, myPass);

            PreparedStatement prestmt = con.prepareStatement("SELECT * FROM crud_test");
            ResultSet rs = prestmt.executeQuery();

            while(rs.next()){
                //main get columns
                int id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                Date birthDate = rs.getDate("birthDate");

                System.out.println(id+"|"+firstName +" "+ lastName+ "|" + birthDate);
            }
            // use con here
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setData(){
        int id ;
        String firstName;
        String lastName;
        Date birthDate;


        try{
            Connection con = DriverManager.getConnection(myUrl, myUser, myPass);

            PreparedStatement prestmt = con.prepareStatement(String.format("%s",));

        }catch(SQLException e){
            throw new RuntimeException(e);
        }



    }


}
