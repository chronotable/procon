import java.util.*;

public class Main{
  public static void main(String[] args){
    new Main().run();
  }
  void run(){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int on = 0;
    int[] last = new int[n];
    for(int i = 0; i < n; i++){
      last[i] = sc.nextInt();
      if(last[i] == 1)on++;
    }
    int[] next = new int[n];
    boolean[] use = new boolean[n];
    for(int i = 0; i < n; i++){
      int b = -1;
      if(i < n - on)b = 0;
      else b = 1;
      int ind = 0;
      while(last[ind] != b || use[ind])ind++;
      use[ind] = true;
      next[i] = ind;
    }
    int cur = 0;
    for(int i = 0; i < n; i++){
      cur = next[cur];
      System.out.print(last[cur] + " ");
    }
  }
}
