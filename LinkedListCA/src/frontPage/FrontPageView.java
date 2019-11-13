
/*
 *  @Author = Caue Meireles Duarte
 */
package frontPage;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

//Front Page View, has the main functionalities of the application
public class FrontPageView extends JFrame {
	
	private FrontPageController controller;

	//Class constructor
	public FrontPageView(FrontPageController controller) {
		this.controller = controller;
		this.addWindowListener(controller);
		settings();
		createElements();
	}

	/**
	 *Sets the frame's layout to a GridBaglayout, creates top JLabel and the five buttons.
	 *
	 * @see FrontPageController
	 */
	private void createElements() {
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(10,0,10,0);
		JLabel titleLbl = new JLabel("<html><b>Welcome to the Immigration Appointment System</b></html>");
		c.gridy = 0;
		this.add(titleLbl, c);
		c.ipady = 25;
		c.ipadx = 20;
		JButton loginBt = new JButton("Check/Delete Registration");
		loginBt.setActionCommand("checkInfo");
		loginBt.addActionListener(controller);
		c.gridy = 1;
		this.add(loginBt, c);
		JButton newCustBt = new JButton("New Registration");
		newCustBt.setActionCommand("newEntry");
		newCustBt.addActionListener(controller);
		c.gridy = 2;
		this.add(newCustBt, c);
		JButton checkMediaBt = new JButton("View All Registration");
		checkMediaBt.setActionCommand("viewAll");
		checkMediaBt.addActionListener(controller);
		c.gridy = 3;
		this.add(checkMediaBt, c);
		JButton viewAllBt = new JButton("Clear Last Entries");
		viewAllBt.setActionCommand("deleteLast");
		viewAllBt.addActionListener(controller);
		c.gridy = 4;
		this.add(viewAllBt, c);
		JButton addMediaBt = new JButton("Close Program");
		addMediaBt.setActionCommand("close");
		addMediaBt.addActionListener(controller);
		c.gridy = 5;
		this.add(addMediaBt, c);
		
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
		this.setSize(310,450);
		this.validate();
		this.repaint();
		
	}

}
