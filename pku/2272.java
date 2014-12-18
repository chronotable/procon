import java.util.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	double[] zone = new double[5];
	for(int i = 0; i < zone.length;i++)zone[i] = (i+1)*(i+1)*9;
	for(;;){
	    double x = sc.nextDouble();
	    if(x==-100)break;
	    double y = sc.nextDouble();
	    int p1 = 0;
	    for(int i = 0; i < zone.length;i++)
		if(x*x+y*y <= zone[i]){p1+=(100 - 20*i);break;}
	    for(int o = 0;o < 2;o++){
		x = sc.nextDouble();
		y = sc.nextDouble();
		for(int i = 0; i < zone.length;i++){
		    if(x*x+y*y <= zone[i]){p1+=(100-20*i);break;}
		}
	    }
	    int p2 = 0;
	    for(int o = 0;o < 3;o++){
		x = sc.nextDouble();
		y = sc.nextDouble();
		for(int i = 0; i < zone.length;i++){
		    if(x*x+y*y <= zone[i]){p2+=(100-20*i);break;}
		}
	    }
	    System.out.print("SCORE: " + p1 + " to " + p2 + ", ");
	    if(p1>p2)System.out.println("PLAYER 1 WINS.");
	    else if(p1<p2)System.out.println("PLAYER 2 WINS.");
	    else System.out.println("TIE.");
	}
    }
}