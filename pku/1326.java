import java.util.*;
import static java.lang.Math.*;

public class Main{
  public static void main(String[] args){
    new Main().run();
  }
  
  void run(){
    Scanner sc = new Scanner(System.in);
    for(;sc.hasNext();){
      long ans = 0;
      for(;;){
        String line = sc.nextLine();
        if(line.equals("0"))break;
        if(line.equals("#"))return;
        String[] ss = line.split(" ");
        int dis = Integer.parseInt(ss[2]);
        if(ss[3].equals("F")){
          ans += dis*2l;
        }else if(ss[3].equals("B")){
          ans += dis + (dis+1)/2;
        }else{
          if(dis <= 500)ans += 500;
          else ans += dis;
        }
      }
      System.out.println(ans);
    }
  }
}

