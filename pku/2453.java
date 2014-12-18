import java.util.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	for(;;){
	    int n = sc.nextInt();
	    if(n==0)break;
	    String s = "";
	    for(;n>0;n/=2)s=(n%2)+s;
	    s="0"+s;
	    int[] d = new int[s.length()];
	    for(int i = 0; i < d.length;i++)d[i]=s.charAt(i)-'0';
	    int on=0;
	    int p;
	    for(p = d.length-1;p>=0;p--){
		if(d[p-1]==0 && d[p]==1)break;
		if(d[p]==1)on++;
	    }
	    d[p-1]=1;
	    d[p]=0;
	    for(int i = d.length-1;i > p;i--)d[i]=0;
	    for(int i = 0; i < on;i++)d[d.length-1-i]=1;
	    int ans = 0;
	    for(int i = 0; i < d.length;i++){
		if(d[i]==1)ans += (1 << (d.length-1-i));
	    }
	    System.out.println(ans);
	}
    }
}