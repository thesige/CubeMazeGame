package dto;

import java.awt.Point;
import java.util.HashMap;

import logic.BComponent;
import logic.Maps;

public class Config {

	public final int FIELD_SIZE = 3;
	
	public HashMap<Point, BComponent[][]> AllMaps = new HashMap<Point, BComponent[][]>();
	public BComponent[][] SingleMap = null;
}