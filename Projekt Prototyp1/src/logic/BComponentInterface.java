package logic;

/**
 * The single components
 * @author jermann
 *
 */
public abstract interface BComponentInterface {
	/**
	 * Checks if the player can walk
	 * @param alignment, the direction
	 * @return, boolean
	 */
	public boolean canWalk(int alignment);
	
	/**
	 * Checks if the component is the exit
	 * @return false, true on BComponentExit
	 */
	public boolean isExit();
	
	/**
	 * gets the image as string
	 * @return
	 */
	public String getImage();
	
	/**
	 * Replaces the image with the one with the player
	 */
	public void replaceWithPlayer();
	
	/**
	 * Replaces the image with the one without the player
	 */
	public void replaceNoPlayer();
}