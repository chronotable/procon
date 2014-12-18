import java.util.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int l = sc.nextInt();
	Info[] tbl = new Info[n];
	for(int i = 0; i < n;i++){
	    tbl[i] = new Info(sc.nextInt(), sc.nextInt());
	}
	Arrays.sort(tbl);
	int pos = -1;
	int ans = 0;
	for(int i = 0; i < n;i++){
	    int v;
	    if(pos > tbl[i].s)v = pos;
	    else v = tbl[i].s;
	    int bn;
	    if(v < tbl[i].e) bn = (tbl[i].e - v - 1) / l + 1;
	    else bn = 0;
	    ans += bn;
	    pos = v + bn * l;
	}
	System.out.println(ans);
    }

    static class Info implements Comparable<Info>{
	int s,e;
	Info(int a, int b){
	    s = a;
	    e = b;
	}
	public int compareTo(Info i){
	    return this.s - i.s;
	}
    }
}