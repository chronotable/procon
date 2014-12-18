
import java.util.*;

public class Main{
    public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	int[] fac = new int[10];
	fac[0] = 1;
	fac[1] = 1;
	boolean[] yes = new boolean[1000001];
	for(int i = 2; i <= 9;i++)fac[i] = fac[i-1] * i;
	for(int i = 1; i < 1<<10;i++){
	    int val = 0;
	    for(int j = 0; j < 10;j++){
		int b = (i >> j) & 1;
		if(b==1)val += fac[j];
	    }
	    yes[val] = true;
	}
	for(;;){
	    int n = sc.nextInt();
	    if(n < 0)break;
	    if(yes[n])System.out.println("YES");
	    else System.out.println("NO");
	}
    }
}
