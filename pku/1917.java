
import java.util.*;

public class Main{

    public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	sc.nextLine();
	for(;n>0;n--){
	    String l1 = sc.nextLine();
	    String l2 = sc.nextLine();
	    String c1 = "";
	    String fb = null, sb="";
	    String fbm = "", sbm = "";
	    for(int i = 0 ; i < l1.length();i++){
		if(l1.charAt(i)=='<'){
		    String con = "";
		    for(i++;l1.charAt(i)!='>';i++)con += l1.charAt(i);
		    String msg = "";
		    for(i++;i < l1.length() && l1.charAt(i) != '<';i++)
			msg += l1.charAt(i);
		    if(fb==null){
			fb = con;
			fbm = msg;
		    }else {
			sb = con;
			sbm = msg;
		    }
		    c1 += con + msg;
		    i--;
		}else{
		    c1 += l1.charAt(i);
		}
	    }
	    String c2 = "";
	    for(int i = 0; i < l2.length();i++){
		if(l2.charAt(i)=='.')break;
		c2 += l2.charAt(i);
	    }
	    c2 += sb + fbm + fb + sbm;
	    System.out.println(c1);
	    System.out.println(c2);
	}
    }

}
