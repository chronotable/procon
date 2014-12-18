import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String args[]){
        new Main().run();
    }
    void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Interval[] tbl = new Interval[n];
        for(int i = 0; i < n;i++){
            tbl[i] = new Interval(sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(tbl);
        for(int i = 0; i < n;){
            int start = tbl[i].s;
            int end = tbl[i++].e;
            while(i<n && tbl[i].s <= end){
                if(tbl[i].e > end)end = tbl[i].e;
                i++;
            }
            System.out.println(start + " " + end);
        }
    }

    static class Interval implements Comparable<Interval>{
        int s, e;
        Interval(int a, int b){
            s = a;
            e = b;
        }
        public int compareTo(Interval i){
            return this.s - i.s;
        }
    }
}
