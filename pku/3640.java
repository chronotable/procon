import java.util.*;

public class Main{
    public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	TreeMap<Long,Integer> tm = new TreeMap<Long,Integer>();
	int n;
	for(;;){
	    n=sc.nextInt();
	    if(n==0)break;
	    tm.clear();
	    int[] course = new int[5];
	    int m=1;
	    for(int i = 0; i < n;i++){
		for(int j = 0; j < 5;j++)course[j]=sc.nextInt();
		Arrays.sort(course);
		long k = 0;
		for(int j = 0; j < 5; j++)k = k * 1000 + course[j];
		if(tm.containsKey(k)){
		    int v = tm.get(k);
		    tm.put(k,++v);
		    if(v>m)m=v;
		}else{
		    tm.put(k,1);
		}
	    }
	    int s = 0;
	    Object[] vals = (tm.values().toArray());
	    for(int i = 0;i < vals.length;i++){
		Integer t = (Integer)vals[i];
		if(t.intValue()==m)s++;
	    }
	    System.out.println(s*m);
	}
    }
}
