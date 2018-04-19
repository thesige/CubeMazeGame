package logic;

//Street
public class BComponentStreet extends BComponentParent{
	
	public BComponentStreet(int alignment) {
		super(alignment);
		replaceNoPlayer();
	}
	
	public boolean canWalk(int direction){
		if (alignment == 1){
			switch (direction){
			case 1:
			case 3: return true;
			}
		} else if (alignment == 2){
			switch (direction){
			case 2:
			case 4: return true;
			}
		} 
		return  false;
	}
	
	public String getImage() {
		return img;
	}

	@Override
	public void replaceWithPlayer() {
		switch(alignment) {
		case 1:
			img = "/dto/Street1player.png";
			break;
		case 2:
			img = "/dto/Street2player.png";
			break;
		}
	}

	@Override
	public void replaceNoPlayer() {
		switch(alignment) {
		case 1:
			img = "/dto/Street1.png";
			break;
		case 2:
			img = "/dto/Street2.png";
			break;
		}
	}
}