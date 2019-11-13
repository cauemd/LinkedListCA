
/*
 *  @Author = Caue Meireles Duarte
 */
package appointmentTable;

import doublyList.DoublyLinkedList;
import doublyList.Node;

public class AppointmentTableModel {

	/*
	 *Creates an Object[][] array, iterates through the list and populates the array with the data from the appointments.
	 *
	 * @param list 		a DoublyLinkedList with the all the data from the appointments
	 * @return			a Object[][] with all the data from the appointments
	 *
	 * @see AppointmentTableView, AppointmentTableModel, Person
	 */
	public Object[][] gettingDataFromList(DoublyLinkedList list) {
		Object[][] data = new Object[list.getSize()][5];
		Node current = list.getFirstNode();
		int counter = 0;
		while (current != null) {
			data[counter][0] = current.getPerson().getID();
			data[counter][1] = current.getPerson().getfName();
			data[counter][2] = current.getPerson().getlName();
			data[counter][3] = current.getPerson().getPassport();
			data[counter][4] = current.getPerson().getArrivalDate();
			current = current.getNext();
			counter++;
		}
		return data;
	}

	
	
}
