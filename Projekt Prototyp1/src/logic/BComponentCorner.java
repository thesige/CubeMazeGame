package logic;

//Corner
public class BComponentCorner extends BComponentParent{
	
	public BComponentCorner(int alignment) {
		super(alignment);
		replaceNoPlayer();
	}
	
    public boolean canWalk(int direction){
        if (alignment == 1){
            switch (direction){
                case 1:
                case 2: return true;
            }
        } else if (alignment == 2){
            switch (direction){
                case 2:
                case 3: return true;
            }
        }else if (alignment == 3){
            switch (direction){
                case 3:
                case 4: return true;
            }
        }else if (alignment == 4){
            switch (direction){
                case 1:
                case 4: return true;
            }
        }
        return false;
    }

	public String getImage() {
		return img;
	}

	@Override
	public void replaceWithPlayer() {
		switch(alignment) {
		case 1:
			img = "/dto/Corner2player.png";
			break;
		case 2:
			img = "/dto/Corner3player.png";
			break;
		case 3:
			img = "/dto/Corner4player.png";
			break;
		case 4:
			img = "/dto/Corner1player.png";
			break;
	}
	}

	@Override
	public void replaceNoPlayer() {
		switch(alignment) {
		case 1:
			img = "/dto/Corner2.png";
			break;
		case 2:
			img = "/dto/Corner3.png";
			break;
		case 3:
			img = "/dto/Corner4.png";
			break;
		case 4:
			img = "/dto/Corner1.png";
			break;
	}
	}
}
