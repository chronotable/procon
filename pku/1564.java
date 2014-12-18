import java.util.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	for(;;){
	    int t = sc.nextInt();
	    int n = sc.nextInt();
	    if(n==0)break;
	    System.out.println("Sums of " + t + ":");
	    int[] s = new int[n];
	    for(int i = 0; i < n;i++)s[i] = sc.nextInt();
	    HashSet<String> hs = new HashSet<String>();
	    for(int i = 1;i < 1<<n;i++){
		int sum = 0;
		ArrayList<Integer> ar = new ArrayList<Integer>();
		for(int j = 0; j < n;j++){
		    if(((i >> j) & 1) == 1){
			sum += s[j];
			ar.add(s[j]);
		    }
		}
		if(sum==t){
		    int[] k = new int[ar.size()];
		    for(int j = 0; j < k.length;j++)k[j] = ar.get(j);
		    Arrays.sort(k);
		    String str = "";
		    for(int j = k.length-1;j>0;j--)str = str + k[j] +" ";
		    str = str + k[0];
		    if(!hs.contains(str))hs.add(str);
		}
	    }
	    if(hs.size()==0){
		System.out.println("NONE");
		continue;
	    }
	    Info[] tbl = new Info[hs.size()];
	    int count = 0;
	    Iterator<String> it = hs.iterator();
	    for(;it.hasNext();){
		tbl[count++] = new Info(it.next());
	    }
	    Arrays.sort(tbl);
	    for(int i = 0; i < tbl.length;i++){
		for(int j = 0; j < tbl[i].seq.length - 1;j++){
		    System.out.print(tbl[i].seq[j] + "+");
		}
		System.out.println(tbl[i].seq[tbl[i].seq.length-1]);
	    }
	}
    }

    static class Info implements Comparable<Info>{
	String s;
	int[] seq;
	Info(String a){
	    s = a;
	    String[] sar = s.split(" ");
	    seq = new int[sar.length];
	    for(int i = 0; i < seq.length;i++)
		seq[i] = Integer.parseInt(sar[i]);
	}
	public int compareTo(Info i){
	    for(int j = 0; j < seq.length && j < i.seq.length;j++){
		if(this.seq[j]!=i.seq[j])return i.seq[j] - this.seq[j];
	    }
	    return 0;
	}
    }
}
