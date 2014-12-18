import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    String[] dna;
    int ans;
    int n;

    void tra(boolean[] u, int depth, String cur){
        if(depth == n){
            ans = min(ans, cur.length());
            return;
        }
        if(cur.length() >= ans)return;
        for(int i = 0; i < n; i++){
            if(u[i])continue;
            u[i] = true;
            String next = dna[i];
            int len = 1;
            int maxlen = 0;
            for(; len <= next.length() && len <= cur.length(); len++){
                String tail = cur.substring(cur.length()-len);
                String head = next.substring(0, len);
                if(tail.equals(head))maxlen = len;
            }
            len--;
            String cand = next.substring(maxlen);
            tra(u, depth+1, cur+cand);
            u[i] = false;
        }
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(;T > 0; T--){
            n = sc.nextInt();
            //int[] a = new int[n];
            dna = new String[n];
            for(int i = 0; i < n; i++)dna[i] = sc.next();
            //for(int i = 0; i < n; i++)a[i] = i;
            ans = 1<<20;
            boolean[] u = new boolean[n];
            tra(u, 0, "");
            System.out.println(ans);
            /*
            do{
                int sum = dna[a[0]].length();
                String cur = dna[a[0]] + "";
                for(int i = 1; i < n; i++){
                    String next = dna[a[i]];
                    int len = 1;
                    int maxlen = 0;
                    for(; len <= next.length() && len <= cur.length(); len++){
                        String tail = cur.substring(cur.length()-len);
                        String head = next.substring(0, len);
                        if(tail.equals(head))maxlen = len;
                    }
                    len--;
                    String cand = next.substring(maxlen);
                    sum += cand.length();
                    cur += cand;
                }
                ans = min(ans, sum);
            }while(nextPermutation(a));
            System.out.println(ans);
            */
        }
    }

    public static boolean nextPermutation(int[] a) {
        for (int i = a.length - 1; i > 0; --i) {
            if (a[i - 1] < a[i]) {
                int swapIndex = find(a[i - 1], a, i, a.length - 1);
                int temp = a[swapIndex];
                a[swapIndex] = a[i - 1];
                a[i - 1] = temp;
                Arrays.sort(a, i, a.length);
                return true;
            }
        }
        return false;
    }

    private static int find(int dest, int[] a, int s, int e) {
        if (s == e) {
            return s;
        }
        int m = (s + e + 1) / 2;
        return a[m] <= dest ? find(dest, a, s, m - 1) : find(dest, a, m, e);
    }
}
