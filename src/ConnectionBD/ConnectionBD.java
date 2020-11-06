package ConnectionBD;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBD {

    private static final String configurationFile = "BD.properties";
    private static Connection conn;
    
    public static Connection getConnection() {
        try {
            String jdbcDriver, dbUrl, username, password;
            DatabaseAccessProperties dap = new DatabaseAccessProperties(configurationFile);
            jdbcDriver = dap.getMySqlDriver();
            dbUrl = dap.getDatabaseUrl();
            username = dap.getUsername();
            password = dap.getPassword();

            Class.forName(jdbcDriver);
            conn = DriverManager.getConnection(dbUrl, username, password);
            SQLWarningsExceptions.printWarnings(conn);
            
            return conn;
            
        } catch (SQLException se) {
            SQLWarningsExceptions.printExceptions(se);
            return null;
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            e.printStackTrace();
            return null;
    }
        
        
}

  public static void closeConn(Connection conn) throws Exception{
    if(conn!=null){
    conn.close();
    }
  }
   
}

