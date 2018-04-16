package dto;

import java.awt.Point;

/**
 * The player
 * @author jermann
 * POSITION, saves the position on the current map
 * MAP, saves the current map
 */
public class Player {

	private static Point POSITION;
	private static Point MAP;

	/**
	 * creates the player with the given coordinates
	 * @param pOSITION, position on the current map
	 * @param map, current map
	 */
	public Player(Point pOSITION, Point map) {
		super();
		POSITION = pOSITION;
		MAP = map;
	}

	/**
	 * gets the position on the current map
	 * @return, position on current map
	 */
	public static Point getPOSITION() {
		return POSITION;
	}

	/**
	 * puts the position on the current map
	 * @param position, new position on current map
	 */
	public static void setPOSITION(Point position) {
		POSITION = position;
	}
	
	/**
	 * gets the current map
	 * @return, current map
	 */
	public static Point getMAP() {
		return MAP;
	}

	/**
	 * puts the current map
	 * @param map, new current map
	 */
	public static void setMAP(Point map) {
		MAP = map;
	}
	
}
