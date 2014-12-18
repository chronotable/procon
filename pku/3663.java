
import java.util.*;

public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int s = sc.nextInt();
    int[] d = new int[n];
    for(int i = 0; i < n; i++){
      d[i] = sc.nextInt();
    }
    Arrays.sort(d);
    int ans = 0;
    for(int i = 0; i < n - 1;i++){
      if(d[i] + d[i+1] > s)break;
      int v = s - d[i];
      int p = Arrays.binarySearch(d,v);
      if(p < 0) p = -p;
      p--;
      if(p <= i) p = i+1;
      while(p < n && d[i] + d[p] <= s)p++;
      ans += p - i - 1;
    }
    System.out.println(ans);
  }
}

