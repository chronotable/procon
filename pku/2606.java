import java.util.*;

public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] x = new int[n];
    int[] y = new int[n];
    for(int i = 0; i < n;i++){
      x[i]=sc.nextInt();
      y[i]=sc.nextInt();
    }
    int max = 0;
    for(int i = 0; i < n - 1;i++){
      for(int j = i + 1;j < n;j++){
        int a = x[i] - x[j];
        int b = y[i] - y[j];
        int c = 0;
        for(int k = 0; k < n;k++){
          if(a*(y[k]-y[j])==b*(x[k]-x[j]))c++;
        }
        if(c>max)max=c;
      }
    }
    System.out.println(max);
  }
}