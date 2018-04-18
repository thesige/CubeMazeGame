package gui;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
/**
 * The startscreen
 *  * @author jermann
 *
 */
public class Hub extends JFrame implements ActionListener {
	private JButton start[];
	private JPanel panel1;
	private int maxFieldSize;
	
	/**
	 * creates the startscreen and checks for the maximum fieldsize (2 - (display size / 300))
	 */
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
		this.setTitle("Choose Map Size");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.add(panel1);
		
		panel1.setBackground(Color.white);
		
		for(int i = 0; i < maxFieldSize; i++) {
			start[i] = new JButton(String.valueOf(i + 2) + "x" + String.valueOf(i + 2));
			panel1.add(start[i]);
			start[i].setBackground(Color.GRAY);
			start[i].addActionListener(this);
		}
		this.setVisible(true);
	}

	/**
	 * Checks which button got pressed and starts the game
	 */
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
