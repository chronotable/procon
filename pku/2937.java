import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int axis;
        int n;
        boolean isrev;
        String com;
        while((n = Integer.parseInt(scan.nextLine())) != 0) {
            com = scan.nextLine();
            StringTokenizer st = new StringTokenizer(com," ");
            String c;
            axis = 0;
            isrev = false;
            while(st.hasMoreTokens()) {
                c = st.nextToken();
                if(c.charAt(0) == 'm') {
                    int a = Integer.parseInt(c.substring(1,c.length()));
                    if(a % 2 == 1) {
                        isrev = !isrev;
                    }
                }else {
                    int a = Integer.parseInt(c.substring(1,c.length()));
                    if(isrev) {
                        a = a % n;
                        if(axis > a) axis -= a;
                        else axis = (n - (a - axis)) % n;
                    }else {
                      axis += a;
                      axis = axis % n;
                    }
                }
            }
            if(isrev) {
                if(axis != 0) {
                    if(axis < (n - axis)) System.out.println("r" + axis + " " + "m1");
                    else if(axis > (n - axis))System.out.println("m1 " + "r" + (n - axis));
                    else System.out.println("m1");
                }else {
                    System.out.println("m1");
                }
            }else {
                if(axis != 0) {
                    if(axis < (n - axis) + 2) {
                        System.out.println("r" + axis);
                    }else if(axis > (n - axis) + 2) {
                        System.out.println("m1 " + "r" + (n - axis) + " m1");
                    }else {
                        System.out.println("");
                    }
                }else {
                    System.out.println("");
                }
            }
        }
    }
}