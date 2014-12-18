
import java.util.*;

public class Main{
    public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	int[] f = null;
	for(;sc.hasNext();){
	    String s = sc.next();
	    if(f == null)f = new int[s.length()];
	    for(int i = 0; i < s.length();i++){
		f[i] += s.charAt(i) - '0';
		f[i] %= 10;
	    }
	}
	for(int i = 0; i < f.length;i++){
	    System.out.print(f[i]);
	}
    }
}
