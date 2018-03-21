package logic;

import java.awt.Point;

import dto.Config;
import gui.DefaultView;


public class PlayerMoving {
	MapBuilder mapBuilder = new logic.MapBuilder();
	
	public void validateMove(DefaultView view, Config conf, int direction) {
		int x = dto.Player.getPOSITION().x;
		int y = dto.Player.getPOSITION().y;
		int mapX = dto.Player.getMAP().x;
		int mapY = dto.Player.getMAP().y;
		//Checks if we can walk, else stay here
		if(getActualComponent(conf, x, y).canWalk(direction)) {
			switch(direction){
				case 1: //up
					if(y + 1 > conf.FIELD_SIZE - 1) {
						//Generate new Side
						createField(view, conf, new Point(mapX, mapY), new Point(mapX, mapY + 1), x, y, x, 0, direction);
					}else {
						updateField(view, conf, x, y, x, y + 1, direction);
					}
					break;
				case 2: //right
					if(x + 1 > conf.FIELD_SIZE - 1) {
						//Generate new Side
						createField(view, conf, new Point(mapX, mapY), new Point(mapX + 1, mapY), x, y, 0, y, direction);
					}else {
						updateField(view, conf, x, y, x + 1, y, direction);
					}
					break;
				case 3: //down
					if(y - 1 < 0) {
						//Generate new Side
						createField(view, conf, new Point(mapX, mapY), new Point(mapX, mapY - 1), x, y, x, conf.FIELD_SIZE - 1, direction);
					}else {
						updateField(view, conf, x, y, x, y - 1, direction);
					}
					break;
				case 4: //left
					if(x - 1 < 0) {
						//Generate new Side
						createField(view, conf, new Point(mapX, mapY), new Point(mapX - 1, mapY), x, y, conf.FIELD_SIZE - 1, y, direction);
					}else {
						updateField(view, conf, x, y, x - 1, y, direction);
					}
					break;
			}
		}
	}
	
	private BComponent getActualComponent(Config conf, int x, int y) {
		BComponent Actual = conf.SingleMap[x][y];
		return Actual;
	}
	
	private void updatePlayerPosition(Config conf, Point mapPoint, int x, int y) {
		conf.SingleMap[x][y].replaceWithPlayer();
	}
	
	private void updatePlayerPosition(Config conf, int x, int y) {
		conf.SingleMap[x][y].replaceWithPlayer();
	}
	
	private void createField(DefaultView view, Config conf, Point oldMap, Point mapPoint, int oldX, int oldY, int x, int y, int direction) {
		BComponent[][] tempMap;
		if(conf.AllMaps.get(mapPoint) == null) {
			conf.AllMaps.put(mapPoint, mapBuilder.BuildMap(conf));
		}
		tempMap = conf.AllMaps.get(mapPoint);
		
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
		if(getActualComponent(conf, x, y).canWalk(direction)) {
			conf.AllMaps.get(new Point(oldMap))[oldX][oldY].replaceNoPlayer();
			conf.SingleMap = tempMap;
		}
		
		if(getActualComponent(conf, x, y).isExit()) {
			view.showEnd();
		}else {
			dto.Player.setPOSITION(new Point(x, y));
			updatePlayerPosition(conf, mapPoint, x, y);
			view.displayNewField(new Point(x, y));
		}
	}
	
	private void updateField(DefaultView view, Config conf, int oldX, int oldY, int newX, int newY, int direction) {
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
		if(getActualComponent(conf, newX, newY).canWalk(direction)) {
			dto.Player.setPOSITION(new Point(newX, newY));
			conf.SingleMap[oldX][oldY].replaceNoPlayer();
			updatePlayerPosition(conf, newX, newY);
			view.displayNewField(new Point(newX, newY));
			if(getActualComponent(conf, newX, newY).isExit()) {
				view.showEnd();
			}
		}
	}
}