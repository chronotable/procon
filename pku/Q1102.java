import java.util.*;
import static java.lang.Math.*;

public class Q1102{
    public static void main(String[] args){
        new Q1102().run();
    }

    String[][] digit = new String[][]{
        {
            " - ",
            "| |",
            "   ",
            "| |",
            " - ",
        },
        {
            "   ",
            "  |",
            "   ",
            "  |",
            "   ",
        },
        {
            " - ",
            "  |",
            " - ",
            "|  ",
            " - ",
        },
        {
            " - ",
            "  |",
            " - ",
            "  |",
            " - ",
        },
        {
            "   ",
            "| |",
            " - ",
            "  |",
            "   ",
        },
        {
            " - ",
            "|  ",
            " - ",
            "  |",
            " - ",
        },
        {
            " - ",
            "|  ",
            " - ",
            "| |",
            " - ",
        },
        {
            " - ",
            "  |",
            "   ",
            "  |",
            "   ",
        },
        {
            " - ",
            "| |",
            " - ",
            "| |",
            " - ",
        },
        {
            " - ",
            "| |",
            " - ",
            "  |",
            " - ",
        },
    };

    String[] tos(int s, int n){
        int w = s + 2;
        int h = 1 + s + 1 + s + 1;
        char[][] c = new char[h][w];
        for(int i = 0; i < h; i++){
            int y;
            if(i == 0)y = 0;
            else if(i < 1 + s)y = 1;
            else if(i == 1 + s)y = 2;
            else if(i < 2+s+s)y = 3;
            else y = 4;
            for(int j = 0; j < w; j++){
                int x;
                if(j == 0)x = 0;
                else if(j < s+1)x = 1;
                else x = 2;
                c[i][j] = digit[n][y].charAt(x);
            }
        }
        String[] ret = new String[h];
        for(int i = 0; i < h; i++)
            ret[i] = new String(c[i]);
        return ret;
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        for(;;){
            int s = sc.nextInt();
            int n = sc.nextInt();
            if(s+n==0)break;
            String[] ans = null;
            String m = "" + n;
            for(int i = 0; i < m.length(); i++){
                String[] ss = tos(s, m.charAt(i) - '0');
                if(ans == null){
                    ans = ss;
                }else{
                    for(int j = 0; j < ans.length; j++)
                        ans[j] += " " + ss[j];
                }
            }
            for(int i = 0; i < ans.length; i++){
                String a = ans[i];
                int ind;
                if((ind = a.lastIndexOf('-')) >= 0){
                    if(ind != a.length()-1)
                        a = a.substring(0, ind+2);
                }else if((ind = a.lastIndexOf('|')) >= 0){
                    if(ind != a.length()-1)
                        a = a.substring(0, ind+2);
                }
                System.out.println(a);
            }
            System.out.println();
        }
    }
}
