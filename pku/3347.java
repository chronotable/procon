import java.util.*;
import static java.lang.Math.*;

public class Main{
  public static void main(String[] args){
    new Main().run();
  }
  
  void run(){
    Scanner sc = new Scanner(System.in);
    for(;;){
      int n = sc.nextInt();
      if(n == 0)break;
      Sq[] s = new Sq[n+3];
      s[0] = new Sq(0, 0, 0);
      int mx = 0;
      for(int i = 1; i <= n; i++){
        int h = sc.nextInt();
        s[i] = new Sq(h, 0, 0);
        if(s[i].h <= s[i-1].h){
          s[i].l = s[i-1].r - abs(s[i].h - s[i-1].h);
        }else{
          int maxl = 0;
          for(int j = i-1; j >= 0; j--){
            s[i].l = s[j].r - abs(s[i].h - s[j].h);
            if(maxl < s[i].l)maxl = s[i].l;
          }
          s[i].l = maxl;
        }
        if(s[i].l < 0)s[i].l = 0;
        s[i].r = s[i].l + 2 * s[i].h;
        if(s[i].r > s[mx].r)mx = i;
      }
      s[n+1] = new Sq(0,0,0);
      s[n+1].l = s[mx].r;
      for(int i = 1; i <= n; i++){
        for(int k = i-1; k >= 0; k--){
          for(int j = i+1; j <= n+1; j++){
            if(s[k].r >= s[j].l)s[i].used = false;
          }
        }
      }
      int ind = 1;
      while(!s[ind].used)ind++;
      System.out.print(ind++);
      while(ind <= n){
        if(s[ind].used)System.out.print(" " + ind);
        ind++;
      }
      System.out.println();
    }
  }
  
  class Sq{
    int h, l, r;
    boolean used;
    Sq(int a, int b, int c){
      h = a;
      l = b;
      r = c;
      used = true;
    }
  }
  
  /*
  void run(){
    Scanner sc = new Scanner(System.in);
    for(;;){
      int n = sc.nextInt();
      if(n == 0)break;
      int[] s = new int[n+1];
      for(int i = 1; i <= n; i++)s[i] = sc.nextInt();
      ArrayList<Integer> ans = new ArrayList<Integer>();
      double[] b = new double[n+1];
      ans.add(1);
      b[1] = s[1] / sqrt(2);
      for(int i = 2; i <= n; i++){
        if(b[i-1] + s[i-1]*sqrt(2) < s[i] / sqrt(2)){
          ans.clear();
          ans.add(i);
          b[i] = s[i] / sqrt(2);
          continue;
        }
        double tb = b[i-1] + s[i-1] * sqrt(2);
        if(s[i] < s[i-1])tb = b[i-1] + s[i] * sqrt(2);
        for(int j = i-2; j >= 1; j--){
          if((b[j] + tb) / 2.0 < b[j] + s[j] / sqrt(2) &&
             abs((b[j] + tb) / 2.0 - (tb - s[i] / sqrt(2))) > 1e-9 ){
            if(s[j] > s[i]){
              tb = b[j] + s[i] * sqrt(2);
            }else{
              tb = b[j] + s[j] * sqrt(2);
            }
            ArrayList<Integer> na = new ArrayList<Integer>();
            for(int k = 0; k < ans.size(); k++){
              int v = ans.get(k);
              if(v <= j)na.add(v);
            }
            ans = na;
            break;
          }
          b[i] = tb;
          ans.add(i);
        }
      }
      System.out.print(ans.get(0));
      for(int i = 1; i < ans.size(); i++)System.out.print(" " + ans.get(i));
      System.out.println();
    }
  }
  */
}
