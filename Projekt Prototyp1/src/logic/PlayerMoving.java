package logic;

import java.awt.Point;

import dto.Config;
import gui.DefaultView;

/**
 * Validates the movements of the player
 * @author jermann
 *
 */
public class PlayerMoving {
	MapBuilder mapBuilder = new logic.MapBuilder();
	
	/**
	 * Checks if the player can move in the given direction and shows the new map
	 * @param view, instance of the game
	 * @param conf, configuration
	 * @param direction, the wanted direction
	 */
	public void validateMove(DefaultView view, Config conf, int direction) {
		Point player = dto.Player.getPOSITION();
		Point map = dto.Player.getMAP();
		//Checks if we can walk, else stay here
		if(getActualComponent(conf, map, player).canWalk(direction)) {
			switch(direction){
				case 1: //up
					if(player.y + 1 > conf.FIELD_SIZE - 1) {
						//Generate new Side
						createField(view, conf, map, new Point(map.x, map.y + 1), player, new Point(player.x, 0), direction);
					}else {
						updateField(view, conf, player, new Point(player.x, player.y + 1), direction);
					}
					break;
				case 2: //right
					if(player.x + 1 > conf.FIELD_SIZE - 1) {
						//Generate new Side
						createField(view, conf, map, new Point(map.x + 1, map.y), player, new Point(0, player.y), direction);
					}else {
						updateField(view, conf, player, new Point(player.x + 1, player.y), direction);
					}
					break;
				case 3: //down
					if(player.y - 1 < 0) {
						//Generate new Side
						createField(view, conf, map, new Point(map.x, map.y - 1), player, new Point(player.x, conf.FIELD_SIZE - 1), direction);
					}else {
						updateField(view, conf, player, new Point(player.x, player.y - 1), direction);
					}
					break;
				case 4: //left
					if(player.x - 1 < 0) {
						//Generate new Side
						createField(view, conf, map, new Point(map.x - 1, map.y), player, new Point(conf.FIELD_SIZE - 1, player.y), direction);
					}else {
						updateField(view, conf, player, new Point(player.x - 1, player.y), direction);
					}
					break;
			}
		}
	}
	
	/**
	 * Gets the component
	 * @param conf, configuration
	 * @param map, the Map
	 * @param player, the Position
	 * @return, Component
	 */
	private BComponent getActualComponent(Config conf, Point map, Point player) {
		BComponent Actual = conf.AllMaps.get(map)[player.x][player.y];
		return Actual;
	}
	
	/**
	 * Changes the image back to the one without the player
	 * @param conf, the configuration
	 * @param player, the Position on the Map
	 */
	private void updatePlayerPosition(Config conf, Point player) {
		conf.SingleMap[player.x][player.y].replaceWithPlayer();
	}
	
	/**
	 * gets/creates the new field, checks if moving is possible and renders
	 * @param view, instance of the Game
	 * @param conf, configuration
	 * @param oldMap, current Map
	 * @param newMap, map after change
	 * @param oldPlayer, current player position
	 * @param newPlayer, player position after change
	 * @param direction, the given direction
	 */
	private void createField(DefaultView view, Config conf, Point oldMap, Point newMap, Point oldPlayer, Point newPlayer, int direction) {
		if(!conf.AllMaps.containsKey(newMap)) {
			conf.AllMaps.put(newMap, mapBuilder.BuildMap(conf));
		}
		
		switch(direction) {
		case 1:
			direction = 3;
			break;
		case 2:
			direction = 4;
			break;
		case 3:
			direction = 1;
			break;
		case 4:
			direction = 2;
			break;
		}
		if(getActualComponent(conf, newMap, newPlayer).canWalk(direction)) {
			conf.AllMaps.get(oldMap)[oldPlayer.x][oldPlayer.y].replaceNoPlayer();
			conf.SingleMap = conf.AllMaps.get(newMap);
			dto.Player.setMAP(newMap);
			dto.Player.setPOSITION(newPlayer);
			updatePlayerPosition(conf, newPlayer);
			view.displayNewField(newPlayer);
		}
		
		if(getActualComponent(conf, newMap, newPlayer).isExit()) {
			view.showEnd();
		}
	}
	
	/**
	 * Checks if the player can move and updates the field
	 * @param view, instance of the Game
	 * @param conf, configuration
	 * @param oldPlayer, current player position
	 * @param newPlayer, player position after change
	 * @param direction, the given direction
	 */
	private void updateField(DefaultView view, Config conf, Point oldPlayer, Point newPlayer, int direction) {
		switch(direction) {
		case 1:
			direction = 3;
			break;
		case 2:
			direction = 4;
			break;
		case 3:
			direction = 1;
			break;
		case 4:
			direction = 2;
			break;
		}
		if(getActualComponent(conf, dto.Player.getMAP(), newPlayer).canWalk(direction)) {
			dto.Player.setPOSITION(newPlayer);
			conf.SingleMap[oldPlayer.x][oldPlayer.y].replaceNoPlayer();
			updatePlayerPosition(conf, newPlayer);
			view.displayNewField(newPlayer);
			if(getActualComponent(conf, dto.Player.getMAP(), newPlayer).isExit()) {
				view.showEnd();
			}
		}
	}
}