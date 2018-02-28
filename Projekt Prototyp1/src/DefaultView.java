import java.awt.event.*;
import javax.swing.*;

public class DefaultView extends JFrame implements KeyListener{
	
	public DefaultView() {
		this.setLayout(null);
		this.setSize(500, 500);
		this.setTitle("Programm");
		addKeyListener(this);
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public void run(int direction, int steps){
		
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		switch (arg0.getKeyCode()){
		case KeyEvent.VK_LEFT: System.out.println("ercvec");
		break;
		case KeyEvent.VK_UP: 
		break;
		case KeyEvent.VK_RIGHT: 
		break;
		case KeyEvent.VK_DOWN: 
		break;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
}
