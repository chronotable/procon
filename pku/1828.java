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
            if(n==0)break;
            Point[] ps = new Point[n];
            for(int i = 0; i < n;i++){
                ps[i] = new Point(sc.nextInt(), sc.nextInt());
            }
            Arrays.sort(ps);
            int ans = 0;
            long ymx = Long.MIN_VALUE;
            for(int i = n-1;i >= 0;i--){
                if(1l * ps[i].y > ymx){
                    ans++;
                    ymx = 1l * ps[i].y;
                }
            }
            System.out.println(ans);
        }
    }

    class Point implements Comparable<Point>{
        int x, y;
        Point(int a, int b){
            x = a;
            y = b;
        }
        public int compareTo(Point p){
            if(this.x != p.x)return this.x - p.x;
            return this.y - p.y;
        }
    }
}
