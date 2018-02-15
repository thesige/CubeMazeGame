import java.awt.event.*;
import javax.swing.*;

public class Hub extends JFrame implements ActionListener {

	private JButton b1;
	
	public Hub() {
		this.setLayout(null);
		this.setSize(500, 500);
		this.setTitle("Programm");
		
		b1 = new JButton("Start");
		this.add(b1);
		b1.setBounds(175, 175, 100, 100);
		b1.addActionListener(this);
		
		this.setVisible(true);
	}

	public void actionPerformed (ActionEvent e){
		if (e.getSource() == b1){
			DefaultView v = new View1();
			this.setVisible(false);
		}
	}
}
