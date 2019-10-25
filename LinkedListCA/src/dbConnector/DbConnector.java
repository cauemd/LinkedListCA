
/*
 *  @Author = Caue Meireles Duarte
 */

package dbConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnector {

	public DbConnector(){
		try{
			// Load the database driver
			Class.forName("com.mysql.cj.jdbc.Driver").getConstructor().newInstance() ;

			String dbServer = "jdbc:mysql://localhost:3306/ultravision?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String user = "root";
			String password = "";
			
			String query = "SELECT * FROM customers";

			// Get a connection to the database
			Connection conn = DriverManager.getConnection(dbServer, user, password) ;

			// Get a statement from the connection
			Statement stmt = conn.createStatement() ;

			// Execute the query
			ResultSet rs = stmt.executeQuery(query) ;


			// Loop through the result set
			while(rs.next()) {
				System.out.println( rs.getString("custID") + "\t" + rs.getString("fName") + 
						"\t" + rs.getString("lName")) ;
			}

			// Close the result set, statement and the connection
			rs.close() ;
			stmt.close() ;
			conn.close() ;
		}
		catch( SQLException se ){
			System.out.println( "SQL Exception:" ) ;

			// Loop through the SQL Exceptions
			while( se != null ){
				System.out.println( "State  : " + se.getSQLState()  ) ;
				System.out.println( "Message: " + se.getMessage()   ) ;
				System.out.println( "Error  : " + se.getErrorCode() ) ;

				se = se.getNextException() ;
			}
		}
		catch( Exception e ){
			System.out.println( e ) ;
		}

	}
}
