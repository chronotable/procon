import java.util.*;

public class Main{
    public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	int t = sc.nextInt();
	for(;t>0;t--){
	    int n = sc.nextInt();
	    String s = "aaaaaaaaaaaa";
	    for(int i = 0; i < 4;i++)s += s;
	    String[] r = new String[n];
	    for(int i = 0; i < n;i++){
		r[i] = sc.next();
		if(r[i].length() < s.length())s = r[i];
	    }
	    int ans = 1;
	    for(; ans <= s.length();ans++){
		boolean f = false;
		for(int i = 0; i <= s.length() - ans && !f;i++){
		    String a = s.substring(i,i+ans);
		    String b = "";
		    for(int j = 0; j < a.length();j++)
			b = b + a.charAt(a.length() - 1 - j);
		    int e;
		    for(e = 0; e < n;e++){
			if(r[e].indexOf(a) != -1)continue;
			if(r[e].indexOf(b) != -1)continue;
			break;
		    }
		    if(e==n)f=true;
		}
		if(!f)break;
	    }
	    System.out.println(ans-1);
	}
    }
}