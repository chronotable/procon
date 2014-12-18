import java.util.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	double[][][] ans = new double[11][101][11];
	for(int i = 1;i < 11; i++){
	    for(int j = 1;j <= i;j++)ans[i][1][j]=1.0/i;
	    for(int j = 2; j <= 100;j++){
		for(int k = 1; k<=i;k++){
		    if(k==1){
			if(i==1){
			    ans[i][j][k]+=ans[i][j-1][k];
			}else {
			    ans[i][j][k]+=ans[i][j-1][k+1]/i +
				ans[i][j-1][k]/i;
			}
		    }else if(k==i){
			ans[i][j][k]+=(ans[i][j-1][k-1]+ans[i][j-1][k]) / i;
		    }else{
			ans[i][j][k]+=(ans[i][j-1][k-1]+
				       ans[i][j-1][k]+ans[i][j-1][k+1]) / i;
		    }
		}
	    }
	}
	for(;sc.hasNext();){
	    int k = sc.nextInt();
	    int n = sc.nextInt();
	    double a = 0.0;
	    for(int i = 1; i<= k+1;i++)a+=ans[k+1][n][i];
	    System.out.printf("%.5f\n",a*100.0);
	}
    }
}