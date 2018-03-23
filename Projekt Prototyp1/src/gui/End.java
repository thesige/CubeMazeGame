package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
/**
 * The endscreen, includes a button to go to the startscreen and another one to exit
 * @author jermann
 *
 */
public class End extends JFrame implements ActionListener {

private JButton ExitButton;
private JButton StartButton;
	
	/**
	 * Creates the view
	 */
	public End() {
		this.setLayout(new GridLayout(2, 1));
		this.setSize(500, 500);
		this.setTitle("Escaped");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		StartButton = new JButton("Start new Maze");
		ExitButton = new JButton("Exit");
		this.add(StartButton);
		this.add(ExitButton);
		StartButton.addActionListener(this);
		ExitButton.addActionListener(this);
		
		this.setVisible(true);
	}

	/**
	 * Checks which button got pressed
	 * StartButton, startscreen gets displayed
	 * ExitButton, application gets closed
	 */
	public void actionPerformed (ActionEvent e){
		if (e.getSource() == StartButton){
			this.dispose();
			@SuppressWarnings("unused")
			Hub h = new Hub();
		}
		if (e.getSource() == ExitButton){
			System.exit(0);
		}
	}

}
