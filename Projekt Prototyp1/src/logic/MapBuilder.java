package logic;

import java.awt.Point;

import dto.Config;

/**
 * Builds the new maps
 * @author jermann
 *
 */
public class MapBuilder {
	
	/**
	 * Creates the map
	 * @param conf, configuration
	 * @return, created map
	 */
	public BComponentInterface[][] BuildMap(Config conf){
		BComponentInterface b[][] = new BComponentInterface[conf.FIELD_SIZE][conf.FIELD_SIZE];
		for(int j = 0; j < conf.FIELD_SIZE; j++) {
			for(int i = 0; i < conf.FIELD_SIZE; i++) {
				int RandomExit = (int)(Math.random() * (6 * (conf.FIELD_SIZE * conf.FIELD_SIZE)));
				if(RandomExit == 0) {
					b[j][i] = new BComponentExit(1);
				}else {
					int RandomBComponent = (int)(Math.random() * 4 + 1);
					switch(RandomBComponent) {
						case 1:
							b[j][i] = new BComponentStreet((int)(Math.random() * 2 + 1));
							break;
						case 2:
							b[j][i] = new BComponentCorner((int)(Math.random() * 4 + 1));
							break;
						case 3:
							b[j][i] = new BComponentBranch((int)(Math.random() * 4 + 1));
							break;
						case 4:
							b[j][i] = new BComponentCrossroad(1);
							break;
					}
				}
			}
		}
		return b;
	}
	
	/**
	 * Gets the image string of the component
	 * @param conf, configuration
	 * @param map, given map
	 * @param bcomp, field on map
	 * @return, string with path to the image
	 */
	public String getImageAsLabel(Config conf, Point map, Point bcomp) {
		return conf.SingleMap[bcomp.x][bcomp.y].getImage();
	}
}