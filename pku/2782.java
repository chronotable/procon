import java.util.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int len = sc.nextInt();
	int[] bl = new int[n];
	for(int i = 0; i < n;i++)bl[i]=sc.nextInt();
	Arrays.sort(bl);
	int ans = 0;
	int ri = n-1,li = 0;
	for(;ri>=li;ri--){
	    if(ri!=li && bl[ri]+bl[li] <= len)li++;
	    ans++;
	}
	System.out.println(ans);
    }
}