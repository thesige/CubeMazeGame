package gui;
import java.awt.event.*;
import javax.swing.*;
import dto.Player;
import logic.View1;
import logic.View2;
import logic.View3;
import logic.View4;
import logic.View5;
import logic.View6;

public class DefaultView extends JFrame implements KeyListener{
	
	Player p;
	View1 v1;
	View2 v2;
	View3 v3;
	View4 v4;
	View5 v5;
	View6 v6;
	
	public DefaultView() {
		this.setLayout(null);
		this.setSize(500, 500);
		this.setTitle("Programm");
		addKeyListener(this);
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		p = new Player(0, 0);
		this.view1();
	}
	
	public void run(int direction){
		
	}
	
	public void view1(){
		this.v1 = new View1();
	}
	
	public void view2(){
		this.v2 = new View2();
	}

	public void view3(){
		this.v3 = new View3();
	}
	
	public void view4(){
		this.v4 = new View4();
	}
	
	public void view5(){
		this.v5 = new View5();
	}
	
	public void view6(){
		this.v6 = new View6();
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		switch (arg0.getKeyCode()){
		case KeyEvent.VK_LEFT:
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
