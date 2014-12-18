import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(;n>0;n--){
            int x = sc.nextInt();
            int d = lowbit(x) - 1;
            System.out.printf("%d %d\n",x-d,x+d);
        }
    }

    int lowbit(int n){
        return n & (-n);
    }

}
