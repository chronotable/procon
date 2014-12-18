import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[16];
        for(int i = 0; i < d.length; i++)
            d[i] = sc.nextInt();
        int[][] s = new int[20][20];
        for(int i = 0; i < 20; i++)
            for(int j = 0; j < 20;j++)
                s[i][j] = sc.nextInt();
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        for(int o = 0; o < n; o++){
            int[][] nx = new int[20][20];
            for(int i = 0; i < 20; i++){
                for(int j = 0; j < 20;j++){
                    int sum = s[i][j];
                    for(int k = 0; k < dx.length; k++){
                        int y = i + dy[k];
                        int x = j + dx[k];
                        if(x < 0 || x >= 20 || y < 0 || y >= 20)continue;
                        sum += s[y][x];
                    }
                    nx[i][j] = s[i][j] + d[sum];
                    if(nx[i][j] > 3)nx[i][j] = 3;
                    if(nx[i][j] < 0)nx[i][j] = 0;
                }
            }
            s = nx;
        }
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 20; j++){
                char c = '.';
                if(s[i][j] == 1)c = '!';
                else if(s[i][j] == 2)c = 'X';
                else if(s[i][j] == 3)c = '#';
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
