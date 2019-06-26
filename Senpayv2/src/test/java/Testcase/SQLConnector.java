package Testcase;		
import java.sql.Connection;  
import java.sql.DriverManager; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnector {
	
     public static void selectQuery() throws SQLException, ClassNotFoundException { 
 String dbURL = "jdbc:sqlserver://18.138.38.84:1433/SANDBOX_FPay";
 String username = "devhn";
        String password = "devhn2019";
        //Load MS SQL JDBC Driver
        Class.forName("net.sourceforge.jtds.jdbc.Driver");
        //Creating connection to the database
        Connection con = DriverManager.getConnection(dbURL,username,password);
        //Creating statement object
     Statement st = con.createStatement();
     String selectquery = "SELECT * FROM MobileConfirmation order by MobileConfirmationID desc";
        //Executing the SQL Query and store the results in ResultSet
     ResultSet rs = st.executeQuery(selectquery);
     //While loop to iterate through all data and print results
     while (rs.next()) {
     System.out.println(rs.getString("token"));
     }
        //Closing DB Connection
     con.close();
 }
}