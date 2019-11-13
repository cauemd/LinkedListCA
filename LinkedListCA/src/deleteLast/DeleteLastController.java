
/*
 *  @Author = Caue Meireles Duarte
 */
package deleteLast;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import doublyList.DoublyLinkedList;
import frontPage.FrontPageController;

public class DeleteLastController implements WindowListener, ActionListener {
	
	private DeleteLastView view;
	private DeleteLastModel model;
	private DoublyLinkedList list;
	
	public DeleteLastController(DoublyLinkedList list) {
		this.list = list;
		this.model = new DeleteLastModel(list);
		this.view = new DeleteLastView(this);
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		new FrontPageController(list);
		this.view.dispose();
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
	//handling buttons from the view
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("delete")) {													//delete appointments button
			
			if(list.getSize() == 0) {																	//error message if there are no appointments
				JOptionPane.showMessageDialog(this.view, "There are no appointments in the system.",
						"Easy Day!", JOptionPane.WARNING_MESSAGE);
			} else {																					//validating
				String textBox = view.getDeleteTF();
				if (!textBox.matches("^[0-9]+$")) {
					JOptionPane.showMessageDialog(this.view, "Please insert only numbers in the Text Field!.",
							"Unvalid text", JOptionPane.ERROR_MESSAGE);
				} else if (Integer.parseInt(textBox) >= list.getSize()) {
					int confirm = JOptionPane.showConfirmDialog(this.view,"The selected number is higher than the amount of appointments. All appointments will be deleted."
							+ "Proceed?","Confirmation",JOptionPane.YES_NO_OPTION, 1);
					if (confirm == 0) {
						model.deletingAppointments(list.getSize());
						JOptionPane.showMessageDialog(this.view, "Appointments Deleted!");
						windowClosing(null);
					} 
				} else {
					model.deletingAppointments(Integer.parseInt(textBox));
					JOptionPane.showMessageDialog(this.view, "Appointments Deleted!");
					windowClosing(null);
				}
			}
			
		} else {																						//return to front page button
			windowClosing(null);
		}
	}

	/*
	 *Returns a String representing the number of Appointments in the System.
	 *
	 * @return 	A String representation of the number appointments
	 *
	 * @see		DoublyLinkedList
	 */
	public String getTotalCount() {
		return Integer.toString(this.list.getSize());
	}
	
}
