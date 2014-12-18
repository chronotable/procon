import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    void run(){
        //Scanner sc = new Scanner(System.in);
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        try{
            for(;sc.ready();){
                String head = sc.readLine();
                String[] nm = head.split(" ");
                int n = Integer.parseInt(nm[0]);
                int m = Integer.parseInt(nm[1]);
                int[][] g = new int[n][n];
                for(int i = 0; i < m; i++){
                    String line = sc.readLine();
                    String[] par = line.split(" ");
                    int a = Integer.parseInt(par[0]);
                    int b = Integer.parseInt(par[1]);
                    int c = Integer.parseInt(par[2]);
                    g[a][b] += c;
                    g[b][a] += c;
                }
                System.out.println(MinCut.minCut(g));
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}

class MinCut{
    static int minCut(int[][] c){
        int n = c.length;
        int cut = 1<<30;
        int[] id = new int[n], b = new int[n];
        for(int i = 0; i < n; i++)id[i] = i;
        for(; n > 1; n--){
            Arrays.fill(b, 0);
            for(int i = 0; i + 1 < n; i++){
                int p = i+1;
                for(int j = i + 1; j < n; j++){
                    b[id[j]] += c[id[i]][id[j]];
                    if(b[id[p]] < b[id[j]])p = j;
                }
                // swap id[i+1] and id[p];
                int temp = id[i+1];
                id[i+1] = id[p];
                id[p] = temp;
            }
            cut = Math.min(cut, b[id[n-1]]);
            for(int i = 0; i < n-2; i++){
                c[id[i]][id[n-2]] += c[id[i]][id[n-1]];
                c[id[n-2]][id[i]] += c[id[n-1]][id[i]];
            }
        }
        return cut;
    }
}
