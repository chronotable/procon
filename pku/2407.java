import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean[] u = new boolean[40000];
        int[] p = new int[40000];
        int pn = 0;
        for(int i = 2; i < u.length;i++){
            if(!u[i]){
		p[pn++]=i;
		for(int j = i * 2;j < u.length;j+=i)u[j]=true;
	    }
        }
        for(;;){
	    int n = sc.nextInt();
	    if(n==0)break;
	    int[] y = new int[40000];
	    int yn=0;
	    double ans=n;
	    for(int i  =0 ;i < pn;i++){
		if(n<p[i])break;
		if(n%p[i]==0){
		    y[yn++]=p[i];
		    while(n%p[i]==0)n/=p[i];
		}
	    }
	    if(yn==0){
		System.out.println(n-1);
		continue;
	    }
	    if(n!=1)y[yn++]=n;
	    for(int i = 0 ; i < yn;i++){
		ans=ans*(y[i]-1)/y[i];
	    }
	    System.out.println((int)ans);
        }
    }

}

