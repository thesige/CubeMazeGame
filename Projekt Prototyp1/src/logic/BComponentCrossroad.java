package logic;

//Crossroad
public class BComponentCrossroad implements BComponent{
	@SuppressWarnings("unused")
	private int alignment;
	private String img;
	
	public BComponentCrossroad(int alignment) {
		super();
		this.img = "/dto/Crossroad.png";
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
}