package logic;

//Branch
public class BComponentBranch extends BComponentParent{
	
	public BComponentBranch(int alignment) {
		super(alignment);
		replaceNoPlayer();
	}
	
    public boolean canWalk(int direction){
        if (alignment == 1){
            switch (direction){
                case 1:
                case 2:
                case 3: return true;
            }
        } else if (alignment == 2){
            switch (direction){
                case 2:
                case 3:
                case 4: return true;
            }
        }else if (alignment == 3){
            switch (direction){
                case 3:
                case 4:
                case 1: return true;
            }
        }else if (alignment == 4){
            switch (direction){
                case 4:
                case 1:
                case 2: return true;
            }
        }
        return false;
    }

	@Override
	public String getImage() {
		return img;
	}

	@Override
	public void replaceWithPlayer() {
		switch(alignment) {
			case 1:
				img = "/dto/Branch3player.png";
				break;
			case 2:
				img = "/dto/Branch4player.png";
				break;
			case 3:
				img = "/dto/Branch1player.png";
				break;
			case 4:
				img = "/dto/Branch2player.png";
				break;
		}
		
	}

	@Override
	public void replaceNoPlayer() {
		switch(alignment) {
		case 1:
			img = "/dto/Branch3.png";
			break;
		case 2:
			img = "/dto/Branch4.png";
			break;
		case 3:
			img = "/dto/Branch1.png";
			break;
		case 4:
			img = "/dto/Branch2.png";
			break;
	}
	}
}