import java.util.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt(), k = sc.nextInt();
	for(int i = 0; i < k;i++){
	    int s=sc.nextInt(),t=sc.nextInt(),r=sc.nextInt();
	    int v = s*t;
	    int ans;
	    if(n%v>0){
		ans=(n/v)*(t+r) + ((n%v)+(s-1))/s;
	    }else{
		ans=(n/v)*(t+r)-r;
	    }
	    System.out.println(ans);
	}
    }
}