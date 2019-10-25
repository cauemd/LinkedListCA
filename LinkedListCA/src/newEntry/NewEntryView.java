
/*
 *  @Author = Caue Meireles Duarte
 */
package newEntry;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import frontPage.FrontPageController;

//Controller for the New Entry view/model. Responsible for adding new entries to the system.
public class NewEntryView extends JFrame{

	private NewEntryController controller;
	private JLabel errorLbl;
	private JTextField fName;
	private JTextField lName;
	private JTextField passport;
	private int priorityLvl = 0;
	private JComboBox<String> monthCb;
	private JComboBox<Integer> dayCb;
	private JComboBox<Integer> yearCb;

	//Class constructor 
	public NewEntryView(NewEntryController controller) {
		this.controller = controller;
		this.addWindowListener(controller);
		settings();
		createElements();
	}

	/**
	 *Sets the frame's layout to a GridBaglayout, creates JLabels and respective JTextFields for first and last name and
	 *passport number. Creates JComboBox to select day, month and year of arrival. Creates and group JRadioButtons to select appointment
	 *priority. Adds confirmation and cancel button at the bottom plus error label.
	 *
	 * @see NewEntryController
	 */
	private void createElements() {

		//creating holy panel
		JPanel holyPnl = new JPanel();
		this.add(holyPnl);

		//creating Layout Manager
		holyPnl.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10, 0, 0, 10);
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.HORIZONTAL;

		//creating labels
		JLabel firstNameLb = new JLabel("First Name:");
		holyPnl.add(firstNameLb, c);
		JLabel lastNameLb = new JLabel("Last Name:");
		c.gridy = 1;
		holyPnl.add(lastNameLb, c);
		JLabel passportLb = new JLabel("Passport Number:");
		c.gridy = 2;
		holyPnl.add(passportLb, c);

		//creating JTextFields
		JTextField firstNameTF = new JTextField(30);
		c.gridwidth = 5;
		c.gridx = 1;
		c.gridy = 0;
		this.fName = firstNameTF;
		holyPnl.add(firstNameTF, c);
		JTextField lastNameTF = new JTextField(30);
		c.gridy = 1;
		this.lName = lastNameTF;
		holyPnl.add(lastNameTF, c);
		JTextField passportTF = new JTextField(30);
		c.gridy = 2;
		this.passport = passportTF;
		holyPnl.add(passportTF, c);

		//creating JComboBoxes for the date of arrival
		JLabel dateLbl = new JLabel("Select Date of Arrival:");
		dateLbl.setHorizontalAlignment(SwingConstants.CENTER);
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(10, 0, 0, 10);
		c.gridwidth = 6;
		c.gridx = 0;
		c.gridy = 3;
		holyPnl.add(dateLbl, c);

