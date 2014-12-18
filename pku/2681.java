import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for(int o = 1; o <= n;o++){
            String a = sc.nextLine();
            String b = sc.nextLine();
            int[] ac = new int[26];
            int[] bc = new int[26];
            for(int i = 0; i < a.length(); i++)
                ac[a.charAt(i) - 'a']++;
            for(int i = 0; i < b.length(); i++)
                bc[b.charAt(i) - 'a']++;
            int ans = 0;
            for(int i = 0; i < ac.length; i++){
                int mn = min(ac[i], bc[i]);
                ans += ac[i] - mn + bc[i] - mn;
            }
            System.out.printf("Case #%d:  %d\n", o, ans);
        }
    }
}