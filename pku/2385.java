import java.util.*;

public class Main{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt(),w=sc.nextInt();
    int[] f = new int[t+1];
    for(int i=1;i<=t;i++)f[i]=sc.nextInt()-1;
    int[][][] dp = new int[t+1][w+1][2];
    PriorityQueue<Info> q = new PriorityQueue<Info>();
    q.offer(new Info(0,0,0,1));
    int ans=-1;
    while(!q.isEmpty()){
      Info temp = q.poll();
      if(temp.w>w)continue;
      if(dp[temp.t][temp.w][temp.p]>=temp.a)continue;
      dp[temp.t][temp.w][temp.p]=temp.a;
      if(ans<temp.a)ans=temp.a;
      if(temp.t==t)continue;
      if(f[temp.t+1]==0){
        if(temp.p==0){
          q.offer(new Info(temp.t+1,temp.w,temp.p,temp.a+1));
        }else{
          q.offer(new Info(temp.t+1,temp.w+1,0,temp.a+1));
          q.offer(new Info(temp.t+1,temp.w,1,temp.a));
        }
      }else{
        if(temp.p==1){
          q.offer(new Info(temp.t+1,temp.w,temp.p,temp.a+1));
        }else{
          q.offer(new Info(temp.t+1,temp.w+1,1,temp.a+1));
          q.offer(new Info(temp.t+1,temp.w,0,temp.a));
        }
      }
    }
    System.out.println(ans-1);
  }
  
  static class Info implements Comparable<Info>{
    int t,w,p;
    int a;
    Info(int t,int w,int p,int a){
      this.t=t;
      this.w=w;
      this.p=p;
      this.a=a;
    }
    
    public int compareTo(Info i){
      if(this.a-i.a<0)return 1;
      else if(this.a-i.a>0)return -1;
      else return 0;
    }
  }
}


