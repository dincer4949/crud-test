import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scnr = new Scanner(System.in);

    static String url = "jdbc:postgresql://localhost:5432/postgres"; // table details
    static String username = "postgres";
    static String password = "dincer1";
    //MySql infos--------------------------------------------------------
    static String myUrl = "jdbc:mysql://sql3.freesqldatabase.com/sql3692828"; // table details
    static String myUser = "sql3692828";
    static String myPass = "BP8fglQUEM";
    public static void main(String[] args) {

        getData();
        setData();

    }
    public static void getData(){

        ArrayList<String> results = new ArrayList<String>();
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

                results.add(id+"|"+firstName +" "+ lastName+ "|" + birthDate);
            }

            for(String result:results){
                System.out.println(result);
            }


            // use con here
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static void setData(){

        //ask to user
        System.out.print("Enter an ID for the new user: ");
        int id = scnr.nextInt();
        System.out.print("Enter the firstname of the new user: ");
        String firstName= scnr.next();
        System.out.print("Enter the lastname of the new user: ");
        String lastName= scnr.next();
        System.out.println("Enter the birthdate of the new user(YYYY-MM-DD: ");
        String birthDate= scnr.next();

        try{
            Connection con = DriverManager.getConnection(myUrl, myUser, myPass);
            PreparedStatement prestmt = con.prepareStatement("INSERT INTO `crud_test`(id,firstName,lastName,birthDate) VALUES (?,?,?,?) ");

            prestmt.setInt(1,id);
            prestmt.setString(2,firstName);
            prestmt.setString(3,lastName);
            prestmt.setDate(4,Date.valueOf(birthDate));

            int rowsAffected = prestmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("The new user created!");
                System.out.println("-------------------------------------");
            } else {
                System.out.println("Failed to create the new user.");
            }

            getData();

        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void updateData(){
        try{
            Connection con = DriverManager.getConnection(myUrl, myUser, myPass);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


}
