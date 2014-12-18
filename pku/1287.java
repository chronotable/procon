
import java.util.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	for(;;){
	    int p = sc.nextInt();
	    if(p==0)break;
	    int r = sc.nextInt();
	    int[][] q = new int[p][p];
	    for(int i = 0; i < p;i++)Arrays.fill(q[i],1000);
	    for(int i = 0; i < r;i++){
		int x = sc.nextInt() - 1;
		int y = sc.nextInt() - 1;
		int c = sc.nextInt();
		if(c < q[x][y]){
		    q[x][y]=q[y][x]=c;
		}
	    }
	    int ans = 0;
	    for(int i = 0; i < p-1;i++){
		int mi = 1000;
		int ind = 0;
		for(int j = 0; j < p;j++){
		    if(q[0][j] < mi){
			mi = q[0][j];
			ind = j;
		    }
		}
		if(mi==1000)System.out.println("error");
		ans += q[0][ind];
		for(int j = 1; j < p;j++){
		    if(q[0][j]==1500)continue;
		    if(q[0][j] > q[ind][j])q[0][j] = q[ind][j];
		}
		q[0][ind] = 1500;
	    }
	    System.out.println(ans);
	}
    }
}
