import java.util.*;
import static java.lang.Math.*;

public class HexagonPuzzle{

    private int root(int[] a, int n){
        if(a[n] != n)a[n] = root(a, a[n]);
        return a[n];
    }
  
    private void merge(int[] a, int s, int t){
        a[root(a, t)] = root(a, s);
    }

    public int theCount(String[] board){
        final long MOD = 1000000007;
        int n = board.length;
        char[][] b = new char[n][];
        for(int i = 0; i < n; i++)b[i] = board[i].toCharArray();
        int[][] ind = new int[n][];
        int count = 0;
        for(int i = 0; i < n; i++){
            ind[i] = new int[b[i].length];
            for(int j = 0; j < ind[i].length; j++)ind[i][j] = count++;
        }
        long[] fact = new long[3000];
        fact[2] = 1;
        for(int i = 3; i < fact.length; i++)fact[i] = (fact[i-1] * i) % MOD;
        int[] root = new int[3000];
        for(int i = 0; i < root.length; i++)root[i] = i;
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j <= i; j++){
                if(b[i][j] == '.' && b[i+1][j] == '.' && b[i+1][j+1] == '.'){
                    merge(root, ind[i][j], ind[i+1][j]); merge(root, ind[i][j], ind[i+1][j+1]);
                }
            }
        }
        for(int i = n-1; i > 0; i--){
            for(int j = 1; j < i; j++){
                if(b[i-1][j-1] == '.' && b[i-1][j] == '.' && b[i][j] == '.'){
                    merge(root, ind[i-1][j-1], ind[i-1][j]); merge(root, ind[i-1][j-1], ind[i][j]);
                }
            }
        }
        int[] freq = new int[root.length];
        for(int i = 0; i < freq.length; i++)freq[root(root, i)]++;
        long ans = 1;
        for(int i = 0; i < freq.length; i++)if(freq[i] >= 3)ans = (ans * fact[freq[i]]) % MOD;
        return (int)ans;
    }
}