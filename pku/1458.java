import java.util.*;

public class Main{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int i,j;
        for(;sc.hasNext();){
            String a=sc.next(),b=sc.next();
            int[][] tbl=new int[a.length()+1][b.length()+1];
            for(i=1;i<=a.length();i++){
                for(j=1;j<=b.length();j++) {
                    int v=tbl[i-1][j-1];
                    if(a.charAt(i-1)==b.charAt(j-1))v++;
                    if(v<tbl[i-1][j])v=tbl[i-1][j];
                    if(v<tbl[i][j-1])v=tbl[i][j-1];
                    tbl[i][j]=v;
                }
            }
            System.out.println(tbl[a.length()][b.length()]);
        }

    }
}