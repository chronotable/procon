import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        for(;;){
            String org = sc.next();
            String s = org;
            if(s.equals("-1"))break;
            Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
            ht.put(s, 0);
            for(int count = 1;;count++){
                int[] fig = new int[10];
                for(int i = 0; i < s.length(); i++)
                    fig[s.charAt(i) - '0']++;
                String nx = "";
                for(int i = 0; i < 10; i++){
                    if(fig[i] > 0)nx += "" + fig[i] + i;
                }
                //System.out.println("nx = " + nx);
                if(s.equals(nx)){
                    if(count == 1){
                        System.out.printf("%s is self-inventorying\n", s);
                    }else{
                        System.out.printf("%s is self-inventorying after %d steps\n", org, count-1);
                    }
                    break;
                }else if(ht.containsKey(nx)){
                    int loop = count - ht.get(nx);
                    System.out.printf("%s enters an inventory loop of length %d\n", org, loop);
                    break;
                }else if(count >= 15){
                    System.out.printf("%s can not be classified after 15 iterations\n", org);
                    break;
                }
                s = nx;
                ht.put(nx, count);
            }
        }
    }
}
