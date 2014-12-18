import java.util.*;

public class Main{

    static byte[] u = new byte[16000000];

    public static void main(String[] args){

	Scanner sc = new Scanner(System.in);
	int a = sc.nextInt();
	int c = sc.nextInt();
	int m = sc.nextInt();
	int r = sc.nextInt();
	int n = r;
	for(;;){
	    if(u[n]>0)break;
	    u[n]=1;
	    n=(a*n + c) % m;
	}
	int ans=0;
	int ind;
	int prev=0;
	for(ind = 0; ind < 16000000;ind++)if(u[ind]>0){prev=ind;break;}
	for(ind++;ind < 16000000;ind++){
	    if(u[ind]>0){
		if(ans<ind-prev)ans=ind-prev;
		prev=ind;
	    }
	}
	System.out.println(ans);
    }
}