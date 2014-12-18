import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    void run(){
        //System.out.println(countZero(100));
        Scanner sc = new Scanner(System.in);
        for(;;){
            long m = sc.nextLong();
            long n = sc.nextLong();
            if(n+m==-2)break;
            System.out.println(getCountZero(n)-getCountZero(m-1));
        }
    }

    long getCountZero(long n){
        if(n <= 0)return n;
        long ret = 0;
        ret += 10l* getCountZero(n/10);
        ret += n / 10;
        long m = n / 10 * 10 + 9;
        while(m > n){
            ret -= countZero(m--);
        }
        return ret;
    }

    long countZero(long v){
        long ret = 0;
        while(v > 0){
            if(v % 10 == 0)ret++;
            v /= 10;
        }
        return ret;
    }

}
