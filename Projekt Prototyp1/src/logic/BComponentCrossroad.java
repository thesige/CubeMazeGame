package logic;

//Crossroad
public class BComponentCrossroad implements BComponent{
	@SuppressWarnings("unused")
	private int alignment;
	private String img;
	
	public BComponentCrossroad(int alignment) {
		super();
		replaceNoPlayer();
	}
	
    public boolean canWalk(int direction){
        return true;
    }
    
    public boolean isExit() {
    	return false;
    }
    
    public String getImage() {
		return this.img;
	}

	@Override
	public void replaceWithPlayer() {
		this.img = "/dto/Crossroadplayer.png";
	}

	@Override
	public void replaceNoPlayer() {
		this.img = "/dto/Crossroad.png";
	}
}