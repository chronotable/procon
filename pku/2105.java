
import java.util.*;

public class Main{

    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	for(;n>0;n--){
	    String s = sc.next();
	    int b = 128;
	    int c = 0;
	    String ans = "";
	    for(int i = 0; i < s.length();){
		if(s.charAt(i)=='1'){
		    c+=b;
		}
		b = b>>1;
		i++;
		if(i%8==0){
		    ans+=c;
		    if(i!=32)ans+=".";
		    b=128;
		    c=0;
		}
	    }
	    System.out.println(ans);
	}
    }

}
