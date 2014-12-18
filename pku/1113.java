import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args) {
        new Main().run();
    }

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), L = sc.nextInt();
        Point[] ps = new Point[n];
        for (int i = 0; i < n; i++) ps[i] = new Point(sc.nextInt(), sc.nextInt());
        System.out.printf("%.0f%n", 2 * PI * L + calc(convexHull(ps)));
    }

    double calc(Point[] ps) {
        double res = 0;
        int n = ps.length;
        for (int i = 0; i < n; i++) {
            res += ps[i].sub(ps[(i + 1) % n]).abs();
        }
        return res;
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

    static class Point implements Comparable<Point> {
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

}
