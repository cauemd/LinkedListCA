
/*
 *  @Author = Caue Meireles Duarte
 */
package appointmentTable;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AppointmentTableView extends JFrame{
	
	private AppointmentTableController controller;
	
	//Constructs a AppointmnetTableController instance
	public AppointmentTableView(AppointmentTableController controller) {
		this.controller = controller;
		this.addWindowListener(controller);
		settings();
		createElements();
	}
	/**
	 *Creates the JTable that will be used to display all the appointments data from the list.
	 *If found, displays information on the bottom label, otherwise shows error message,
	 *
	 * @see APpointmentTableController
	 */
	private void createElements() {
		
		//creating table and populating it with data
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(10,10,10,10);
		String[] columns = {"App ID", "First Name", "Last Name", "Passport", "Date of Arrival"};
		JTable table = new JTable (controller.generateDataArrayFromList(), columns);
		JScrollPane scrollPane = new JScrollPane(table);
		c.weightx = 1;
		c.weighty = 1;
		table.setFillsViewportHeight(true);
		this.add(scrollPane, c);
		
		JButton returnBtn = new JButton("Return to Front Page");
		returnBtn.setActionCommand("return");
		returnBtn.addActionListener(controller);
		c.weightx = 0;
		c.weighty = 0;
		c.gridy = 1;
		this.add(returnBtn,c);
		
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
		this.setSize(500,400);
		this.validate();
		this.repaint();

	}

}
