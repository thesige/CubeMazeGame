package logic;

import java.awt.Point;

import dto.Config;
import gui.DefaultView;


public class PlayerMoving {
	MapBuilder mapBuilder = new logic.MapBuilder();
	
	public boolean validateMove(DefaultView view, Config conf, int direction) {
		int x = dto.Player.getPOSITION().x;
		int y = dto.Player.getPOSITION().y;
		System.out.println(x);
		System.out.println(y);
		//Checks if we can walk, else stay here
		if(getActualComponent(conf, x, y).isExit()) {
			view.showEnd();
		}else if(getActualComponent(conf, x, y).canWalk(direction)) {
			System.out.println("movig");
			switch(direction){
				case 1: //up
					if(y + 1 > conf.FIELD_SIZE - 1) {
						//Generate new Side
						conf.CurrentMapArray = mapBuilder.BuildMap(conf);
						dto.Player.setPOSITION(new Point(x, 0));
						view.displayNewField();
					}else {
						dto.Player.setPOSITION(new Point(x, y + 1));
					}
					break;
				case 2: //right
					if(x + 1 > conf.FIELD_SIZE - 1) {
						//Generate new Side
						conf.CurrentMapArray = mapBuilder.BuildMap(conf);
						dto.Player.setPOSITION(new Point(0, y));
						view.displayNewField();
					}else {
						dto.Player.setPOSITION(new Point(x + 1, y));
					}
					break;
				case 3: //down
					if(y - 1 < 0) {
						//Generate new Side
						conf.CurrentMapArray = mapBuilder.BuildMap(conf);
						dto.Player.setPOSITION(new Point(x, conf.FIELD_SIZE - 1));
						view.displayNewField();
					}else {
						dto.Player.setPOSITION(new Point(x, y - 1));
					}
					break;
				case 4: //left
					if(x - 1 < 0) {
						//Generate new Side
						conf.CurrentMapArray = mapBuilder.BuildMap(conf);
						dto.Player.setPOSITION(new Point(conf.FIELD_SIZE - 1, y));
						view.displayNewField();
					}else {
						dto.Player.setPOSITION(new Point(x - 1, y));
					}
					break;
				default: //wrong input
					break;
			}
		}
		return false;
	}
	
	private BComponent getActualComponent(Config conf, int x, int y) {
		BComponent Actual = conf.CurrentMapArray[x][y];
		return Actual;
	}
}