import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
	new Main().run();
    }

    void run(){
	Scanner sc = new Scanner(System.in);
	int o = sc.nextInt();
	for(;o>0;o--){
	    int n = sc.nextInt();
	    int[] p = new int[n];
	    for(int i = 0; i < n; i++)p[i] = sc.nextInt();
	    int[] w = wseq(decodeP(p), n);
	    for(int i = 0; i < w.length; i++){
		if(i>0)System.out.print(" ");
		System.out.print(w[i]);
	    }
	    System.out.println("");
	}
    }

    String decodeP(int[] p){
	String ret = "";
	int cur = 0;
	for(int v : p){
	    for(int i = cur; i < v; i++)ret += "(";
	    ret += ")";
	    cur = v;
	}
	return ret;
    }

    int[] wseq(String s, int n){
	int[] ret = new int[n];
	int cur = 0;
	for(int i = 0; i < s.length(); i++){
	    if(s.charAt(i) == '(')continue;
	    int right = 1;
	    int left = 0;
	    for(int j = i-1; j>=0; j--){
		if(s.charAt(j) == '(')left++;
		else right++;
		if(right == left)break;
	    }
	    ret[cur++] = right;
	}
	return ret;
    }
}