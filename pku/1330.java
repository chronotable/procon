import java.util.*;

public class Main{
  public static void main(String[] args){
    new Main().run();
  }
  void run(){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for(;t>0;t--){
      int n = sc.nextInt();
      int[] anc = new int[n+1];
      for(int i = 1; i <= n;i++)anc[i] = i;
      for(int i = 0; i < n-1;i++){
        int a = sc.nextInt(),b = sc.nextInt();
        anc[b] = a;
      }
      int a = sc.nextInt(), b = sc.nextInt();
      boolean[] u = new boolean[n+1];
      while(a != anc[a]){
        u[a] = true;
        a = anc[a];
      }
      u[a] = true;
      while(!u[b])b = anc[b];
      System.out.println(b);
    }
  }
}
