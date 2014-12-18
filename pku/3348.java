import java.util.*;
import static java.lang.Math.*;

public class Main{

    public static void main(String[] args){
        new Main().run();
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Point[] points = new Point[n];
        for(int i = 0; i < n; i++)
            points[i] = new Point(sc.nextInt(), sc.nextInt());
        Point[] chp = convexHull(points);
        int area = (int)floor(convexArea(chp));
        System.out.println(area/50);
    }

    class Point implements Comparable<Point> {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        Point sub(Point p) {
            return new Point(x - p.x, y - p.y);
        }
        int dot(Point p) {
            return x * p.x + y * p.y;
        }
        int det(Point p) {
            return x * p.y - y * p.x;
        }
        double abs() {
            return hypot(x, y);
        }
        public int compareTo(Point o) {
            if (x != o.x) return x - o.x;
            return y - o.y;
        }
    }

    Point[] convexHull(Point[] ps) {
        int n = ps.length, k = 0;
        Arrays.sort(ps);
        Point[] qs = new Point[n * 2];
        for (int i = 0; i < n; qs[k++] = ps[i++]) {
            while (k > 1 && qs[k - 1].sub(qs[k - 2]).det(ps[i].sub(qs[k - 1])) <= 0) k--;
        }

        for (int i = n - 2, t = k; i >= 0; qs[k++] = ps[i--]) {
            while (k > t && qs[k - 1].sub(qs[k - 2]).det(ps[i].sub(qs[k - 1])) <= 0) k--;
        }

        Point[] res = new Point[k - 1];
        System.arraycopy(qs, 0, res, 0, k - 1);
        return res;
    }

    double convexDiameter(Point[] pt){
        int n = pt.length;
        int is = 0, js = 0;
        for(int i = 1; i < n;i++){
            if(pt[i].y > pt[is].y)is = i;
            if(pt[i].y < pt[js].y)js = i;
        }
        double maxd = pt[is].sub(pt[js]).abs();
        int i, maxi, j, maxj;
        i = maxi = is;
        j = maxj = js;
        do{
            if(pt[(i+1)%n].sub(pt[i]).det(pt[(j+1)%n].sub(pt[j])) >= 0)j = (j+1) % n;
            else i = (i+1) % n;
            double dis = pt[i].sub(pt[j]).abs();
            if(dis > maxd){
                maxd = dis;
                maxi = i; maxj = j;
            }
        }while(i != is || j != js);
        return maxd;
    }

    double convexArea(Point[] pt){
        double ret = 0.0;
        for(int i = 0; i < pt.length; i++)
            ret += pt[i].det(pt[(i+1) % pt.length]);
        return ret / 2.0;
    }

}
