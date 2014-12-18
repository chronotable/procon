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
            int d = sc.nextInt();
            if(n+d == 0)break;
            int[] a = new int[n];
            for(int i = 0; i < d; i++)
                for(int j = 0; j < n; j++){
                    int v = sc.nextInt();
                    if(v!=0)a[j]++;
                }
            boolean f = false;
            for(int i = 0; i < n; i++)
                if(a[i] == d){
                    f = true;
                    break;
                }
            System.out.println(f ? "yes" : "no");
        }
    }
}
