import java.util.*;

public class Main{
  public static void main(String[] args){
    Hashtable<Integer,Integer> ht = new Hashtable<Integer,Integer>();
    int[] a = new int[5];
    int ans=0;
    Scanner sc = new Scanner(System.in);
    for(int i = 0;i< 5;i++)a[i]=sc.nextInt();
    int b,c,d,e,f,g,h;
    
    for(int i = -50;i <=50;i++){
      if(i==0)continue;
      d=i*i*i*a[2];
      for(int j = -50;j<=50;j++){
        if(j==0)continue;
        e=j*j*j*a[3];
        for(int k = -50;k <= 50;k++){
          if(k==0)continue;
          f=d+e+k*k*k*a[4];
          if(ht.containsKey(f)){
            ht.put(f,ht.get(f)+1);
          }else{
            ht.put(f,1);
          }
        }
      }
    }
    
    for(int i = -50;i<=50;i++){
      if(i==0)continue;
      b=i*i*i*a[0];
      for(int j = -50;j<=50;j++){
        if(j==0)continue;
        c=j*j*j*a[1] + b;
        if(ht.containsKey(c)){
          ans+=ht.get(c);
        }
      }
    }
    System.out.println(ans);
  }
}

