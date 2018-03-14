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
		this.view1();
	}
	
	public void run(int direction, int steps){
		
	}
	
	public void view1(){
		View1 v1 = new View1();
	}
	
	public void view2(){
		View2 v2 = new View2();
	}

	public void view3(){
		View3 v3 = new View3();
	}
	
	public void view4(){
		View4 v4 = new View4();
	}
	
	public void view5(){
		View5 v5 = new View5();
	}
	
	public void view6(){
		View6 v6 = new View6();
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
