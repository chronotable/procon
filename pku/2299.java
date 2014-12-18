import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }
    void run(){
        Scanner sc = new Scanner(System.in);
        for(;;){
            int n = sc.nextInt();
            if(n == 0)break;
            int[] s = new int[n];
            for(int i = 0; i < n;i++)s[i] = sc.nextInt();
            System.out.println(calc(s));
        }
    }
    long calc(int[] s){
        if(s.length == 1)return 0;
        int[] la = new int[s.length / 2];
        int[] ra = new int[s.length - s.length/2];
        int i = 0;
        for(int j = 0; j < la.length;j++)la[j] = s[i++];
        for(int j = 0; j < ra.length;j++)ra[j] = s[i++];
        long res = calc(la) + calc(ra);
        int li = 0, ri = 0;
        i = 0;
        while(li < la.length && ri < ra.length){
            if(la[li] <= ra[ri]){
                s[i++] = la[li++];
            }else{
                s[i++] = ra[ri++];
                res += la.length - li;
            }
        }
        while(li < la.length)s[i++] = la[li++];
        while(ri < ra.length)s[i++] = ra[ri++];
        return res;
    }
}
