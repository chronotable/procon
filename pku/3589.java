import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(;n>0;n--){
            String s = sc.next();
            String t = sc.next();
            boolean[] u = new boolean[10];
            for(int i = 0; i < t.length(); i++)
                u[t.charAt(i)-'0']=true;
            int a = 0,b = 0;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == t.charAt(i))a++;
                if(u[s.charAt(i) - '0'])b++;
            }
            System.out.printf("%dA%dB\n", a, b-a);
        }
    }
}
