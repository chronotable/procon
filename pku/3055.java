import java.util.*;
import static java.lang.Math.*;

public class Main{
  public static void main(String[] args){
    new Main().run();
  }
  
  void run(){
    Scanner sc = new Scanner(System.in);
    int o = sc.nextInt();
    loop:
    for(;o>0;o--){
      String a = sc.next();
      String b = sc.next();
      int la = a.length();
      int lb = b.length();
      int[] fa = new int[10];
      int[] fb = new int[10];
      for(int i = 0; i < la; i++)fa[a.charAt(i)-'0']++;
      for(int i = 0; i < lb; i++)fb[b.charAt(i)-'0']++;
      if(isFriend(fa, fb)){
        System.out.println("friends");
        continue loop;
      }
      for(int i = 0; i < la - 1; i++){
        int left = a.charAt(i) - '0';
        int right = a.charAt(i+1)-'0';
        fa[left]--; fa[right]--;
        int x = left-1;
        int y = right+1;
        if((x >= 0 && y >= 0 && x < 10 && y < 10) && (i!=0 || x != 0)){
          fa[x]++;fa[y]++;
          if(isFriend(fa, fb)){
            System.out.println("almost friends");
            continue loop;
          }
          fa[x]--;fa[y]--;
        }
        x = left+1;
        y = right-1;
        if((x >= 0 && y >= 0 && x < 10 && y < 10) && (i!=0 || x != 0)){
          fa[x]++;fa[y]++;
          if(isFriend(fa, fb)){
            System.out.println("almost friends");
            continue loop;
          }
          fa[x]--;fa[y]--;
        }
        fa[left]++;fa[right]++;
      }
      
      for(int i = 0; i < lb - 1; i++){
        int left = b.charAt(i) - '0';
        int right = b.charAt(i+1)-'0';
        fb[left]--; fb[right]--;
        int x = left-1;
        int y = right+1;
        if((x >= 0 && y >= 0 && x < 10 && y < 10) && (i!=0 || x != 0)){
          fb[x]++;fb[y]++;
          if(isFriend(fa, fb)){
            System.out.println("almost friends");
            continue loop;
          }
          fb[x]--;fb[y]--;
        }
        x = left+1;
        y = right-1;
        if((x >= 0 && y >= 0 && x < 10 && y < 10) && (i!=0 || x != 0)){
          fb[x]++;fb[y]++;
          if(isFriend(fa, fb)){
            System.out.println("almost friends");
            continue loop;
          }
          fb[x]--;fb[y]--;
        }
        fb[left]++;fb[right]++;
      }
      
      System.out.println("nothing");
    }
  }
  
  boolean isFriend(int[] fa, int[] fb){
    for(int i = 0; i < 10; i++){
      if((fa[i] == 0 && fb[i] > 0) ||
         (fa[i] > 0 && fb[i] == 0))return false;
    }
    return true;
  }
}
