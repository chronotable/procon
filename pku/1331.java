import java.util.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int t = sc.nextInt();
	for(;t>0;t--){
	    int p = sc.nextInt();
	    int q = sc.nextInt();
	    int r = sc.nextInt();
	    int ans = 0;
	    for(int i = 2;i <= 16;i++){
		boolean f = true;
		long np = 0;
		int bp = p;
		for(int j = 1;bp > 0;j*=i){
		    int m = bp % 10;
		    if(m >= i){f=false;break;}
		    np += m * j;
		    bp /= 10;
		}
		long nq = 0;
		int bq = q;
		for(int j = 1;bq > 0;j*=i){
		    int m = bq % 10;
		    if(m >= i){f=false;break;}
		    nq += m * j;
		    bq /= 10;
		}
		long nr = 0;
		int br = r;
		for(int j = 1;br > 0;j*=i){
		    int m = br % 10;
		    if(m >= i){f=false;break;}
		    nr += m * j;
		    br /= 10;
		}
		if(f && np*nq==nr){
		    ans=i;
		    break;
		}
	    }
	    System.out.println(ans);
	}
    }
}
