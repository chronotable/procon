import java.util.*;
import static java.lang.Math.*;

public class MysticAndCandies{
    int n;
    public int minBoxes(int C, int X, int[] low, int[] high){
        n = low.length;
        int sum = 0;
        int t = X;
        Arrays.sort(low);
        for(int i = n-1; i >= 0; i--){
            t -= low[i];
            sum++;
            if(t <= 0)break;
        }
        int ans = sum;
        Arrays.sort(high);
        t = C - X;
        sum = n;
        for(int i = 0; i < n; i++){
            t -= high[i];
            sum--;
            if(t < 0){
                sum++;
                break;
            }
        }
        ans = min(ans, sum);
        return ans;
    }
    /*
  int sim(int C, int X, int[] low, int[] high, int start){
    boolean[] u = new boolean[n];
    C -= low[start];
    X -= low[start];
    u[start] = true;
    int ret = 1;
    while(X > 0){
      ArrayList<E> a = new ArrayList<E>();
      for(int i = 0; i < n; i++)if(!u[i])a.add(new E(high[i], i));
      if(a.size() == 0)return n;
      Collections.sort(a);
      int sum = 0;
      for(int i = 0; i < a.size()-1; i++)sum += a.get(i).value;
      int cand0 = C - sum;
      int ind0 = a.get(a.size()-1).index;
      //if(cand0 < low[ind0] || cand0 > high[ind0])cand0 = -1;
      int cand1 = 0, ind1 = -1;
      for(int i = 0; i < n; i++)if(!u[i]){
        if(cand1 < low[i] || (cand1 == low[i] && high[ind1] < high[i])){
          cand1 = low[i]; ind1 = i;
        }
      }
      if(cand0 > cand1){
        C -= cand0; X -= cand0; u[ind0] = true; 
      }else{
        C -= cand1; X -= cand1; u[ind1] = true;
      }
      ret++;
    }
    return ret;
  }
  public int minBoxes(int C, int X, int[] low, int[] high){
    n = low.length;
    int ans = n;
    for(int i = 0; i < n; i++)ans = min(ans, sim(C, X, low, high, i));
    return ans;
  }
    */
}

/*
class E implements Comparable<E>{
  int value;
  int index;
  E(int v, int i){
    value = v; index = i;
  }
  public int compareTo(E e){
    return value - e.value;
  }
}
*/