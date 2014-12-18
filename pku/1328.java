import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    static final double EPS = 1e-9;

    void run(){
        Scanner sc = new Scanner(System.in);
        for(int o = 1;;o++){
            int n = sc.nextInt();
            int d = sc.nextInt();
            if((n|d)==0)break;
            System.out.printf("Case %d: ", o);
            Range[] tbl = new Range[n];
            boolean imp = false;
            for(int i = 0; i < n;i++){
                double a = sc.nextInt();
                int b = sc.nextInt();
                if(b > d || b < 0){
                    imp = true;
                }
                double dis = sqrt(d*d - b*b);
                tbl[i] = new Range(a - dis,a + dis);
            }
            if(imp){
                System.out.println("-1");
                continue;
            }
            Arrays.sort(tbl);
            int ans = 0;
            for(int i = 0; i < n;){
                ans++;
                double x = tbl[i++].e;
                while(i < n && tbl[i].s < x + EPS)i++;
            }
            System.out.println(ans);
        }
    }

    static class Range implements Comparable<Range>{
        double s,e;
        Range(double a, double b){
            s = a; e = b;
        }
        public int compareTo(Range r){
            return Double.compare(this.e, r.e);
        }
    }
}
