import java.util.*;
import static java.lang.Math.*;

public class PaintTheRoom{
    private static final String OK = "Paint";
    private static final String NG = "Cannot paint";
    public String canPaintEvenly(int R, int C, int K){
        if(K==1)return OK;
        int mn = min(R, C);
        int mx = max(R, C);
        if(mn == 2 || mx == 2)return OK;
        if(mn % 2 == 1 && mx % 2 == 1)return NG;
        return OK;
    }
}
