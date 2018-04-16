package logic;

//Corner
public class BComponentCorner implements BComponent{
	private int alignment;
	private String img;
	
	public BComponentCorner(int alignment) {
		super();
		this.alignment = alignment;
		replaceNoPlayer();
	}
	
    public boolean canWalk(int direction){
        if (this.alignment == 1){
            switch (direction){
                case 1:
                case 2: return true;
            }
        } else if (this.alignment == 2){
            switch (direction){
                case 2:
                case 3: return true;
            }
        }else if (this.alignment == 3){
            switch (direction){
                case 3:
                case 4: return true;
            }
        }else if (this.alignment == 4){
            switch (direction){
                case 1:
                case 4: return true;
            }
        }
        return false;
    }

	public String getImage() {
		return this.img;
	}

	@Override
	public void replaceWithPlayer() {
		switch(this.alignment) {
		case 1:
			this.img = "/dto/Corner2player.png";
			break;
		case 2:
			this.img = "/dto/Corner3player.png";
			break;
		case 3:
			this.img = "/dto/Corner4player.png";
			break;
		case 4:
			this.img = "/dto/Corner1player.png";
			break;
	}
	}

	@Override
	public void replaceNoPlayer() {
		switch(this.alignment) {
		case 1:
			this.img = "/dto/Corner2.png";
			break;
		case 2:
			this.img = "/dto/Corner3.png";
			break;
		case 3:
			this.img = "/dto/Corner4.png";
			break;
		case 4:
			this.img = "/dto/Corner1.png";
			break;
	}
	}
}
