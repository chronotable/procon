import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long ans = 0;
        PriorityQueue<Integer> ar = new PriorityQueue<Integer>();
        for(int i = 0; i < n;i++)ar.offer(sc.nextInt());
        while(ar.size() > 1){
            int a = ar.poll();
            int b = ar.poll();
            ans += a + b;
            ar.offer(a+b);
        }
        System.out.println(ans);
    }
}