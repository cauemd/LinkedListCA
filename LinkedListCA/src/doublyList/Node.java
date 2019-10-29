
/*
 *  @Author = Caue Meireles Duarte
 */
package doublyList;

import person.Person;

public class Node {

	private Node next;
	private Node previous;
	private Person person;

	/*
	 *Class constructor, receives only a Person object as argument. Next and Previous node defined by DoublyLinked class add method.
	 *
	 * @param	person A person object that will be added to the Linked List
	 * @see 	DoublyLinkedList, Person
	 */
	public Node(Person person) {
		this.person = person;
	}

	/*
	 *Returns the reference to the next node in the Linked List. Returns null if it's the last node.
	 *
	 * @return	the next Node object in the Linked List.
	 * @see		DoublyLinkedList
	 */
	public Node getNext() {
		return this.next;
	}

	/*
	 *Returns the reference to the previous node in the Linked List. Returns null if it's the first node.
	 *
	 * @return 	the previous Node object in the Linked List.
	 * @see 	DoublyLinkedList
	 */
	public Node getPrevious() {
		return this.previous;
	}
	
	/*
	 *Returns the passport attribute of the Person being referenced in the Node.
	 *
	 * @return 	a String containing the passport number from the Person object that this node holds reference to.
	 * @see 	Person
	 */
	public String getPersonPassport() {
		return this.person.getPassport();
	}
	
	/*
	 *Returns the passport attribute of the Person being referenced in the Node.
	 *
	 * @return	the priority of the appointment of the person that this node holds reference to.
	 * @see 	Person
	 */
	public int getPersonPriority() {
		return this.person.getPriority();
	}

	/*
	 * Sets the node passed as argument as the next link to the node calling the method.
	 * 
	 * @param	node	the node being assigned as in the next position from this node.
	 * @see		DoublyLinkedList
	 */
	public void setNext(Node node) {
		this.next = node;
		
	}
	
	/*
	 * Sets the node passed as argument as the next link to the node calling the method.
	 *
	 * @param	node	the node being assigned as in the previous position from this node.
	 *
	 * @see 	DoublyLinkedList
	 */
	public void setPrevious(Node node) {
		this.next = node;
		
	}
}
