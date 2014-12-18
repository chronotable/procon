import java.util.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	System.out.println("PERFECTION OUTPUT");
	for(;;){
	    int n = sc.nextInt();
	    if(n==0)break;
	    ArrayList<Integer> ar = new ArrayList<Integer>();
	    int s = (int)Math.sqrt(n);
	    ar.add(1);
	    for(int i = 2; i <= s;i++){
		if(n%i==0){
		    ar.add(i);
		    ar.add(n/i);
		}
	    }
	    int sum = 0;
	    for(int i = 0; i < ar.size();i++){
		sum+=ar.get(i);
	    }
	    if(s*s==n)sum-=s;
	    System.out.printf("%5d  ",n);
	    if(sum == n)System.out.println("PERFECT");
	    else if(sum>n)System.out.println("ABUNDANT");
	    else System.out.println("DEFICIENT");
	}
	System.out.println("END OF OUTPUT");
    }
}
