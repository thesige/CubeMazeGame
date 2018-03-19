package logic;

import java.awt.Point;

import dto.Config;
import gui.DefaultView;


public class PlayerMoving {
	MapBuilder mapBuilder = new logic.MapBuilder();
	
	public void validateMove(DefaultView view, Config conf, int direction) {
		int x = dto.Player.getPOSITION().x;
		int y = dto.Player.getPOSITION().y;
		//Checks if we can walk, else stay here
		if(getActualComponent(conf, x, y).canWalk(direction)) {
			switch(direction){
				case 1: //up
					if(y + 1 > conf.FIELD_SIZE - 1) {
						//Generate new Side
						createField(view, conf, x, 0);
					}else {
						updateField(view, conf, x, y, x, y + 1);
					}
					break;
				case 2: //right
					if(x + 1 > conf.FIELD_SIZE - 1) {
						//Generate new Side
						createField(view, conf, 0, y);
					}else {
						updateField(view, conf, x, y, x + 1, y);
					}
					break;
				case 3: //down
					if(y - 1 < 0) {
						//Generate new Side
						createField(view, conf, x, conf.FIELD_SIZE - 1);
					}else {
						updateField(view, conf, x, y, x, y - 1);
					}
					break;
				case 4: //left
					if(x - 1 < 0) {
						//Generate new Side
						createField(view, conf, conf.FIELD_SIZE - 1, y);
					}else {
						updateField(view, conf, x, y, x - 1, y);
					}
					break;
			}
		}
	}
	
	private BComponent getActualComponent(Config conf, int x, int y) {
		BComponent Actual = conf.CurrentMapArray[x][y];
		return Actual;
	}
	
	private void updatePlayerPosition(Config conf, int x, int y) {
		conf.CurrentMapArray[x][y].replaceWithPlayer();
	}
	
	private void createField(DefaultView view, Config conf, int x, int y) {
		if(getActualComponent(conf, x, y).isExit()) {
			view.showEnd();
		}else {
			conf.CurrentMapArray = mapBuilder.BuildMap(conf);
			dto.Player.setPOSITION(new Point(x, y));
			updatePlayerPosition(conf, x, y);
			view.displayNewField();
		}
	}
	
	private void updateField(DefaultView view, Config conf, int oldX, int oldY, int newX, int newY) {
		dto.Player.setPOSITION(new Point(newX, newY));
		conf.CurrentMapArray[oldX][oldY].replaceNoPlayer();
		updatePlayerPosition(conf, newX, newY);
		view.displayNewField();
		if(getActualComponent(conf, newX, newY).isExit()) {
			view.showEnd();
		}
	}
}