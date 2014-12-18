import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for(int o = sc.nextInt();o>0;o--){
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n;i++)a[i] = sc.nextInt();
            Arrays.sort(a);
            System.out.println(2 * (a[n-1]-a[0]));
        }
    }
}
