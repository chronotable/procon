import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
	new Main().run();
    }

    void run(){
	Scanner sc = new Scanner(System.in);
	for(;;){
	    int n = sc.nextInt();
	    int m = sc.nextInt();
	    if(n+m==0)break;
	    ArrayList<Integer>[] group = new ArrayList[m];
	    for(int i = 0; i < m; i++)group[i] = new ArrayList<Integer>();
	    for(int i = 0; i < m; i++){
		int a = sc.nextInt();
		for(int j = 0; j < a; j++){
		    int k = sc.nextInt();
		    group[i].add(k);
		}
		Collections.sort(group[i]);
	    }
	    boolean[][] con = new boolean[m][m];
	    for(int i = 0; i < m; i++)
		for(int j = i+1; j < m; j++){
		    for(int k = 0; k < group[i].size(); k++)
			if(Collections.binarySearch(group[j], group[i].get(k)) >= 0)
			    con[i][j] = con[j][i] = true;
		}
	    boolean[] u = new boolean[m];
	    for(int i = 0; i < m; i++){
		if(u[i])continue;
		if(Collections.binarySearch(group[i], 0) >= 0)
		    tra(i, con, u);
	    }
	    boolean[] is = new boolean[n+1];
	    int ans = 0;
	    for(int i = 0; i < m; i++){
		if(!u[i])continue;
		for(int j = 0; j < group[i].size(); j++){
		    int v = group[i].get(j);
		    if(!is[v]){
			is[v] = true;
			ans++;
		    }
		}
	    }
	    if(!is[0])ans++;
	    System.out.println(ans);
	}
    }

    void tra(int cur, boolean[][] con, boolean[] u){
	int m = u.length;
	u[cur] = true;
	for(int i = 0; i < m; i++){
	    if(con[cur][i] && !u[i])
		tra(i, con, u);
	}
    }
}
