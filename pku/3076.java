import java.util.*;
import static java.lang.Math.*;

public class Main{

  private static final int LEN = 16;
  private static final int BLC = 4;

  private static final int ROWS = LEN * LEN * LEN;
  private static final int COLS = LEN * LEN * 4;
  private static final int NODES = ROWS * COLS;

  private DLN head;
  private DLN[] row = new DLN[ROWS + 1];
  private DLN[] col = new DLN[COLS + 1];
  private DLN[] pool = new DLN[LEN * LEN * LEN * LEN + 10];
  int nodeCount = 0;
  int[] count = new int[COLS + 1];
  int[] solution = new int[ROWS + 1];

  private static int cellPos(int row, int col){
    return LEN * LEN * 3 + row * LEN + col;
  }
  private static int rowPos(int row, int val){
    return row * LEN + val;
  }
  private static int colPos(int col, int val){
    return LEN * LEN + col * LEN + val;
  }
  private static int boxPos(int box, int val){
    return LEN * LEN * 2 + box * LEN + val;
  }
  
  void init(){
    head = new DLN();
    for(int i = 0; i < col.length; i++)col[i] = new DLN();
    for(int i = 0; i < row.length; i++)row[i] = new DLN();
    for(int i = 0; i < pool.length; i++)pool[i] = new DLN();
    Arrays.fill(count, 0);
    Arrays.fill(solution, -1);
    nodeCount = 0;
    head.row = head.col = 0;
    head.left = head.right = head.up = head.down = head;
    for(int i = 0 ; i < COLS; i++){
      col[i].left = head.left;
      head.left = col[i];
      col[i].right = head;
      col[i].val = 0;
      col[i].col = i;
      col[i].up = col[i].down = col[i];
      col[i].left.right = col[i];
      col[i].right.left = col[i];
    }
    for(int i = 0; i < ROWS; i++){
      row[i].up = head.up;
      head.up = row[i];
      row[i].row = i;
      row[i].down = head;
      row[i].left = row[i].right = row[i];
      row[i].up.down = row[i];
      row[i].down.up = row[i];
    }
  }

  void addDLN(int r, int c, int v, int ci){
    int ri = r * LEN * LEN + c * LEN + v;
    count[ci]++;
    pool[nodeCount].row = ri;
    pool[nodeCount].col = ci;
    pool[nodeCount].up = col[ci];
    pool[nodeCount].down = col[ci].down;
    col[ci].down.up = pool[nodeCount];
    col[ci].down = pool[nodeCount];
    pool[nodeCount].left = row[ri];
    pool[nodeCount].right = row[ri].right;
    row[ri].right.left = pool[nodeCount];
    row[ri].right = pool[nodeCount++];
  }

  void del(int ci){
    DLN p, q;
    
    //delete column
    col[ci].left.right = col[ci].right;
    col[ci].right.left = col[ci].left;
    
    //delete row
    for(p = col[ci].down; p != col[ci]; p = p.down){
      for(q = p.right; q != p; q = q.right){
        count[q.col]--;
        q.up.down = q.down;
        q.down.up = q.up;
      }
      p.left.right = p.right;
      p.right.left = p.left;
    }
  }
  
  void restore(int ci){
    DLN p, q;
    
    //restore row
    for(p = col[ci].down; p != col[ci]; p = p.down){
      p.left.right = p;
      p.right.left = p;
      for(q = p.right; q != p; q = q.right){
        q.up.down = q;
        q.down.up = q;
        count[q.col]++;
      }
    }
    
    //restore column
    col[ci].left.right = col[ci];
    col[ci].right.left = col[ci];
  }
  
  boolean solve(int depth){
    DLN p, q;
    int selectedCol = -1, mn;
    
    if(head.right == head)
      return true;
    
    //choose col
    mn = LEN * 10;
    for(p = head.right; p != head; p = p.right){
      if(mn > count[p.col]){
        mn = count[p.col];
        selectedCol = p.col;
        if(mn <= 1)break;
      }
    }
    if(mn == 0)return false;
    
    //choose row
    del(selectedCol);
    for(p = col[selectedCol].down; p != col[selectedCol]; p = p.down){
      solution[depth] = p.row;
      
      //del column
      p.left.right = p;
      for(q = p.right; q != p; q = q.right){
        del(q.col);
      }
      p.left.right = p.right;
      
      //repeat
      if(solve(depth + 1))return true;
      
      //restore col
      p.right.left = p;
      for(q = p.left; q != p; q = q.left)
        restore(q.col);
      
      p.right.left = p.left;
    }
    restore(selectedCol);
    return false;
  }
  
  void printAns(){
    char[][] ss = new char[LEN][LEN];
    for(int i = 0; i < LEN*LEN; i++){
      int r, c, v;
      r = solution[i] / (LEN * LEN);
      c = (solution[i] / LEN) % LEN;
      v = solution[i] % LEN;
      ss[r][c] = (char)(v + 'A');
      //System.out.println("r = " + r + " : c = " + c + " : v = " + v);
    }
    for(int i = 0; i < LEN; i++){
      System.out.println(new String(ss[i]));
    }
    System.out.println();
  }

  private class DLN{
    int row, col, val;
    DLN up, right, down, left;
    
    DLN(){
      row = col = val = -1;
      up = right = down = left = null;
    }
  }
  
  void run(){
    Scanner sc = new Scanner(System.in);
    //Scanner tc = sc;
    //if(sc == tc)System.out.println("sc == tc");
    for(;sc.hasNext();){
      String[] b = new String[LEN];
      for(int i = 0; i < LEN; i++)b[i] = sc.next();
      init();
      for(int i = 0; i < LEN; i++){
        //System.out.println(b[i]);
        for(int j = 0; j < LEN; j++){
          if(b[i].charAt(j) == '-'){
            for(int k = 0; k < LEN; k++){
              addDLN(i, j, k, cellPos(i, j));
              addDLN(i, j, k, rowPos(i, k));
              addDLN(i, j, k, colPos(j, k));
              addDLN(i, j, k, boxPos(i / BLC * BLC + j / BLC, k));
            }
          }else{
            int v = b[i].charAt(j) - 'A';
            addDLN(i, j, v, cellPos(i, j));
            addDLN(i, j, v, rowPos(i, v));
            addDLN(i, j, v, colPos(j, v));
            addDLN(i, j, v, boxPos(i / BLC * BLC + j / BLC, v));
          }
        }
      }
      for(int i = 0; i < ROWS; i++){
        row[i].left.right = row[i].right;
        row[i].right.left = row[i].left;
      }
      //if(solve(0))System.out.println("find solution!");
      solve(0);
      printAns();
    }
  }
  
  public static void main(String[] args){
    new Main().run();
  }
}
