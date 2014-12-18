import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for(int o = 1; o <= T; o++){
            int n = Integer.parseInt(sc.nextLine());
            P[] tbl = new P[n+1];
            for(int i = 1; i <= n; i++){
                String line = sc.nextLine();
                tbl[i] = new P(line, line.charAt(0) == 'C');
            }
            boolean[] u = new boolean[n+1];
            System.out.println("STORY " + o);
            String[] ans = tra(tbl, u, 1).split("\t");
            for(String s : ans)
                System.out.println(s);
        }
    }

    String tra(P[] tbl, boolean[] u, int pos){
        if(u[pos])return null;
        u[pos] = true;
        if(!tbl[pos].isC)
            return tbl[pos].isHappy ? tbl[pos].text : null;
        String ret0 = tra(tbl, u, tbl[pos].next0);
        if(ret0 != null)
            return tbl[pos].text + "\t" + ret0;
        String ret1 = tra(tbl, u, tbl[pos].next1);
        if(ret1 != null)
            return tbl[pos].text + "\t" + ret1;
        return null;
    }

}

class P{
    boolean isC;
    String text;
    int next0, next1;
    boolean isHappy;
    P(String s, boolean isc){
        text = s.substring(s.indexOf('\"')+1, s.lastIndexOf('\"'));
        isC = isc;
        String[] parts = s.split(" ");
        if(isC){
            next0 = Integer.parseInt(parts[parts.length-2]);
            next1 = Integer.parseInt(parts[parts.length-1]);
        }else{
            isHappy = parts[parts.length-1].equals("HAPPY");
        }
    }
}
