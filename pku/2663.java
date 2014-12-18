import java.util.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int[] ans = new int[31];
	ans[0]=1;
	ans[2] = 3;
	for(int i = 4; i<= 30; i+=2){
	    ans[i] = 3*ans[i-2]+2;
	    for(int j = i - 4; j > 0; j-=2){
		ans[i] += 2*ans[j];
	    }
	}
	for(;;){
	    int n = sc.nextInt();
	    if(n==-1)break;
	    if(n%2==1){
		System.out.println("0");
		continue;
	    }
	    System.out.println(ans[n]);
	}
    }
}
