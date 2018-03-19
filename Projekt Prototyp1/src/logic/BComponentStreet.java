package logic;

//Street
public class BComponentStreet implements BComponent{
	private int alignment;
	private String img;
	
	public BComponentStreet(int alignment) {
		super();
		this.alignment = alignment;
		replaceNoPlayer();
	}
	
	public boolean canWalk(int direction){
		if (this.alignment == 1){
			switch (direction){
			case 1:
			case 3: return true;
			}
		} else if (this.alignment == 2){
			switch (direction){
			case 2:
			case 4: return true;
			}
		} 
		return  false;
	}
	
	public boolean isExit() {
    	return false;
    }
	
	public String getImage() {
		return this.img;
	}

	@Override
	public void replaceWithPlayer() {
		switch(this.alignment) {
		case 1:
			this.img = "/dto/Street1player.png";
			break;
		case 2:
			this.img = "/dto/Street2player.png";
			break;
		}
	}

	@Override
	public void replaceNoPlayer() {
		switch(this.alignment) {
		case 1:
			this.img = "/dto/Street1.png";
			break;
		case 2:
			this.img = "/dto/Street2.png";
			break;
		}
	}
}