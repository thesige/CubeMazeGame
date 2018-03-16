package dto;

import java.awt.Point;

public class Player {

	private static Point POSITION;

	public Player(Point pOSITION) {
		super();
		POSITION = pOSITION;
	}

	public static Point getPOSITION() {
		return POSITION;
	}

	public static void setPOSITION(Point pOSITION) {
		POSITION = pOSITION;
	}
	
}
