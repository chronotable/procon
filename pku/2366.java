import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int[] q = new int[p];
        for(int i = 0; i < p;i++)q[i] = sc.nextInt();
        int x = sc.nextInt();
        boolean yes = false;
        Arrays.sort(q);
        for(int i = 0; i < x;i++){
            int v = 10000-sc.nextInt();
            int l = 0;
            int r = p-1;
            int m = 0;
            while(l<=r){
                m = (l+r)/2;
                if(q[m]>v){
                    r = m - 1;
                }else if(q[m] < v){
                    l = m+1;
                }else{
                    break;
                }
            }
            if(q[m] == v){System.out.println("YES");return;}

        }
        System.out.println("NO");
    }
}
