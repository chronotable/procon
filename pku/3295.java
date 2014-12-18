import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
	new Main().run();
    }

    String s;
    int ind;

    boolean eval(int mask){
	char c = s.charAt(ind++);
	if(c >= 'p' && c <= 't')
	    return ((mask >> (c-'p')) & 1) == 1;
	else if(c == 'N')return !eval(mask);
	boolean left = eval(mask);
	boolean right = eval(mask);
	if(c == 'K')return left && right;
	else if(c == 'A')return left || right;
	else if(c == 'E')return left == right;
	else if(c == 'C'){
	    if(left && !right)return false;
	    else return true;
	}
	return false;
    }

    void run(){
	Scanner sc = new Scanner(System.in);
	for(;;){
	    s = sc.next();
	    if(s.equals("0"))break;
	    boolean[] exist = new boolean[5];
	    for(int i = 0; i < s.length(); i++){
		char c = s.charAt(i);
		if(c >= 'p' && c <= 't')exist[c-'p']=true;
	    }
	    boolean tauto = true;
	    loop:
	    for(int mask = 0; mask < 32; mask++){
		for(int i = 0; i < exist.length; i++)
		    if(!exist[i] && ((mask>>i)&1)==0)continue loop;
		ind = 0;
		tauto = tauto && eval(mask);
	    }
	    System.out.printf("%s\n", tauto ? "tautology" : "not");
	}
    }
}