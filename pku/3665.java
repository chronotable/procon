
import java.util.*;

public class Main{
    public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int t = sc.nextInt();
	int[] r = new int[n];
	if(n==1){
	    for(int i = 0; i < t;i++)System.out.println(1);
	    return;
	}
	for(int i = 0; i < n;i++)r[i]=sc.nextInt();
	for(int i = 0; i < t;i++){
	    int mx = -1,p=-1;
	    for(int j = 0; j < n;j++)if(r[j]>mx){mx=r[j];p=j;}
	    int v = mx / (n-1);
	    int mod = mx % (n-1);
	    if(p<mod)mod++;
	    for(int j = 0; j < n;j++)r[j]+=v;
	    for(int j = 0; j < mod;j++)r[j]++;
	    r[p]=0;
	    System.out.println(p+1);
	}
    }
}
