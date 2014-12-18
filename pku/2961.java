import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    int tra(long n, long x, long y){
        if(n == 1l)return 1;
        long d = n / 2l;
        if(x / d == 1l && y / d == 1l)
            return - tra(d, x % d, y % d);
        else return tra(d, x % d, y % d);
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        int o = sc.nextInt();
        for(; o > 0; o--){
            long n = sc.nextLong();
            long sx = sc.nextLong();
            long sy = sc.nextLong();
            int w = sc.nextInt();
            int h = sc.nextInt();
            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    if(j > 0)System.out.print(" ");
                    System.out.print(tra(n, sx + j, sy + i));
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
