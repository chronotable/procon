import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for(;sc.hasNext();){
            int n = sc.nextInt();
            if(n<0)break;
            double[] x =new double[n+2];
            double[][] y = new double[n+2][4];
            double[][] dis = new double[n+2][4];
            x[0] = 0;x[n+1] = 10;
            Arrays.fill(y[n+1], 5.0);Arrays.fill(y[0], 5.0);
            for(int i = 1; i <= n; i++){
                x[i] = sc.nextDouble();
                for(int j = 0; j < 4; j++)
                    y[i][j] = sc.nextDouble();
                Arrays.sort(y[i]);
            }
            for(int i = 1; i <= n+1; i++){
                for(int j = 0; j < 4;j++){
                    double mn = 1e3;
                    for(int g = 0; g < i; g++){
                        if(x[i] == x[g])
                            continue;
                        for(int h = 0; h < 4; h++){
                            try{
                            double a = (y[i][j] - y[g][h]) / (x[i] - x[g]);
                            double b = y[i][j] - a * x[i];
                            boolean f = true;
                            for(int k = g + 1; k < i; k++){
                                double z = a * x[k] + b;
                                if(z < y[k][0] ||
                                   (z > y[k][1] && z < y[k][2]) ||
                                   z > y[k][3]){
                                    f = false;
                                    break;
                                }
                            }
                            if(f){
                                mn = min(mn, dis[g][h] + hypot(x[i] - x[g],
                                         y[i][j] - y[g][h]));
                            }
                            }catch (RuntimeException re){

                            }
                        }
                    }
                    dis[i][j] = mn;
                }
            }
            System.out.printf("%.2f\n", dis[n+1][0]);
        }
    }
}

