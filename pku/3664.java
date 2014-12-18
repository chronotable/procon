import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String args[]){
        new Main().run();
    }
    void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Info[] tbl = new Info[n];
        for(int i = 0; i < n;i++)
            tbl[i] = new Info(i,sc.nextInt(), sc.nextInt());
        Arrays.sort(tbl);
        int mx = 0;
        int ans = -1;
        //for(int i = 0 ; i < n; i++)System.out.println(tbl[i]);
        for(int i = 0; i < k;i++){
            if(tbl[i].b > mx){
                mx = tbl[i].b;
                ans = tbl[i].ind + 1;
            }
        }
        System.out.println(ans);
    }

    class Info implements Comparable<Info>{
        int ind,a,b;
        Info(int i, int va, int vb){
            ind = i;
            a = va;
            b = vb;
        }
        public int compareTo(Info i){
            return i.a - this.a;
        }
        public String toString(){
            return "id = " + ind + " : a = " + a + " : b = " + b;
        }
    }
}
