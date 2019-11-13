
/*
 *  @Author = Caue Meireles Duarte
 */
package deleteLast;

import dbConnector.DbConnector;
import doublyList.DoublyLinkedList;
import doublyList.Node;

public class DeleteLastModel {
	
	private DoublyLinkedList list;
	
	public DeleteLastModel(DoublyLinkedList list) {
		this.list = list;
	}

	public void deletingAppointments(int appNumber) {
		if(appNumber == 0) {
			return;
		}
		
		else {
			DbConnector db = new DbConnector();
			Node currentNode = this.list.getLastNode();
			for (int i = 0; i < appNumber; i++) {
				db.removeEntryFromDB(currentNode.getPerson().getID());
				currentNode = currentNode.getPrevious();
			}
			list.setLastNode(currentNode);
			currentNode.setNext(null);
		}
		list.setSize(list.getSize() - appNumber);
		
	}

}
