import java.util.*;
import static java.lang.Math.*;

public class Family{
    public String isFamily(int[] p1, int[] p2){
        int n = p1.length;
        boolean[][] con = new boolean[n][n];
        for(int i = 0; i < n; i++)if(p1[i] != -1)con[p1[i]][p2[i]] = con[p2[i]][p1[i]] = true;
        int[] gender = new int[n];
        //boolean possible = true;
        for(int i = 0; i < n; i++)if(gender[i] == 0){
                gender[i] = 1;
                Queue<Integer> q = new LinkedList<Integer>();
                q.offer(i);
                while(!q.isEmpty()){
                    int cur = q.poll();
                    for(int j = 0; j < n; j++)if(con[cur][j]){
                            if(gender[j] != 0){
                                if(gender[j] == gender[cur])return "Impossible";
                            }else{
                                gender[j] = -gender[cur];
                                q.offer(j);
                            }
                        }
                }
            }
        return "Possible";
    }
}