		//Creates month ComboBox and Label
		JLabel monthLb = new JLabel("Month:");
		c.gridwidth = 1;
		c.gridy = 4;
		holyPnl.add(monthLb, c);
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October",
				"November", "December"};
		JComboBox<String> monthBox = new JComboBox<>(months);
		this.monthCb = monthBox;
		monthBox.addActionListener(controller);
		monthBox.setSelectedItem("Test");
		monthBox.setActionCommand("setDay");
		c.gridx = 1;
		c.anchor = GridBagConstraints.WEST;
		holyPnl.add(monthBox, c);

		//creates day combo box and label
		JLabel dayLb = new JLabel("Day:");
		c.gridx = 2;
		c.anchor = GridBagConstraints.CENTER;
		holyPnl.add(dayLb, c);

		JComboBox<Integer> dayBox = new JComboBox<>();
		c.anchor = GridBagConstraints.CENTER;
		this.dayCb = dayBox;
		c.gridx = 3;
		holyPnl.add(dayBox, c);

		//creates year combo box and label
		JLabel yearLb = new JLabel("Year:");
		c.gridx = 4;
		c.anchor = GridBagConstraints.CENTER;
		holyPnl.add(yearLb, c);
		JComboBox<Integer> yearBox = new JComboBox<>(controller.generateYears());
		c.anchor = GridBagConstraints.WEST;
		this.yearCb = yearBox;
		c.gridx = 5;
		yearBox.setActionCommand("setDay");
		yearBox.addActionListener(controller);
		holyPnl.add(yearBox, c);		


		//creating RadioButtons and ButtonGroup for the Priority Level
		JLabel priorityLbl = new JLabel("Select Priority Level:");
		priorityLbl.setHorizontalAlignment(SwingConstants.CENTER);
		c.gridwidth = 6;
		c.gridx = 0;
		c.gridy = 5;
		holyPnl.add(priorityLbl, c);
		JRadioButton highRB = new JRadioButton("High Priority");
		highRB.setActionCommand("high");
		highRB.addActionListener(controller);
		c.anchor = GridBagConstraints.CENTER;
		c.gridwidth = 2;
		c.gridy = 6;
		holyPnl.add(highRB, c);
		JRadioButton mediumRB = new JRadioButton("Medium Priority");
		mediumRB.setActionCommand("medium");
		mediumRB.addActionListener(controller);
		c.gridx = 2;
		holyPnl.add(mediumRB, c);
		JRadioButton lowRB = new JRadioButton("Low Priority");
		lowRB.setActionCommand("low");
		lowRB.addActionListener(controller);
		c.gridx = 4;
		c.anchor = GridBagConstraints.CENTER;
		holyPnl.add(lowRB, c);
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(highRB);
		btnGroup.add(mediumRB);
		btnGroup.add(lowRB);

		//creating buttons
		JButton registerBtn = new JButton("Register");
		registerBtn.addActionListener(controller);
		registerBtn.setActionCommand("register");
		c.gridwidth = 3;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 8;
		c.insets = new Insets(20,10,0,10);
		holyPnl.add(registerBtn, c);
		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.setActionCommand("cancel");
		cancelBtn.addActionListener(controller);
		c.gridx = 3;
		holyPnl.add(cancelBtn, c);	
		JLabel errorLbl = new JLabel("# Immigration System #");
		this.errorLbl = errorLbl;
		c.gridwidth = 6;
		errorLbl.setHorizontalAlignment(SwingConstants.CENTER);
		c.gridx = 0;
		c.gridy = 9;
		holyPnl.add(errorLbl, c);

		this.validate();
		this.repaint();
	}

	/**
	 *	Sets main visual aspects for the frame.
	 */
	private void settings() {
		this.setTitle("New Entry");
		this.setVisible(true);
		this.setResizable(false);
		this.setSize(600,350);
		this.validate();
		this.repaint();

	}

	/*
	 *Sets the class "priorityLvl" attribute according to the JRadioButton selected by the user. Selected RadioButton
	 *triggers an event and the controller returns an int accordingly. 
	 *1 for High Priority, 2 for Medium Priority and 3 for Low Priority
	 *
	 * @see NewEntryController
	 */
	public void setPriority(int priority) {
		this.priorityLvl = priority;

	}

	/*
	 *Populates the JComboBox according to the month selected in the month JComboBox. If February is selected, check for leap year.
	 *
	 * 
	 * @see NewEntryController
	 */
	public void setDayBox(String month) {
		dayCb.removeAllItems();
		if (month.equals("January") || month.equals("March") || month.equals("May") || month.equals("July") ||
				month.equals("August") || month.equals("October") || month.equals("December")){
			for(int i=1;i<=31;i++){
				dayCb.addItem(i);
			}

		} else if (month.equals("April") || month.equals("June") || month.equals("September") || month.equals("November")) {
			for(int i=1;i<=30;i++){
				dayCb.addItem(i);
			}

			//Handling February
		} else {

			//checking if leap year
			if(controller.isLeapYear( (int) yearCb.getSelectedItem())) {
				for(int i=1;i<=29;i++){
					dayCb.addItem(i);
				}
			} else {
				for(int i=1;i<=28;i++){
					dayCb.addItem(i);
				}
			}

		}

	}

	/**
	 *Verifies if every field is filled before sending the data to the database.
	 *
	 * @see NewEntryController
	 */
	public boolean isFilled() {
		if (this.fName.getText() == null || this.lName.getText() == null || this.passport.getText() == null || 
				this.dayCb.getSelectedItem() == null || this.priorityLvl == 0) {
			return false;
		} else {
			return true;
		}
	}

	
	/**
	 *Returns a string from the selected item in the Month ComboBox
	 *
	 * @see JComboBox
	 */
	public String getMonth() {
		return (String) monthCb.getSelectedItem();
	}
	
	/**
	 *Returns a string from the selected item in the Day ComboBox
	 *
	 * @see JComboBox
	 */
	public int getDay() {
		return (int) dayCb.getSelectedItem();
	}
	
	/**
	 *Returns a string from the selected item in the Year ComboBox
	 *
	 * @see JComboBox
	 */
	public int getYear() {
		return (int) yearCb.getSelectedItem();
	}
	
	/**
	 *Returns a string from the First Name JTextField
	 *
	 * @see JTextField
	 */
	public String getFName() {
		return this.fName.getText().trim();
	}
	
	/**
	 *Returns a string from the Last Name JTextField
	 * @see JComboBox
	 */
	public String getLName() {
		return this.lName.getText().trim();
	}
	
	/**
	 *Returns a string from the passport JTextField
	 * @see JComboBox
	 */
	public String getPassport() {
		return this.passport.getText().trim();
	}
	
	/**
	 *Returns an int representing the Priority. 1 for high, 2 for medium and 3 for low.
	 *
	 * @see JComboBox
	 */
	public int getPriority() {
		// TODO Auto-generated method stub
		return this.priorityLvl;
	}
	
	/**
	 *Returns the JLabel object related to the screen message
	 * @see JComboBox
	 */
	public JLabel getErrorLbl() {
		return this.errorLbl;
	}

	
}

