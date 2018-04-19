package gui;
import java.awt.GridLayout;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.Point;
import java.awt.event.*;
import javax.swing.*;

import dto.Config;
import logic.BComponentInterface;
import logic.BComponentCrossroad;
import logic.MapBuilder;
import logic.PlayerMoving;

/**
 * The gui of the maze
 * @author jermann
 *
 */
@SuppressWarnings("serial")
public class DefaultView extends JFrame implements KeyListener{
	JPanel side;
	private Config conf = new dto.Config();
	MapBuilder mapBuilder = new logic.MapBuilder();
	
	/**
	 * Creates the first map, places the player and displays the whole thing
	 * @param mapSize, length (number of components) of a side
	 */
	public DefaultView(int mapSize, int screen) {
		
		getConf().FIELD_SIZE = mapSize;
		
		this.setLayout(new GridLayout(1, 1));
		int size = 0;
		if(getConf().FIELD_SIZE * 600 < screen) {
			size = getConf().FIELD_SIZE * 600;
		}else if(getConf().FIELD_SIZE * 500 < screen) {
			size = getConf().FIELD_SIZE * 500;
		}else if(getConf().FIELD_SIZE * 400 < screen) {
			size = getConf().FIELD_SIZE * 400;
		}else if(getConf().FIELD_SIZE * 300 < screen) {
			size = getConf().FIELD_SIZE * 300;
		}else{
			while(getConf().FIELD_SIZE * 300 >= screen) {
				getConf().FIELD_SIZE -= 1;
				size = screen;
			}
		}
		
		this.setSize(size, size);
		this.setTitle("Escape the Maze!");
		addKeyListener(this);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		dto.Player.setPOSITION(new Point(ThreadLocalRandom.current().nextInt(0, getConf().FIELD_SIZE), ThreadLocalRandom.current().nextInt(0, getConf().FIELD_SIZE)));
		dto.Player.setMAP(new Point(0, 0));
		getConf().AllMaps.put(new Point(0, 0), mapBuilder.BuildMap(getConf()));
		
		getConf().SingleMap = getConf().AllMaps.get(new Point(0, 0));
		if(getConf().SingleMap[dto.Player.getPOSITION().x][dto.Player.getPOSITION().y].isExit()) {
			getConf().SingleMap[dto.Player.getPOSITION().x][dto.Player.getPOSITION().y] = new BComponentCrossroad(1);
		}
		getConf().SingleMap[dto.Player.getPOSITION().x][dto.Player.getPOSITION().y].replaceWithPlayer();
		side = new JPanel(new GridLayout(getConf().FIELD_SIZE, getConf().FIELD_SIZE));
		this.add(side);
		displayNewField(dto.Player.getMAP());
	}
	
	/**
	 * renders the map
	 * @param mapPoint, the given map
	 */
	public void displayNewField(Point mapPoint) {
		side.removeAll();
		for(int x = 0; x < getConf().FIELD_SIZE; x++) {
			for(int y = 0; y < getConf().FIELD_SIZE; y++) {
				side.add(getImageAsLabel(mapPoint, new Point(x, y)));
			}
		}
		this.setVisible(true);
	}
	
	/**
	 * Gets the image of the component as JLabel
	 * @param mapPoint, given map
	 * @param bcomponent, given position on map
	 * @return JLabel with the image
	 */
	private JLabel getImageAsLabel(Point mapPoint, Point bcomponent) {
		return new JLabel(new ImageIcon(getClass().getResource(mapBuilder.getImageAsLabel(getConf(), mapPoint, bcomponent))));
	}
	
	/**
	 * Displays the endscreen
	 */
	public void showEnd() {
		this.dispose();
		@SuppressWarnings("unused")
		End end = new End();
	}
	
	/**
	 * Checks which button got pressed and goes into the validateMove function
	 */
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
		playerMoving.validateMove(this, getConf(), direction);
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
	
	//JUNIT HELPERS
	public void testMoveHelp(int direction) {
		PlayerMoving playerMoving = new logic.PlayerMoving();
		playerMoving.validateMove(this, getConf(), direction);
	}
	
	public void createMapForTest2(int alignment) {
		getConf().SingleMap[0][1] = new logic.BComponentStreet(alignment);
		getConf().SingleMap[1][1] = new logic.BComponentStreet(alignment);
	}
	
	public void createMapForTest1(int alignment) {
		getConf().SingleMap[1][1] = new logic.BComponentStreet(alignment);
		getConf().SingleMap[2][1] = new logic.BComponentStreet(alignment - 1);
	}
	
	public void createMapForTest3(int alignment) {
		getConf().SingleMap[1][2] = new logic.BComponentStreet(alignment);
		BComponentInterface temp[][] = new BComponentInterface[3][3];
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				temp[i][j] = new logic.BComponentStreet(alignment);
			}
		}
		getConf().AllMaps.put(new Point(0, 1), temp);
	}
	
	public void setPlayerLocation(Point p) {
		dto.Player.setPOSITION(p);
	}
	
	public Point getPlayerLocation(){
		return dto.Player.getPOSITION();
	}
	
	public Point getPlayerMap(){
		return dto.Player.getMAP();
	}

	public Config getConf() {
		return conf;
	}

	public void setConf(Config conf) {
		this.conf = conf;
	}
}
