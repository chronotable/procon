import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
	new Main().run();
    }

    void run(){
	Scanner sc = new Scanner(System.in);
	for(;;){
	    int[] n = new int[6];
	    int sum = 0;
	    for(int i = 0; i < 6; i++){
		n[i] = sc.nextInt();
		sum += n[i];
	    }
	    if(sum == 0)break;
	    int ans = n[5];
	    while(n[4] > 0){
		ans++;
		n[4]--;
		n[0] -= 11;
	    }
	    while(n[3] > 0){
		ans++;
		n[3]--;
		int p2n = min(5, n[1]);
		n[1] -= p2n;
		int rest = 20 - p2n*4;
		n[0] -= rest;
	    }
	    while(n[2] > 0){
		ans++;
		int p3n = min(4, n[2]);
		n[2] -= p3n;
		int mxp2n = 0;
		if(p3n == 1)mxp2n = 5;
		else if(p3n == 2)mxp2n = 3;
		else if(p3n == 3)mxp2n = 1;
		int p2n = min(mxp2n, n[1]);
		n[1] -= p2n;
		int rest = 36 - p3n*9 - p2n*4;
		n[0] -= rest;
	    }
	    while(n[1] > 0){
		ans++;
		int p2n = min(9, n[1]);
		n[1] -= p2n;
		int rest = 36 - 4 * p2n;
		n[0] -= rest;
	    }
	    if(n[0] > 0){
		ans += n[0] / 36;
		if(n[0] % 36 > 0)ans++;
	    }
	    System.out.println(ans);
	}
    }
}
