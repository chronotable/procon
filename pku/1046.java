
import java.util.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	Colo[] tbl = new Colo[16];
	for(int i = 0; i < 16;i++){
	    tbl[i] = new Colo(sc.nextInt(),sc.nextInt(),sc.nextInt());
	}
	for(;;){
	    int i = sc.nextInt();
	    int j = sc.nextInt();
	    int k = sc.nextInt();
	    if(i+j+k==-3)break;
	    Colo temp = new Colo(i,j,k);
	    double md = 1 << 30;
	    int ind = 0;
	    for(int s = 0; s < 16;s++){
		if(md > temp.dis(tbl[s])){
		    md = temp.dis(tbl[s]);
		    ind = s;
		}
	    }
	    System.out.println(temp + " maps to " + tbl[ind]);
	}
    }

    static class Colo{
	int r,g,b;
	Colo(int i, int j, int k){
	    r = i;
	    g = j;
	    b = k;
	}
	double dis(Colo c){
	    return Math.sqrt(1.0*(r-c.r)*(r-c.r) + (g-c.g)*(g-c.g) + (b-c.b)*(b-c.b));
	}
	public String toString(){
	    return "("+r+","+g+","+b+")";
	}
    }
}
