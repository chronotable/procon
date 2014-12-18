import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        try{
            new Main().run();
        }catch(Exception e){

        }
    }

    int n,f;
    double[] a;
    double[] s;
    final double EPS = 1e-6;

    boolean check(double v){
        double d = s[f-1] - v * f;
        if(d >= EPS)return true;
        for(int i = f; i < n; i++){
            double x = d + a[i] - v;
            double y = s[i] - s[i-f] - v * f;
            d = max(x, y);
            if(d >= EPS)return true;
        }
        return d >= EPS;
    }

    void run() throws Exception{
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String param = sc.readLine();
        String[] ps = param.split(" ");
        n = Integer.parseInt(ps[0]);
        f = Integer.parseInt(ps[1]);
        a = new double[n];
        s = new double[n];
        double mna = 1e30;
        double mxa = -1e30;
        for(int i = 0; i < n; i++){
            a[i] = Double.parseDouble(sc.readLine()) * 1000;
            mna = min(mna, a[i]);
            mxa = max(mxa, a[i]);
        }
        s[0] = a[0];
        for(int i = 1; i < n; i++)s[i] = s[i-1] + a[i];
        double ans = mna;
        for(;mxa-mna >= EPS;){
            double m = (mna + mxa) / 2;
            if(check(m)){
                ans = max(ans, m);
                mna = m;
            }else{
                mxa = m;
            }
        }
        System.out.printf("%d\n", (int)(ans+0.2));
    }
}
