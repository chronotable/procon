import java.util.*;
import static java.lang.Math.*;

public class Main{
  public static void main(String[] args){
    new Main().run();
  }
  void run(){
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    int n = s.length();
    int[] tot = new int[26];
    Arrays.fill(tot,1);
    int sum = 0;
    for(int i = 1; i < n;i++){
      int[] next = new int[26];
      for(int j = 0; j < 26;j++){
        sum += tot[j];
        for(int k = j + 1;k < 26;k++)next[j] += tot[k];
      }
      tot = next;
    }
    //System.out.println(sum);
    int head = (int)(s.charAt(0)-'a');
    for(int i = 0; i < head;i++)sum += tot[i];
    tra(head,head,1,n,val(s));
    if(ind==-1)System.out.println("0");
    else System.out.println(sum+ind);
  }
  int ind = -1;
  int count = 0;
  void tra(long cur, int tail, int len, int n, long des){
    if(len == n){
      count++;
      if(cur==des)ind = count;
      return;
    }
    for(int i = tail+1;i < 26;i++){
      tra(cur*26l + i, i, len+1, n, des);
    }
  }

  long val(String s){
    long res = 0;
    for(int i = 0; i < s.length();i++){
      int v = (int)(s.charAt(i)-'a');
      res = res * 26l + v;
    }
    return res;
  }
}
