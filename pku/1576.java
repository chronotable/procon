import java.util.*;
import static java.lang.Math.*;

public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    for(;;){
      int n = sc.nextInt();
      int d = sc.nextInt();
      int c = sc.nextInt();
      if(n==0)break;
      String deck = sc.next();
      String[] card = new String[c];
      for(int i = 0; i < c;i++)card[i] = sc.next();
      int[] pos = new int[n];
      Arrays.fill(pos,-1);
      int ind;
      for(ind = 0; ind < c;ind++){
        int nxt = -1;
        for(int j = 0; j < card[ind].length();j++){
          pos[ind % n]++;
          int old = pos[ind%n];
          nxt = deck.substring(pos[ind%n]).indexOf(card[ind].charAt(j));
          if(nxt != -1)pos[ind%n] = nxt + old;
          else pos[ind%n] = deck.length()-1;
        }
        if(pos[ind%n]==deck.length()-1)break;
      }
      if(ind < c){
        System.out.printf("Player %d won after %d cards.\n", (ind%n)+1, ind+1);
      }else{
        System.out.printf("No player won after %d cards.\n", c);
      }
    }
  }
}
