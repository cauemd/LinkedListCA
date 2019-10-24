
/*
 *  @Author = Caue Meireles Duarte
 */
package doublyList;

import person.Person;

public class Node {

	private Node next;
	private Node previous;
	private Person person;

	//Class constructor, the "next" and "previous" parameters will receive null if the node is the last or first in the list.
	public Node(Node next, Node previous, Person person) {
		this.next = next;
		this.previous = previous;
		this.person = person;
	}

	/*
	 *Returns the reference to the next node in the Linked List. Returns null if it's the last node.
	 *
	 * @see DoublyLinkedList
	 */
	public Node getNext() {
		return this.next;
	}

	/*
	 *Returns the reference to the previous node in the Linked List. Returns null if it's the first node.
	 *
	 * @see DoublyLinkedList
	 */
	public Node getPrevious() {
		return this.previous;
	}
	
	/*
	 *Returns the passport attribute of the Person being referenced in the Node.
	 *
	 * @see Person
	 */
	public String getPersonPassport() {
		return this.person.getPassport();
	}
	
	/*
	 *Returns the passport attribute of the Person being referenced in the Node.
	 *
	 * @see Person
	 */
	public int getPersonPriority() {
		return this.person.getPriority();
	}

	/*
	 * Sets the node passed as argument as the next link to the node calling the method.
	 *
	 * @see DoublyLinkedList
	 */
	public void setNext(Node node) {
		this.next = node;
		
	}
	
	/*
	 * Sets the node passed as argument as the next link to the node calling the method.
	 *
	 * @see DoublyLinkedList
	 */
	public void setPrevious(Node node) {
		this.next = node;
		
	}
}
