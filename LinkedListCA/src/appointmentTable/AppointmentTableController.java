
/*
 *  @Author = Caue Meireles Duarte
 */
package appointmentTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import doublyList.DoublyLinkedList;
import frontPage.FrontPageController;

public class AppointmentTableController implements ActionListener, WindowListener{
	
	private AppointmentTableView view;
	private AppointmentTableModel model;
	private DoublyLinkedList list;
	
	//Constructs a AppointmnetTableController instance
	public AppointmentTableController(DoublyLinkedList list) {
		this.list = list;
		this.model = new AppointmentTableModel();
		this.view = new AppointmentTableView(this);
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		this.view.dispose();
		new FrontPageController(list);
		
	}
	
	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("return")) {
			windowClosing(null);
		}
		
	}

	/*
	 *Passes the list to the model so it can create a 2D Object array with all the data from all appointments in the list, then returns the array
	 *
	 * @see AppointmentTableView, AppointmentTableModel, Person
	 */
	public Object[][] generateDataArrayFromList() {
		return model.gettingDataFromList(list);
	}

}
