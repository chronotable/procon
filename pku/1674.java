import java.util.*;

public class Main{
    public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	int t = sc.nextInt();
	for(;t>0;t--){
	    int n = sc.nextInt();
	    int[] s = new int[n];
	    for(int i = 0; i < n;i++)s[i] = sc.nextInt()-1;
	    int ans = 0;
	    for(int i = 0; i < n;i++){
		if(s[i]==-1)continue;
		int j = s[i];
		s[i]=-1;
		while(j!=i){
		    int x = j;
		    j=s[j];
		    s[x]=-1;
		    ans++;
		}
	    }
	    System.out.println(ans);
	}
    }
}
