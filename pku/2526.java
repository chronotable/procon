import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String args[]){
        new Main().run();
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        for(int o = sc.nextInt(); o>0;o--){
            int n = sc.nextInt();
            Point[] ps = new Point[n];
            double ax = 0, ay = 0;
            for(int i = 0; i < n; i++){
                ps[i] = new Point(sc.nextDouble(), sc.nextDouble());
                ax += ps[i].x;
                ay += ps[i].y;
            }
            Point cp = new Point(ax / n, ay / n);
            //System.out.println(cp);
            Arrays.sort(ps);
            boolean[] u = new boolean[n];
            boolean f = true;
            for(int i = 0; i < n; i++){
                if(u[i])continue;
                Point opp = cp.add(cp.sub(ps[i]));
                int ind = Arrays.binarySearch(ps, opp);
                if(ind < 0 || u[ind]){
                    f = false;
                    break;
                }
                u[ind] = true;
                u[i] = true;
            }
            System.out.println(f ? "yes" : "no");
        }
    }

    class Point implements Comparable<Point>{
        double x,y;
        static final double EPS = 1e-9;
        Point(double a, double b){
            x = a;
            y = b;
        }
        Point add(Point p){
            return new Point(this.x+p.x, this.y+p.y);
        }
        Point sub(Point p){
            return new Point(this.x - p.x, this.y - p.y);
        }
        public String toString(){
            return String.format("(%.2f, %.2f)", x, y);
        }
        boolean equals(Point p){
            return abs(this.x-p.x) < EPS && abs(this.y-p.y) < EPS;
        }
        public int compareTo(Point p){
            if(this.equals(p))return 0;
            if(this.x < p.x)return -1;
            else if(this.x > p.x)return 1;
            else if(this.y < p.y)return 1;
            else return -1;
        }
    }
}
