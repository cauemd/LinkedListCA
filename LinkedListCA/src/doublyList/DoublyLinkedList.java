
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
	 *Adds a high priority node in the right position. Also changes the references on both adjacent nodes.
	 *
	 * @see Node
	 */
	private void addingHighPriority(Node node) {
		//in case there are no high priority nodes
		if (this.lastHighPriority == null) {
			node.setNext(this.first);
			this.first.setPrevious(node);
			this.first = node;

		//in case there are other high priority nodes	
		} else {
			node.setNext(this.lastHighPriority.getNext());
			node.setPrevious(this.lastHighPriority);
			
			//in case there are only high priority nodes on the list (node going to the back of the list)
			if(this.lastHighPriority == this.last) {
				this.lastHighPriority.setNext(node);
				this.last = node;
			//in case there are nodes with other priority
			} else {
				this.lastHighPriority.getNext().setPrevious(node);
				this.lastHighPriority.setNext(node);
			}
		}
		size++;
		this.lastHighPriority = node;
	}

	/*
	 *Adds a medium priority node in the right. Also changes the references on both adjacent nodes.
	 *
	 * @see Node
	 */
	private void addingMediumPriority(Node node) {
		//in case there are no other medium or high priority nodes
		if (this.lastMediumPriority == null && this.lastHighPriority == null) {
			this.first.setPrevious(node);
			node.setNext(this.first);
			this.first = node;

		//in case there are no medium priority nodes, but there are high priority nodes 
		} else if (this.lastMediumPriority == null) {
			node.setNext(this.lastHighPriority.getNext());
			node.setPrevious(this.lastHighPriority);
			
			//in case there are only high priority nodes (new node going to the end of the list)
			if (this.lastHighPriority.getNext() == null) {
				node.setPrevious(this.lastHighPriority);
				this.last = node;
			} else {
				this.lastHighPriority.getNext().setPrevious(node);
			}
			this.lastHighPriority.setNext(node);
			
		//in case there are both medium and high priority nodes (doesn't matter if there are low priority nodes or note)
		} else {
			node.setNext(this.lastMediumPriority.getNext());
			node.setPrevious(this.lastMediumPriority);
			this.lastMediumPriority.setNext(node);
			this.lastMediumPriority.getNext().setPrevious(node);
		}

		//verifying if the added node is the last one in the list
		if (node.getNext() == null) {
			this.last = node;
		}
		this.lastMediumPriority = node;
		size++;
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
