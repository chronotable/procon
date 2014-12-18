import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class Main{
  public static void main(String[] args){
    new Main().run();
  }
  
  void run(){
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    try{
      for(;;){
        String[] cn = sc.readLine().split(" ");
        int c = Integer.parseInt(cn[0]);
        int n = Integer.parseInt(cn[1]);
        if(c+n==0)break;
        int[] use = new int[c];
        int[] cand = new int[n];
        String[] cs = sc.readLine().split(" ");
        for(int i = 0; i < n; i++)cand[i] = Integer.parseInt(cs[i]);
        int sum = 0;
        int start = -1, end = -1;
        for(int i = 0; i < n; i++){
          sum = (sum + cand[i]) % c;
          if(sum == 0){
            start = 1;
            end = i + 1;
            break;
          }
          if(use[sum] > 0){
            start = use[sum] + 1;
            end = i + 1;
            break;
          }
          use[sum] = i+1;
        }
        for(int i = start; i < end; i++)
          System.out.print(i + " ");
        System.out.println(end);
      }
    }catch(Exception e){
      e.printStackTrace();
    }

  }
}
