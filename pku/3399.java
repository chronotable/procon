import java.util.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int k = sc.nextInt();
	ArrayList<Integer> pn = new ArrayList<Integer>();
	ArrayList<Integer> nn = new ArrayList<Integer>();
	for(int i = 0; i < n;i++){
	    int v = sc.nextInt();
	    if(v<0)nn.add(v);
	    else pn.add(v);
	}
	Collections.sort(pn);
	Collections.sort(nn);
	ArrayList<Integer> ans = new ArrayList<Integer>();
	for(int i = 0; i <= k; i+=2){
	    if(i > nn.size())break;
	    if(k-i > pn.size())continue;
	    if(ans.size()==0){
		for(int j = 0; j < i;j++)ans.add(nn.get(j));
		for(int j = 0 ; j < k-i;j++)ans.add(pn.get(pn.size()-j-1));
	    }else{
		ArrayList<Integer> t = new ArrayList<Integer>();
		boolean tincz = false;
		for(int j = 0; j < i;j++)t.add(nn.get(j));
		for(int j = 0 ; j < k-i;j++){
		    int v = pn.get(pn.size()-j-1);
		    t.add(v);
		    if(v==0)tincz=true;
		}
		if(tincz)continue;
		boolean aincz = false;
		for(int j = 0; j < ans.size();j++)if(ans.get(j)==0)aincz=true;
		if(aincz){ans = t;continue;}
		Info[] at = new Info[ans.size()];
		Info[] tt = new Info[t.size()];
		for(int j = 0; j < k;j++){
		    at[j] = new Info(ans.get(j));
		    tt[j] = new Info(t.get(j));
		}
		Arrays.sort(at);
		Arrays.sort(tt);
		double rat = 1;
		for(int j = k-1; j >= 0;j--)
		    rat = rat * 
			(1.0*Math.abs(tt[j].v) / Math.abs(at[j].v));
		if(rat > 1.0)ans=t;
	    }
	}
	if(ans.size()==0){
	    for(int i = 0; i < k && i < nn.size();i++){
		ans.add(nn.get(nn.size()-1-i));
	    }
	    for(int i=0;ans.size() < k;i++)ans.add(pn.get(i));
	}
	Collections.sort(ans);
	for(int i = ans.size()-1; i > 0;i--)
	    System.out.print(ans.get(i) + " ");
	System.out.print(ans.get(0));
    }

    static class Info implements Comparable<Info>{
	int v;
	Info(int a){v=a;}
	public int compareTo(Info i){
	    return Math.abs(v)-Math.abs(i.v);
	}
    }
}