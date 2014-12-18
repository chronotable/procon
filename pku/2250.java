import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        for(;sc.hasNext();){
        ArrayList<String> former = new ArrayList<String>();
        ArrayList<String> latter = new ArrayList<String>();
        for(former.add("dummy");;){
            String s = sc.next();
            if(s.equals("#"))break;
            former.add(s);
        }
        for(latter.add("dummy");;){
            String s = sc.next();
            if(s.equals("#"))break;
            latter.add(s);
        }
        String[] f = new String[former.size()];
        former.toArray(f);
        String[] l = new String[latter.size()];
        latter.toArray(l);
        int h = f.length - 1;
        int w = l.length - 1;
        int[][] lcs = new int[h+1][w+1];
        int[][] py = new int[h+1][w+1];
        int[][] px = new int[h+1][w+1];
        for(int i = 1; i <= h; i++){
            py[i][0] = i-1;
            px[i][0] = 0;
        }
        for(int i = 1; i<=w; i++){
            py[0][i] = 0;
            px[0][i] = i-1;
        }
        py[0][0] = -1;
        px[0][0] = -1;
        for(int i = 1; i <= h;i++){
            for(int j = 1; j <= w;j++){
                int us = lcs[i-1][j];
                int ls = lcs[i][j-1];
                int ds = -1;
                if(f[i].equals(l[j])){
                    ds = lcs[i-1][j-1]+1;
                }
                int mx = max(us, max(ls, ds));
                lcs[i][j] = mx;
                if(mx == ds){
                    py[i][j] = i-1;
                    px[i][j] = j-1;
                }else if(mx == us){
                    py[i][j] = i-1;
                    px[i][j] = j;
                }else{
                    py[i][j] = i;
                    px[i][j] = j-1;
                }
            }
        }
        int cx = w;
        int cy = h;
        ArrayList<String> aa = new ArrayList<String>();
        while(cx > 0 && cy > 0){
            int nx = px[cy][cx];
            int ny = py[cy][cx];
            if(abs(cx - nx) == 1 && abs(cy - ny) == 1)
                aa.add(f[cy]);
            cx = nx;
            cy = ny;
        }
        Collections.reverse(aa);
        for(int i = 0; i < aa.size() -1; i++)
            System.out.print(aa.get(i) + " ");
        System.out.println(aa.get(aa.size()-1));
        }
    }

    /*
    void run(){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> former = new ArrayList<String>();
        ArrayList<String> latter = new ArrayList<String>();
        for(;;){
            String s = sc.next();
            if(s.equals("#"))break;
            former.add(s);
        }
        for(;;){
            String s = sc.next();
            if(s.equals("#"))break;
            latter.add(s);
        }
        String[] f = new String[former.size()];
        former.toArray(f);
        String[] l = new String[latter.size()];
        latter.toArray(l);
        //System.out.println(f[f.length-1] + " : "  + l[l.length-1]);
        int[] ci = new int[f.length];
        int[] score = new int[f.length];
        int[] prev = new int[f.length];
        boolean[] u = new boolean[l.length];
        for(int i = 0; i < f.length; i++){
            int j = 0;
            for(;j < l.length;j++)if(!u[j] && l[j].equals(f[i]))break;
            ci[i] = j;
            if(j < l.length)u[j] = true;
        }
        int ansmx = 0;
        int ansind = -1;
        for(int i = 0; i < f.length; i++){
            if(ci[i] >= l.length)continue;
            int mx = 0;
            int ind = -1;
            for(int j = 0; j < i; j++){
                if(ci[i] > ci[j] && mx < score[j]){
                    mx = score[j];
                    ind = j;
                }
            }
            prev[i] = ind;
            score[i] = mx + 1;
            if(score[i] > ansmx){
                ansmx = score[i];
                ansind = i;
            }
        }
        ArrayList<String > aa = new ArrayList<String>();
        while(ansind >= 0){
            aa.add(f[ansind]);
            ansind = prev[ansind];
        }
        Collections.reverse(aa);
        for(int i = 0; i < aa.size() - 1; i++)
            System.out.print(aa.get(i) + " ");
        System.out.println(aa.get(aa.size() - 1));
    }
    */
}
