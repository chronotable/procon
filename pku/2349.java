import java.util.*;
import static java.lang.Math.*;

public class Main{
  public static void main(String[] args){
    new Main().run();
  }
  
  void run(){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for(;n > 0;n--){
      int s = sc.nextInt();
      int p = sc.nextInt();
      int[] x = new int[p];
      int[] y = new int[p];
      for(int i = 0; i < p; i++){
        x[i] = sc.nextInt();
        y[i] = sc.nextInt();
      }
      ArrayList<E> ar = new ArrayList<E>();
      for(int i = 0; i < p; i++){
        for(int j = i+1; j < p; j++){
          ar.add(new E(i, j, hypot(x[i] - x[j], y[i] - y[j])));
        }
      }
      Collections.sort(ar);
      int[] par = new int[p];
      for(int i =0 ; i < p; i++)par[i] = i;
      int rest = p;
      for(int i = 0; i < ar.size(); i++){
        E e = ar.get(i);
        if(root(par, e.s) == root(par, e.e))continue;
        merge(par, root(par, e.s), root(par, e.e));
        rest--;
        if(rest == s){
          System.out.printf("%.2f\n", e.dis);
          break;
        }
      }
    }
  }
  
  static int root(int[] par, int a){
    if(par[a] == a)return a;
    return par[a] = root(par, par[a]);
  }
  
  static void merge(int[] par, int a, int b){
    par[root(par, b)] = root(par, a);
  }
  
  class E implements Comparable<E>{
    int s,e;
    double dis;
    E(int a, int b, double c){
      s = a;
      e = b;
      dis = c;
    }
    public int compareTo(E e){
      return Double.compare(this.dis, e.dis);
    }
  }
}

