import java.util.*;

public class Main{

    static int count = 1;
    static String[] tbl = new String[83682];

    static void tra(String s, int p, int l){
	if(s.length() == l){
	    tbl[count++] = s;
	    return;
	}
	for(int i = p;i < 26;i++){
	    tra(s + (char)('a' + i), i + 1, l);
	}
    }

    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	for(int i = 1; i <= 5;i++)tra("",0,i);
	for(;sc.hasNext();){
	    String q = sc.next();
	    int ind = 1;
	    for(;ind < tbl.length;ind++)if(q.equals(tbl[ind]))break;
	    if(ind < tbl.length)System.out.println(ind);
	    else System.out.println(0);
	}
    }
}