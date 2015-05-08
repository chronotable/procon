import java.util.*;
import static java.lang.Math.*;

public class IncrementAndDoubling{
    public int getMin(int[] da){
        int[] cost = new int[1001];
        Arrays.fill(cost, 1<<20);
        Queue<Integer> q = new LinkedList<Integer>();
        cost[0] = 0;
        q.offer(0);
        while(!q.isEmpty()){
            int v = q.poll();
            // increment
            if(v+1 < cost.length && cost[v+1] > cost[v] + 1){
                cost[v+1] = cost[v] + 1; q.offer(v+1);
            }
            // double
            if(v*2 < cost.length && cost[v*2] > cost[v] + 1){
                cost[v*2] = cost[v] + 1; q.offer(v*2);
            }
        }
        int ans = 1<<30;
        int double_step = 0;
        while(true){
            int sum = 0;
            for(int v : da)sum += cost[v];
            ans = min(ans, sum + double_step);
            if(sum == 0)break;
            boolean allzero = true;
            for(int i = 0; i < da.length; i++){
                if((da[i] & 1) == 1){
                    da[i]--;
                    double_step++;
                }
                allzero &= da[i] == 0;
                da[i] >>= 1;
            }
            if(!allzero)
                double_step++;
        }
        return ans;
    }
}
