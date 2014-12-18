import java.util.*;

public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    boolean[] u = new boolean[k+1];
    int b = 0;
    int ans = 0;
    for(int i = 0; i < n;i++){
      int v = sc.nextInt();
      if(!u[v]){
        u[v] = true;
        b++;
        if(b==k){
          b=0;
          ans++;
          Arrays.fill(u,false);
        }
      }
    }
    System.out.println(ans+1);
  }
}
