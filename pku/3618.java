
import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	int t = sc.nextInt();
	int n = sc.nextInt();
	Info[] is = new Info[n];
	for(int i = 0; i < n;i++)is[i] = new Info(sc.nextInt());
	Arrays.sort(is);
	int p = 0;
	int sum = 0;
	int ans = 0;
	for(;ans < n;ans++){
	    sum += abs(is[ans].v - p);
	    if(sum > t)break;
	    p = is[ans].v;
	}
	System.out.println(ans);
    }

    static class Info implements Comparable<Info>{
	int v;
	Info(int a){
	    this.v = a;
	}
	public int compareTo(Info i){
	    return Math.abs(this.v) - Math.abs(i.v);
	}
    }
}
