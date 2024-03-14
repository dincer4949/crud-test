import java.sql.*;
import java.util.Scanner;

public class Main {

    Scanner scnr = new Scanner(System.in);

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
        int id=0;
        String firstName="";
        String lastName="";
        Date birthDate=null;
        //ask to user



        try{
            Connection con = DriverManager.getConnection(myUrl, myUser, myPass);

            PreparedStatement prestmt = con.prepareStatement(String.format("INSERT INTO `crud_test`(id,firstName,lastName,birthDate) VALUES (%d,\"%s\",\"%s\",\"%s\") ",id,firstName,lastName,birthDate));

        }catch(SQLException e){
            throw new RuntimeException(e);
        }



    }


}
