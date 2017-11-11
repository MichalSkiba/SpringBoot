package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectManager {

	
	    private static final String JDBC_LOADER = "com.mysql.jdbc.Driver";
	    private static final String URL = "jdbc:mysql://localhost:3306/";
	    private static final String LOGIN = "root";
	    private static final String PASSWORD = "root";

	    private Connection connection;

	    public ConnectManager() throws ClassNotFoundException, SQLException{
	        Class.forName(JDBC_LOADER);
	        connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
	    }

	    public Connection getConnection() throws SQLException{
	        return connection;
	    }
	    
	   
	    
	}
	
	

