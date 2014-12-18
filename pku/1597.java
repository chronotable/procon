
import java.util.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	for(;sc.hasNext();){
	    int s = sc.nextInt();
	    int m = sc.nextInt();
	    boolean[] u = new boolean[m];
	    int c = 0;
	    int f = 0;
	    for(;c<m;c++){
		if(u[f])break;
		u[f]=true;
		f = (f + s) % m;
	    }
	    System.out.printf("%10d%10d",s,m);
	    if(c==m)System.out.println("    Good Choice");
	    else System.out.println("    Bad Choice");
	    System.out.println();
	}
    }
}

