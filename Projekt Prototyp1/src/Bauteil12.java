
public class Bauteil12 {

	public boolean bl(int direction, int alignment){
		if (alignment == 1){
			switch (direction){
			case 1: return true;
			case 2: return false;
			case 3: return true;
			case 4: return false;
			default: return false;
			}
		} else if (alignment == 2){
			switch (direction){
			case 1: return false;
			case 2: return true;
			case 3: return false;
			case 4: return true;
			default: return false;
			}
		} else {
			return false;
		}
	}
}
