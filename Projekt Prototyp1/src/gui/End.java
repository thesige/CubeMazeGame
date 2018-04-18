package gui;

import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;
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
		this.setLayout(new GridLayout(2, 1));
		this.setSize(500, 500);
		this.setTitle("Escaped");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		panel1 =new JPanel();
		panel1.setSize(250, 250);
		panel1.setBackground(Color.white);
		panel2 =new JPanel();
		panel2.setSize(250, 250);
		panel2.setBackground(Color.white);
		label1=new JLabel("You escaped the Maze!!!");
		label1.setFont(new Font("sans serif", Font.ITALIC,26));
		
		StartButton = new JButton("Start new Maze");
		StartButton.setBackground(Color.GRAY);
		StartButton.setSize(50, 50);
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
