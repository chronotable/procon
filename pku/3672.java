import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int t = sc.nextInt();
        int ud = sc.nextInt();
        int f = sc.nextInt();
        ud += sc.nextInt();
        int ans;
        int sum=0;
        for(ans=0;ans<t;ans++){
            String s = sc.next();
            if(s.equals("f"))sum+=f*2;
            else sum+=ud;
            if(sum > m){
                System.out.println(ans);
                return;
            }
        }
        System.out.println(t);
    }
}
