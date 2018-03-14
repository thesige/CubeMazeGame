package gui;
import javax.swing.*;

import logic.Bauteil12;

public class Bauteil11 extends JFrame {

	private Bauteil12 bt121;
	private int alignment;
	
	public Bauteil11(int alignment){
		this.alignment = alignment;
	}
	
	public boolean bl(int direction){
		return bt121.bl(direction, alignment);
	}
}
