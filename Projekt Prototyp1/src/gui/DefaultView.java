package gui;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.*;
import javax.swing.*;

import dto.Config;
import logic.BComponent;
import logic.MapBuilder;
import logic.PlayerMoving;

@SuppressWarnings("serial")
public class DefaultView extends JFrame implements KeyListener{
	JPanel side;
	Config conf = new dto.Config();
	MapBuilder mapBuilder = new logic.MapBuilder();
	
	public DefaultView() {
		this.setLayout(new GridLayout(1, 1));
		this.setSize(1700, 1700);
		this.setTitle("RubiksMaze");
		addKeyListener(this);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		dto.Player.setPOSITION(new Point(1, 1));
		dto.Player.setMAP(new Point(0, 0));
		conf.AllMaps.put(new Point(0, 0), mapBuilder.BuildMap(conf));
		
		conf.AllMaps.get(new Point(0, 0))[dto.Player.getPOSITION().x][dto.Player.getPOSITION().y].replaceWithPlayer();
		conf.SingleMap = conf.AllMaps.get(new Point(0, 0));
		side = new JPanel(new GridLayout(conf.FIELD_SIZE, conf.FIELD_SIZE));
		this.add(side);
		displayNewField(dto.Player.getMAP());
	}
	
	public void displayNewField(Point mapPoint) {
		side.removeAll();
		for(int x = 0; x < conf.FIELD_SIZE; x++) {
			for(int y = 0; y < conf.FIELD_SIZE; y++) {
				side.add(getImageAsLabel(mapPoint, x, y));
			}
		}
		this.setVisible(true);
	}
	
	private JLabel getImageAsLabel(Point mapPoint, int x, int y) {
		return new JLabel(new ImageIcon(getClass().getResource(mapBuilder.getImageAsLabel(conf, mapPoint, x, y))));
	}
	
	public void showEnd() {
		this.dispose();
		@SuppressWarnings("unused")
		End end = new End();
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		PlayerMoving playerMoving = new logic.PlayerMoving();
		int direction = 0;
		switch (arg0.getKeyCode()){
			case KeyEvent.VK_LEFT:
				direction = 3;
				break;
			case KeyEvent.VK_UP:
				direction = 4;
				break;
			case KeyEvent.VK_RIGHT:
				direction = 1;
				break;
			case KeyEvent.VK_DOWN:
				direction = 2;
				break;
		}
		playerMoving.validateMove(this, conf, direction);
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
}
