import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] ans = new int[14];
        for(int i = 1; i< 14;i++){
            for(int j = 1; ; j++){
                boolean f = true;
                int pos = 0;
                for(int k = 0; k < i;k++){
                    pos = (pos + j - 1) % (i * 2 - k);
                    if(pos < i){
                        f = false;
                        break;
                    }
                }
                if(f){ans[i] = j;break;}
            }
        }
        for(;;){
            int n = sc.nextInt();
            if(n==0)break;
            System.out.println(ans[n]);
        }
    }
}