import java.util.*;
import static java.lang.Math.*;

public class UniformBoard{
    int n;
    char[][] B;
    public int getBoard(String[] board, int K){
        n = board.length;
        B = new char[n][];
        for(int i = 0; i < n; i++)B[i] = board[i].toCharArray();
        int total = n * n;
        int apple = 0, pear = 0;
        for(int i = 0; i < n; i++)for(int j = 0; j < n; j++){
                if(B[i][j] == 'A')apple++;
                else if(B[i][j] == 'P')pear++;
            }
        int empty = total - apple - pear;
        int ans = 0;
        for(int a = 0; a < n; a++)for(int b = 0; b < n; b++)
                                      for(int c = a; c < n; c++)for(int d = b; d < n; d++){
                                              int h = c - a + 1;
                                              int w = d - b + 1;
                                              int T = h * w;
                                              if(T > apple)continue;
                                              int A = 0, P = 0;
                                              for(int i = a; i <= c; i++)for(int j = b; j <= d; j++){
                                                      if(B[i][j] == 'A')A++;
                                                      else if(B[i][j] == 'P')P++;
                                                  }
                                              int E = T - A - P;
                                              if(A == T){
                                                  ans = max(ans, A);
                                                  continue;
                                              }
                                              if(empty > 0 && E + P * 2 <= K)ans = max(ans, T);
                                          }
        return ans;
    }
}
