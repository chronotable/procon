
import java.util.*;

public class Main{

    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	String enc = sc.next();
	String org = sc.next();
	int[] app1 = new int[26];
	for(int i = 0; i < enc.length();i++)app1[enc.charAt(i) - 'A']++;
	int[] app2 = new int[26];
	for(int i = 0; i < org.length();i++)app2[org.charAt(i) - 'A']++;
	int i,j;
	for(i = 0; i < 26;i++){
	    for(j = 0;j < 26;j++){
		if(app1[i] == app2[j])break;
	    }
	    if(j==26)break;
	    app2[j]=0;
	}
	if(i<26)System.out.println("NO");
	else System.out.println("YES");
    }
}
