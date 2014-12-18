import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }
    void run(){
        Scanner sc = new Scanner(System.in);
        for(;;){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a+b==0)break;
            int[] u = new int[b];
            Arrays.fill(u, -1);
            String ans = ".";
            int count = 0;
            while(a > 0 && u[a] < 0){
                u[a] = count++;
                ans += a * 10 / b;
                a = (a * 10) % b;
            }
            for(int i = 0; i <= ans.length() / 50; i++){
                if(i == ans.length() / 50){
                    if(ans.length()%50!=0)
                        System.out.println(ans.substring(i*50));
                }else{
                    System.out.println(ans.substring(i*50,(i+1)*50));
                }
            }
            if(a == 0)
                System.out.println("This expansion terminates.");
            else
                System.out.printf("The last %d digits repeat forever.\n",
                                  count - u[a]);
        }
    }
}
