import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for(;sc.hasNext();){
            int c = sc.nextInt();
            int f1 = sc.nextInt();
            int f2 = sc.nextInt();
            int a = ((f2 - c) - 2 * (f1 - c)) / 2;
            int b = f1 - c - a;
            System.out.printf("%d %d %d\n", 9 * a + 3 * b + c,
                              16 * a + 4 * b + c,
                              25 * a + 5 * b + c);
        }
    }
}
