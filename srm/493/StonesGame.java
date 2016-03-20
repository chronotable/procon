import java.util.*;
import static java.lang.Math.*;

public class StonesGame{
    boolean win(int N, int M, int K, int L){
        int low = max(0, M - K + 1);
        final int mn = low + (low + K - 1 - M);
        int high = min(M, N - K);
        final int mx = high + (high + K - 1 - M);
        if(L < mn || mx < L)return false;
        if(K % 2 == 0){
            M++;
        }
        if(M % 2 == L % 2)return true;
        return false;
    }
    public String winner(int N, int M, int K, int L){
        M--; L--;
        if(win(N, M, K, L))
            return "Romeo";
        boolean f = false;
        for(int i = M - K + 1; i <= M; i++)if(i >= 0 && i < N && i + K <= N)
                                               if(!win(N, i + (i + K - 1 - M), K, L)){f = true; break;}
        if(!f)return "Strangelet";
        return "Draw";
    }
}
