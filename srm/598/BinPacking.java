import java.util.*;
import static java.lang.Math.*;

public class BinPacking{
    public int minBins(int[] item){
        Arrays.sort(item);
        int ans = item.length;
        for(int start = 0; start < item.length; start += 3){
            int sum = start / 3;
            int left = start;
            for(int i = item.length-1; i >= 0 && i >= left; i--){
                if(i == left){
                    sum++; break;
                }
                if(left+1 < i && item[i] + item[left] + item[left+1] <= 300){
                    left += 2;
                    sum++;
                    continue;
                }
                if(item[i] + item[left] <= 300){
                    left++; sum++;
                    continue;
                }
                sum++;
            }
            ans = min(ans, sum);
            if(start + 3 >= item.length || item[start] + item[start+1] + item[start+2] > 300)break;
        }
        return ans;
    }
}