
/*
 *  @Author = Caue Meireles Duarte
 */
package doublyList;

/*Class used as a Doubly LInked List structure for the Node objects. Considering that different nodes have different priorities, instead of keeping track of only
 * the first and last node, as a design choice the list will also keep track of the last node of both medium and high priority. This will increase efficiency 
 * when adding new nodes to the list, since there will be no need to iterate through the whole list to look for the right position.
 */

public class DoublyLinkedList <E>{

	private Node first;
	private Node last;
	private Node lastHighPriority;
	private Node lastMediumPriority;
	private int size;

	//Default constructor
	public DoublyLinkedList() {
		this.size = 0;
	}

	/*
	 *Checks the node's priority and call corresponding method to add the node in the correct position. If the Linked List is empty, adds the node to the list.
	 *
	 * @see Node, Person
	 */
	public void add(Node node) {

		//if Linked List is empty, the added node will be first and last.
		if (this.size == 0) {
			this.first = node;
			this.last = node;
			size++;
			switch (node.getPersonPriority()) {
				case 1:
					this.lastHighPriority = node;
					break;
				case 2:
					this.lastMediumPriority = node;
					break;
			}
			return;
		//Calls respective method in case list is not empty
		} else {
			switch (node.getPersonPriority()) {
			case 1:
				addingHighPriority(node);
				break;
			case 2:
				addingMediumPriority(node);
				break;
			case 3:
				addingLowPriority(node);
				break;
			}
		}
	}


	/*
	 *Adds a medium priority node before the first low priority node. Also changes the references of both adjacent nodes.
	 *
	 * @see Node
	 */
	private void addingMediumPriority(Node node) {
		//in case there are no other medium or high priority nodes
		if (this.lastMediumPriority == null) {
			
		}
	}

	/*
	 *Adds a low priority node to the end of the list. Also references the node passed as argument as the next link to the node that was at the end of the list.
	 *
	 * @see Node
	 */
	private void addingLowPriority(Node node) {
		this.last.setNext(node);
		node.setPrevious(this.last);
		this.last = node;
		size++;		
	}

	/*
	 *Iterates through the Linked List searching for a Node referencing a Person that has the same passport attribute as the String being passed as argument.
	 *Returns null if the argument doesn't  match with any Node.
	 *
	 * @see DoublyLinkedList
	 */
	public Node searchPerson(String passport) {
		Node temp = this.first;

		do {
			if (temp.getPersonPassport().equalsIgnoreCase(passport)) {
				return temp;
			} else {
				temp = temp.getNext();
			}

		}while (temp != null);

		return null;
	}


}
