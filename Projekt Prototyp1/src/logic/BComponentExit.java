package logic;

public class BComponentExit extends BComponentParent{
	
	public BComponentExit(int alignment) {
		super(alignment);
		img = "/dto/Player.png";
	}
	
    public boolean canWalk(int direction){
        return true;
    }
    
    public boolean isExit() {
    	return true;
    }
    
    public String getImage() {
		return img;
	}

	@Override
	public void replaceWithPlayer() {
	}

	@Override
	public void replaceNoPlayer() {
	}
}