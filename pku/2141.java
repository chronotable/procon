import java.util.*;

public class Main{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    String enc = sc.nextLine();
    String s = sc.nextLine();
    for(int i = 0; i < s.length();i++){
      char c = s.charAt(i);
      if(c==' '){
        System.out.print(" ");
        continue;
      }
      Character ch = new Character(c);
      char a;
      if(ch.isUpperCase(ch)){
        a=(char)(enc.charAt(c-'A')-'a'+'A');
      }else {
        a=enc.charAt(c-'a');
      }
      System.out.print(a);
    }
  }
}

