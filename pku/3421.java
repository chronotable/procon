import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }
    void run(){
        Scanner sc = new Scanner(System.in);
        boolean[] isp = new boolean[10000];
        for(int i = 2; i < isp.length;i++){
            if(!isp[i])
                for(int j = i * 2; j < isp.length; j += i)
                    isp[j] = true;
        }
        long[][] comb = new long[21][21];
        comb[0][0] = 1l;
        for (int i = 1; i < 21; i++) {
            comb[i][0] = 1l;
            for (int j = 1; j < 21; j++) {
                comb[i][j] = comb[i - 1][j - 1] + comb[i - 1][j];
            }
        }
        for(;sc.hasNext();){
            int n = sc.nextInt();
            int anslen = 0;
            ArrayList<Integer> ar = new ArrayList<Integer>();
            for(int i = 2; i < isp.length; i++){
                if(isp[i])continue;
                int sum = 0;
                while(n % i == 0){
                    n /= i;
                    sum++;
                }
                if(sum == 0)continue;
                anslen += sum;
                ar.add(sum);
            }
            if(n != 1){
                anslen++;
                ar.add(1);
            }
            int total = anslen;
            long num = 1l;
            for(int i = 0; i < ar.size(); i++){
                int v = ar.get(i);
                num *= comb[total][v];
                total -= v;
            }
            System.out.println(anslen + " " + num);
        }
    }
}
