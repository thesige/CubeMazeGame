package logic;

//Street
public class BComponentStreet implements BComponent{
	private int alignment;
	private String img;
	
	public BComponentStreet(int alignment) {
		super();
		if(alignment > 2){
			this.alignment = alignment % 2;
		}else {
			this.alignment = alignment;
		}
		if(this.alignment == 2) {
			this.img = "/dto/Street1.png";
		}else {
			this.img = "/dto/Street2.png";
		}
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
}