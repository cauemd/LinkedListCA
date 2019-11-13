
/*
 *  @Author = Caue Meireles Duarte
 */
package newEntry;

import dbConnector.DbConnector;
import doublyList.DoublyLinkedList;
import person.Person;

public class NewEntryModel {
	
	private NewEntryController controller;
	private DoublyLinkedList list;
	
	public NewEntryModel(NewEntryController controller, DoublyLinkedList list) {
		this.controller = controller;
		this.list = list;
	}

	/*
	 *Creates a new Person object with the data received from the controller and assigns a id to the appointment. Finally returns an instance of the Person class.
	 *
	 * @param 	fName		first name of the person being registered
	 * @param 	lName		last name of the person being registered
	 * @param 	passport	passport of the person being registered
	 * @param 	priority	the priority of the appointment
	 * @return	a Person object with all the information passed as argument.
	 * 
	 * @see		NewEntryView, NewEntryController, DoublyLinkedList, Person
	 */
	public Person newRegister(String fName, String lName, String passport, int priority, String date) {
		String id = "";
		switch (priority) {
			case 1:
				id = "A" + list.getHighCounter();
				break;
			case 2:
				id = "B" + list.getMediumCounter();
				break;
			case 3:
				id = "C" + list.getLowCounter();
				break;
		}
		
		Person person = new Person(fName, lName, passport, priority, id, date);
		
		return person;
	}
	
	/*
	 *Passes a Person object to the database connector so it can insert it into the MySQL database. Returns true if the insert is successful, returns
	 *false otherwise or in cases there is already an entry with the Person passport
	 *
	 * @param 	person	object containing the data that will be added in the database
	 * @return	a boolean showing if the insert in the database was successful or not.
	 *
	 * @see		NewEntryView, NewEntryController, DoublyLinkedList, Person
	 */
	public boolean registerInDatabase(Person person) {
		DbConnector db = new DbConnector();
		if(db.insertNewPerson(person, list)) {
			return true;
		}
		return false;
		
	}
	
	

}
