import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> dic = new ArrayList<String>();
        for(;;){
            String s = sc.next();
            if(s.equals("#"))break;
            dic.add(s);
        }
        for(;;){
            String s = sc.next();
            if(s.equals("#"))break;
            ArrayList<String> cand = new ArrayList<String>();
            boolean match = false;
            for(int i = 0; i < dic.size(); i++){
                String w = dic.get(i);
                if(s.equals(w)){
                    match = true;
                    break;
                }
                if(lack1char(s,w) || lack1char(w,s) ||
                   mis1char(s,w)){
                    cand.add(w);
                }
            }
            if(match){
                System.out.println(s + " is correct");
            }else{
                System.out.print(s + ":");
                for(int i = 0; i < cand.size(); i++)
                    System.out.print(" " + cand.get(i));
                System.out.println();
            }
        }
    }

    boolean lack1char(String a, String b){
        if(a.length() != b.length()-1)return false;
        boolean skip = false;
        int bi = 0;
        for(int i = 0; i < a.length(); i++){
            char ac = a.charAt(i);
            if(ac != b.charAt(bi)){
                if(skip)return false;
                else if(b.charAt(++bi) != ac)
                    return false;
                skip = true;
            }
            bi++;
        }
        return true;
    }

    boolean mis1char(String a, String b){
        if(a.length() != b.length())return false;
        int count = 0;
        for(int i = 0; i < a.length(); i++)
            if(a.charAt(i) != b.charAt(i))count++;
        return count == 1;
    }

    /*
    int lcs(String a, String b){
        int h = a.length();
        int w = b.length();
        int[][] dp = new int[h+1][w+1];
        for(int i = 1; i <= h; i++){
            for(int j = 1; j <= w; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = max(dp[i-1][j-1] + 1,
                                   max(dp[i-1][j], dp[i][j-1]));
                }else{
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[h][w];
    }
    */
}