import java.util.*;

public class Main{

    static int[] s;
    static int[][] pos;
    static int[] mx;

    static void tra(int x){
	mx[x] = 1;
	pos[x][0] = x;
	int cp = s[x];
	while(cp != x){
	    pos[x][mx[x]++] = cp;
	    cp = s[cp];
	}
    }

    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	for(;;){
	    int n = sc.nextInt();
	    if(n==0)break;
	    s = new int[n];
	    for(int i = 0; i < n;i++){
		s[i] = sc.nextInt()-1;
	    }
	    pos = new int[n][n];
	    mx = new int[n];
	    for(int i = 0; i < n;i++)tra(i);

	    for(;;){
		int k = sc.nextInt();
		if(k==0)break;
		String m = sc.nextLine();
		m = m.substring(1);
		for(;m.length() < n;)m = m + " ";
		char[] mc = m.toCharArray();
		char[] nm = new char[n];
		for(int i = 0; i < n;i++)
		    nm[pos[i][k%mx[i]]] = mc[i];
		String ans = new String(nm);
		System.out.println(ans);
	    }
	    System.out.println();
	}
    }
}