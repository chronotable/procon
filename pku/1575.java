import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }
    void run(){
        Scanner sc = new Scanner(System.in);
        for(;;){
            String s = sc.next();
            if(s.equals("end"))break;
            boolean vowel = false;
            boolean[] isv = new boolean[s.length()];
            boolean twoCons = false;
            for(int i = 0; i < s.length();i++){
                char c = s.charAt(i);
                if(c == 'a' || c== 'i' || c == 'u' || c=='e' || c=='o'){
                    vowel = true;
                    isv[i] = true;
                }else{
                    isv[i] = false;
                }
                if(c!='e' && c!='o' && i != s.length()-1 && c == s.charAt(i+1))
                    twoCons = true;
            }
            boolean threeCons = false;
            for(int i = 0; i < isv.length - 2; i++){
                if(isv[i] == isv[i+1] && isv[i+1] == isv[i+2])threeCons = true;
            }
            System.out.printf("<%s> is ", s);
            if(!vowel || twoCons || threeCons)System.out.print("not ");
            System.out.println("acceptable.");
        }
    }
}
