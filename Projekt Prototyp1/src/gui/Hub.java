package gui;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Hub extends JFrame implements ActionListener {

	private JButton start[] = new JButton[6];
	
	public Hub() {
		this.setLayout(new GridLayout(2, 3));
		this.setSize(500, 500);
		this.setTitle("Programm");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		for(int i = 0; i < 6; i++) {
			start[i] = new JButton(String.valueOf(i + 2));
			this.add(start[i]);
			start[i].addActionListener(this);
		}
		
		this.setVisible(true);
	}

	public void actionPerformed (ActionEvent e){
		for(int i = 0; i < 6; i++) {
			if (e.getSource() == start[i]){
				this.dispose();
				@SuppressWarnings("unused")
				DefaultView v = new DefaultView(i + 2);
				break;
			}
		}
	}
}
