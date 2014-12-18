import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        int[] dom = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        String[] mn = new String[]{
            "Saturday", "Sunday", "Monday","Tuesday",
            "Wednesday", "Thursday", "Friday"
        };
        int doy = 0;
        for(int v : dom)doy += v;
        if(doy != 365){
            System.out.println("error");
            System.exit(1);
        }
        for(;;){
            int n = sc.nextInt();
            if(n < 0)break;
            int on = n;
            int cy = 2000;
            int cm = 0;
            for(;n > 365;){
                n -= 365;
                if(cy % 4 == 0 && (cy % 100 != 0 || cy % 400 == 0))n--;
                cy++;
            }
            for(;cm < dom.length; cm++){
                int day = dom[cm];
                if(cm == 1 && cy % 4 == 0 &&
                   (cy % 100 != 0 || cy % 400 == 0))day++;
                if(n - day < 0)break;
                n -= day;
            }
            if(cm == 12){
                cm = 0;
                cy++;
            }
            System.out.printf("%d-%02d-%02d %s\n", cy, cm+1,
                              n+1, mn[on%7]);
        }
    }
}
