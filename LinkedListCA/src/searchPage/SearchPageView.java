
/*
 *  @Author = Caue Meireles Duarte
 */
package searchPage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import frontPage.FrontPageController;

public class SearchPageView extends JFrame {

	private SearchPageController controller;
	private JTextField idTF;
	private JLabel firstNameLbl;
	private JLabel lastNameLbl;
	private JLabel passportLbl;
	private JLabel dateLbl;

	//constructs a instance to work as the view of the search node feature
	public SearchPageView(SearchPageController controller) {
		this.controller = controller;
		this.addWindowListener(controller);
		settings();
		createElements();
	}


	/**
	 *Sets the frame's layout to a GridBaglayout, creates top panel with a text field and button for user to insert the ID of the appointment to be searched.
	 *If found, displays information on the bottom label, otherwise shows error message,
	 *
	 * @see FrontPageController
	 */
	private void createElements() {

		//creating LayoutManager
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(10,10,10,10);
		//c.anchor = GridBagConstraints.CENTER;
		c.fill = GridBagConstraints.HORIZONTAL;

		//creating top panel
		JPanel topPanel = new JPanel();
		topPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		topPanel.setLayout(layout);
		JLabel titleLbl = new JLabel("<html><b>Please, insert the appointment ID:</b></html>");
		topPanel.add(titleLbl, c);
		JTextField idTF = new JTextField(15);
		this.idTF = idTF;
		c.gridy = 1;
		topPanel.add(idTF, c);
		JButton checkBtn = new JButton("Search");
		checkBtn.setActionCommand("search");
		checkBtn.addActionListener(controller);
		c.gridy = 2;
		topPanel.add(checkBtn, c);

		//creating bottom panel
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		bottomPanel.setLayout(layout);
		c.anchor = GridBagConstraints.WEST;
		JLabel name1Lbl = new JLabel("First Name: ");
		c.gridy = 0;
		bottomPanel.add(name1Lbl, c);
		JLabel firstNameLbl = new JLabel("");
		c.gridx = 1;
		this.firstNameLbl = firstNameLbl;
		bottomPanel.add(firstNameLbl, c);
		JLabel name2Lbl = new JLabel("Last Name: ");
		c.gridy = 1;
		c.gridx = 0;
		bottomPanel.add(name2Lbl, c);
		JLabel lastNameLbl = new JLabel("");
		c.gridx = 1;
		this.lastNameLbl = lastNameLbl;
		bottomPanel.add(lastNameLbl, c);
		JLabel pLbl = new JLabel("Passport: ");
		c.gridy = 2;
		c.gridx = 0;
		bottomPanel.add(pLbl, c);
		JLabel passportLbl = new JLabel("");
		c.gridx = 1;
		this.passportLbl = passportLbl;
		bottomPanel.add(passportLbl, c);
		JLabel dLbl = new JLabel("Date of Arrival: ");
		c.gridy = 3;
		c.gridx = 0;
		bottomPanel.add(dLbl, c);
		JLabel dateLbl = new JLabel("");
		c.gridx = 1;
		this.dateLbl = dateLbl;
		bottomPanel.add(dateLbl, c);

		//adding cancel appointment and return button
		JButton cancelBtn = new JButton("Cancel Appointment");
		cancelBtn.setActionCommand("cancelApt");
		cancelBtn.addActionListener(controller);
		c.gridy = 4;
		c.gridx = 0;
		bottomPanel.add(cancelBtn, c);
		JButton returnBtn = new JButton("Return to Front Page");
		returnBtn.setActionCommand("return");
		returnBtn.addActionListener(controller);
		c.gridx = 1;
		bottomPanel.add(returnBtn, c);

		//adding pannels to the frame
		this.setLayout(layout);
		c.weightx = 0.1;
		c.gridy = 0;
		this.add(topPanel, c);
		c.gridy = 1;
		this.add(bottomPanel, c);
		
		this.validate();
		this.repaint();

	}

	/**
	 *	Sets the title, visibility and size of the frame. Also stops the user for being able to resize the frame.
	 */
	private void settings() {
		this.setTitle("Immigration System");
		this.setVisible(true);
		this.setResizable(false);
		this.setSize(370,400);
		this.validate();
		this.repaint();

	}

	/*
	 * Returns the JLabel that displays the person's first name
	 * 
	 * @return 	a label that displays the person's first name
	 */
	public JLabel getFirstNameLbl() {
		return firstNameLbl;
	}
	
	/*
	 * Changes the content of the label containing the first name of the person being searched by the system.
	 * 
	 * @param 	fname	the first name of the person
	 */
	public void setFirstNameLbl(String fName) {
		this.firstNameLbl.setText(fName);
	}

	/*
	 * Returns the JLabel that displays the person's last name
	 * 
 	 * @return 	a label that displays the person's last name
	 */
	public JLabel getLastNameLbl() {
		return lastNameLbl;
	}

	/*
	 * Changes the content of the label containing the last name of the person being searched by the system.
	 * 
	 * @param 	lname	the last name of the person
	 */
	public void setLastNameLbl(String lName) {
		this.lastNameLbl.setText(lName);
	}
	
	/*
	 * Returns the JLabel that displays the person's passport
	 *	
	 * @return a label that displays the person's passport
	 */
	public JLabel getPassportLbl() {
		return passportLbl;
	}
	
	/*
	 * Changes the content of the label containing the passport of the person being searched by the system.
	 * 
	 * @param 	passport	the passport of the person
	 */
	public void setPassportLbl(String passport) {
		this.passportLbl.setText(passport);
	}

	/*
	 * Returns the JLabel that displays the person's date of arrival
	 * 
	 * @return a label that displays the person's date of arrival
	 */
	public JLabel getDateLbl() {
		return dateLbl;
	}
	
	/*
	 * Changes the content of the label containing the date of entry of the person being searched by the system.
	 * 
	 * @param 	date	the date of entry of the person
	 */
	public void setDateLbl(String date) {
		this.dateLbl.setText(date);
	}

	/*
	 * Returns the String inside the search JTextField
	 * 
	 * @return a String representing the contents of the JTextField in the frame
	 */
	public String getIdTF() {
		return idTF.getText().trim();
	}

}
