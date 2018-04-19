package logic;

//Crossroad
public class BComponentCrossroad extends BComponentParent{
	
	public BComponentCrossroad(int alignment) {
		super(alignment);
		replaceNoPlayer();
	}
	
    public boolean canWalk(int direction){
        return true;
    }
    
    public String getImage() {
		return img;
	}

	@Override
	public void replaceWithPlayer() {
		img = "/dto/Crossroadplayer.png";
	}

	@Override
	public void replaceNoPlayer() {
		img = "/dto/Crossroad.png";
	}
}