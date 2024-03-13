import java.sql.*;
import org.postgresql.*;

public class Main {

    static String url = "jdbc:postgresql://localhost:5432/postgres"; // table details
    static String username = "postgres";
    static String password = "dincer1";
    public static void main(String[] args) {

        try{
            Connection con = DriverManager.getConnection(url, username, password);

            PreparedStatement prestmt = con.prepareStatement("SELECT * FROM users");
            ResultSet rs = prestmt.executeQuery();

            while(rs.next()){
                //main get columns
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");

                System.out.println(firstName + lastName);
            }
            // use con here
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
