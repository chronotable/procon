import java.util.*;

public class Main{
  public static void main(String[] args){
    new Main().run();
  }
  
  void run(){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    ArrayList<Integer> ar = new ArrayList<Integer>();
    ar.add(0);
    for(int i = 1; i < n; i++)ar.add(sc.nextInt(), i);
    //for(int i = 0; i < n; i++)System.out.println(ar.get(i));
    int[] ans = new int[n];
    for(int i = 0; i < n; i++)ans[ar.get(i)] = i+1;
    for(int i = 0; i < n; i++)System.out.println(ans[i]);

    /*
    E[] tbl = new E[n];
    tbl[0] = new E(0, 0);
    for(int i = 1; i < n; i++)tbl[i] = new E(sc.nextInt(), i);
    Arrays.sort(tbl);
    int[] ans = new int[n];
    for(int i = 0; i < n; i++)ans[tbl[i].pos] = i+1;
    for(int i = 0; i < n; i++)System.out.println(ans[i]);
    */
  }
  
  class E implements Comparable<E>{
    int v, pos;
    E(int a, int b){
      v = a;
      pos = b;
    }
    public int compareTo(E e){
      if(this.v != e.v)return this.v - e.v;
      return e.pos - this.pos;
    }
  }
}
