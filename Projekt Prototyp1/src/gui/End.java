package gui;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
/**
 * The endscreen, includes a button to go to the startscreen and another one to exit
 * @author jermann
 *
 */
public class End extends JFrame implements ActionListener {

private JPanel panel1;
private JPanel panel2;
private JLabel label1;
private JButton ExitButton;
private JButton StartButton;
	
	/**
	 * Creates the view
	 */
	public End() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		
		this.setLayout(new GridLayout(2, 1));
		this.setSize(width / 2, height / 2);
		this.setTitle("Escaped");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		panel1 = new JPanel();
		panel1.setBackground(Color.white);
		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(2, 1));
		panel2.setBackground(Color.white);
		label1= new JLabel("You escaped the Maze!!!");
		
		StartButton = new JButton("Start new Maze");
		StartButton.setBackground(Color.GRAY);
		ExitButton = new JButton("Exit");
		ExitButton.setBackground(Color.GRAY);
		this.add(panel1); 
		this.add(panel2);
		panel1.add(label1);
		panel2.add(StartButton);
		panel2.add(ExitButton);
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
