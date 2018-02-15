import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class View1 extends DefaultView implements KeyListener{
	
	private Bauteil11 bt111;
	
	public View1() {
		bt111 = new Bauteil11(1);
		bt111.setBounds(0, 0, 10, 10);
		//super.add(bt111);
		
	}

	public void run(int direction){
		if (bt111.bl(direction) == true){
			super.run(direction, 1);
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		switch (arg0.getKeyCode()){
		case 37: super.setVisible(false);
		break;
		case 38: super.setVisible(true);
		break;
		case 39: super.setVisible(false);
		break;
		case 40: super.setVisible(true);
		break;
		}
	}
}
