import java.util.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int z = sc.nextInt();
	for(int o = 1; o<= z;o++){
	    System.out.println("Scenario #" + o + ":");
	    int t = sc.nextInt();
	    int p = sc.nextInt();
	    int[] d = new int[p];
	    for(int i = 0; i < p;i++)d[i] = sc.nextInt();
	    int tt = 0,bn=0, bs=0;
	    for(bn = 0;bn < p;bn++){
		if(tt+d[bn] > t)break;
		tt+=d[bn];
	    }
	    for(int i = 0; i < bn;i++)bs+=d[i] * (bn-i);
	    int sn=0, ss=0;
	    Arrays.sort(d);
	    for(tt=0;sn < p;sn++){
		if(tt+d[sn] > t)break;
		tt+=d[sn];
	    }
	    for(int i = 0;i < sn;i++)ss += d[i] * (sn-i);
	    int[] r = new int[p];
	    for(int i =0;i < p;i++)r[i]=d[p-i-1];
	    int ln=0, ls=0;
	    for(tt=0;ln < p;ln++){
		if(tt+r[ln] > t)break;
		tt+=r[ln];
	    }
	    for(int i = 0;i < ln;i++)ls += r[i] * (ln-i);
	    System.out.println("Steve wins with " + sn + " solved problems and a score of " + ss + ".");
	    System.out.println();
	}
    }
}