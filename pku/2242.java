import static java.lang.Math.*;
import java.util.*;

public class Main{

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    while(sc.hasNext()){
      Point p1 = new Point(sc.nextDouble(),sc.nextDouble());
      Point p2 = new Point(sc.nextDouble(),sc.nextDouble());
      Point p3 = new Point(sc.nextDouble(),sc.nextDouble());
      System.out.printf("%.2f\n",2*cradius(p1.dis(p2),p2.dis(p3),p3.dis(p1))*PI);
    }
  }
  static double cradius(double a,double b,double c){
    double s = (a+b+c)/2;
    return a*b*c/(sqrt(s*(s-a)*(s-b)*(s-c))*4);
  }
  static class Point{
    double x,y;
    Point(double a,double b){
      x=a;
      y=b;
    }
    double dis(Point p){
      return hypot(x-p.x,y-p.y);
    }
  }

}

