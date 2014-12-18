import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }
    void run(){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        Block[] b = new Block[k];
        boolean[] dp = new boolean[40100];
        dp[0] = true;
        for(int i = 0; i < k;i++)
            b[i] = new Block(sc.nextInt(),sc.nextInt(),sc.nextInt());
        Arrays.sort(b);
        for(int i = 0; i < k;i++){
            for(int j = b[i].a; j >= 0;j--){
                if(dp[j]){
                    int p = (b[i].a - j) / b[i].h;
                    if(p > b[i].c)p = b[i].c;
                    for(int x = 1; x <= p;x++)
                        dp[j + x * b[i].h] = true;
                }
            }
        }
        int mx = 0;
        for(int i = dp.length-1;i >= 0;i--)
            if(dp[i]){
                mx = i;
                break;
            }
        System.out.println(mx);
    }

    class Block implements Comparable<Block>{
        int h,a,c;
        Block(int height, int altitude, int quantity){
            h = height;
            a = altitude;
            c = quantity;
        }
        public int compareTo(Block b){
            if(this.a != b.a)return this.a - b.a;
            if(this.h != b.h)return b.h - this.h;
            return this.c - b.c;
        }
    }
}
