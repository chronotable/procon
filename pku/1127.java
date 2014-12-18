import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args) throws Exception{
        new Main().run();
    }

    int n;
    Line[] ls;
    boolean[][] g;

    void run() throws Exception{
        Scanner sc = new Scanner(System.in);
        //BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        // only sc.readLine() is available

        for(;;){
            n = sc.nextInt();
            if(n == 0)break;
            ls = new Line[n];
            for(int i = 0; i < n; i++)
                ls[i] = new Line(new Point(sc.nextInt(), sc.nextInt()),
                                 new Point(sc.nextInt(), sc.nextInt()));
            g = new boolean[n][n];
            for(int i = 0; i < n; i++){
                g[i][i] = true;
                for(int j = i+1; j < n; j++)
                    if(ls[i].intersectSS(ls[j]))
                        g[i][j] = g[j][i] = true;
            }
            for(int k = 0; k < n; k++)
                for(int i = 0; i < n; i++)
                    for(int j = 0; j < n; j++)
                        g[i][j] |= g[i][k] && g[k][j];
            for(;;){
                int a = sc.nextInt(), b = sc.nextInt();
                if(a+b==0)break;
                System.out.printf("%sCONNECTED\n", !g[a-1][b-1]?"NOT ":"");
            }
        }
    }
}

class Point implements Comparable<Point> {
    double x, y;
    private static final double EPS = 1e-9;
    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    Point add(Point p){
        return new Point(x + p.x, y + p.y);
    }
    Point sub(Point p) {
        return new Point(x - p.x, y - p.y);
    }
    // naiseki
    double dot(Point p) {
        return x * p.x + y * p.y;
    }
    // gaiseki
    double det(Point p) {
        return x * p.y - y * p.x;
    }
    double abs() {
        return hypot(x, y);
    }
    public int compareTo(Point o) {
        if (x != o.x) return x > o.x ? 1 : -1;
        return y > o.y ? 1 : -1;
    }
    // from spaghetti
    public static int ccw(Point a, Point d, Point e){
        Point b = d.sub(a);
        Point c = e.sub(a);
        if(b.det(c) > 0) return 1;  //counter clockwise
        if(b.det(c) < 0) return -1; //clockwise
        if(b.dot(c) < 0) return 2; // e--a--d on line
        if(b.abs() < c.abs()) return -2 ; // a--d--e on line
        return 0;
    }
    public String toString(){
        return String.format("(%.2f, %.2f)", x, y);
    }
}
class Line{
    Point s, e;
    private static final double EPS = 1e-9;
    Line(Point a, Point b){
        s = a;
        e = b;
    }
    /**
     * L -> Line
     * S -> Segment
     * P -> Point
     */
    boolean intersectLL(Line l){
        return abs(this.e.sub(this.s).det(l.e.sub(l.s))) > EPS || //non-para
            abs(this.e.sub(this.s).det(l.s.sub(this.s))) < EPS; //same line
    }
    boolean intersectLS(Line l){
        return this.e.sub(this.s).det(l.s.sub(this.s)) * //l.s is left
            this.e.sub(this.s).det(l.e.sub(this.s)) < EPS;
    }
    boolean intersectLP(Point p){
        return abs(this.e.sub(p).det(this.s.sub(p))) < EPS;
    }
    boolean intersectSS(Line l){
        return Point.ccw(this.s, this.e, l.s) *
            Point.ccw(this.s, this.e, l.e) <= 0 &&
            Point.ccw(l.s, l.e, this.s) *
            Point.ccw(l.s, l.e, this.e) <= 0;
    }
    boolean intersectSP(Point p){
        return this.s.sub(p).abs() + this.e.sub(p).abs() -
            this.e.sub(this.s).abs() < EPS; //triangle inequality
    }
    Point crossPoint(Line l){
        double A = this.e.sub(this.s).det(l.e.sub(l.s));
        double B = this.e.sub(this.s).det(this.e.sub(l.s));
        if(abs(A) < EPS && abs(B) < EPS) return l.s; // same line
        if(abs(A) < EPS){
            // PRECONDITION NOT SATISFIED!
            return null;
        }
        Point tp = l.e.sub(l.s);
        return l.s.add(new Point(tp.x * B / A, tp.y * B / A));
    }
    public String toString(){
        return String.format("[%s - %s]", s.toString(), e.toString());
    }
}
