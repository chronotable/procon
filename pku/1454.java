
import java.util.*;
import java.math.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	BigInteger[] tbl = new BigInteger[367];
	tbl[1] = new BigInteger("1");
	for(int i = 2;i < 367;i++)tbl[i] = tbl[i-1].multiply(new BigInteger(""+i));
	
	for(;;){
	    int n = sc.nextInt();
	    if(n==0)break;
	    String s = tbl[n].toString();
	    int[] d = new int[10];
	    for(int i = 0; i < s.length();i++)d[s.charAt(i)-'0']++;
	    System.out.println(n+"! --");
	    for(int i = 0; i < 10;i++){
		System.out.printf("   (%d)%5d",i,d[i]);
		if(i==4||i==9)System.out.println();
		else System.out.print(" ");
	    }
	}
    }
}
