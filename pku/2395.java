import java.util.*;

public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    long[][] con = new long[n+1][n+1];
    for(int i = 0; i < n + 1;i++)
      for(int j = 0; j < n + 1;j++)
        con[i][j] = Long.MAX_VALUE / 2l;
    for(int i = 0; i < m;i++){
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();
      if(con[a][b] < c)continue;
      con[a][b] = con[b][a] = (long)c;
    }
    long ans = 0;
    for(;;){
      long min = Long.MAX_VALUE;
      int p = -1;
      for(int i = 2; i <= n;i++){
        if(min>con[1][i]){
          min = con[1][i];
          p = i;
        }
      }
      if(min==Long.MAX_VALUE)break;
      if(min > ans) ans=min;
      for(int i = 2;i <= n;i++){
        if(con[1][i] == Long.MAX_VALUE)continue;
        if(con[1][i] > con[p][i])con[1][i] = con[p][i];
      }
      con[1][p] = Long.MAX_VALUE;
    }
    System.out.println(ans);
  }
}


