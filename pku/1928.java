import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        int o = sc.nextInt();
        for(;o > 0; o--){
            int h = sc.nextInt();
            int w = sc.nextInt();
            int k = sc.nextInt();
            int total = h * w;
            Cell[] tbl = new Cell[total];
            for(int i = 0; i < h;i++)
                for(int j = 0; j < w; j++)
                    tbl[i*w + j] = new Cell(i,j,sc.nextInt());
            Arrays.sort(tbl);
            int ans = 0;
            if(k < 1 + tbl[0].y + 1 + tbl[0].y + 1){
                System.out.println(0);
                continue;
            }
            ans = tbl[0].p;
            int cur = 1 + tbl[0].y + 1;
            for(int i = 0; i < total - 1; i++){
                int nc = abs(tbl[i+1].y - tbl[i].y) +
                    abs(tbl[i+1].x - tbl[i].x) + 1;
                int nr = tbl[i+1].y + 1;
                if(cur + nc + nr > k)break;
                cur += nc;
                ans += tbl[i+1].p;
            }
            System.out.println(ans);
        }
    }

    class Cell implements Comparable<Cell>{
        int y,x;
        int p;
        Cell(int a, int b, int c){
            y = a;
            x = b;
            p = c;
        }
        public int compareTo(Cell i){
            return i.p - this.p;
        }
    }
}
