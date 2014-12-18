import java.util.*;

public class Main{
    public static void main(String[] args){
	double[] d = new double[10];
	d[0]=1.0;
	for(int i = 1; i < 10;i++)d[i]=d[i-1]/i;
	double[] ans = new double[10];
	ans[0]=d[0];
	for(int i = 1; i < 10;i++)ans[i]=d[i]+ans[i-1];
	System.out.println("n e");
	System.out.println("- -----------");
	System.out.println("0 1");
	System.out.println("1 2");
	System.out.println("2 2.5");
	for(int i = 3; i < 10;i++){
	    if(i!=8)System.out.printf("%d %.9f\n",i,ans[i]);
	    else System.out.printf("%d %.8f\n",i,ans[i]);
	}
    }
}