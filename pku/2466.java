import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        loop:
        for(;sc.hasNext();){
            int n = sc.nextInt();
            int total = n * (n-1) / 2;
            int[] ps = new int[total];
            for(int i = 0; i < total; i++)
                ps[i] = sc.nextInt();
            Arrays.sort(ps);
            boolean[] u = new boolean[total];
            u[0] = u[1] = true;
            for(int i = 2; i < total; i++){
                int a2 = ps[0] + ps[1] - ps[i];
                if(a2 % 2 == 1)continue;
                u[i] = true;
                int a = a2 / 2;
                ArrayList<Integer> cand = new ArrayList<Integer>();
                cand.add(a); cand.add(ps[0] - a); cand.add(ps[1] - a);
                boolean flag = true;
                Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
                for(int j = 2; j < total; j++)
                    if(i!=j){
                        if(ht.containsKey(ps[j]))
                            ht.put(ps[j], ht.get(ps[j])+1);
                        else
                            ht.put(ps[j], 1);
                    }
                jail:
                for(int j = 3; j < n; j++){
                    int mn = 1<<30;
                    for(int k = 2; k < total; k++)
                        if(ht.containsKey(ps[k]) && ht.get(ps[k]) > 0){
                            mn = ps[k];
                            ht.put(ps[k], ht.get(ps[k])-1);
                            break;
                        }
                    int v = mn - a;
                    for(int k = 1; k < cand.size(); k++){
                        int sum = v + cand.get(k);
                        if(!ht.containsKey(sum) || ht.get(sum) <= 0){
                            flag = false;
                            break jail;
                        }
                        ht.put(sum, ht.get(sum)-1);
                    }
                    cand.add(v);
                }
                if(flag){
                    System.out.print(cand.get(0));
                    for(int j = 1; j < cand.size(); j++)
                        System.out.print(" " + cand.get(j));
                    System.out.println();
                    continue loop;
                }
            }
            System.out.println("Impossible");
        }
    }
}
