package logic;

public abstract interface BComponent {
	
	String img = null;

	public boolean canWalk(int alignment);
	
	public boolean isExit();
	public String getImage();
}