package gui;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Hub extends JFrame implements ActionListener {

	private JButton StartButton;
	
	public Hub() {
		this.setLayout(new GridLayout(1, 1));
		this.setSize(500, 500);
		this.setTitle("Programm");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		StartButton = new JButton("Start");
		this.add(StartButton);
		StartButton.addActionListener(this);
		
		this.setVisible(true);
	}

	public void actionPerformed (ActionEvent e){
		if (e.getSource() == StartButton){
			this.dispose();
			@SuppressWarnings("unused")
			DefaultView v = new DefaultView();
		}
	}
}
