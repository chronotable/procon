import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int o = sc.nextInt();
        for(int t = 1; t <= o; t++){
            String s = sc.next();
            int len = s.length();
            int[] p = new int[]{9,3,7};
            for(int d = 0; d < 10;d++){
                char[] c = s.toCharArray();
                for(int i = 0; i < len; i++) if(c[i]=='?')c[i] = (char)(d + '0');
                int sum = 0;
                for(int i = 0; i < len;i++){
                    sum += (c[len-i-1] - '0') * p[i%3];
                }
                if(sum % 10 == 0){
                    System.out.println("Scenario #" + t + ":");
                    System.out.println(new String(c));
                    System.out.println();
                    break;
                }
            }
        }
    }
}
