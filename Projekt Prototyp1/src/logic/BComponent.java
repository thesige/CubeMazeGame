package logic;

public abstract interface BComponent {
	
	String img = null;

	public boolean canWalk(int alignment);
	
	public default boolean isExit() {
		return false;
	};
	public String getImage();
	public void replaceWithPlayer();
	public void replaceNoPlayer();
}