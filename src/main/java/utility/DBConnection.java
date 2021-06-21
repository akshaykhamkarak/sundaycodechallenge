package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import exception.ConnectionUtilityException;



public class DBConnection {

	
	private static String URL="jdbc:mysql://localhost:3307/educationsystem";
	private static String USERNAME="root";
	private static String PASSWORD="Trishali@1999";

	  public static Connection getConnection()throws SQLException,ConnectionUtilityException{
		  Connection con=null;
		  try{
			  Class.forName("com.mysql.cj.jdbc.Driver");
			  con=DriverManager.getConnection(URL,USERNAME,PASSWORD);
		  }
		  catch (Exception e) {
		throw new ConnectionUtilityException("Connection not set up properly....");
		}
		return con;
	  }
}
