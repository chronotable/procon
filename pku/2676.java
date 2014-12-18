import java.util.*;
import static java.lang.Math.*;

public class Main{
    private static final int LEN = 9;
    private static final int BLC = 3;
    public static void main(String[] args){
        new Main().run();
    }
    void run(){
        Scanner sc = new Scanner(System.in);
        for(int o = Integer.parseInt(sc.nextLine()); o > 0; o--){
            Cell[][] b = new Cell[LEN][LEN];
            boolean[][] u = new boolean[LEN][LEN];
            for(int i = 0; i < LEN; i++){
                String s = sc.nextLine();
                for(int j = 0; j < s.length();j++){
                    int v = s.charAt(j) - '0';
                    b[i][j] = new Cell(v);
                    if(v > 0)u[i][j] = true;
                }
            }
            for(int i = 0; i < LEN; i++){
                for(int j = 0; j < LEN; j++){
                    if(b[i][j].val == 0)continue;
                    propagate(b, i, j, b[i][j].val, -1, u);
                }
            }
            solve(b,u, 0);
            printBoard(b);
        }
    }

    boolean solve(Cell[][] b, boolean[][] u, int dl){
        int[] next = new int[2];
        if(!select(b, u, next))
            return false;
        if(next[0] < 0)
            return true;

        u[next[0]][next[1]] = true;

        /*
        int free = 0;
        for(int i = 0; i < LEN; i++)
            if(b[next[0]][next[1]].cand[i])free++;
        if(b[next[0]][next[1]].rest != free){
            System.out.println("ERROR");
            System.exit(1);
        }
        */

        /*
        if(next[0] == 4 && next[1] == 0){
            System.out.println("r = 4 c == 0");
            printBoard(b);
            System.out.print("candidates:");
            for(int i = 0; i < LEN; i++)
                if(b[next[0]][next[1]].cand[i] == Cell.FREE)
                    System.out.print(" " + (i+1));
            System.out.println();
        }
        */

        for(int i = 0; i < LEN; i++){
            if(b[next[0]][next[1]].cand[i] == Cell.FREE){
            //if(ok(b, next[0], next[1], i + 1)){
                b[next[0]][next[1]].val = i + 1;
                propagate(b, next[0], next[1], i+1, dl, u);
                if(solve(b, u, dl + 1))return true;
                undoPropagate(b, next[0], next[1], i+1, dl, u);
            }
        }
        u[next[0]][next[1]] = false;
        b[next[0]][next[1]].val = 0;

        return false;
    }

    boolean select(Cell[][] b, boolean[][] u, int[] next){
        int nr = -1;
        int nc = -1;
        int mncand = LEN + 1;
        for(int i = 0; i < LEN; i++){
            for(int j = 0; j < LEN; j++){
                if(u[i][j]) continue;
                if(b[i][j].rest == 0)
                    return false;
                else if(b[i][j].rest > 0 && b[i][j].rest < mncand){
                    nr = i;
                    nc = j;
                    mncand = b[i][j].rest;
                }
            }
        }
        next[0] = nr;
        next[1] = nc;
        return true;
    }


    void propagate(Cell[][] b, int r, int c, int v, int dl, boolean[][] u){
        //row
        for(int i = 0; i < LEN;i++){
            if(!u[r][i] && b[r][i].cand[v-1] == Cell.FREE){
                b[r][i].cand[v-1] = dl;
                b[r][i].rest--;
            }
        }
        //column
        for(int i = 0; i < LEN; i++){
            if(!u[i][c] && b[i][c].cand[v-1] == Cell.FREE){
                b[i][c].cand[v-1] = dl;
                b[i][c].rest--;
            }
        }
        //block
        int sr = (r / BLC) * BLC;
        int sc = (c / BLC) * BLC;
        for(int i = 0; i < BLC; i++){
            for(int j = 0; j < BLC; j++){
                int nr = sr + i;
                int nc = sc + j;
                if(!u[nr][nc] && b[nr][nc].cand[v-1] == Cell.FREE){
                    b[nr][nc].cand[v-1] = dl;
                    b[nr][nc].rest--;
                }
            }
        }
    }

    void undoPropagate(Cell[][] b, int r, int c, int v, int dl, boolean[][] u){
        //row
        for(int i = 0; i < LEN;i++){
            if(!u[r][i] && b[r][i].cand[v-1] == dl){
                b[r][i].cand[v-1] = Cell.FREE;
                b[r][i].rest++;
            }
        }
        //column
        for(int i = 0; i < LEN; i++){
            if(!u[i][c] && b[i][c].cand[v-1] == dl){
                b[i][c].cand[v-1] = Cell.FREE;
                b[i][c].rest++;
            }
        }
        //block
        int sr = (r / BLC) * BLC;
        int sc = (c / BLC) * BLC;
        for(int i = 0; i < BLC; i++){
            for(int j = 0; j < BLC; j++){
                int nr = sr + i;
                int nc = sc + j;
                if(!u[nr][nc] && b[nr][nc].cand[v-1] == dl){
                    b[nr][nc].cand[v-1] = Cell.FREE;
                    b[nr][nc].rest++;
                }
            }
        }
    }

    boolean ok(Cell[][] b, int r, int c, int v){
        //row
        for(int i = 0; i < LEN;i++){
            if(b[r][i].val == v){
                return false;
            }
        }
        //column
        for(int i = 0; i < LEN; i++){
            if(b[i][c].val == v){
                return false;
            }
        }
        //block
        int sr = (r / BLC) * BLC;
        int sc = (c / BLC) * BLC;
        for(int i = 0; i < BLC; i++){
            int nr = sr + i;
            for(int j = 0; j < BLC; j++){
                int nc = sc + j;
                if(b[nr][nc].val == v){
                    return false;
                }
            }
        }
        return true;
    }

    void printBoard(Cell[][] b){
        for(int i = 0; i < LEN; i++){
            for(int j = 0; j < LEN;j++){
                System.out.print(b[i][j].val);
            }
            System.out.println();
        }
    }

    class Cell{
        static final int FREE = Integer.MAX_VALUE;
        int val;
        int rest;
        int[] cand = new int[LEN];
        Cell(int v){
            val = v;
            if(v > 0){
                Arrays.fill(cand, -1);
                //cand[v-1] = true;
                rest = -1;
            }else{
                Arrays.fill(cand, FREE);
                rest = LEN;
            }
        }
    }
}
