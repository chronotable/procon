import java.util.*;
import java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for(;;){
            String start = sc.nextLine();
            if(!start.equals("START"))break;
            String cipher = sc.nextLine();
            String ans = "";
            for(int i = 0; i < cipher.length(); i++){
                char c = cipher.charAt(i);
                if(c >= 'A' && c <= 'Z'){
                    c = (char)(((c - 5 - 'A' + 26) % 26) + 'A');
                }
                ans += c;
            }
            System.out.println(ans);
            sc.nextLine();
        }
    }
}
