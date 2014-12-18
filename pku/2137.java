import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }
    void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<C>[] ec = new ArrayList[n];
        for(int i = 0; i < n; i++){
            ec[i] = new ArrayList<C>();
            int s = sc.nextInt();
            for(int j = 0; j < s; j++){
                C c = new C(sc.nextInt(), sc.nextInt());
                ec[i].add(c);
            }
        }
        double ans = 1e30;
        for(int start = 0; start < ec[0].size(); start++){
            double[][] memo = new double[n][41];
            for(int i = 0; i < n; i++)Arrays.fill(memo[i], 1e30);
            memo[0][start] = 0;
            for(int i = 1; i < n; i++){
                for(int j = 0; j < ec[i].size(); j++){
                    C cur = ec[i].get(j);
                    for(int k = 0; k < ec[i-1].size(); k++){
                        C prev = ec[i-1].get(k);
                        memo[i][j] = min(memo[i][j],
                                         memo[i-1][k] + cur.dis(prev));
                    }
                }
            }
            double mn = 1e40;
            C cur = ec[0].get(start);
            for(int k = 0; k < ec[n-1].size(); k++){
                C prev = ec[n-1].get(k);
                ans = min(ans, memo[n-1][k] + cur.dis(prev));
            }
            ans = min(ans, mn);
        }
        System.out.printf("%d\n", (int)(ans*100));
    }
}

class C{
    int x,y;
    C(int a, int b){
        x = a;
        y = b;
    }
    double dis(C c){
        return hypot(x - c.x, y - c.y);
    }
}
