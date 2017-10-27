import java.sql.Connection;

public class test {
    public static void main(String[] args) {
        //Connection con = DB_connector.connect();
        DB_statements statements = new DB_statements();
        //statements.createNewDB();
        statements.useDB("ThisDatabase");
        //statements.createTable("MyTable");
        statements.insertData("MyTable");
    }
}
