import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }
    void run(){
        Scanner sc = new Scanner(System.in);
        for(;sc.hasNext();){
            int[] co = new int[9];
            for(int i = 0; i < co.length;i++)co[i] = sc.nextInt();
            int r = 0;
            while(r < co.length && co[r] == 0)r++;
            if(r < co.length){
                if(abs(co[r]) != 1 || r==8)System.out.print(co[r]);
                else if(co[r] == -1)System.out.print("-");
                if(r != 8){
                    if(8-r > 1)System.out.printf("x^%d", 8-r);
                    else System.out.print("x");
                }
            }else{
                System.out.print(0);
            }
            for(r++;r < co.length;r++){
                if(co[r] == 0)continue;
                if(co[r] > 0){
                    System.out.print(" + ");
                }else{
                    System.out.print(" - ");
                }
                int a = abs(co[r]);
                if(a != 1 || r == 8)System.out.print(a);
                if(r != 8){
                    if(8-r>1)System.out.printf("x^%d", 8-r);
                    else System.out.print("x");
                }
            }
            System.out.println();
        }
    }
}
