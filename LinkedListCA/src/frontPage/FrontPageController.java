
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

import newEntry.NewEntryController;

//Controller for the front page
public class FrontPageController implements ActionListener, WindowListener {

	private FrontPageModel model;
	private FrontPageView view;

	public FrontPageController() {
		this.model = new FrontPageModel();
		this.view = new FrontPageView(this);

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	//creates option pane to confirm if the user wants to close the program
	@Override
	public void windowClosing(WindowEvent e) {
		int confirm = JOptionPane.showConfirmDialog(null,"Are You Sure You Want to Exit?","Exit",JOptionPane.YES_NO_OPTION, 1);
		if (confirm == 0) {
			System.exit(0);
		} else {
			view.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		}
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
	//handling buttons from the view
	public void actionPerformed(ActionEvent e) {

		//"New Entry" Button
		if (e.getActionCommand().equals("newEntry")) {
			new NewEntryController();
			this.view.dispose();
		}

	}

}
