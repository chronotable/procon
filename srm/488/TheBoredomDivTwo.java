import java.util.*;

public class TheBoredomDivTwo{
    public int find(int n, int m, int j, int b){
        int ans = n;
        if(j > n)ans++;
        if(b > n && b != j)ans++;
        return ans;
    }
}