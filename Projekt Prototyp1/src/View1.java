import java.awt.event.*;
import javax.swing.*;

public class View1 extends DefaultView implements ActionListener{
	
	private Bauteil1 bt11;
	
	public View1() {
		bt11 = new Bauteil1();
		super.add(bt11);
	}

	public void run(int direction){
		super.run(direction, 1);
	}
	
	public void actionPerformed (ActionEvent e){
		
	}
}
