import java.util.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	boolean[] u = new boolean[1000002];
	ArrayList<Integer> hp = new ArrayList<Integer>();
	for(int i = 5; i < u.length; i += 4){
	    if(!u[i]){
		hp.add(i);
		for(int j = i; j < u.length;j += 4){
		    long v = 1l * i * j;
		    if(v >= u.length)break;
		    u[(int)v] = true;
		}
	    }
	}

	ArrayList<Integer> hsp = new ArrayList<Integer>();
	final int M = 1000001;
	for(int i = 0; i < hp.size(); i++){
	    int a = hp.get(i);
	    for(int j = i; j < hp.size();j++){
		int b = hp.get(j);
		long v = 1l * a * b;
		if(v <= M)hsp.add((int)v);
		else break;
	    }
	}
	Collections.sort(hsp);
	ArrayList<Integer> ans = new ArrayList<Integer>();
	ans.add(hsp.get(0));
	int prev = hsp.get(0);
	for(int i = 1; i < hsp.size();i++){
	    int v = hsp.get(i);
	    if(v == prev)continue;
	    ans.add(v);
	    prev = v;
	}

	for(;;){
	    int n = sc.nextInt();
	    if(n==0)break;
	    int ind = Collections.binarySearch(ans,n);
	    System.out.print(n + " ");
	    if(ind>=0)System.out.println(ind+1);
	    else System.out.println(-ind - 1);
	}
    }
}