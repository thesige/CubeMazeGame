package dto;

import java.awt.Point;
import java.util.HashMap;

import logic.BComponentInterface;

/**
 * The storage, important variables get stored here
 * @author jermann
 *
 */
public class Config {

	public int FIELD_SIZE;
	
	public HashMap<Point, BComponentInterface[][]> AllMaps = new HashMap<Point, BComponentInterface[][]>();
	public BComponentInterface[][] SingleMap = null;
}