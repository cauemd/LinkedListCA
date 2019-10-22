
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

}
