import java.util.*;
public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	for(;;){
	    String s = sc.next();
	    int ri = s.indexOf('R');
	    int ci = s.indexOf('C');
	    int rn = Integer.parseInt(s.substring(ri+1,ci));
	    int cn = Integer.parseInt(s.substring(ci+1));
	    if(rn+cn==0)break;
	    String t = "";
	    int v=26;
	    for(;cn>v;v*=26){
		int m = cn % v;
		if(m==0)m=v;
		int h = m / (v/26);
		t = (char)(h-1+'A') + t;
		cn -= m;
	    }
	    int h = cn / (v/26);
	    t = (char)(h-1+'A')+t;
	    System.out.println(t+rn);
	}
    }
}