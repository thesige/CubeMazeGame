package gui;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;

import dto.Config;
import logic.BComponent;
import logic.BComponentCrossroad;
import logic.MapBuilder;
import logic.PlayerMoving;

@SuppressWarnings("serial")
public class DefaultView extends JFrame implements KeyListener{
	JPanel side;
	Config conf = new dto.Config();
	MapBuilder mapBuilder = new logic.MapBuilder();
	
	public DefaultView(int mapSize) {
		conf.FIELD_SIZE = mapSize;
		
		this.setLayout(new GridLayout(1, 1));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		int screen;
		if(height < width) {
			screen = (int)height;
		}else {
			screen = (int)width;
		}
		int size = 0;
		if(conf.FIELD_SIZE * 600 < screen) {
			size = conf.FIELD_SIZE * 600;
		}else if(conf.FIELD_SIZE * 500 < screen) {
			size = conf.FIELD_SIZE * 500;
		}else if(conf.FIELD_SIZE * 400 < screen) {
			size = conf.FIELD_SIZE * 400;
		}else if(conf.FIELD_SIZE * 300 < screen) {
			size = conf.FIELD_SIZE * 300;
		}else{
			while(conf.FIELD_SIZE * 300 >= screen) {
				conf.FIELD_SIZE -= 1;
				size = screen;
			}
		}
		
		this.setSize(size, size);
		this.setTitle("Escape the Maze!");
		addKeyListener(this);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		dto.Player.setPOSITION(new Point(ThreadLocalRandom.current().nextInt(0, conf.FIELD_SIZE), ThreadLocalRandom.current().nextInt(0, conf.FIELD_SIZE)));
		dto.Player.setMAP(new Point(0, 0));
		conf.AllMaps.put(new Point(0, 0), mapBuilder.BuildMap(conf));
		
		conf.SingleMap = conf.AllMaps.get(new Point(0, 0));
		if(conf.SingleMap[dto.Player.getPOSITION().x][dto.Player.getPOSITION().y].isExit()) {
			conf.SingleMap[dto.Player.getPOSITION().x][dto.Player.getPOSITION().y] = new BComponentCrossroad(1);
		}
		conf.SingleMap[dto.Player.getPOSITION().x][dto.Player.getPOSITION().y].replaceWithPlayer();
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
