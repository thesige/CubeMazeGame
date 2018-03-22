package dto;

import java.awt.Point;
import java.util.HashMap;

import logic.BComponent;

public class Config {

	public int FIELD_SIZE;
	
	public HashMap<Point, BComponent[][]> AllMaps = new HashMap<Point, BComponent[][]>();
	public BComponent[][] SingleMap = null;
}