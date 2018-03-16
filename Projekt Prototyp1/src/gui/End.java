package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class End extends JFrame implements ActionListener {

private JButton ExitButton;
private JButton StartButton;
	
	public End() {
		this.setLayout(new GridLayout(2, 1));
		this.setSize(500, 500);
		this.setTitle("Programm");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		StartButton = new JButton("Start new Maze");
		ExitButton = new JButton("Exit");
		this.add(StartButton);
		this.add(ExitButton);
		StartButton.addActionListener(this);
		ExitButton.addActionListener(this);
		
		this.setVisible(true);
	}

	public void actionPerformed (ActionEvent e){
		if (e.getSource() == StartButton){
			this.dispose();
			@SuppressWarnings("unused")
			DefaultView v = new DefaultView();
		}
		if (e.getSource() == ExitButton){
			System.exit(0);
		}
	}

}
