import java.util.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	for(;sc.hasNext();){
	    int n = sc.nextInt();
	    int m = sc.nextInt();
	    for(int i = 1; i< n;i++)m = m ^ sc.nextInt();
	    if(m==0)System.out.println("No");
	    else System.out.println("Yes");
	}
    }
}