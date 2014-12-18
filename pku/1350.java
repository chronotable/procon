
import java.util.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	for(;;){
	    int n = sc.nextInt();
	    if(n==-1)break;
	    System.out.println("N="+n + ":");
	    if(n>9999 || n<1000 || n%1111==0){
		System.out.println("No!!");
		continue;
	    }
	    int t = 0;
	    while(n!=0 && n!=6174){
		int[] d = new int[new String(""+n).length()];
		int m = n;
		for(int i = 0; i < d.length;i++){
		    d[i] = m % 10;
		    m /= 10;
		}
		Arrays.sort(d);
		int b=0, s=0;
		for(int i = 0; i < d.length;i++){
		    s = s * 10 + d[i];
		    b = b * 10 + d[d.length-1-i];
		}
		n = b - s;
		System.out.println(b+"-"+s+"="+n);
		t++;
	    }
	    System.out.println("Ok!! " + t + " times");
	}
    }
}
