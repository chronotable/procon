
import java.util.*;

public class Main{

    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int c = sc.nextInt();
	int f1 = sc.nextInt();
	int f2 = sc.nextInt();
	int d = sc.nextInt();
	int[] t = new int[2001];
	for(int i = 0; i < c;i++){
	    int l = sc.nextInt();
	    int r = sc.nextInt();
	    for(int j = l;j <= r;j++){
		t[j]++;
	    }
	}
	int ans = d;
	int sum = 0;
	for(;;){
	    sum += t[ans];
	    if(f1 - sum <= f2)break;
	    ans--;
	}
	System.out.println(ans);
    }

}
