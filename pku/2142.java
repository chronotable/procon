import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	for(;;){
	    int a = sc.nextInt();
	    int b = sc.nextInt();
	    int c = sc.nextInt();
	    if(a+b+c==0)break;
	    int ax = 999999,ay = 999999;
	    for(int i = -50010;i < 50010;i++){
		int s = abs(i * a + c);
		if(s % b > 0)continue;
		int x = abs(i);
		int y = s / b;
		if(x+y < ax + ay || (x+y==ax+ay && x*a+y*b < ax*a+ay*b)){
		    ax = x;
		    ay = y;
		}
	    }
	    System.out.println(ax + " " + ay);
	}
    }
}