
import java.util.*;

public class Main{

    public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	int i = sc.nextInt();
	double m = sc.nextInt();
	int y = sc.nextInt();
	for(;y>0;y--){
	    m = m + m * i / 100.0;
	}
	System.out.println((int)Math.floor(m));
    }

}
