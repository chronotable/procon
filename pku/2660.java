import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for(;;){
            int k = sc.nextInt();
            int m = sc.nextInt();
            if((k|m)==0)break;
            double[][] sat = new double[k][3];
            for(int i = 0; i < k;i++)
                for(int j = 0; j < 3; j++)sat[i][j] = sc.nextDouble();
            int ans = 0;
            for(int i = 0; i < m;i++){
                double[] ty = new double[3];
                for(int j = 0; j < 3;j++)ty[j] = sc.nextDouble();
                for(int j = 0; j < k;j++)if(chk(ty, sat[j])){ans++;break;}
            }
            System.out.println(ans);
        }
    }
    static final double R = 20000.0 / PI;
    static boolean chk(double[] a, double[] b){
        double dot = a[0]*b[0] + a[1]*b[1] + a[2]*b[2];
        return (dot >= R*R);
    }
}