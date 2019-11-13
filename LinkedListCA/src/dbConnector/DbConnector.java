
/*
 *  @Author = Caue Meireles Duarte
 */

package dbConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import doublyList.DoublyLinkedList;
import person.Person;

public class DbConnector {

	private Connection conn;

	public DbConnector(){
		try{
			// Load the database driver
			Class.forName("com.mysql.cj.jdbc.Driver").getConstructor().newInstance() ;

			String dbServer = "jdbc:mysql://localhost:3306/appointmentSystem?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String user = "root";
			String password = "";

			// Get a connection to the database
			this.conn = DriverManager.getConnection(dbServer, user, password) ;

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

	/*
	 *Gets the data from a Person object and try inserting it into the MySQL database. Returns true if the connector is successful, returns false otherwise or
	 *in case the passport atribute from the instance passed as argument is already registered in the database.
	 *
	 * @param 	person	object containing the data that will be added in the database
	 * @return	a boolean showing if the insert in the database was successful or not.
	 *
	 * @see		NewEntryView, NewEntryController, DoublyLinkedList, Person
	 */
	public boolean insertNewPerson(Person person, DoublyLinkedList list) {
		PreparedStatement stmt = null;

		try {
			//verifying if user already exists
			String query = "SELECT * FROM appointments WHERE passport = ?;";
			stmt = conn.prepareStatement(query);
			stmt.setString(1, person.getPassport());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return false;
			}	

			//inserting user into the database
			query = "INSERT INTO appointments (id, fName, lName, passport, priority, arrivalDate) VALUES (?, ?, ?, ?, ?, ?);";
			stmt = conn.prepareStatement(query);
			stmt.setString(1, person.getID());
			stmt.setString(2, person.getfName());
			stmt.setString(3, person.getlName());
			stmt.setString(4, person.getPassport());
			stmt.setInt(5, person.getPriority());
			stmt.setString(6, person.getArrivalDate());
			stmt.executeUpdate();
			
			
			//updating the number of total appointments
			switch (person.getPriority()) {
				case 1:
					query = "UPDATE totalapp SET highPriority = highPriority + 1 WHERE id = 1";
				//	list.setHighCounter(list.getHighCounter() + 1);
					break;
				case 2:
					query = "UPDATE totalapp SET mediumPriority = mediumPriority + 1 WHERE id = 1";
				//	list.setMediumCounter(list.getMediumCounter() + 1);
					break;
				default:
					query = "UPDATE totalapp SET lowPriority = lowPriority + 1 WHERE id = 1";
				//	list.setLowCounter(list.getLowCounter() + 1);
			}
			
			stmt = conn.prepareStatement(query);
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	/*
	 *Gets the data from the appointments table from the MySQL database and adds it to a list, while counting the number of high, medium and low appointments
	 *and setting the number to the list.
	 *
	 * @param 	list	the list that will receive the data from the database
	 *
	 * @see		DoublyLinkedList, Person
	 */
	public void loadList(DoublyLinkedList list) {
		PreparedStatement stmt = null;
		try {
			//Getting appointments data from database
			String query = "SELECT * FROM appointments;";
			stmt = conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Person person = new Person(rs.getString("fName"), rs.getString("lName"), rs.getString("passport"), rs.getInt("priority"), rs.getString("id"), 
						rs.getString("arrivalDate"));
				list.add(person);
			}
			
			//getting total appointments of each priority
			query = "SELECT * FROM totalapp WHERE id = 1";
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();
			rs.next();
			list.setHighCounter(rs.getInt("highPriority"));
			list.setMediumCounter(rs.getInt("mediumPriority"));
			list.setLowCounter(rs.getInt("lowPriority"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 *Removes a tuple from the database according to its ID.
	 *
	 * @param 	id	the id of the appointment that will be deleted.
	 *
	 * @see		DoublyLinkedList, Person, SearchPageModel
	 */
	public void removeEntryFromDB(String id) {
		PreparedStatement stmt = null;

		try {

			//removing appointment from database
			String query = "DELETE FROM appointments WHERE id = ?;";
			stmt = conn.prepareStatement(query);
			stmt.setString(1, id);
			stmt.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
