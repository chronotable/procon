
import java.util.*;

public class Main{

    static int a;
    static String s;

    public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	for(;sc.hasNext();){
	    s = sc.next();
	    a = 0;
	    boolean f = tra();
	    if(a == s.length()-1 && f)System.out.println("YES");
	    else System.out.println("NO");
	}
    }

    static boolean tra(){
	if(a >= s.length())return false;
	char c = s.charAt(a);
	if(c>='p' && c<='z')return true;
	if(c=='N'){
	    a++;
	    return tra();
	}else if(c=='C' || c=='D' || c=='E' || c=='I'){
	    a++;
	    boolean i = tra();
	    a++;
	    boolean j = tra();
	    return i&&j;
	}else{
	    return false;
	}
    }

}

