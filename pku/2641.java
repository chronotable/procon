import java.util.*;
import static java.lang.Math.*;

//this is the correct along with problem definitions
public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	for(;;){
	    int w = sc.nextInt();
	    int h = sc.nextInt();
	    int s = sc.nextInt();
	    int m = sc.nextInt();
	    int n = sc.nextInt();
	    if(h+w+s+m+n==0)break;
	    double dy = 1.0 * h * n / s;
	    double dx = 1.0 * w * m / s;
	    double v = hypot(dx,dy);
	    double angle = atan(dy/dx) / PI * 180.0;
	    System.out.printf("%.2f %.2f\n", angle, v);
	}
    }
}