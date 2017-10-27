import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_connector {
    // Declare a connection
    private static Connection con = null;
    // JDBC driver
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    // the url = jdbc://host name:port#/db name
    private static String url = "jdbc:mysql://localhost:3306/";
    // user name
    private static String usr = "root";
    // password
    private static String password = "12345";

    public static Connection connect() {
        System.out.println("\n--Connecting to MySQL JDBC");


        // Lokaliser Mysql JDBC driver
        try

        {
            Class.forName(DRIVER);
        }
        // Catch exceptions if JDBC is not found
        catch (
                ClassNotFoundException ex)

        {
            ex.printStackTrace();
            System.out.println("\n--JDBC driver is missing--");

        }
        System.out.println("\n-- Mysql JDBC Driver registered--");

        // Connect to database = URL, userName, pass



        try {
            con = DriverManager.getConnection(url, usr, password);
        }
        // Catch exceptions on connection error
        catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("\n--Did not connect try agian--");

        }
        // if connection is a success
        if (con!= null){
            System.out.println("\n--Connection was a success--");
        } else{
            System.out.println("\n--Failed to connect--");
        }
        return  con;


        // Catch exceptions on connection error
    }

}
