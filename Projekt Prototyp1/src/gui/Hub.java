package gui;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;

@SuppressWarnings("serial")
/**
 * The startscreen
 *  * @author jermann
 *
 */
public class Hub extends JFrame implements ActionListener {
	private JButton start[];
	private int maxFieldSize;
	private int screenSize;
	
	/**
	 * creates the startscreen and checks for the maximum fieldsize (2 - (display size / 300))
	 */
	public Hub() {
		UIManager.put("Label.font", new Font("Arial", Font.PLAIN, 80));
	    UIManager.put("Button.font", new Font("Arial", Font.BOLD, 30));
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		if(height < width) {
			this.screenSize = (int)height;
		}else {
			this.screenSize = (int)width;
		}
		maxFieldSize = (this.screenSize / 300) - 2;
		start = new JButton[maxFieldSize];
		
		this.setLayout(new GridLayout(2, 3));
		this.setSize(width / 2, height / 2);
		this.setTitle("Choose Map Size");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		
		for(int i = 0; i < maxFieldSize; i++) {
			start[i] = new JButton(String.valueOf(i + 2) + "x" + String.valueOf(i + 2));
			this.add(start[i]);
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
				DefaultView v = new DefaultView(i + 2, this.screenSize);
				break;
			}
		}
	}
}
