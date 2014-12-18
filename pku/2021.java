import java.util.*;

public class Main{

    static Hashtable<String, Integer> ht;
    static int[] ages;
    static int[][] diff;
    static int n;

    static void tra(int x){
	for(int i = 0; i < n;i++){
	    if(diff[x][i] != Integer.MAX_VALUE && ages[i]==-1){
		ages[i] = ages[x] + diff[x][i];
		tra(i);
	    }
	}
    }

    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int t = sc.nextInt();
	for(int o = 1; o <= t;o++){
	    n = sc.nextInt();
	    ages = new int[n];
	    Arrays.fill(ages,-1);
	    ht = new Hashtable<String,Integer>();
	    diff = new int[n][n];
	    for(int i = 0; i < n;i++)Arrays.fill(diff[i],Integer.MAX_VALUE);
	    int si = 0;
	    for(int i = 0; i < n;i++){
		String a = sc.next();
		String b = sc.next();
		int v = sc.nextInt();
		if(a.equals("Ted")){
		    if(!ht.containsKey(b))ht.put(b,ht.size());
		    ages[ht.get(b)] = 100 - v;
		    si = ht.get(b);
		    continue;
		}
		if(!ht.containsKey(a))ht.put(a,ht.size());
		if(!ht.containsKey(b))ht.put(b,ht.size());
		diff[ht.get(a)][ht.get(b)] = -v;
		diff[ht.get(b)][ht.get(a)] = v;
	    }
	    for(int i = 0; i < n;i++)if(ages[i]!=-1)tra(i);
	    Enumeration<String> en = ht.keys();
	    Info[] tbl = new Info[n];
	    int c = 0;
	    for(;en.hasMoreElements();){
		String s = en.nextElement();
		int v = ages[ht.get(s)];
		tbl[c++] = new Info(s,v);
	    }
	    Arrays.sort(tbl);
	    System.out.println("DATASET " + o);
	    for(int i = 0; i < tbl.length;i++)System.out.println(tbl[i]);
	}
    }

    static class Info implements Comparable<Info>{
	String name;
	int age;
	Info(String a, int b){
	    name = a;
	    age = b;
	}
	public int compareTo(Info i){
	    if(this.age != i.age) return i.age - this.age;
	    return name.compareTo(i.name);
	}
	public String toString(){
	    return name + " " + age;
	}
    }
}