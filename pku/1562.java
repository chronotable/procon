import java.util.*;

public class Main{
  static int h,w;
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    while(true){
      h=sc.nextInt();
      w=sc.nextInt();
      if(h+w==0)break;
      char[][] f = new char[h][w];
      for(int i = 0;i < h;i++){
        String s = sc.next();
        for(int j=0;j<w;j++)f[i][j]=s.charAt(j);
      }
      boolean[][] u = new boolean[h][w];
      int ans=0;
      for(int i = 0; i < h;i++){
        for(int j = 0; j < w;j++){
          if(f[i][j]=='@'&&!u[i][j]){
            tra(i,j,f,u);
            ans++;
          }
        }
      }
      System.out.println(ans);
    }
  }
  static int[] dy = new int[]{0,1,1,1,0,-1,-1,-1};
  static int[] dx = new int[]{1,1,0,-1,-1,-1,0,1};
  static void tra(int y,int x,char[][] f,boolean[][] u){
    if(u[y][x])return;
    u[y][x]=true;
    for(int k = 0; k < 8;k++){
      int nx = x+dx[k];
      int ny = y+dy[k];
      if(nx >=0&&nx<w&&ny>=0&&ny<h&&f[ny][nx]=='@')tra(ny,nx,f,u);
    }
  }
}

