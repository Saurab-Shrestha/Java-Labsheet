import java.sql.*;
public class ConnectDB {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/student";
    public static void main(String[] args)
    {
        try{
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open the connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,"root","");

            // Execute a query
            System.out.println("Creating a statement...");
            stmt = conn.createStatement();

            
        }

    }

}
