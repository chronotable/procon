import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> ar = new ArrayList<Double>();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) ar.add(sc.nextInt() * 1.0);
        for(int i = 0; i < n-1; i++){
            Collections.sort(ar);
            double x = ar.get(ar.size()-1);
            double y = ar.get(ar.size()-2);
            ar.remove(ar.size()-1);
            ar.remove(ar.size()-1);
            double z = 2 * sqrt(x * y);
            ar.add(z);
        }
        System.out.printf("%.3f\n",ar.get(0));
    }
}
