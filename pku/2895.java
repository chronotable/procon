import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        int o = Integer.parseInt(sc.nextLine());
        final int[] pos = new int[]{
            2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9,9
        };
        final int[] push = new int[]{
            1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,4,1,2,3,1,2,3,4
        };
        for(;o>0;o--){
            String[] pw = sc.nextLine().split(" ");
            int p = Integer.parseInt(pw[0]);
            int w = Integer.parseInt(pw[1]);
            String sen = sc.nextLine();
            int ans = 0;
            for(int i = 0; i < sen.length()-1; i++){
                char c = sen.charAt(i);
                if(c == ' '){
                    ans += p;
                    continue;
                }
                int ind = c - 'A';
                char nxt = sen.charAt(i+1);
                if(nxt == ' ' || pos[ind] != pos[nxt-'A']){
                    ans += push[ind] * p;
                }else{
                    ans += push[ind] * p;
                    ans += w;
                }
            }
            char lst = sen.charAt(sen.length()-1);
            if(lst == ' ')ans += p;
            else ans += push[lst-'A'] * p;
            System.out.println(ans);
        }
    }
}
