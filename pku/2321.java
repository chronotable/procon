import java.util.*;
import static java.lang.Math.*;

public class Main{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    String f = sc.nextLine();
    String[] fn = f.split(" ");
    int n = fn.length;
    int[][] card = new int[n][n];
    for(int i = 0; i < n;i++)card[0][i] = Integer.parseInt(fn[i]);
    for(int i = 1;i < n;i++)
      for(int j = 0; j < n;j++)card[i][j] = sc.nextInt();
    int[] csum = new int[n];
    for(int i = 0; i < n;i++)
      for(int j = 0; j < n;j++)csum[i] += card[i][j];
    double[][] tbl = new double[10][n];
    tbl[0][0] = 1.0;
    for(int i = 1; i < 10;i++){
      for(int j = 0; j < n;j++){
        for(int k = 0; k < n;k++){
          tbl[i][j] += tbl[i-1][k] * card[k][j] / csum[k];
        }
      }
    }
    for(int i = 0; i < 10;i++){
      for(int j = 0; j < n;j++){
        System.out.printf("%.5f", tbl[i][j]);
        if(j!=n-1)System.out.print(" ");
      }
      System.out.println();
    }
  }
}

