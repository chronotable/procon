import java.util.*;

public class Main {

  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    int treeNum;
    int w,h;
    int[][] trees;
    int s,t;
    int max;
    while((treeNum = scan.nextInt()) != 0) {
      max = -1;
      w = scan.nextInt();
      h = scan.nextInt();
      trees = new int[treeNum][2];
      for(int i = 0;i < treeNum;i++) {
        trees[i][0] = scan.nextInt() - 1;
        trees[i][1] = scan.nextInt() - 1;
      }
      s = scan.nextInt();
      t = scan.nextInt();
      for(int i = 0;i < w - s + 1;i++) {
        for(int j = 0;j < h - t + 1;j++) {
          int sum = 0;
          for(int n = 0;n < treeNum;n++) {
            if(i <= trees[n][0] && i + s > trees[n][0] &&
               j <= trees[n][1] && j + t > trees[n][1]) {
              sum++;
            }
          }
          if(sum > max) max = sum;
        }
      }
      System.out.println(max);
    }
  }

}

