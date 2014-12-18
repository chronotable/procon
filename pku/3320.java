import java.util.*;
import static java.lang.Math.*;

public class Main{
  public static void main(String[] args){
    new Main().run();
  }
  void run(){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] seq = new int[n];
    Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
    for(int i = 0; i < n;i++){
      seq[i] = sc.nextInt();
      if(!ht.containsKey(seq[i]))ht.put(seq[i], ht.size());
    }
    int idn = ht.size();
    int[] freq = new int[idn];
    boolean[] u = new boolean[idn];
    int collect = 0;
    int head = 0;
    int ans = n;
    for(int i = 0; i < n;i++){
      int v = ht.get(seq[i]);
      if(!u[v]){
        u[v] = true;
        collect++;
      }
      freq[v]++;
      while(head < n){
        int hv = ht.get(seq[head]);
        if(freq[hv] > 1){
          freq[hv]--;
          head++;
        }else{
          break;
        }
      }
      if(collect == idn)ans = min(ans, i - head + 1);
    }
    System.out.println(ans);
  }
}
