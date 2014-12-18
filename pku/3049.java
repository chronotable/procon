

import java.util.*;

public class Main{

    private static int l;
    private static int c;
    private static char[] alp;

    public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	l = sc.nextInt();
	c = sc.nextInt();
	alp = new char[c];
	for(int i = 0; i < c;i++)alp[i] = sc.next().charAt(0);
	Arrays.sort(alp);
	tra(0,0,0,"");
    }

    private static void tra(int p, int len, int vn, String str){
	if(len==l){
	    if(vn > 0 && len - vn > 1)System.out.println(str);
	    return;
	}
	for(int i = p; i <= c - (l - len);i++){
	    if(alp[i]=='a' || alp[i]=='i' || alp[i]=='u' || alp[i]=='e'
	       || alp[i]=='o'){
		tra(i+1,len+1,vn+1,str+alp[i]);
	    }else{
		tra(i+1,len+1,vn,str+alp[i]);
	    }
	}
    }

}
