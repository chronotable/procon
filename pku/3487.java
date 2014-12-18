import java.util.*;
import static java.lang.Math.*;
public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int o = sc.nextInt();
    for(;o>0;o--){
      int n = sc.nextInt();
      int[] manv = new int[26];
      int[] womanv = new int[26];
      for(int i = 0; i < n ; i++)manv[sc.next().charAt(0)-'a'] = i;
      for(int i = 0; i < n ; i++)womanv[sc.next().charAt(0)-'A'] = i;
      int[][] man = new int[n][n];
      int[][] woman = new int[n][n];
      for(int i = 0; i < n;i++){
        String s = sc.next();
        int who = manv[s.charAt(0)-'a'];
        for(int j = 0; j < n;j++)man[who][j] = womanv[s.charAt(j+2)-'A'];
      }
      for(int i = 0; i < n;i++){
        String s = sc.next();
        int who = womanv[s.charAt(0)-'A'];
        for(int j = 0; j < n;j++)woman[who][j] = manv[s.charAt(j+2)-'a'];
      }
      int[] wv = stableMarriage(man, woman);
      int[] mv = new int[n];
      for(int i = 0; i < n;i++)mv[wv[i]] = i;
      for(int i = 0; i < n;i++){
        for(int j = 0; j < 26;j++)
          if(manv[j] == i){System.out.print(""+((char)(j+'a')));break;}
        for(int j = 0; j < 26;j++)
          if(womanv[mv[i]] == j){System.out.println(" " + ((char)(j+'A')));break;}
      }
      System.out.println();
    }
  }
    /*
     * _man[manID][rank] = womanID, _woman[womanID][rank] = manID
     * Gale-shapley algorithm
     * man first priority
     * @return res[womanID] = manID
    */
    static int[] stableMarriage(int[][] _man, int[][] _woman){
        int n = _man.length;
        int[][] man = new int[n][n];
        int[][] woman = new int[n][n];
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for(int i = 0; i < n;i++){
            for(int j = 0; j < n;j++){
                man[i][j] = _man[i][n-j-1];
                woman[i][_woman[i][j]] = n-j-1;
            }
        }
        int[] mp = new int[n];
        Arrays.fill(mp, n-1);
        for(int i = 0; i < n;i++){
            for(int manID = i; manID >= 0;){
                int womanID = man[manID][mp[manID]--];
                int prevman = res[womanID];
                if(prevman < 0 || woman[womanID][prevman] <
                   woman[womanID][manID]){
                    res[womanID] = manID;
                    manID = prevman;
                }
            }
        }
        return res;
    }
}
