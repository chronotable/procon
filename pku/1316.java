import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        boolean[] u = new boolean[10000];
        for(int i = 1; i < u.length;i++){
            if(!u[i]){
                int v = d(i);
                while(v < u.length){
                    u[v] = true;
                    v = d(v);
                }
            }
        }
        for(int i = 1; i < u.length;i++)if(!u[i])System.out.println(i);
    }
    static int d(int n){
        int m = n;
        int sum = 0;
        while(m>0){
            sum += m % 10;
            m /= 10;
        }
        return n + sum;
    }
}
