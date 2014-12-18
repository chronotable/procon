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
      int w = sc.nextInt();
      int h = sc.nextInt();
      if(n+w+h==0)break;
      ArrayList<Cake> ar = new ArrayList<Cake>();
      ar.add(new Cake(w,h));
      for(int i = 0; i < n; i++){
        int p = sc.nextInt();
        int s = sc.nextInt();
        Cake c = ar.get(p-1);
        ar.remove(c);
        s %= c.w + c.h;
        Cake d, e;
        if(s < c.w){
          d = new Cake(s, c.h);
          e = new Cake(c.w - s, c.h);
        }else{
          s -= c.w;
          d = new Cake(c.w, s);
          e = new Cake(c.w, c.h - s);
        }
        if(d.compareTo(e) < 0){
          ar.add(d);
          ar.add(e);
        }else{
          ar.add(e);
          ar.add(d);
        }
      }
      Collections.sort(ar);
      for(int i = 0; i < ar.size(); i++){
        if(i>0)System.out.print(" ");
        System.out.print(ar.get(i));
      }
      System.out.println();
    }
  }
  
  class Cake implements Comparable<Cake>{
    int w, h;
    int area;
    Cake(int w, int h){
      this.w = w;
      this.h = h;
      area = w*h;
    }
    public int compareTo(Cake c){
      return this.area - c.area;
    }
    public String toString(){
      return "" + area;
    }
  }
}
