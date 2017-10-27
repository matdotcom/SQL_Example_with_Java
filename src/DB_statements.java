import java.sql.*;

public class DB_statements {
    // Declare a statement
    private static Statement stat = null;
    // Declare a connection
    private static Connection con = DB_connector.connect();
    // Declare a result set
    private static ResultSet rs = null;




    // Method to create a new Database
    public void createNewDB()
    {
        // SQL STATEMENT
        String query = "create database if not exists ThisDatabase";
        try {
            // connection
            stat = con.createStatement();
            // execute statement
            stat.executeUpdate(query);
        }
        catch (SQLException ex)
        {
            // handle sql exceptions
            System.out.println("\n--Statement did not execut--");
            ex.printStackTrace();
        }
    }
    //method to use a database
    public void useDB(String dbName){
        //statement
        String query = "use ThisDatabase";
        try
        {
            // connection
            stat = con.createStatement();
            // execute statement
            stat.executeUpdate(query);
            System.out.println("\n --Using " +dbName+"--");
        }
        catch (SQLException ex)
        {
            // handle sql exceptions
            System.out.println("\n--douglas u fucked up--");
            ex.printStackTrace();
        }
    }
    public void createTable(String tableName){
        //sql statement
        String query = "create table if NOT EXISTS " + tableName +
                "(" +
                "id int not null auto_increment," +
                "myName varchar(29)," +
                "address varchar(28),"  +
                "primary key (id)"+
                ")";
        try
        {
        //connection
        stat = con.createStatement();
        //execute query
            stat.executeUpdate(query);
            System.out.println("\n --Table" + tableName + "Created-");
        }
        catch (SQLException ex)
        {
            System.out.println("\n--doug stop fucking up--");
            ex.printStackTrace();
        }
    }
    // method to insert data
    public void insertData(String tableName){
        // sql query
        String query = "insert into " + tableName +
                "(" + "myName, address) " +
                "values ('Mathias', 'My adress'), " +
                "('My Po', 'Her Adress'), " +
                "('Ayy lmao', 'His Adress')";
       try {
           // connect
           stat = con.createStatement();
           // execute
           stat.executeUpdate(query);
           System.out.println("\n--Data inserted into table " + tableName + "--");
       }
       catch (SQLException ex)
       {
           System.out.println("\n--Doug seriously stop--");
           ex.printStackTrace();
       }
    }
    // method to read data from table
    public void selectFromTable(String tableName){
        // SQL query
        String query = "select * from " + tableName;
        try {
            //connection
            stat = con.createStatement();
            //execute
            rs = stat.executeQuery(query);
            System.out.println("\nid\t\tmyName\t\taddress\n__________________________");
            //get data
             while(rs.next()){
                int id = rs.getInt(1); // returns id
                String myName = rs.getString("myName");//returns myName info
                String address = rs.getString("address");// returns address info
                System.out.println(id+"\t\t"+myName+"\t\t"+address);

            }
        }
        catch (SQLException ex){
            System.out.println("\n--Doug PLEASE for FUCKS SAKE--");
            ex.printStackTrace();
        }

    }


}
