import java.util.*;
import static java.lang.Math.*;

public class Main{
  public static void main(String[] args){
    new Main().run();
  }
  void run(){
    Scanner sc = new Scanner(System.in);
    for(int o = 1;sc.hasNext();o++){
      String[] ke = sc.nextLine().split(" ");
      int K = Integer.parseInt(ke[0]);
      int E = Integer.parseInt(ke[1]);
      String[] kw = new String[K];
      //TreeSet<String> kw = new TreeSet<String>();
      String[] ex = new String[E];
      int[] score = new int[E];
      int mx = 1;
      for(int i = 0; i < K; i++)kw[i] = sc.nextLine();//kw.add(sc.nextLine());
      for(int i = 0; i < E; i++){
        ex[i] = sc.nextLine();
        String s = ex[i].toLowerCase();
        s = s.replaceAll("[0-9\".,!?~@#$%^&*(){}|+-;':]", " ");
        //System.out.println(s);
        String[] ss = s.split(" ");
        int sum = 0;
        for(int j = 0; j < ss.length; j++){
          if(ss[j].length() == 0)continue;
          for(int x = 0; x < K; x++){
            if(ss[j].equals(kw[x])){
              sum++;
              break;
            }
            /*
            int pos = ss[j].indexOf(kw[x]);
            if(pos >= 0 && (pos == 0 ||
               pos == ss[j].length() - kw[x].length())){
               sum++;
               break;
            }
            */
          }
        }
        score[i] = sum;
        mx = max(mx, sum);
      }
      System.out.printf("Excuse Set #%d\n", o);
      for(int i = 0; i < E; i++){
        if(score[i] == mx)System.out.println(ex[i]);
      }
      System.out.println();
    }
  }
}
