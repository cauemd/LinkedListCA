
/*
 *  @Author = Caue Meireles Duarte
 */
package newEntry;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import doublyList.DoublyLinkedList;
import frontPage.FrontPageController;
import person.Person;

//Controller for the New Entry view/model. Responsible for adding new entries to the system.
public class NewEntryController implements WindowListener, ActionListener {

	private NewEntryView view;
	private NewEntryModel model;
	private DoublyLinkedList list;

	public NewEntryController(DoublyLinkedList list) {
		this.model = new NewEntryModel(this, list);
		this.view = new NewEntryView(this);
		this.list = list;
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		new FrontPageController(list);
		view.dispose();
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void actionPerformed(ActionEvent e) {

		//handling radio buttons
		if (e.getActionCommand().equals("high")) {
			this.view.setPriority(1);
		} else if (e.getActionCommand().equals("medium")) {
			this.view.setPriority(2);
		} else if (e.getActionCommand().equals("low")) {
			this.view.setPriority(3);

			//changes number of entries in daybox according to selected month
		} else if (e.getActionCommand().equals("setDay")) {
			int month = view.getMonth();
			view.setDayBox(month);

			//handling register button
		} else if (e.getActionCommand().equals("register")) {
										
			if (!view.isFilled()) {								//shows error msg if any field in the view is not filled, creates a new Person object otherwise
				view.getErrorLbl().setForeground(Color.RED);
				view.getErrorLbl().setText("Please, complete all fields.");

			} else {																		//treating the data in the frame	

				String date = view.getDay() + "/" + view.getMonth() + "/" + view.getYear();
				Person person = model.newRegister(view.getFName(), view.getLName(), view.getPassport(), view.getPriority(), date);

				 if(person.getfName().length() > 20 || person.getlName().length() > 20 || 
						 person.getPassport().length() > 10) { 								//verifying if textboxes have valid number of characters
					view.getErrorLbl().setForeground(Color.RED);
					view.getErrorLbl().setText("Invalid number of characters in text box.");
					
				}else if (!this.model.registerInDatabase(person)) {		//triggered if there's already a register with the same passport in the database 
					JOptionPane.showMessageDialog(this.view, "There is a register for this passport already!.",
							"Double Entry.",  JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(this.view, "Appointment complete! Reference number: " + person.getID()); 
					list.add(person);
					this.view.dispose();
					new FrontPageController(this.list);
				}
			}
			//cancel button	
		} else {
			this.view.dispose();
			new FrontPageController(this.list);
		}
	}

	/*
	 *Generates an array of Integer objects to be passed as argument used to populate the view's ComboBox related to the years.
	 *This method generates an array of length 100 counting down from the current year.
	 *
	 * @return	an array of Integer with 100 numbers counting from the current year.
	 * @see 	NewEntryView, Integer, Date
	 */
	public Integer[] generateYears() {
		Integer[] array = new Integer[100];
		int year = Calendar.getInstance().get(Calendar.YEAR);
		for (int i = 0; i <= 99; i++) {
			array[i] = year;
			year--;
		}
		return array;
	}

	/*
	 *Verifies if the year selected in the view's ComboBox is a leap year.
	 *
	 * @param 	year	the year to get through the leap year check
	 * @see		NewEntryView
	 */
	public boolean isLeapYear(int year) {
		if (year % 4 == 0){
			return true;
		} else {
			return false;
		}
	}



}
