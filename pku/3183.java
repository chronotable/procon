
import java.util.*;

public class Main{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n+2];
    a[0]=a[n+1]=-1;
    for(int i = 1; i<= n;i++)a[i]=sc.nextInt();
    ArrayList<Integer> ans = new ArrayList<Integer>();
    for(int i = 1; i <= n;i++){
      if(a[i-1] <= a[i] && a[i]>= a[i+1])ans.add(i);
    }
    for(int i = 0; i < ans.size();i++)System.out.println(ans.get(i));
  }
}

