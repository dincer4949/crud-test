import java.sql.*;

public class Main {

    static String url = "jdbc:postgresql://localhost:5432/users"; // table details
    static String username = "postgres";
    static String password = "dincer1";
    public static void main(String[] args) {
        getConnection();

    }


    public static void getConnection() {

        try{
            Connection con = DriverManager.getConnection(url, username, password);
            String getTable = "SELECT * FROM users";
            PreparedStatement prestmt = con.prepareStatement(getTable);
            ResultSet rs = prestmt.executeQuery();

            while(rs.next()){
                //main get columns
            }
            // use con here
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
