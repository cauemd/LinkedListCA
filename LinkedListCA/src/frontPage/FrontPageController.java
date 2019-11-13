
/*
 *  @Author = Caue Meireles Duarte
 */
package frontPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import appointmentTable.AppointmentTableController;
import deleteLast.DeleteLastController;
import doublyList.DoublyLinkedList;
import newEntry.NewEntryController;
import searchPage.SearchPageController;

//Controller for the front page
public class FrontPageController implements ActionListener, WindowListener {

	private FrontPageView view;
	private DoublyLinkedList list;

	public FrontPageController(DoublyLinkedList list) {
		this.view = new FrontPageView(this);
		this.list = list;
	}

	

	//creates option pane to confirm if the user wants to close the program
	@Override
	public void windowClosing(WindowEvent e) {
		int confirm = JOptionPane.showConfirmDialog(view,"Are You Sure You Want to Exit?","Exit",JOptionPane.YES_NO_OPTION, 1);
		if (confirm == 0) {
			System.exit(0);
		} else {
			view.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		}
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

		//handling buttons
		if (e.getActionCommand().equals("newEntry")) {					//new entry button
			new NewEntryController(this.list);
			this.view.dispose();
		} else if (e.getActionCommand().equals("checkInfo")){			//check and delete entry button
			new SearchPageController(this.list);
			this.view.dispose();
		} else if (e.getActionCommand().equals("viewAll")) {			//view all button, show error if list is empty
			if(list.getSize() != 0) {
				new AppointmentTableController(this.list);
				this.view.dispose();
			} else {
				JOptionPane.showMessageDialog(view, "The list is still empty.","Empty List", JOptionPane.WARNING_MESSAGE);
			}			
		} else if (e.getActionCommand().equals("deleteLast")) {			//delete last entries button
			new DeleteLastController(list);
			this.view.dispose();
		} else {														//close button
			this.windowClosing(null);
		}
	}

}
