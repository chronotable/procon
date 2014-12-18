
import java.util.*;

public class Main{

    static int[] seq;
    static int ans;
    static int s;
    static int n;

    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int t = sc.nextInt();
	for(;t>0;t--){
	    n = sc.nextInt();
	    s = sc.nextInt();
	    seq = new int[n];
	    for(int i  =0 ; i < n; i++)seq[i] = sc.nextInt();
	    ans = s+1;
	    binarySearch(1,n);
	    if(ans<s+1)System.out.println(ans);
	    else System.out.println(0);
	}
    }

    static void binarySearch(int l, int r){
	if(l>r)return;
	int m = (l+r)/2;
	int sum = 0;
	boolean f = false;
	for(int i = 0; i < m;i++)sum+=seq[i];
	if(sum>=s)f=true;
	for(int i = m; !f && i < n;i++){
	    sum-=seq[i-m];
	    sum+=seq[i];
	    if(sum>=s)f=true;
	}
	if(f){
	    if(ans>m)ans=m;
	    binarySearch(l,m-1);
	}else{
	    binarySearch(m+1,r);
	}
    }

}
