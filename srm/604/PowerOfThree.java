import java.util.*;
import static java.lang.Math.*;

public class PowerOfThree{
    public String ableToGet(int x, int y){
        while(x != 0 || y != 0){
            x = abs(x); y = abs(y);
            if(x % 3 == 0 && y % 3 == 0)return "Impossible";
            if(x % 3 == 1)x--;
            else if(x % 3 == 2)x++;
            else if(y % 3 == 1)y--;
            else if(y % 3 == 2)y++;
            if(x % 3 > 0 || y % 3 > 0)return "Impossible";
            x /= 3; y /= 3;
        }
        return "Possible";
    }
}