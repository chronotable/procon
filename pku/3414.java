import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }
    void run(){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int mx = max(a, b);
        LinkedList<Info> q = new LinkedList<Info>();
        String[][] operator = new String[a + 1][b + 1];
        int[][] prev = new int[a + 1][b + 1];
        q.add(new Info(0, 0, "start", 0, 0));
        Info temp;
        while(!q.isEmpty()){
            temp = q.poll();
            if(operator[temp.v1][temp.v2] != null)continue;
            operator[temp.v1][temp.v2] = temp.op;
            prev[temp.v1][temp.v2] = temp.p;
            if(temp.v1 == c || temp.v2 == c){
                int num = temp.n;
                int ca = temp.v1;
                int cb = temp.v2;
                ArrayList<String> ar = new ArrayList<String>();
                while(ca > 0 || cb > 0){
                    ar.add(operator[ca][cb]);
                    int r = prev[ca][cb];
                    ca = r / 1000;
                    cb = r % 1000;
                }
                Collections.reverse(ar);
                System.out.println(num);
                for(int i = 0; i < ar.size(); i++)
                    System.out.println(ar.get(i));
                return;
            }
            Info next;
            //FILL(1)
            if(operator[a][temp.v2] == null){
                next = new Info(a, temp.v2, "FILL(1)", temp.v1 * 1000 + temp.v2, temp.n + 1);
                q.offer(next);
            }
            //FILL(2)
            if(operator[temp.v1][b] == null){
                next = new Info(temp.v1, b, "FILL(2)", temp.v1 * 1000 + temp.v2, temp.n + 1);
                q.offer(next);
            }
            //DROP(1)
            if(operator[0][temp.v2] == null){
                next = new Info(0, temp.v2, "DROP(1)", temp.v1 * 1000 + temp.v2, temp.n + 1);
                q.offer(next);
            }
            //DROP(2)
            if(operator[temp.v1][0] == null){
                next = new Info(temp.v1, 0, "DROP(2)", temp.v1 * 1000 + temp.v2, temp.n + 1);
                q.offer(next);
            }
            //POUR(1,2)
            int flow12 = min(temp.v1, b - temp.v2);
            if(operator[temp.v1 - flow12][temp.v2 + flow12] == null){
                next = new Info(temp.v1 - flow12, temp.v2 + flow12, "POUR(1,2)", temp.v1 * 1000 + temp.v2, temp.n + 1);
                q.offer(next);
            }
            //POUR(2,1);
            int flow21 = min(a - temp.v1, temp.v2);
            if(operator[temp.v1 + flow21][temp.v2 - flow21] == null){
                next = new Info(temp.v1 + flow21, temp.v2 - flow21, "POUR(2,1)", temp.v1 * 1000 + temp.v2, temp.n + 1);
                q.offer(next);
            }
        }
        System.out.println("impossible");
    }

    class Info{
        int v1,v2;
        String op;
        int p;
        int n;
        Info(int a, int b, String c, int d, int e){
            v1 = a;
            v2 = b;
            op = c;
            p = d;
            n = e;
        }
    }
}
