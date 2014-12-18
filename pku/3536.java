import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
	new Main().run();
    }

    void run(){
	Scanner sc = new Scanner(System.in);
	for(;sc.hasNext();){
	    int n = sc.nextInt();
	    if(isPrime(n)){
		System.out.printf("%d %d %d\n", n, 1, 1);
		continue;
	    }
	    int lim = (int)sqrt(n) + 1;
	    int mn = n * 100;
	    int a = -1,b = -1,c = -1;
	    for(int i = 2; i <= lim; i++){
		if(n % i != 0)continue;
		int v = n / i;
		int inl = (int)sqrt(v) + 1;
		for(int j = 1; j <= inl; j++){
		    if(v % j != 0)continue;
		    int x = v / j;
		    int sum = 2*i*j + 2*i*x + 2*j*x;
		    if(sum < mn){
			mn = sum;
			a = i; b = j; c = x;
		    }
		}
	    }
	    System.out.printf("%d %d %d\n", a, b, c);
	}
    }

    boolean isPrime(int n){
	if(n % 2 == 0)return false;
	int sn = (int)sqrt(n) + 1;
	for(int i = 3; i <= sn; i += 2)
	    if(n % i == 0)return false;
	return true;
    }
}