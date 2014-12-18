import java.util.*;
import static java.lang.Math.*;

public class Main{
  public static void main(String[] args){
    new Main().run();
  }
  
  void run(){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] data = new int[n];
    for(int i = 0; i < n; i++)data[i] = sc.nextInt();
    int[] use = new int[n];
    Arrays.fill(use, -1);
    int sum = 0;
    int start = -1, end = -1;
    for(int i = 0; i < n; i++){
      sum = (sum + data[i]) % n;
      if(sum == 0){
        start = 0;
        end = i;
        break;
      }
      if(use[sum] >= 0){
        start = use[sum] + 1;
        end = i;
        break;
      }
      use[sum] = i;
    }
    if(start < 0){
      System.out.println(0);
    }else{
      System.out.println(end - start + 1);
      for(int i = start; i <= end; i++)
        System.out.println(data[i]);
    }
  }
}
