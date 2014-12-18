import java.util.*;

public class Main{
    public static void main(String args[]){
	Scanner sca = new Scanner(System.in);
	int t = sca.nextInt();
	for(int o=1;o<=t;o++){
	    char[] sa = sca.next().toCharArray();
	    char[] sb = sca.next().toCharArray();
	    char[] sc = sca.next().toCharArray();
	    boolean[][] tbl = new boolean[sa.length+1][sb.length+1];
	    tbl[0][0]=true;
	    for(int i = 0; i <= sa.length;i++){
		for(int j = 0;j <= sb.length;j++){
		    if((j>0&&tbl[i][j-1]&&sb[j-1]==sc[i+j-1]) ||
		       (i>0&&tbl[i-1][j]&&sa[i-1]==sc[i+j-1]))
			tbl[i][j]=true;
		}
	    }
	    System.out.print("Data set "+o+": ");
	    if(tbl[sa.length][sb.length])System.out.println("yes");
	    else System.out.println("no");
	}
    }
}