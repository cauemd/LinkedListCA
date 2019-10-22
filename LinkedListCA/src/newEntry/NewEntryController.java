
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

import frontPage.FrontPageController;
import person.Person;

//Controller for the New Entry view/model. Responsible for adding new entries to the system.
public class NewEntryController implements WindowListener, ActionListener {
	
	private NewEntryView view;
	private NewEntryModel model;

	public NewEntryController() {
		this.model = new NewEntryModel();
		this.view = new NewEntryView(this);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		new FrontPageController();
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
			String month = view.getMonth();
			view.setDayBox(month);
		
		//handling register button
		}else if (e.getActionCommand().equals("register")) {
			//shows error msg if any field in the view is not filled, creates a new Person object otherwise
			if (!view.isFilled()) {
				view.getErrorLbl().setForeground(Color.RED);
				view.getErrorLbl().setText("Please, complete all fields.");
			}else {
				Person citizen = new Person(view.getFName(), view.getLName(), view.getPassport(), view.getPriority());
				
			}
		}
	}

	/*
	 *Generates an array of Integer objects to be passed as argument used to populate the view's ComboBox related to the years.
	 *This method generates an array of length 100 counting down from the current year.
	 *
	 * @see NewEntryView, Integer, Date
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
	 * @see NewEntryView
	 */
	public boolean isLeapYear(int year) {
		if (year % 4 == 0){
			return true;
		} else {
			return false;
		}
	}
	
	
	
}
