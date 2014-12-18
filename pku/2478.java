import java.util.*;
import static java.lang.Math.*;

public class Main{
  public static void main(String[] args){
    new Main().run();
  }
  
  void run(){
    Scanner sc = new Scanner(System.in);
    final int M = 1000001;
    EulerPhi ep = new EulerPhi(M);
    long[] ans = new long[M];
    ans[2] = ep.f[2];
    for(int i = 3; i < ans.length; i++)ans[i] = ep.f[i] + ans[i-1];
    for(;;){
      int n = sc.nextInt();
      if(n == 0)break;
      System.out.println(ans[n]);
    }
  }
}

class EulerPhi{
  int[] f;
  int n;
  
  EulerPhi(int a){
    n = a;
    f = new int[n];
    boolean [] p = new boolean[n];
    for(int i = 0; i < n; i++){
      p[i] = true;
      f[i] = i;
    }
    for(int i = 2; i < n; i++){
      if(p[i]){
        f[i] -= f[i] / i;
        for(int j = i+i; j < n; j+=i){
          p[j] = false;
          f[j] -= f[j] / i;
        }
      }
    }
  }
}
