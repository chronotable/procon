import java.util.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	Stack<String> forward = new Stack<String>();
	Stack<String> backward = new Stack<String>();
	String cur = "http://www.acm.org/";
	for(;;){
	    String cmd = sc.next();
	    if(cmd.equals("VISIT")){
		backward.push(cur);
		cur = sc.next();
		forward.clear();
		System.out.println(cur);
	    }else if(cmd.equals("BACK")){
		if(backward.empty()){
		    System.out.println("Ignored");
		}else{
		    forward.push(cur);
		    cur = backward.pop();
		    System.out.println(cur);
		}
	    }else if(cmd.equals("FORWARD")){
		if(forward.empty()){
		    System.out.println("Ignored");
		}else{
		    backward.push(cur);
		    cur = forward.pop();
		    System.out.println(cur);
		}
	    }else if(cmd.equals("QUIT")){
		break;
	    }
	}
    }
}