import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        int[] h = new int[n];
        for(int i = 0; i < n;i++)h[i] = sc.nextInt();
        Arrays.sort(h);
        int sum = 0;
        int cur = n-1;
        for(;cur >= 0;cur--){
            sum += h[cur];
            if(sum >= b){
                System.out.println(n-cur);
                break;
            }
        }
    }
}