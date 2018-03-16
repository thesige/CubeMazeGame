package logic;

//Corner
public class BComponentCorner implements BComponent{
	private int alignment;
	private String img;
	
	public BComponentCorner(int alignment) {
		super();
		if(alignment > 4){
        	this.alignment = alignment % 4;
        }else {
        	this.alignment = alignment;
        }
		if(alignment == 1) {
			this.img = "/dto/Corner1.png";
		}else if(alignment == 2) {
			this.img = "/dto/Corner2.png";
		}else if(alignment == 3) {
			this.img = "/dto/Corner3.png";
		}else {
			this.img = "/dto/Corner4.png";
		}
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
    
    public boolean isExit() {
    	return false;
    }

	public String getImage() {
		return this.img;
	}
}
