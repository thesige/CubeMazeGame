import java.awt.event.KeyListener;
import javax.swing.*;

public class View1 extends DefaultView{
	
	private Bauteil11 bt111;
	
	public View1() {
		bt111 = new Bauteil11(1);
		bt111.setBounds(0, 0, 10, 10);
		super.add(bt111);
		
		
		
	}

	public void run(int direction){
		if (bt111.bl(direction) == true){
			super.run(direction, 1);
		}
	}
}
