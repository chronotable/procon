import java.util.*;

public class Main{

    public static void main(String[] args){
	int n,m;
	Scanner sc = new Scanner(System.in);
	for(;;){
	    n=sc.nextInt();
	    m=sc.nextInt();
	    if(n+m==0)break;
	    int[] h = new int[n];
	    int[] k = new int[m];
	    for(int i = 0; i < n;i++)h[i]=sc.nextInt();
	    for(int i = 0; i < m;i++)k[i]=sc.nextInt();
	    Arrays.sort(h);
	    Arrays.sort(k);
	    int hp=0,kp=0;
	    int ans=0;
	    for(;hp<n&&kp<m;hp++){
		boolean flag = false;
		for(;kp<m;kp++){
		    if(h[hp]<=k[kp]){
			flag=true;
			break;
		    }
		}
		if(flag){
		    ans+=k[kp++];
		}else{
		    break;
		}
	    }
	    if(hp==n){
		System.out.println(ans);
	    }else{
		System.out.println("Loowater is doomed!");
	    }
	}
    }

}
