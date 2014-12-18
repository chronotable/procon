import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
	new Main().run();
    }

    void run(){
	Scanner sc = new Scanner(System.in);
	int c = sc.nextInt();
	int g = sc.nextInt();
	int[] pos = new int[c];
	int[] wght = new int[g];
	for(int i = 0; i < c; i++)
	    pos[i] = sc.nextInt();
	for(int i = 0; i < g; i++)
	    wght[i] = sc.nextInt();
	final int M = 5000;
	int[] memo = new int[M*2+1];
	memo[M] = 1;
	for(int i = 0; i < g; i++){
	    int[] nxt = new int[M*2+1];
	    for(int j = 0; j < c; j++){
		int val = wght[i] * pos[j];
		for(int k = 0; k < nxt.length; k++)
		    if(memo[k] > 0)nxt[k + val] += memo[k];
	    }
	    memo = nxt;
	}
	System.out.println(memo[M]);
    }
}
