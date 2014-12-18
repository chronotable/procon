import java.util.*;

public class Main {

public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    int n;
    int[][] a = new int[2][1000];
    while(true) {
        n = scan.nextInt();
        if(n == 0) break;
        for(int i = 0;i < n;i++) {
             a[0][i] = scan.nextInt();
        }
        int t = 1;
        int dif;
        boolean homo = true;
        int cur;
        for(cur = 1;cur < n;cur++) {
            for(int j = 0;j < n;j++) {
                //cin >> a[t][j];
                a[t][j] = scan.nextInt();
            }
            t = 1 - t;
            dif = a[1][0] - a[0][0];
            for(int j = 1;j < n;j++) {
                if(a[1][j] - a[0][j] != dif) {
                    homo = false;
                    break;
                }
            }
            if(!homo) break;
        }
        for(;cur < n;cur++) {
            scan.nextLine();
        }
        if(homo) System.out.println("homogeneous");
        else System.out.println("not homogeneous");
    }
}

}