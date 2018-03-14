package logic;

//Street
public abstract class Bauteil12 implements BComponent{

	public boolean bl(int direction, int alignment){
		if(alignment > 2){
			alignment = alignment % 2;
		}
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
		} else {
			return false;
		}
	}
}
