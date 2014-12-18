import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }
    void run(){
        Scanner sc = new Scanner(System.in);
        int o = sc.nextInt();
        for(;o>0;o--){
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[] ans = new int[n];
            for(int i = 0; i < n; i++)ans[i] = sc.nextInt();
            Arrays.sort(ans);
            for(int i = 1; i < m; i++){
                int[] s = new int[n];
                for(int j = 0; j < n; j++)s[j] = sc.nextInt();
                Arrays.sort(s);
                int[] tmp = new int[n];
                for(int j = 0; j < n; j++)tmp[j] = ans[j] + s[0];
                for(int j = 1; j < n; j++){
                    int ind1 = 0;
                    int ind2 = 0;
                    int[] tmp2 = new int[n];
                    for(int k = 0; k < n; k++){
                        int v1 = tmp[ind1], v2 = ans[ind2] + s[j];
                        if(v1 <= v2){
                            tmp2[k] = v1;
                            ind1++;
                        }else{
                            tmp2[k] = v2;
                            ind2++;
                        }
                    }
                    tmp = tmp2;
                    if(ind2==0)break;
                }
                ans = tmp;
            }
            System.out.print(ans[0]);
            for(int i = 1; i < n; i++)System.out.print(" " + ans[i]);
            System.out.println();
        }
    }
}
