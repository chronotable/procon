import java.util.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	for(int o = 1;;o++){
	    int n = sc.nextInt();
	    if(n==0)break;
	    double[][] s = new double[n][4];
	    double[] x = new double[n*2];
	    double[] y = new double[n*2];
	    int px = 0, py = 0;
	    for(int i = 0; i < n;i++){
		for(int j = 0; j < 4;j++){
		    s[i][j] = sc.nextDouble();
		    if(j%2==0)x[px++]=s[i][j];
		    else y[py++]=s[i][j];
		}
	    }
	    Arrays.sort(x);
	    Arrays.sort(y);
	    double ans = 0;
	    for(int i = 0; i < px - 1;i++){
		for(int j = 0; j < py - 1;j++){
		    for(int k = 0; k < n;k++){
			if(s[k][0] <= x[i] && x[i+1] <= s[k][2] &&
			   s[k][1] <= y[j] && y[j+1] <= s[k][3]){
			    ans += (x[i+1]-x[i])*(y[j+1]-y[j]);
			    break;
			}
		    }
		}
	    }
	    System.out.println("Test case #" + o);
	    System.out.printf("Total explored area: %.2f\n",ans);
	    System.out.println();
	}
    }
}