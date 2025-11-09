
package studentms;
import java.util.*;
import java.sql.*;

public class DBConnection {
    private static final String url = "jdbc:mysql://localhost:3306/studentdb";
    private static final String user = "root";
    private static final String pass = "";
    
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url,user,pass);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
