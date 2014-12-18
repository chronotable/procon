import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        final String[] Haabm = new String[]{
            "pop", "no", "zip", "zotz", "tzec",
            "xul", "yoxkin", "mol", "chen", "yax",
            "zac", "ceh", "mac", "kankin", "muan",
            "pax", "koyab", "cumhu","uayet"
        };
        final String[] Tzolkind = new String[]{
            "imix", "ik", "akbal", "kan", "chicchan",
            "cimi", "manik", "lamat", "muluk", "ok",
            "chuen", "eb", "ben", "ix", "mem",
            "cib", "caban", "eznab", "canac", "ahau"
        };
        int o = sc.nextInt();
        System.out.println(o);
        for(;o > 0;o--){
            String ds = sc.next();
            ds = ds.substring(0, ds.indexOf("."));
            int day = Integer.parseInt(ds);
            String month = sc.next();
            int year = Integer.parseInt(sc.next());
            int dsum = year * 365;
            for(int i = 0; i < Haabm.length; i++){
                if(month.equals(Haabm[i])){
                    dsum += i * 20;
                }
            }
            dsum += day + 1;
            //System.out.printf("dsum = %d\n",dsum);

            //solve
            year = dsum / 260;
            dsum -= year * 260;
            if(dsum == 0){
                dsum = 260;
                year--;
            }
            int num = (dsum-1) % 13;
            int mi = dsum / 20;
            dsum -= mi * 20;
            if(dsum == 0){
                dsum = 20;
                mi--;
            }
            String dayname = Tzolkind[dsum-1];
            System.out.printf("%d %s %d\n", num+1, dayname, year);
        }
    }
}
