import java.util.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int t = sc.nextInt();
	int x = sc.nextInt();
	int m = sc.nextInt();
	double ne = Double.MAX_VALUE;
	int ed=10, ev=0;
	for(int i = 0; i < m;i++){
	    int d = sc.nextInt();
	    int v = sc.nextInt();
	    if((double)d/v < ne){
		ne = (double)d/v;
		ed = d;
		ev = v;
	    }
	}
	int ans = 0;
	int dis = 0;
	for(int i = 0; i < t;i++){
	    if(dis + ev >= ed){
		dis -= ev;
		if(dis < 0)dis=0;
	    }else{
		dis+= ev;
		ans++;
	    }
	}
	System.out.println(ans*x);
    }
}
