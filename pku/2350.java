
import java.util.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int c = sc.nextInt();
	for(;c>0;c--){
	    int n = sc.nextInt();
	    int[] s = new int[n];
	    int sum = 0;
	    for(int i = 0; i < n;i++){
		s[i] = sc.nextInt();
		sum += s[i];
	    }
	    double ave = 1.0 * sum / n;
	    int g = 0;
	    for(int i = 0; i < n;i++)if(ave < (double)s[i])g++;
	    System.out.printf("%.3f",(double)g*100/n);
	    System.out.println("%");
	}
    }
}
