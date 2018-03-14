package logic;

//Corner
public class Bauteil22 {

    public boolean bl(int direction, int alignment){
        if(alignment > 4){
            alignment = alignment % 4;
        }
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
}
