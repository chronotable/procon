import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int n;
        int[] a;
        long total;
        while((n = scan.nextInt()) != 0) {
            a = new int[n];
            total = 0;
            int c = 0;
            boolean f = true;
            for(int i = 0;i < n;i++) {
                if(f) {
                    a[i] = scan.nextInt();
                }else {
                    f = true;
                }
                if(a[c] > 0 && a[i] < 0) {
                    if(Math.abs(a[c]) > Math.abs(a[i])) {
                        total += (i - c) * Math.abs(a[i]);
                        a[c] += a[i];
                        a[i] = 0;
                        //System.out.println(total);
                    }else {
                        total += (i - c) * Math.abs(a[c]);
                        a[i] += a[c];
                        a[c] = 0;
                        f = false;
                    }
                }else if(a[c] < 0 && a[i] > 0) {
                    if(Math.abs(a[c]) > Math.abs(a[i])) {
                        total += (i - c) * Math.abs(a[i]);
                        a[c] += a[i];
                        a[i] = 0;
                    }else {
                        total += (i - c) * Math.abs(a[c]);
                        a[i] += a[c];
                        a[c] = 0;
                        f = false;
                    }
                }
                while(a[c] == 0 && c < i) {
                    c++;
                }
                if(!f) i--;
            }
            System.out.println(total);
        }
    }
}