package gui;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Hub extends JFrame implements ActionListener {
	private JButton start[];
	private int maxFieldSize;
	
	public Hub() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		int screen;
		if(height < width) {
			screen = (int)height;
		}else {
			screen = (int)width;
		}
		maxFieldSize = (screen / 300) - 2;
		start = new JButton[maxFieldSize];
		
		this.setLayout(new GridLayout(2, 3));
		this.setSize(width / 2, height / 2);
		this.setTitle("Configure the Maze");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		for(int i = 0; i < maxFieldSize; i++) {
			start[i] = new JButton(String.valueOf(i + 2));
			this.add(start[i]);
			start[i].addActionListener(this);
		}
		this.setVisible(true);
	}

	public void actionPerformed (ActionEvent e){
		for(int i = 0; i < maxFieldSize; i++) {
			if (e.getSource() == start[i]){
				this.dispose();
				@SuppressWarnings("unused")
				DefaultView v = new DefaultView(i + 2);
				break;
			}
		}
	}
}
