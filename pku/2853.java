import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int o = sc.nextInt();
	for(; o > 0; o--){
	    int n = sc.nextInt();
	    int m = sc.nextInt();
	    int ans = 0;
	    for(int i = 2; ; i++){
		long rest = m - 1l * i * (i - 1) / 2;
		if(rest / i == 0)break;
		if(rest % i == 0)ans++;
	    }
	    System.out.println(n + " " + ans);
	}
    }
}
