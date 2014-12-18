import java.util.*;
import static java.lang.Math.*;

public class Main{
  public static void main(String[] args){
    new Main().run();
  }
  
  void run(){
    Scanner sc = new Scanner(System.in);
    for(; sc.hasNext();){
      C c1 = new C(new P(sc.nextDouble(), sc.nextDouble()), sc.nextDouble());
      C c2 = new C(new P(sc.nextDouble(), sc.nextDouble()), sc.nextDouble());
      System.out.printf("%.3f\n", c1.calcDupArea(c2));
    }
  }
  
  class C{
    static final double EPS = 1e-9;
    P p;
    double r;
    C(P a, double b){
      p = a;
      r = b;
    }
    public double calcDupArea(C c){
      double d = this.p.dis(c.p);
      if(this.r + c.r < d + EPS){
        return 0;
      }else if(d < abs(this.r - c.r) + EPS){
        double r = min(this.r, c.r);
        return r*r*PI;
      }else{
        double rc = (d*d + this.r * this.r - c.r*c.r) / (2*d);
        double theta = acos(rc / this.r);
        double phi = acos((d-rc) / c.r);
        //System.out.printf("rc = %2.f, theta = %.2f, phi = %.2f\n", rc, theta, phi);
        return this.r * this.r * theta + c.r*c.r*phi - d*this.r*sin(theta);
      }
    }
    
    double areaCC(P c1, double r1, P c2, double r2) {
      double d = c1.dis(c2);
      if (r1 + r2 < d + EPS) return 0;
      if (d < abs(r1 - r2) + EPS) {
        double r = min(r1, r2);
        return r * r * PI;
      }
      double x = (d * d + r1 * r1 - r2 * r2) / (2 * d);
      double t1 = acos(x / r1);
      double t2 = acos((d - x) / r2);
      return r1 * r1 * t1 + r2 * r2 * t2 - d * r1 * sin(t1);
    }
    
  }
  
  class P{
    double x, y;
    P(double a, double b){
      x = a;
      y = b;
    }
    public double dis(P p){
      return hypot(this.x - p.x, this.y - p.y);
    }
  }
}
