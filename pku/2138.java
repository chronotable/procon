import java.util.*;

public class Main{
    public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	String org = sc.next();
	String ans = org;
	ArrayList<Info> ar = new ArrayList<Info>();
	ar.add(new Info(org));
	for(int i = 0; i < n;i++){
	    String s = sc.next();
	    if(org.length() < s.length()) ar.add(new Info(s));
	}
	Collections.sort(ar);
	boolean[] u = new boolean[ar.size()];
	u[0] = true;
	for(int i = 1;i < ar.size();i++){
	    Info x = ar.get(i);
	    for(int j = 0; j < i;j++){
		Info y = ar.get(j);
		if(x.w.length() <= y.w.length())break;
		if(!u[j])continue;
		if(x.diff(y)) {
		    u[i] = true;
		    if(ans.length() < x.w.length())
			ans = x.w;
	        }
	    }
	}
	System.out.println(ans);
    }
    static class Info implements Comparable<Info>{
	String w;
	Info(String s){
	    w=s;
	}
	public int compareTo(Info i){
	    return this.w.length() - i.w.length();
	}
	boolean diff(Info temp){
	    String z = temp.w;
	    if(this.w.length() - 1 != z.length())return false;
	    int d = 0;
	    for(int i = 0; i < z.length() && d < 2 && d+i < w.length();i++){
		if(w.charAt(i+d) != z.charAt(i)){
		    d++;
		    i--;
		}
	    }
	    if(d>1)return false;
	    return true;
	}
	public String toString(){
	    return this.w;
	}
    }
}