import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
	new Main().run();
    }

    void run(){
	Scanner sc = new Scanner(System.in);
	for(;;){
	    int n = sc.nextInt();
	    if(n==0)break;
	    int cur = 9;
	    int fig = 1;
	    while(n - 2*cur > 0){
		n -= 2*cur;
		cur *= 10;
		fig *= 10;
	    }
	    fig += ((n%cur==0) ? cur : n%cur)-1;
	    System.out.print(fig);
	    if(n-cur <= 0)fig /= 10;
	    while(fig > 0){
		System.out.print(fig % 10);
		fig /= 10;
	    }
	    System.out.println();
	}
    }
}