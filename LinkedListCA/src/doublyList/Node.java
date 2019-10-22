
/*
 *  @Author = Caue Meireles Duarte
 */
package doublyList;

import person.Person;

public class Node <E>{
	
	private Node next;
	private Node previous;
	private E person;
	
	//Class constructor, the "next" and "previous" parameters will receive null if the node is the last or first in the list.
	public Node(Node next, Node previous, E person) {
		this.next = next;
		this.previous = previous;
		this.person = person;
	}

}
