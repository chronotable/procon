import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] t = new int[n];
        for(int i = 0; i < n; i++)
            t[i] = sc.nextInt();
        Arrays.sort(t);
        if(n == 1){
            System.out.println(t[0]);
            System.out.println(t[0]);
            return;
        }
        int tail = n-1;
        ArrayList<String> ans = new ArrayList<String>();
        int sum = 0;
        while(tail > 2){
            if(2 * t[1] - t[0] < t[tail-1]){
                sum += t[0] + 2*t[1] + t[tail];
                ans.add(t[0] + " " + t[1]);
                ans.add(t[0] + "");
                ans.add(t[tail-1] + " " + t[tail]);
                ans.add( t[1] + "");
            }else{
                sum += 2*t[0] + t[tail-1] + t[tail];
                ans.add(t[0] + " " + t[tail]);
                ans.add(t[0] + "");
                ans.add(t[0] + " " + t[tail-1]);
                ans.add(t[0] + "");
            }
            tail -=2;
        }
        if(tail == 2){
            sum += t[2] + t[1] + t[0];
            ans.add(t[0] + " " + t[2]);
            ans.add(t[0] + "");
            ans.add(t[0] + " " + t[1]);
        }else{
            sum += t[1];
            ans.add(t[0] + " " + t[1]);
        }
        System.out.println(sum);
        for(String s : ans)
            System.out.println(s);
    }
}
