import java.util.*;
public class Main{
  public static void main(String[] args){
    Scanner s = new Scanner(System.in);
    for(;;){
int n = s.nextInt();
if(n==0)break;
System.out.printf("%s\n", n%2==0 ? "No Solution!" : "" + (n-1));
}
  }
}