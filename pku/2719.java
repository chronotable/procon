import java.util.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	for(;;){
	    int n = sc.nextInt();
	    if(n==0)break;
	    String s = ""+n;
	    int[] d = new int[s.length()];
	    if(s.charAt(0) > '4')d[0]=1;
	    for(int i = 1; i < s.length();i++){
		int tot = Integer.parseInt(s.substring(0,i));
		if(s.charAt(i) > '4')tot++;
		int x=1;
		for(int j = i-1; j>=0;j--){
		    tot -= d[j]*x;
		    x*=10;
		}
		d[i]=tot;
	    }
	    int y=1,sub=0;
	    for(int i=d.length-1;i>=0;i--){
		sub+=d[i]*y;
		y*=10;
	    }
	    System.out.println(n + ": "+ (n-sub));
	}
    }
}