import java.util.*;
import static java.lang.Math.*;

public class BigFatInteger{
    public int minOperations(int A, int B){
        int ans = 0;
        //HashSet<Integer> s = new HashSet<Integer>();
        int a = A;
        int mx = 0;
        for(int i = 2; i <= a; i++){
            if(a % i > 0)continue;
            ans++;
            int count = 0;
            while(a % i == 0){
                count++;
                a /= i;
            }
            mx = max(mx, count);
        }
        mx *= B;
        //System.out.println(mx);
        int cur = 1;
        while(cur < mx){
            cur *= 2; ans++;
        }
        return ans;
    }
}