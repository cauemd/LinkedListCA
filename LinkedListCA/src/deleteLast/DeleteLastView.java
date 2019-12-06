
/*
 *  @Author = Caue Meireles Duarte
 */
package deleteLast;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DeleteLastView extends JFrame {
	
	private DeleteLastController controller;
	private JTextField deleteTF;
	
	public DeleteLastView(DeleteLastController controller) {
		this.controller = controller;
		this.addWindowListener(controller);
		settings();
		createElements();
	}

	/**
	 *Sets the frame's layout to a GridBaglayout, creates JLabel to display number of appointments, TextField to input number of appointments to be deleted and confirmation and return buttons
	 *
	 * @see DeleteLastController
	 */
	private void createElements() {
	
		//creating LayoutManager
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(10,10,10,10);
		c.fill = GridBagConstraints.HORIZONTAL;

		//creating top panel
		JPanel topPanel = new JPanel();
		topPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		topPanel.setLayout(layout);
		JLabel titleLbl = new JLabel("<html><b>Please, insert the number of appointments <br/> you want to delete:</b></html>");
		topPanel.add(titleLbl, c);
		JTextField deleteTF = new JTextField(15);
		this.deleteTF = deleteTF;
		c.gridy = 1;
		topPanel.add(deleteTF, c);
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.setActionCommand("delete");
		deleteBtn.addActionListener(controller);
		c.gridy = 2;
		topPanel.add(deleteBtn, c);

		//creating bottom panel
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		bottomPanel.setLayout(layout);
		c.anchor = GridBagConstraints.WEST;
		JLabel totalLbl = new JLabel("Total Appointments: ");
		bottomPanel.add(totalLbl, c);
		JLabel totalCountLbl = new JLabel(controller.getTotalCount());
		c.gridx = 1;
		bottomPanel.add(totalCountLbl, c);
		
		//creating return button
		JButton returnBtn = new JButton("Return to Front Page");
		returnBtn.setActionCommand("return");
		returnBtn.addActionListener(controller);
		
		//adding panels and return button to the frame
		this.setLayout(layout);
		c.weightx = 0.1;
		c.gridy = 0;
		this.add(topPanel, c);
		c.gridy = 1;
		this.add(bottomPanel, c);
		c.gridy = 2;
		this.add(returnBtn, c);
		
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
		this.setSize(310,300);
		this.validate();
		this.repaint();
		
	}
	
	public String getDeleteTF() {
		return this.deleteTF.getText().trim();
	}
}
