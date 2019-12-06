
/*
 *  @Author = Caue Meireles Duarte
 */
package searchPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import doublyList.DoublyLinkedList;
import frontPage.FrontPageController;
import person.Person;

//controller for the search page
public class SearchPageController implements ActionListener, WindowListener{

	private DoublyLinkedList list;
	private SearchPageView view;
	private SearchPageModel model;
	private String aptID = "";

	//constructs a instance to work as the controller of the search node feature
	public SearchPageController(DoublyLinkedList list) {
		this.list = list;
		this.model = new SearchPageModel(list);
		this.view = new SearchPageView(this);
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

	//handling buttons
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("return")) {				//return to the front page button
			this.view.dispose();
			new FrontPageController(list);

		}else if (e.getActionCommand().equals("search")){			//search appointment button
			this.aptID = view.getIdTF().toUpperCase();
			Person person = model.searchPersonID(aptID);
			if (person != null) {										//changes data being displayed if the list has a person with the ID being searched
				this.view.setFirstNameLbl(person.getfName());
				this.view.setLastNameLbl(person.getlName());
				this.view.setPassportLbl(person.getPassport());
				this.view.setDateLbl(person.getArrivalDate());
			} else {													//shows error dialog if ID can't be found
				JOptionPane.showMessageDialog(this.view, "There is no appointment that matches the ID you are looking for!",
						"ID not found",  JOptionPane.ERROR_MESSAGE);	
				this.aptID = "";
			}
		} else if (e.getActionCommand().equals("cancelApt")) {		//cancel appointment button
			if (!this.aptID.equals("")) {
				int n = JOptionPane.showConfirmDialog(this.view, "Are you sure you want to cancel appointment " + aptID + "?", "Confirming cancelation",
					    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (n == 0) {
					this.model.removeNode(this.aptID);
					JOptionPane.showMessageDialog(this.view, "Appointment Deleted!");
					this.view.dispose();
					new FrontPageController(list);
				}
			}
		}
	}

}
