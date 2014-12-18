import java.util.*;

public class Main{
    public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int k = sc.nextInt();
	int[] s = new int[n];
	for(int i =0; i < n;i++)s[i] = sc.nextInt();
	Hashtable<Integer,Integer> ht = new Hashtable<Integer,Integer>();
	TreeSet<Integer> ts = new TreeSet<Integer>();
	for(int i = 0; i < k;i++){
	    if(!ht.containsKey(s[i])) {ht.put(s[i],1);ts.add(s[i]);}
	    else ht.put(s[i],ht.get(s[i])+1);
	}
	ArrayList<Integer> mns = new ArrayList<Integer>();
	ArrayList<Integer> mxs = new ArrayList<Integer>();
	mns.add(ts.first());
	mxs.add(ts.last());
	for(int i = 1; i <= n-k;i++){
	    if(ht.get(s[i-1]) < 2){
		ht.remove(s[i-1]);
		ts.remove(s[i-1]);
	    }else{
		ht.put(s[i-1],ht.get(s[i-1])-1);
	    }
	    if(!ht.containsKey(s[i-1+k])){
		ht.put(s[i-1+k],1);
		ts.add(s[i-1+k]);
	    }else{
		ht.put(s[i-1+k],ht.get(s[i-1+k])+1);
	    }
	    mns.add(ts.first());
	    mxs.add(ts.last());
	}
	StringBuffer ans = new StringBuffer("");
	for(int i = 0; i < mns.size()-1;i++){
	    ans.append(mns.get(i));ans.append(" ");
	}
	ans.append(mns.get(mns.size()-1));
	System.out.println(ans);
	ans = new StringBuffer("");
	for(int i = 0; i < mxs.size()-1;i++){
	    ans.append(mxs.get(i));ans.append(" ");
	}
	ans.append(mxs.get(mxs.size()-1));
	System.out.println(ans);
    }
}