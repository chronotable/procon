import java.util.*;
import static java.lang.Math.*;

public class DoubleOrOneEasy{
    public int minimalSteps(int a, int b, int na, int nb){
        if(a > na || b > nb)return -1;
        int ret = -1;
        if(na % 2 == nb % 2){
            int res = minimalSteps(a, b, na>>1, nb>>1);
            if(res >= 0)ret = res + (na%2==1?2:1);
        }
        int ad = na-a;
        int bd = nb-b;
        if(ad==bd){
            if(ret < 0)ret = ad;
            else ret = min(ret, ad);
        }
        return ret;
    }
}
