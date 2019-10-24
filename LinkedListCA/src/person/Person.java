
/*
 *  @Author = Caue Meireles Duarte
 */
package person;

//Class that will hold the data regarding the people in the system.
public class Person {
	
	private String fName;
	private String lName;
	private String passport;
	private int priority;
	
	//Class constructor, makes sure no object is initialized with missing data
	public Person(String fName, String lName, String passport, int priority) {
		System.out.println(this);
		this.fName = fName;
		this.lName = lName;
		this.passport = passport;
		this.priority = priority;
	}
	
	/*
	 *Returns the person's first name attribute.
	 *
	 * @see DoublyLinkedList
	 */
	public String getFName() {
		return this.fName;
	}
	
	/*
	 *Returns the person's last name attribute.
	 *
	 * @see DoublyLinkedList
	 */
	public String getLName() {
		return this.lName;
	}

	/*
	 *Returns the person's passport attribute.
	 *
	 * @see DoublyLinkedList
	 */
	public String getPassport() {
		return this.passport;
	}

	/*
	 *Returns the person's priority attribute.
	 *
	 * @see DoublyLinkedList
	 */
	public int getPriority() {
		return this.priority;
	}

}
