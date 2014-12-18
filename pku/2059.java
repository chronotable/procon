import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
	new Main().run();
    }

    void run(){
	Scanner sc = new Scanner(System.in);
	int o = sc.nextInt();
	loop:
	for(;o > 0; o--){
	    int s = sc.nextInt();
	    int h = sc.nextInt();
	    int[] hx = new int[h];
	    int[] hy = new int[h];
	    for(int i =0 ; i < h; i++){
		hx[i] = sc.nextInt();
		hy[i] = sc.nextInt();
	    }
	    for(int x = 0; x <= s; x++){
		looppp:
		for(int y = 0; y <= s; y++){
		    double mx = 0.0;
		    for(int i = 0; i < h; i++){
			if(x == hx[i] && y == hy[i])continue looppp;
			mx = max(mx, hypot(x - hx[i], y - hy[i]));
		    }
		    if(x - mx < 0 || x + mx > s ||
		       y - mx < 0 || y + mx > s)continue;
		    System.out.printf("%d %d\n", x, y);
		    continue loop;
		}
	    }
	    System.out.println("poodle");
	}
    }
}