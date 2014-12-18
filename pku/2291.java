
import java.util.*;

public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int o = sc.nextInt();
    for(;o>0;o--){
      int n = sc.nextInt();
      int[] r = new int[n];
      for(int i = 0; i < n;i++)r[i]=sc.nextInt();
      Arrays.sort(r);
      int ans = 0;
      for(int i = 0; i < n;i++)if(r[i]*(n-i)>ans)ans=r[i]*(n-i);
      System.out.println(ans);
    }
  }
}

