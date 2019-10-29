
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
	private String id;
	
	//Class constructor, makes sure no object is initialized with missing data
	public Person(String fName, String lName, String passport, int priority, String id) {
		this.fName = fName;
		this.lName = lName;
		this.passport = passport;
		this.priority = priority;
		this.id = id;
	}
	
	/*
	 *Returns the person's first name attribute.
	 *
	 */
	public String getfName() {
		return this.fName;
	}
	
	/*
	 *Returns the person's last name attribute.
	 *
	 */
	public String getlName() {
		return this.lName;
	}

	/*
	 *Returns the person's passport attribute.
	 *
	 */
	public String getPassport() {
		return this.passport;
	}

	/*
	 *Returns the person's priority attribute.
	 *
	 */
	public int getPriority() {
		return this.priority;
	}
	
	/*
	 *Returns the person's appointment ID.
	 *
	 */
	public String getID() {
		return this.id;
	}

}
