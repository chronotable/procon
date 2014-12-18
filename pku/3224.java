import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int mx = 0;
        int ans = -1;
        int n = sc.nextInt();
        for(int i = 1; i<=n;i++){
            int sum = 0;
            for(int j =0; j < n;j++){
                int v = sc.nextInt();
                if(v==3)sum++;
            }
            if(sum > mx){mx = sum; ans = i;}
        }
        System.out.println(ans);
    }
}
