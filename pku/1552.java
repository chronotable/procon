import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for(;;){
            ArrayList<Integer> ar = new ArrayList<Integer>();
            int v = sc.nextInt();
            if(v == -1)break;
            ar.add(v);
            for(;;){
                v = sc.nextInt();
                if(v == 0) break;
                ar.add(v);
            }
            int ans = 0;
            for(int i = 0; i < ar.size();i++){
                v = ar.get(i);
                for(int j = 0; j < ar.size();j++)if(v == ar.get(j) * 2){
                    ans++;
                    break;
                }
            }
            System.out.println(ans);
        }
    }
}
