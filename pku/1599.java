import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
	new Main().run();
    }

    /*
    int[] specimens;
    double mn;
    int[][] each;
    int[] es;
    double ave;

    void run(){
	Scanner sc = new Scanner(System.in);
	for(int o = 1; sc.hasNext(); o++){
	    int c = sc.nextInt();
	    int s = sc.nextInt();
	    specimens = new int[s];
	    mn = 1e30;
	    ave = 0.0;
	    for(int i = 0; i < s; i++){
		specimens[i] = sc.nextInt();
		ave += specimens[i];
	    }
	    ave /= c;
	    int[] pos = new int[s];
	    int[] size = new int[c];
	    tra(0, pos, size);
	    System.out.printf("Set #%d\n", o);
	    for(int i = 0; i < c; i++){
		System.out.printf("%2d:", i);
		for(int j = 0; j < es[i]; j++)
		    System.out.printf(" %d", each[i][j]);
		System.out.println();
	    }
	    System.out.printf("IMBALANCE %.5f\n\n", mn);
	}
    }

    void tra(int cur, int[] pos, int[] size){
	if(cur == pos.length){
	    int[][] e = new int[size.length][2];
	    int[] s = new int[size.length];
	    for(int i = 0; i < pos.length; i++){
		e[pos[i]][s[pos[i]]++] = specimens[i];
	    }
	    double imb = 0;
	    for(int i = 0; i < e.length; i++){
		int sum = 0;
		for(int j = 0; j < s[i]; j++)sum += e[i][j];
		imb += abs(sum - ave);
	    }
	    if(imb < mn){
		each = e;
		es = s;
		mn = imb;
	    }
	    return;
	}
	for(int i = 0; i < size.length; i++){
	    if(size[i] == 2)continue;
	    size[i]++;
	    pos[cur] = i;
	    tra(cur+1, pos, size);
	    size[i]--;
	}
    }
    */

    
    void run(){
	Scanner sc = new Scanner(System.in);
	for(int o = 1;sc.hasNext();o++){
	    int c = sc.nextInt();
	    int s = sc.nextInt();
	    int[] specimens = new int[s];
	    double ave = 0.0;
	    for(int i = 0; i < s; i++){
		specimens[i] = sc.nextInt();
		ave += specimens[i];
	    }
	    ave /= c;
	    //System.out.println(ave);
	    Arrays.sort(specimens);
	    int[][] each = new int[c][2];
	    int[] size = new int[c];
	    int left = 0;
	    int right = s-1;
	    for(int i = 0; i < c; i++){
		int cur = right - left + 1;
		int rest = c - i;
		if(cur <= 0)continue;
		if(rest * 2 > cur){
		    each[i][0] = specimens[right--];
		    size[i] = 1; 
		}else{
		    each[i][0] = specimens[left++];
		    each[i][1] = specimens[right--];
		    size[i] = 2;
		}
	    }
	    System.out.printf("Set #%d\n", o);
	    double imbalance = 0;
	    for(int i = 0; i < c; i++){
		int sum = 0;
		System.out.printf("%2d:", i);
		for(int j = 0; j < size[i]; j++){
		    System.out.printf(" %d", each[i][j]);
		    sum += each[i][j];
		}
		System.out.println();
		imbalance += abs(sum - ave);
	    }
	    System.out.printf("IMBALANCE %.5f\n\n", imbalance);
	}
    }
    
}