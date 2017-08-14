import java.util.*;
import static java.lang.Math.*;

public class JumpFurther{
    public int furthest(int n, int bs){
        int sum = 0;
        boolean on = false;
        for(int i = 1; i <= n; i++){
            sum += i;
            if(bs == sum)on = true;
        }
        if(on)sum--;
        return sum;
    }
}
