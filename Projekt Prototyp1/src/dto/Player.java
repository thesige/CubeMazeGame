package dto;

import java.awt.Point;

public class Player {

	private static Point POSITION;
	private static Point MAP;

	public Player(Point pOSITION, Point map) {
		super();
		POSITION = pOSITION;
		MAP = map;
	}

	public static Point getPOSITION() {
		return POSITION;
	}

	public static void setPOSITION(Point position) {
		POSITION = position;
	}
	
	public static Point getMAP() {
		return MAP;
	}

	public static void setMAP(Point map) {
		MAP = map;
	}
	
}
