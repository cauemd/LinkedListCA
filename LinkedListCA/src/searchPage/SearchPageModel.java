
/*
 *  @Author = Caue Meireles Duarte
 */
package searchPage;

import dbConnector.DbConnector;
import doublyList.DoublyLinkedList;
import doublyList.Node;
import person.Person;

public class SearchPageModel {

	private SearchPageController controller;
	private DoublyLinkedList list;

	//constructs a instance to work as the model of the search node feature
	public SearchPageModel(SearchPageController controller, DoublyLinkedList list) {
		this.controller = controller;
		this.list = list;
	}

	/*
	 * Search for a node using its ID in the linked list and remove it from the list. The controller will always pass an existing id as parameters.
	 * Also calls method in DbConnector class that will remove the respective tuple from the database.
	 * 
	 * @param id	a String representing the id of the appointment being removed.
	 * @see DbConnector, DoublyLinkedList
	 * 
	 */
	public void removeNode(String id) {

		//in case there is only one node in the list
		if(list.getSize() == 1 ) {
			list.setSize(0);
			list.setFirstNode(null);
			list.setLastNode(null);				
		} else {

			Node currentNode = list.getFirstNode();
			boolean foundNode = false;
			
			//iterating through the list to get the node that matches the id
			do{
				if(currentNode.getPerson().getID().equals(id)) {	
					foundNode = true;
					if (currentNode == list.getFirstNode()) {				//in case the node being removed is the first node
						currentNode.getNext().setPrevious(null);
						list.setFirstNode(currentNode.getNext());

					} else if (currentNode == list.getLastNode()) {		//in case the node being removed is the last node
						currentNode.getPrevious().setNext(null);
						list.setLastNode(currentNode.getPrevious());

					}else {													//in case it's a node from the middle of the list
						currentNode.getNext().setPrevious(currentNode.getPrevious());
						currentNode.getPrevious().setNext(currentNode.getNext());
					}																				
				}else {
					currentNode = currentNode.getNext();
				}

			}while(!foundNode);
			
			//removing the node from the database
			DbConnector db = new DbConnector();
			db.removeEntryFromDB(id);
		}
	}
	/*
	 *Search for a Person object in the Linked List using its ID. Return null if there are no matching IDs.
	 *
	 * @param 	id	a String representing the id of the appointment that the person being searched has.
	 * @return	A instance of the Person class if it matches the string passed as parameter. Returns null otherwise.
	 *
	 * @see		DoublyLinkedList, Person, SearchPageController
	 */
	public Person searchPersonID(String aptID) {

		//checks if list is empty
		if (list.getSize() == 0) {
			return null;
		}
		Node node = list.getFirstNode();
		while (node != null) {
			if (node.getPerson().getID().equals(aptID)) {
				return node.getPerson();
			} else {
				node = node.getNext();
			}
		}
		return null;
	}

}
