package rest_api;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp.BasicDataSource;

public class DatabaseConnectivity {

    private static DatabaseConnectivity  databaseconnectivity;
    private BasicDataSource ds;

    
   
    
    
    private DatabaseConnectivity() throws IOException, SQLException, PropertyVetoException {
        ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");

       
   /*    
        ds.setUsername("root");
        ds.setPassword("9559287622");
        ds.setUrl("jdbc:mysql://localhost:3306/healthok");
        
    */
        // the settings below are optional -- dbcp can work with defaults
        //ds.setMinIdle(5);
        //ds.setMaxIdle(20);
        //ds.setMaxOpenPreparedStatements(180);
       
        ds.setUsername("adminuzuSCxp");
        ds.setPassword("GQBXVWgreeuA");
        ds.setUrl("jdbc:mysql://127.3.104.130:3306/healthok");
        // the settings below are optional -- dbcp can work with defaults
        //ds.setMinIdle(5);
        //ds.setMaxIdle(20);
           //ds.setMaxOpenPreparedStatements(180);
	
    }

    public static DatabaseConnectivity getInstance() throws IOException, SQLException, PropertyVetoException {
        if (databaseconnectivity == null) {
        	databaseconnectivity = new DatabaseConnectivity();
            return databaseconnectivity;
        } else {
            return databaseconnectivity;
        }
    }

    public Connection getConnection() throws SQLException {
        return this.ds.getConnection();
        
    }
    
    
    public static void closeDatabase(Connection connection)
    {  try {
    	 if(connection!=null)
         connection.close();
        }
     catch(Exception e)
           {}
    }
    
    // use this statement for establishing connection to database 
    // connection = DatabaseConnectivity.getInstance().getConnection();
    
    }