import java.util.*;
import static java.lang.Math.*;

public class ColorfulCards{
    int N;
    int m;
    boolean[] p;
    int[] assign(String colors, boolean left2right){
        int[] ret = new int[m];
        boolean enough = true;
        // left to right
        if(left2right){
            for(int i = 1; i <= N; i++)for(int j = 0; j < 1; j++)if(p[i] == (colors.charAt(j) == 'R')){
                        ret[j] = i++;
                        for(j++; j < m; j++){
                            while(i <= N && p[i] != (colors.charAt(j) == 'R'))i++;
                            if(i > N){enough = false; break;}
                            ret[j] = i++;
                        }
                        i = N;
                    }
        }else{
            for(int i = N; i >= 1; i--)for(int j = 0; j < 1; j++)if(p[i] == (colors.charAt(j) == 'R')){
                        ret[j] = i--;
                        for(j++; j < m; j++){
                            while(i >= 1 && p[i] != (colors.charAt(j) == 'R'))i--;
                            if(i == 0){enough = false; break;}
                            ret[j] = i--;
                        }
                        i = 0;
                    }
        }
        if(!enough)Arrays.fill(ret, -1);
        //for(int i = 0; i < m; i++)System.out.print(ret[i] + " ");System.out.println("");
        return ret;
    }
  
    public int[] theCards(int _N, String colors){
        N = _N;
        m = colors.length();
        p = new boolean[N+1];
        Arrays.fill(p, true);
        p[1] = false;
        for(int i = 2; i <= N; i++)if(p[i])for(int j = i+i; j <= N; j += i)p[j] = false;
        int[] l2r = assign(colors, true);
        int[] r2l = assign(new StringBuilder(colors).reverse().toString(), false);
        int[] ret = new int[m];
        for(int i = 0; i < m; i++)ret[i] = l2r[i] == r2l[m-1-i] ? l2r[i] : -1;
        return ret;
    }
}
