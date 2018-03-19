package logic;

//Branch
public class BComponentBranch implements BComponent{
	private int alignment;
	private String img;
	
	public BComponentBranch(int alignment) {
		super();
		if(alignment > 4){
            alignment = alignment % 4;
        }else {
        	this.alignment = alignment;
        }
		replaceNoPlayer();
	}
	
    public boolean canWalk(int direction){
        if (this.alignment == 1){
            switch (direction){
                case 1:
                case 2:
                case 3: return true;
            }
        } else if (this.alignment == 2){
            switch (direction){
                case 2:
                case 3:
                case 4: return true;
            }
        }else if (this.alignment == 3){
            switch (direction){
                case 3:
                case 4:
                case 1: return true;
            }
        }else if (this.alignment == 4){
            switch (direction){
                case 4:
                case 1:
                case 2: return true;
            }
        }
        return false;
    }
    
    public boolean isExit() {
    	return false;
    }

	@Override
	public String getImage() {
		return this.img;
	}

	@Override
	public void replaceWithPlayer() {
		switch(this.alignment) {
			case 1:
				this.img = "/dto/Branch3player.png";
				break;
			case 2:
				this.img = "/dto/Branch4player.png";
				break;
			case 3:
				this.img = "/dto/Branch1player.png";
				break;
			case 4:
				this.img = "/dto/Branch2player.png";
				break;
		}
		
	}

	@Override
	public void replaceNoPlayer() {
		switch(this.alignment) {
		case 1:
			this.img = "/dto/Branch3.png";
			break;
		case 2:
			this.img = "/dto/Branch4.png";
			break;
		case 3:
			this.img = "/dto/Branch1.png";
			break;
		case 4:
			this.img = "/dto/Branch2.png";
			break;
	}
	}
}