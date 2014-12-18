
import java.util.*;

public class Main{

    public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	String uri;
	for(;;){
	    try{
		uri = sc.nextLine();
	    }catch (NoSuchElementException e){
		break;
	    }
	    if(uri.equals("#"))break;
	    String ans = "";
	    for(int i =0; i < uri.length();i++){
		char c = uri.charAt(i);
		if(c==' ')ans+="%20";
		else if(c=='!')ans+="%21";
		else if(c=='$')ans+="%24";
		else if(c=='%')ans+="%25";
		else if(c=='(')ans+="%28";
		else if(c==')')ans+="%29";
		else if(c=='*')ans+="%2a";
		else ans+=c;
	    }
	    System.out.println(ans);
	}
    }

}
