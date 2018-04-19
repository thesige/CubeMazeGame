package logic;

public class BComponentParent implements BComponentInterface{
	protected int alignment;
	protected String img;
	
	public BComponentParent(int alignment) {
		this.alignment = alignment;
	}

	public boolean canWalk(int alignment) {
		return false;
	}

	public String getImage() {
		return null;
	}

	public void replaceWithPlayer() {
	}

	public void replaceNoPlayer() {
	}

	public boolean isExit() {
		return false;
	}

}
