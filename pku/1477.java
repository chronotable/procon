

import java.util.*;

public class Main{

    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int n;
	for(int c = 1;;c++){
	    n = sc.nextInt();
	    if(n==0)break;
	    int[] b = new int[n];
	    int sum = 0;
	    for(int i = 0 ; i < n;i++)sum += b[i] = sc.nextInt();
	    int av = sum / n;
	    int ans = 0;
	    for(int i = 0; i < n;i++)if(b[i] < av) ans += av - b[i];
	    System.out.println("Set #" + c);
	    System.out.println("The minimum number of moves is " + ans + ".");
	    System.out.println();
	}
    }

}

