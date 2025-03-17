import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() throws SQLException{
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payslip", "root", "2024");
        return con;
    } 
}