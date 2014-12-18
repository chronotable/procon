import java.util.*;

public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    for(;sc.hasNext();){
      String a = sc.nextLine();
      int[] ac = new int[26];
      for(int i = 0; i < a.length();i++)ac[(int)(a.charAt(i)-'a')]++;
      String b = sc.nextLine();
      int[] bc = new int[26];
      for(int i = 0; i < b.length();i++)bc[(int)(b.charAt(i)-'a')]++;
      String ans="";
      for(int i = 0; i < 26;i++){
        int m = Math.min(ac[i],bc[i]);
        for(int j = 0; j < m;j++)ans = ans + (char)('a'+i);
      }
      System.out.println(ans);
    }
  }
}