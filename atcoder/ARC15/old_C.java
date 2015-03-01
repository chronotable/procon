import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class C{
    public static void main(String[] args) throws Exception{
        new C().run();
    }

    int n;
    String[] large;
    int[] m;
    String[] small;
    HashSet<String> us = new HashSet<String>();
    HashMap<String, String> memo = new HashMap<String, String>();
    final String S = "\t";

    String tra(String s){
        if(memo.containsKey(s))
            return memo.get(s);
        double mx = 1;
        String mxSmall = s;
        for(int i = 0; i < n; i++)
            if(large[i].equals(s)){
                String a = tra(small[i]);
                double val = Double.parseDouble(a.split(S)[0]);
                if(val * m[i] > mx){
                    mx = val * m[i];
                    mxSmall = a.split(S)[1];
                }
            }
        String ans = mx + S + mxSmall;
        memo.put(s, ans);
        return ans;
    }

    void run() throws Exception{
        Scanner sc = new Scanner(System.in);
        //BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        // only sc.readLine() is available
        n = sc.nextInt();
        large = new String[n];
        m = new int[n];
        small = new String[n];
        for(int i = 0; i < n; i++){
            large[i] = sc.next();
            m[i] = sc.nextInt();
            small[i] = sc.next();
            us.add(large[i]); us.add(small[i]);
        }
        ArrayList<String> ua = new ArrayList<String>();
        for(String s : us)ua.add(s);
        boolean[] cand = new boolean[ua.size()];
        Arrays.fill(cand, true);
        for(int i = 0; i < ua.size(); i++)
            for(int j = 0; j < n; j++)
                if(ua.get(i).equals(small[j])){
                    cand[i] = false;
                    break;
                }
        double mx = 0;
        String mxLarge = "hoge";
        String mxSmall = "fuga";
        for(int i = 0; i < ua.size(); i++)
            if(cand[i]){
                String a = tra(ua.get(i));
                String num = a.split(S)[0];
                String name = a.split(S)[1];
                double val = Double.parseDouble(num);
                if(mx < val){
                    mx = val;
                    mxLarge = ua.get(i);
                    mxSmall = name;
                }
            }
        System.out.printf("1%s=%d%s\n", mxLarge, (int)mx, mxSmall);
    }
}
