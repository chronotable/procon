import java.util.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int[][] s = new int[4][n];
	Hashtable<Integer, Integer> hm = new Hashtable<Integer, Integer>();
	for(int i = 0; i < n;i++){
	    for(int j = 0; j < 4;j++)
		s[j][i] = sc.nextInt();
	}
	for(int i = 0; i < n;i++){
	    for(int j = 0; j < n;j++){
		int a = s[2][i] + s[3][j];
		if(hm.containsKey(a))hm.put(a,hm.get(a)+1);
		else hm.put(a, 1);
	    }
	}
	long ans = 0;
	for(int i = 0; i < n;i++){
	    for(int j = 0; j < n;j++){
		int a = s[0][i] + s[1][j];
		a = -a;
		if(hm.containsKey(a))ans += hm.get(a);
	    }
	}
	System.out.println(ans);
    }
}