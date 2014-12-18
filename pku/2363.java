import java.util.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int t = sc.nextInt();
	for(;t>0;t--){
	    int n = sc.nextInt();
	    if(n==0){System.out.println(0);continue;}
	    int ans = Integer.MAX_VALUE;
	    for(int i = 1; i <=n;i++){
		for(int j = i;j <= n;j++){
		    if(i*j>n)break;
		    int k = n / (i*j);
		    if(i*j*k!=n)continue;
		    int v = i*j*2 + i*k*2 + j*k*2;
		    if(v<ans)ans=v;
		}
	    }
	    System.out.println(ans);
	}
    }
}