import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        for(int o = sc.nextInt(); o > 0; o--){
            String[][] inp = new String[3][3];
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++)
                    inp[i][j] = sc.next();
            }
            int coin;
            boolean light = true;
            loop:
            for(coin = 0; coin < 12; coin++){
                char c = (char)(coin + 'A');
                for(int j = 0; j < 2; j++){
                    light = (j==0);
                    boolean weighted = false;
                    boolean ok = true;
                    for(int k = 0; k < 3; k++){
                        if(inp[k][0].indexOf(c) >= 0){
                            weighted = true;
                            if(light && !inp[k][2].equals("down"))
                                ok = false;
                            else if(!light && !inp[k][2].equals("up"))
                                ok = false;
                        }else if(inp[k][1].indexOf(c) >= 0){
                            weighted = true;
                            if(!light && !inp[k][2].equals("down"))
                                ok = false;
                            else if(light && !inp[k][2].equals("up"))
                                ok = false;
                        }else{
                            if(!inp[k][2].equals("even"))
                                ok = false;
                        }
                    }
                    if(weighted && ok)break loop;
                }
            }
            char ans = (char)(coin + 'A');
            System.out.printf("%c is the counterfeit coin and it is %s.\n",
                              ans, light ? "light" : "heavy");
        }
    }
}
