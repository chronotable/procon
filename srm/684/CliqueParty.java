import java.util.*;
import static java.lang.Math.*;

public class CliqueParty{
    public int maxsize(int[] a, int K){
        Arrays.sort(a);
        int n = a.length;
        int ans = 2;
        for(int x = 0; x < n; x++)for(int y = x+1; y < n; y++){
                int mx = a[y] - a[x];
                int prev = x;
                ArrayList<Integer> ind = new ArrayList<Integer>();
                for(int i = x+1; i < y; i++){
                    int dif = a[i] - a[prev];
                    if(1l * mx <= 1l * dif * K){
                        prev = i;
                        ind.add(i);
                    }
                }
                int sum = 0;
                for(int i = ind.size()-1; i >= 0; i--)if(1l * mx <= 1l * K * (a[y] - a[ind.get(i)])){
                        sum = i + 1;
                        break;
                    }
                ans = max(ans, 2 + sum);
            }
        return ans;
    }
}
