package dto;

import java.awt.Point;
import java.util.HashMap;

import logic.BComponent;

/**
 * The storage, important variables get stored here
 * @author jermann
 *
 */
public class Config {

	public int FIELD_SIZE;
	
	public HashMap<Point, BComponent[][]> AllMaps = new HashMap<Point, BComponent[][]>();
	public BComponent[][] SingleMap = null;
}